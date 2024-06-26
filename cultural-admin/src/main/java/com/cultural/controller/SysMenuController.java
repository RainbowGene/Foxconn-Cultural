package com.cultural.controller;

import java.util.List;

import com.cultural.annotation.GlobalInterceptor;
import com.cultural.annotation.VerifyParam;
import com.cultural.entity.enums.PermissionCodeEnum;
import com.cultural.entity.query.SysMenuQuery;
import com.cultural.entity.po.SysMenu;
import com.cultural.entity.vo.ResponseVO;
import com.cultural.service.SysMenuService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Controller
 */
@RestController("sysMenuController")
@RequestMapping("/settings")
public class SysMenuController extends ABaseController {

    @Resource
    private SysMenuService sysMenuService;

    /**
     * 根据条件分页查询
     */
    @RequestMapping("/menuList")
    @GlobalInterceptor(permissionCode = PermissionCodeEnum.SETTINGS_MENU_LIST)
    public ResponseVO menuList() {
        SysMenuQuery query = new SysMenuQuery();
        query.setFormate2Tree(true);  // 需要格式化为tree
        query.setOrderBy("sort asc");
        List<SysMenu> sysMenus = sysMenuService.findListByParam(query);
        return getSuccessResponseVO(sysMenus);
    }

    /**
     * 新增/修改
     *
     * @param sysMenu
     * @return
     */
    @RequestMapping("/saveMenu")
    @GlobalInterceptor(permissionCode = PermissionCodeEnum.SETTINGS_MENU_EDIT)
    public ResponseVO saveMenu(@VerifyParam SysMenu sysMenu) {
        sysMenuService.saveMenu(sysMenu);
        return getSuccessResponseVO(null);
    }

    /**
     * 删除菜单
     * @param menuId
     * @return
     */
    @RequestMapping("/delMenu")
    @GlobalInterceptor(permissionCode = PermissionCodeEnum.SETTINGS_MENU_EDIT)
    public ResponseVO delMenu(@VerifyParam(required = true) Integer menuId) {
        sysMenuService.deleteSysMenuByMenuId(menuId);
        return getSuccessResponseVO(null);
    }

}