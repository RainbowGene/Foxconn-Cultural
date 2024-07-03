package com.cultural.entity.query;



/**
 * 参数
 */
public class SysColumnQuery extends BaseParam {


	/**
	 * 栏目id
	 */
	private Integer columnId;

	/**
	 * 栏目名
	 */
	private String columnName;

	private String columnNameFuzzy;

	/**
	 * 排序
	 */
	private Integer sort;

	/**
	 * 图标
	 */
	private String iconPath;

	private String iconPathFuzzy;

	/**
	 * 背景颜色
	 */
	private String bgColor;

	private String bgColorFuzzy;

	/**
	 * 栏目封面
	 */
	private String columnCover;

	private String columnCoverFuzzy;

	/**
	 * 父极栏目:0 根节点
	 */
	private Integer pId;

	/**
	 * 栏目类型:0 普通栏目 1 广告页栏目 2 链接栏目
	 */
	private Integer type;

	/**
	 * 跳转地址:文章列表/布幅图片地址/友链
	 */
	private String columnUrl;

	private String columnUrlFuzzy;

	/**
	 * 栏目状态:0 禁用 1 启用
	 */
	private Integer status;

	/**
	 * 栏目简介
	 */
	private String columnDes;

	private String columnDesFuzzy;

	private Boolean format2Tree;

	private Integer[] types;

	public Integer[] getTypes() {
		return types;
	}

	public void setTypes(Integer[] types) {
		this.types = types;
	}

	public Boolean getFormat2Tree() {
		return format2Tree;
	}

	public void setFormat2Tree(Boolean format2Tree) {
		this.format2Tree = format2Tree;
	}

	public void setColumnId(Integer columnId){
		this.columnId = columnId;
	}

	public Integer getColumnId(){
		return this.columnId;
	}

	public void setColumnName(String columnName){
		this.columnName = columnName;
	}

	public String getColumnName(){
		return this.columnName;
	}

	public void setColumnNameFuzzy(String columnNameFuzzy){
		this.columnNameFuzzy = columnNameFuzzy;
	}

	public String getColumnNameFuzzy(){
		return this.columnNameFuzzy;
	}

	public void setSort(Integer sort){
		this.sort = sort;
	}

	public Integer getSort(){
		return this.sort;
	}

	public void setIconPath(String iconPath){
		this.iconPath = iconPath;
	}

	public String getIconPath(){
		return this.iconPath;
	}

	public void setIconPathFuzzy(String iconPathFuzzy){
		this.iconPathFuzzy = iconPathFuzzy;
	}

	public String getIconPathFuzzy(){
		return this.iconPathFuzzy;
	}

	public void setBgColor(String bgColor){
		this.bgColor = bgColor;
	}

	public String getBgColor(){
		return this.bgColor;
	}

	public void setBgColorFuzzy(String bgColorFuzzy){
		this.bgColorFuzzy = bgColorFuzzy;
	}

	public String getBgColorFuzzy(){
		return this.bgColorFuzzy;
	}

	public void setColumnCover(String columnCover){
		this.columnCover = columnCover;
	}

	public String getColumnCover(){
		return this.columnCover;
	}

	public void setColumnCoverFuzzy(String columnCoverFuzzy){
		this.columnCoverFuzzy = columnCoverFuzzy;
	}

	public String getColumnCoverFuzzy(){
		return this.columnCoverFuzzy;
	}

	public void setpId(Integer pId){
		this.pId = pId;
	}

	public Integer getpId(){
		return this.pId;
	}

	public void setType(Integer type){
		this.type = type;
	}

	public Integer getType(){
		return this.type;
	}

	public void setColumnUrl(String columnUrl){
		this.columnUrl = columnUrl;
	}

	public String getColumnUrl(){
		return this.columnUrl;
	}

	public void setColumnUrlFuzzy(String columnUrlFuzzy){
		this.columnUrlFuzzy = columnUrlFuzzy;
	}

	public String getColumnUrlFuzzy(){
		return this.columnUrlFuzzy;
	}

	public void setStatus(Integer status){
		this.status = status;
	}

	public Integer getStatus(){
		return this.status;
	}

	public void setColumnDes(String columnDes){
		this.columnDes = columnDes;
	}

	public String getColumnDes(){
		return this.columnDes;
	}

	public void setColumnDesFuzzy(String columnDesFuzzy){
		this.columnDesFuzzy = columnDesFuzzy;
	}

	public String getColumnDesFuzzy(){
		return this.columnDesFuzzy;
	}

}
