package com.cultural.controller;

import java.util.List;

import com.cultural.annotation.GlobalInterceptor;
import com.cultural.annotation.VerifyParam;
import com.cultural.entity.config.AppConfig;
import com.cultural.entity.enums.PermissionCodeEnum;
import com.cultural.entity.enums.ResponseCodeEnum;
import com.cultural.entity.enums.UserStatusEnum;
import com.cultural.entity.enums.VerifyRegexEnum;
import com.cultural.entity.query.SysAccountQuery;
import com.cultural.entity.po.SysAccount;
import com.cultural.entity.vo.ResponseVO;
import com.cultural.exception.BusinessException;
import com.cultural.service.SysAccountService;
import com.cultural.utils.StringTools;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Controller
 */
@RestController("sysAccountController")
@RequestMapping("/settings")
public class SysAccountController extends ABaseController {

    @Resource
    private SysAccountService sysAccountService;

    @Resource
    private AppConfig appConfig;

    /**
     * 根据条件分页查询
     */
    @RequestMapping("/loadAccountList")
    @GlobalInterceptor(permissionCode = PermissionCodeEnum.SETTINGS_ACCOUNT_LIST)
    public ResponseVO loadDataList(SysAccountQuery query) {
        query.setOrderBy("create_time desc");
        query.setQueryRoles(true);
        return getSuccessResponseVO(sysAccountService.findListByPage(query));
    }

    /**
     * 增加修改用户
     */
    @RequestMapping("/saveAccount")
    @GlobalInterceptor(permissionCode = PermissionCodeEnum.SETTINGS_ACCOUNT_EDIT)
    public ResponseVO saveAccount(@VerifyParam SysAccount sysAccount) {
        sysAccountService.saveSysAccount(sysAccount);
        return getSuccessResponseVO(null);
    }


    /**
     * 修改密码
     */
    @RequestMapping("/updatePassword")
    @GlobalInterceptor(permissionCode = PermissionCodeEnum.SETTINGS_ACCOUNT_UPDATE_PASSWORD)
    public ResponseVO updatePassword(@VerifyParam Integer userId,
                                     @VerifyParam(required = true, regex = VerifyRegexEnum.PASSWORD) String password) {
        SysAccount updateInfo = new SysAccount();
        updateInfo.setPassword(StringTools.encodeByMD5(password));
        sysAccountService.updateSysAccountByUserId(updateInfo, userId);
        return getSuccessResponseVO(null);
    }

    /**
     * 启用/禁用 账号
     */
    @RequestMapping("/updateStatus")
    @GlobalInterceptor(permissionCode = PermissionCodeEnum.SETTINGS_ACCOUNT_OP_STATUS)
    public ResponseVO updateStatus(@VerifyParam Integer userId,
                                   @VerifyParam(required = true) Integer status) {
        UserStatusEnum userStatusEnum = UserStatusEnum.getByStatus(status);
        if (userStatusEnum == null) {
            throw new BusinessException(ResponseCodeEnum.CODE_600);
        }
        SysAccount updateInfo = new SysAccount();
        updateInfo.setStatus(status);
        sysAccountService.updateSysAccountByUserId(updateInfo, userId);
        return getSuccessResponseVO(null);
    }

    /**
     * 删除
     */
    @RequestMapping("/delAccount")
    @GlobalInterceptor(permissionCode = PermissionCodeEnum.SETTINGS_ACCOUNT_DEL)
    public ResponseVO delAccount(@VerifyParam Integer userId) {
        SysAccount sysAccount = this.sysAccountService.getSysAccountByUserId(userId);
        /** 配置项里的超级管理员(多个用,隔开)不能删除*/
        if (!StringTools.isEmpty(appConfig.getSuperAdminPhones()) && ArrayUtils.contains(appConfig.getSuperAdminPhones().split(","), sysAccount.getPhone())) {
            throw new RuntimeException("超级管理员不能删除！");
        }
        sysAccountService.deleteSysAccountByUserId(userId);
        return getSuccessResponseVO(null);
    }
}