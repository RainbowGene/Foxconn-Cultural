package com.cultural.controller;

import java.util.List;

import com.cultural.annotation.GlobalInterceptor;
import com.cultural.annotation.VerifyParam;
import com.cultural.entity.po.SysMenu;
import com.cultural.entity.query.SysRoleQuery;
import com.cultural.entity.po.SysRole;
import com.cultural.entity.vo.ResponseVO;
import com.cultural.service.SysRoleService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 系统角色表 Controller
 */
@RestController("sysRoleController")
@RequestMapping("/settings")
public class SysRoleController extends ABaseController {

    @Resource
    private SysRoleService sysRoleService;

    /**
     * 根据条件分页查询
     */
    @RequestMapping("/loadRoles")
    @GlobalInterceptor
    public ResponseVO loadRoles(SysRoleQuery query) {
        query.setOrderBy("create_time desc");
        return getSuccessResponseVO(sysRoleService.findListByPage(query));
    }

    /**
     * 获取所有角色
     */
    @RequestMapping("/loadAllRoles")
    public ResponseVO loadAllRoles() {
        SysRoleQuery query = new SysRoleQuery();
        query.setOrderBy("create_time desc");
        return getSuccessResponseVO(sysRoleService.findListByParam(query));
    }

    /**
     * 新增角色
     *
     * @param bean
     * @param menuIds     已勾选的菜单项
     * @param halfMenuIds 全选/半选
     * @return
     */
    @RequestMapping("/saveRole")
    @GlobalInterceptor
    public ResponseVO saveRole(@VerifyParam SysRole bean,
                               String menuIds,
                               String halfMenuIds) {
        sysRoleService.saveRole(bean, menuIds, halfMenuIds);
        return getSuccessResponseVO(null);
    }

    /**
     * 保存菜单
     *
     * @param roleId
     * @param menuIds
     * @param halfMenuIds
     * @return
     */
    @RequestMapping("/saveRoleMenu")
    @GlobalInterceptor
    public ResponseVO saveRoleMenu(@VerifyParam(required = true) Integer roleId,
                                   @VerifyParam(required = true) String menuIds,
                                   String halfMenuIds) {
        sysRoleService.saveRoleMenu(roleId, menuIds, halfMenuIds);
        return getSuccessResponseVO(null);
    }

    /**
     * 获取角色菜单
     *
     * @param roleId
     * @return
     */
    @RequestMapping("/getRoleByRoleId")
    @GlobalInterceptor
    public ResponseVO getRoleByRoleId(@VerifyParam(required = true) Integer roleId) {
        SysRole sysRole = sysRoleService.getSysRoleByRoleId(roleId);
        return getSuccessResponseVO(sysRole);
    }

    /**
     * 删除角色
     */
    @RequestMapping("/delRole")
    public ResponseVO delRole(@VerifyParam(required = true) Integer roleId) {
        sysRoleService.deleteSysRoleByRoleId(roleId);
        return getSuccessResponseVO(null);
    }
}