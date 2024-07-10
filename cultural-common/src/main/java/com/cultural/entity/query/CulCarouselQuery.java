package com.cultural.entity.query;



/**
 * 参数
 */
public class CulCarouselQuery extends BaseParam {


	/**
	 * 轮播图ID
	 */
	private Integer carouselId;

	/**
	 * pc端轮播图地址
	 */
	private String pcImgUrl;

	private String pcImgUrlFuzzy;

	/**
	 * 移动端轮播图地址
	 */
	private String appImgUrl;

	private String appImgUrlFuzzy;

	/**
	 * 0 文章id 1 长图展示 2 外链
	 */
	private Integer objectType;

	/**
	 * 文章id
	 */
	private String objectId;

	private String objectIdFuzzy;

	/**
	 * 外部链接
	 */
	private String outerLink;

	private String outerLinkFuzzy;

	/**
	 * 排序
	 */
	private Integer sort;


	public void setCarouselId(Integer carouselId){
		this.carouselId = carouselId;
	}

	public Integer getCarouselId(){
		return this.carouselId;
	}

	public void setPcImgUrl(String pcImgUrl){
		this.pcImgUrl = pcImgUrl;
	}

	public String getPcImgUrl(){
		return this.pcImgUrl;
	}

	public void setPcImgUrlFuzzy(String pcImgUrlFuzzy){
		this.pcImgUrlFuzzy = pcImgUrlFuzzy;
	}

	public String getPcImgUrlFuzzy(){
		return this.pcImgUrlFuzzy;
	}

	public void setAppImgUrl(String appImgUrl){
		this.appImgUrl = appImgUrl;
	}

	public String getAppImgUrl(){
		return this.appImgUrl;
	}

	public void setAppImgUrlFuzzy(String appImgUrlFuzzy){
		this.appImgUrlFuzzy = appImgUrlFuzzy;
	}

	public String getAppImgUrlFuzzy(){
		return this.appImgUrlFuzzy;
	}

	public void setObjectType(Integer objectType){
		this.objectType = objectType;
	}

	public Integer getObjectType(){
		return this.objectType;
	}

	public void setObjectId(String objectId){
		this.objectId = objectId;
	}

	public String getObjectId(){
		return this.objectId;
	}

	public void setObjectIdFuzzy(String objectIdFuzzy){
		this.objectIdFuzzy = objectIdFuzzy;
	}

	public String getObjectIdFuzzy(){
		return this.objectIdFuzzy;
	}

	public void setOuterLink(String outerLink){
		this.outerLink = outerLink;
	}

	public String getOuterLink(){
		return this.outerLink;
	}

	public void setOuterLinkFuzzy(String outerLinkFuzzy){
		this.outerLinkFuzzy = outerLinkFuzzy;
	}

	public String getOuterLinkFuzzy(){
		return this.outerLinkFuzzy;
	}

	public void setSort(Integer sort){
		this.sort = sort;
	}

	public Integer getSort(){
		return this.sort;
	}

}
