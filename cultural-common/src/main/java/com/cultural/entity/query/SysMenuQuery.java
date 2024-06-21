package com.cultural.entity.query;



/**
 * 参数
 */
public class SysMenuQuery extends BaseParam {


	/**
	 * 菜单id
	 */
	private Integer menuId;

	/**
	 * 菜单名
	 */
	private String menuName;

	private String menuNameFuzzy;

	/**
	 * 菜单类型: 0:菜单 1:按钮
	 */
	private Integer menuType;

	/**
	 * 菜单路由
	 */
	private String menuUrl;

	private String menuUrlFuzzy;

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

	private String permissionFuzzy;

	/**
	 * 图标
	 */
	private String icon;

	private String iconFuzzy;


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

	public void setMenuNameFuzzy(String menuNameFuzzy){
		this.menuNameFuzzy = menuNameFuzzy;
	}

	public String getMenuNameFuzzy(){
		return this.menuNameFuzzy;
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

	public void setMenuUrlFuzzy(String menuUrlFuzzy){
		this.menuUrlFuzzy = menuUrlFuzzy;
	}

	public String getMenuUrlFuzzy(){
		return this.menuUrlFuzzy;
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

	public void setPermissionFuzzy(String permissionFuzzy){
		this.permissionFuzzy = permissionFuzzy;
	}

	public String getPermissionFuzzy(){
		return this.permissionFuzzy;
	}

	public void setIcon(String icon){
		this.icon = icon;
	}

	public String getIcon(){
		return this.icon;
	}

	public void setIconFuzzy(String iconFuzzy){
		this.iconFuzzy = iconFuzzy;
	}

	public String getIconFuzzy(){
		return this.iconFuzzy;
	}

}
