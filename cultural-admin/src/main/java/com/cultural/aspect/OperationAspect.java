package com.cultural.aspect;

import com.cultural.annotation.GlobalInterceptor;
import com.cultural.annotation.VerifyParam;
import com.cultural.entity.constants.Constants;
import com.cultural.entity.dto.SessionUserAdminDto;
import com.cultural.entity.enums.PermissionCodeEnum;
import com.cultural.entity.enums.ResponseCodeEnum;
import com.cultural.exception.BusinessException;
import com.cultural.utils.StringTools;
import com.cultural.utils.VerifyUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.List;

/***
 * aop 切面类
 */
@Aspect
@Component("operationAspect")
public class OperationAspect {
    private final Logger logger = LoggerFactory.getLogger(OperationAspect.class);

    private static final String[] BASE_TYPE_ARRAY = new String[]{"java.lang.String",
            "java.lang.Integer", "java.lang.Long"};

    @Pointcut("@annotation(com.cultural.annotation.GlobalInterceptor)")
    private void requestInterceptor() {
    }

    @Before("requestInterceptor()")
    public void interceptorDo(JoinPoint point) throws BusinessException {
        Object[] arguments = point.getArgs();
        Method method = ((MethodSignature) point.getSignature()).getMethod(); // method.getName() 获取方法名
        GlobalInterceptor interceptor = method.getAnnotation(GlobalInterceptor.class);
        if (interceptor == null) {
            return;
        }

        /** 登录校验 */
        if (interceptor.checkLogin()) {
            checkLogin();
        }

        /** 校验权限 */
        if (interceptor.permissionCode() != null && interceptor.permissionCode() != PermissionCodeEnum.NO_PERMISSION) {
            checkPermission(interceptor.permissionCode());
        }

        /** 参数校验 */
        if (interceptor.checkParams()) {
            validateParams(method, arguments);
        }
    }

    /***
     * 登录验证
     */
    void checkLogin() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        SessionUserAdminDto sessionUserAdminDto = (SessionUserAdminDto) request.getSession().getAttribute(Constants.SESSION_KEY);
        if (sessionUserAdminDto == null) {
            throw new BusinessException(ResponseCodeEnum.CODE_901); /** 登录超时 */
        }
    }

    void checkPermission(PermissionCodeEnum permissionCodeEnum) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        SessionUserAdminDto sessionUserAdminDto = (SessionUserAdminDto) request.getSession().getAttribute(Constants.SESSION_KEY);
        List<String> permissionCodeList = sessionUserAdminDto.getPermissionCodeList();
        if (!permissionCodeList.contains(permissionCodeEnum.getCode())) {
            throw new BusinessException(ResponseCodeEnum.CODE_902);
        }
    }

    /**
     * 参数校验
     */
    private void validateParams(Method method, Object[] arguments) throws BusinessException {
        Parameter[] parameters = method.getParameters();
        for (int i = 0; i < parameters.length; i++) {
            Parameter parameter = parameters[i];
            Object value = arguments[i];
            VerifyParam verifyParam = parameter.getAnnotation(VerifyParam.class);
            if (verifyParam == null) {
                continue;
            }
            String paramTypeName = parameter.getParameterizedType().getTypeName(); // 参数类型名

            if (ArrayUtils.contains(BASE_TYPE_ARRAY, paramTypeName)) { // 是否在规则内
                checkValue(value, verifyParam);
            } else {
                checkObjValue(parameter, value);
            }
        }
    }

    /***
     * 对象类型的参数校验
     * @param parameter
     * @param value
     */
    private void checkObjValue(Parameter parameter, Object value) {
        try {
            String typeName = parameter.getParameterizedType().getTypeName();
            Class classz = Class.forName(typeName);
            Field[] fields = classz.getDeclaredFields();
            for (Field field : fields) {
                VerifyParam filedVerifyParam = field.getAnnotation(VerifyParam.class);
                if (filedVerifyParam == null) {
                    continue;
                }
                field.setAccessible(true);
                Object resultValue = field.get(value);
                checkValue(resultValue, filedVerifyParam);
            }
        } catch (Exception e) {
            logger.error("校验对象参数失败");
        }
    }

    /***
     * 基本数据类型的参数校验
     * @param value
     * @param verifyParam
     */
    private void checkValue(Object value, VerifyParam verifyParam) throws BusinessException {
        Boolean isEmpty = value == null || StringTools.isEmpty(value.toString());
        Integer length = value == null ? 0 : value.toString().length();

        /**
         * 校验空
         * */
        if (isEmpty && verifyParam.required()) {
            throw new BusinessException(ResponseCodeEnum.CODE_600);
        }
        /**
         校验长度
         */
        if (!isEmpty && (verifyParam.max() != -1 && verifyParam.max() < length || verifyParam.min() != -1 && verifyParam.min() > length)) {
            throw new BusinessException(ResponseCodeEnum.CODE_600);
        }

        /**
         * 校验正则
         */
        if (!isEmpty && !StringTools.isEmpty(verifyParam.regex().getRegex()) && !VerifyUtils.verify(verifyParam.regex(), String.valueOf(value))) {
            throw new BusinessException(ResponseCodeEnum.CODE_600);
        }
    }
}
