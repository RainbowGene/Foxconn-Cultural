package com.cultural.entity.po;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;


/**
 * 
 */
public class SysMenu implements Serializable {


	/**
	 * 菜单id
	 */
	private Integer menuId;

	/**
	 * 菜单名
	 */
	private String menuName;

	/**
	 * 菜单类型: 0:菜单 1:按钮
	 */
	private Integer menuType;

	/**
	 * 菜单路由
	 */
	private String menuUrl;

	/**
	 * 父级菜单id,根目录为0
	 */
	private Integer pId;

	/**
	 * 排序
	 */
	private Integer sort;

	/**
	 * 权限编码
	 */
	private String permission;

	/**
	 * 图标
	 */
	private String icon;


	public void setMenuId(Integer menuId){
		this.menuId = menuId;
	}

	public Integer getMenuId(){
		return this.menuId;
	}

	public void setMenuName(String menuName){
		this.menuName = menuName;
	}

	public String getMenuName(){
		return this.menuName;
	}

	public void setMenuType(Integer menuType){
		this.menuType = menuType;
	}

	public Integer getMenuType(){
		return this.menuType;
	}

	public void setMenuUrl(String menuUrl){
		this.menuUrl = menuUrl;
	}

	public String getMenuUrl(){
		return this.menuUrl;
	}

	public void setpId(Integer pId){
		this.pId = pId;
	}

	public Integer getpId(){
		return this.pId;
	}

	public void setSort(Integer sort){
		this.sort = sort;
	}

	public Integer getSort(){
		return this.sort;
	}

	public void setPermission(String permission){
		this.permission = permission;
	}

	public String getPermission(){
		return this.permission;
	}

	public void setIcon(String icon){
		this.icon = icon;
	}

	public String getIcon(){
		return this.icon;
	}

	@Override
	public String toString (){
		return "菜单id:"+(menuId == null ? "空" : menuId)+"，菜单名:"+(menuName == null ? "空" : menuName)+"，菜单类型: 0:菜单 1:按钮:"+(menuType == null ? "空" : menuType)+"，菜单路由:"+(menuUrl == null ? "空" : menuUrl)+"，父级菜单id,根目录为0:"+(pId == null ? "空" : pId)+"，排序:"+(sort == null ? "空" : sort)+"，权限编码:"+(permission == null ? "空" : permission)+"，图标:"+(icon == null ? "空" : icon);
	}
}