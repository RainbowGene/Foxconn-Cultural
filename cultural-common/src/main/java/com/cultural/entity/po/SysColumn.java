package com.cultural.entity.po;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;


/**
 * 
 */
public class SysColumn implements Serializable {


	/**
	 * 栏目id
	 */
	private Integer columnId;

	/**
	 * 栏目名
	 */
	private String columnName;

	/**
	 * 排序
	 */
	private Integer sort;

	/**
	 * 图标
	 */
	private String iconPath;

	/**
	 * 背景颜色
	 */
	private String bgColor;

	/**
	 * 栏目封面
	 */
	private String columnCover;

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

	/**
	 * 栏目状态:0 禁用 1 启用
	 */
	private Integer status;

	/**
	 * 栏目简介
	 */
	private String columnDes;

	/**
	 * 子集：用于转tree型
	 */
	private List<SysColumn> children;

	public List<SysColumn> getChildren() {
		return children;
	}

	public void setChildren(List<SysColumn> children) {
		this.children = children;
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

	public void setBgColor(String bgColor){
		this.bgColor = bgColor;
	}

	public String getBgColor(){
		return this.bgColor;
	}

	public void setColumnCover(String columnCover){
		this.columnCover = columnCover;
	}

	public String getColumnCover(){
		return this.columnCover;
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

	@Override
	public String toString (){
		return "栏目id:"+(columnId == null ? "空" : columnId)+"，栏目名:"+(columnName == null ? "空" : columnName)+"，排序:"+(sort == null ? "空" : sort)+"，图标:"+(iconPath == null ? "空" : iconPath)+"，背景颜色:"+(bgColor == null ? "空" : bgColor)+"，栏目封面:"+(columnCover == null ? "空" : columnCover)+"，父极栏目:0 根节点:"+(pId == null ? "空" : pId)+"，栏目类型:0 普通栏目 1 广告页栏目 2 链接栏目:"+(type == null ? "空" : type)+"，跳转地址:文章列表/布幅图片地址/友链:"+(columnUrl == null ? "空" : columnUrl)+"，栏目状态:0 禁用 1 启用:"+(status == null ? "空" : status)+"，栏目简介:"+(columnDes == null ? "空" : columnDes);
	}
}
