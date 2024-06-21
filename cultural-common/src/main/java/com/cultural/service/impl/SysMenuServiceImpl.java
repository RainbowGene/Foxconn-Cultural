package com.cultural.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.cultural.entity.constants.Constants;
import org.springframework.stereotype.Service;

import com.cultural.entity.enums.PageSize;
import com.cultural.entity.query.SysMenuQuery;
import com.cultural.entity.po.SysMenu;
import com.cultural.entity.vo.PaginationResultVO;
import com.cultural.entity.query.SimplePage;
import com.cultural.mappers.SysMenuMapper;
import com.cultural.service.SysMenuService;
import com.cultural.utils.StringTools;


/**
 * 业务接口实现
 */
@Service("sysMenuService")
public class SysMenuServiceImpl implements SysMenuService {

    private static final String ROOT_MENU_NAME = "所有菜单";

    @Resource
    private SysMenuMapper<SysMenu, SysMenuQuery> sysMenuMapper;

    /**
     * 根据条件查询列表
     */
    @Override
    public List<SysMenu> findListByParam(SysMenuQuery param) {
        List<SysMenu> sysMenus = this.sysMenuMapper.selectList(param);
        // 是否需要转为tree
        if (param.getFormate2Tree() != null && param.getFormate2Tree()) {
            // 根目录节点,不在数据库，自己定义
            SysMenu root = new SysMenu();
            root.setMenuId(Constants.DEFUALT_ROOT_MENU_ID); // 根节点 0
            root.setpId(-1); // root 的父节点没有
            root.setMenuName(ROOT_MENU_NAME);
            sysMenus.add(root);
            sysMenus = convertLine2Tree4Menu(sysMenus, -1); // 从-1根节点开始遍历
        }
        return sysMenus;
    }

    /**
     * 线性菜单项转树形菜单:使用递归
     *
     * @return
     */
    public List<SysMenu> convertLine2Tree4Menu(List<SysMenu> dataList, Integer pid) {
        List<SysMenu> children = new ArrayList<>();
        for (SysMenu m : dataList) {
            if (m.getMenuId() != null && m.getpId() != null && m.getpId().equals(pid)) {
                m.setChildren(convertLine2Tree4Menu(dataList, m.getMenuId()));
                children.add(m);
            }
        }
        return children;
    }

    /**
     * 根据条件查询列表
     */
    @Override
    public Integer findCountByParam(SysMenuQuery param) {
        return this.sysMenuMapper.selectCount(param);
    }

    /**
     * 分页查询方法
     */
    @Override
    public PaginationResultVO<SysMenu> findListByPage(SysMenuQuery param) {
        int count = this.findCountByParam(param);
        int pageSize = param.getPageSize() == null ? PageSize.SIZE15.getSize() : param.getPageSize();

        SimplePage page = new SimplePage(param.getPageNo(), count, pageSize);
        param.setSimplePage(page);
        List<SysMenu> list = this.findListByParam(param);
        PaginationResultVO<SysMenu> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
        return result;
    }

    /**
     * 新增
     */
    @Override
    public Integer add(SysMenu bean) {
        return this.sysMenuMapper.insert(bean);
    }

    /**
     * 批量新增
     */
    @Override
    public Integer addBatch(List<SysMenu> listBean) {
        if (listBean == null || listBean.isEmpty()) {
            return 0;
        }
        return this.sysMenuMapper.insertBatch(listBean);
    }

    /**
     * 批量新增或者修改
     */
    @Override
    public Integer addOrUpdateBatch(List<SysMenu> listBean) {
        if (listBean == null || listBean.isEmpty()) {
            return 0;
        }
        return this.sysMenuMapper.insertOrUpdateBatch(listBean);
    }

    /**
     * 多条件更新
     */
    @Override
    public Integer updateByParam(SysMenu bean, SysMenuQuery param) {
        StringTools.checkParam(param);
        return this.sysMenuMapper.updateByParam(bean, param);
    }

    /**
     * 多条件删除
     */
    @Override
    public Integer deleteByParam(SysMenuQuery param) {
        StringTools.checkParam(param);
        return this.sysMenuMapper.deleteByParam(param);
    }

    /**
     * 根据MenuId获取对象
     */
    @Override
    public SysMenu getSysMenuByMenuId(Integer menuId) {
        return this.sysMenuMapper.selectByMenuId(menuId);
    }

    /**
     * 根据MenuId修改
     */
    @Override
    public Integer updateSysMenuByMenuId(SysMenu bean, Integer menuId) {
        return this.sysMenuMapper.updateByMenuId(bean, menuId);
    }

    /**
     * 根据MenuId删除
     */
    @Override
    public Integer deleteSysMenuByMenuId(Integer menuId) {
        return this.sysMenuMapper.deleteByMenuId(menuId);
    }
}