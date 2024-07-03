package com.cultural.entity.query;



/**
 * 参数
 */
public class SysAreaQuery extends BaseParam {


	/**
	 * 地区id
	 */
	private Integer areaId;

	/**
	 * 地区名
	 */
	private String areaName;

	private String areaNameFuzzy;

	/**
	 * 所属地区
	 */
	private Integer pId;

	/**
	 * 地区简介
	 */
	private String areaDes;

	private String areaDesFuzzy;

	/**
	 * 介绍图片
	 */
	private String imgUrl;

	private String imgUrlFuzzy;

	/**
	 * 0 地区 1 城市 2园区 3事业群
	 */
	private Integer type;

	/**
	 * 排序
	 */
	private Integer sort;

	private Boolean formate2Tree;

	public Boolean getFormate2Tree() {
		return formate2Tree;
	}

	public void setFormate2Tree(Boolean formate2Tree) {
		this.formate2Tree = formate2Tree;
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

	public void setAreaNameFuzzy(String areaNameFuzzy){
		this.areaNameFuzzy = areaNameFuzzy;
	}

	public String getAreaNameFuzzy(){
		return this.areaNameFuzzy;
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

	public void setAreaDesFuzzy(String areaDesFuzzy){
		this.areaDesFuzzy = areaDesFuzzy;
	}

	public String getAreaDesFuzzy(){
		return this.areaDesFuzzy;
	}

	public void setImgUrl(String imgUrl){
		this.imgUrl = imgUrl;
	}

	public String getImgUrl(){
		return this.imgUrl;
	}

	public void setImgUrlFuzzy(String imgUrlFuzzy){
		this.imgUrlFuzzy = imgUrlFuzzy;
	}

	public String getImgUrlFuzzy(){
		return this.imgUrlFuzzy;
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

}
