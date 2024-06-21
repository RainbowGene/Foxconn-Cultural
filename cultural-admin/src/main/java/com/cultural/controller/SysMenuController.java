package com.cultural.controller;

import java.util.List;

import com.cultural.entity.query.SysMenuQuery;
import com.cultural.entity.po.SysMenu;
import com.cultural.entity.vo.ResponseVO;
import com.cultural.service.SysMenuService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *  Controller
 */
@RestController("sysMenuController")
@RequestMapping("/settings")
public class SysMenuController extends ABaseController{

	@Resource
	private SysMenuService sysMenuService;
	/**
	 * 根据条件分页查询
	 */
	@RequestMapping("/menuList")
	public ResponseVO loadDataList(){
		SysMenuQuery query = new SysMenuQuery();
		query.setFormate2Tree(true);  // 需要格式化为tree
		query.setOrderBy("sort asc");
		List<SysMenu> sysMenus = sysMenuService.findListByParam(query);
		return getSuccessResponseVO(sysMenus);
	}
}