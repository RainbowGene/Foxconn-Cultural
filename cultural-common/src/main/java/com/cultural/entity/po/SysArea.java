package com.cultural.entity.po;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;


/**
 * 
 */
public class SysArea implements Serializable {


	/**
	 * 地区id
	 */
	private Integer areaId;

	/**
	 * 地区名
	 */
	private String areaName;

	/**
	 * 所属地区
	 */
	private Integer pId;

	/**
	 * 地区简介
	 */
	private String areaDes;

	/**
	 * 介绍图片
	 */
	private String imgUrl;

	/**
	 * 0 地区 1 城市 2园区 3事业群
	 */
	private Integer type;

	/**
	 * 排序
	 */
	private Integer sort;

	private List<SysArea> children;

	public List<SysArea> getChildren() {
		return children;
	}

	public void setChildren(List<SysArea> children) {
		this.children = children;
	}

	public void setAreaId(Integer areaId){
		this.areaId = areaId;
	}

	public Integer getAreaId(){
		return this.areaId;
	}

	public void setAreaName(String areaName){
		this.areaName = areaName;
	}

	public String getAreaName(){
		return this.areaName;
	}

	public void setpId(Integer pId){
		this.pId = pId;
	}

	public Integer getpId(){
		return this.pId;
	}

	public void setAreaDes(String areaDes){
		this.areaDes = areaDes;
	}

	public String getAreaDes(){
		return this.areaDes;
	}

	public void setImgUrl(String imgUrl){
		this.imgUrl = imgUrl;
	}

	public String getImgUrl(){
		return this.imgUrl;
	}

	public void setType(Integer type){
		this.type = type;
	}

	public Integer getType(){
		return this.type;
	}

	public void setSort(Integer sort){
		this.sort = sort;
	}

	public Integer getSort(){
		return this.sort;
	}

	@Override
	public String toString (){
		return "地区id:"+(areaId == null ? "空" : areaId)+"，地区名:"+(areaName == null ? "空" : areaName)+"，所属地区:"+(pId == null ? "空" : pId)+"，地区简介:"+(areaDes == null ? "空" : areaDes)+"，介绍图片:"+(imgUrl == null ? "空" : imgUrl)+"，0 地区 1 城市 2园区 3事业群:"+(type == null ? "空" : type)+"，排序:"+(sort == null ? "空" : sort);
	}
}
