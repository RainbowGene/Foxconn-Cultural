package com.cultural.controller;

import com.cultural.annotation.GlobalInterceptor;
import com.cultural.annotation.VerifyParam;
import com.cultural.entity.constants.Constants;
import com.cultural.entity.dto.CreateImageCode;
import com.cultural.entity.dto.SessionUserAdminDto;
import com.cultural.entity.enums.VerifyRegexEnum;
import com.cultural.entity.vo.ResponseVO;
import com.cultural.exception.BusinessException;
import com.cultural.service.SysAccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
public class LoginController extends ABaseController {
    @Resource
    private SysAccountService sysAccountService;


    /**
     * 获取验证码
     *
     * @param response
     * @param session
     * @throws IOException
     */
    @RequestMapping("/checkCode")
    public void checkCode(HttpServletResponse response, HttpSession session) throws IOException {
        CreateImageCode vCode = new CreateImageCode(130, 38, 5, 10);
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        String code = vCode.getCode();
        session.setAttribute(Constants.CHECK_CODE_KEY, code); // 图片验证码放入session
        vCode.write(response.getOutputStream());
    }

    /**
     * 登录
     *
     * @param session
     * @param phone
     * @param password
     * @param checkCode
     * @return
     */
    @RequestMapping("/login")
    @GlobalInterceptor(checkLogin = false)
    public ResponseVO login(HttpSession session,
                            @VerifyParam(regex = VerifyRegexEnum.PHONE) String phone,
                            @VerifyParam(required = true) String password,
                            @VerifyParam(required = true) String checkCode) {
        if (!checkCode.equalsIgnoreCase((String) session.getAttribute(Constants.CHECK_CODE_KEY))) {
            throw new BusinessException("图片验证码错误！");
        }
        SessionUserAdminDto userAdminDto = sysAccountService.login(phone, password);
        session.setAttribute(Constants.SESSION_KEY, userAdminDto);
        return getSuccessResponseVO(userAdminDto);
    }
}
