package com.cultural.entity.po;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;


/**
 * 
 */
public class CulCarousel implements Serializable {


	/**
	 * 轮播图ID
	 */
	private Integer carouselId;

	/**
	 * pc端轮播图地址
	 */
	private String pcImgUrl;

	/**
	 * 移动端轮播图地址
	 */
	private String appImgUrl;

	/**
	 * 0 文章id 1 长图展示 2 外链
	 */
	private Integer objectType;

	/**
	 * 文章id
	 */
	private String objectId;

	/**
	 * 外部链接
	 */
	private String outerLink;

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

	public void setAppImgUrl(String appImgUrl){
		this.appImgUrl = appImgUrl;
	}

	public String getAppImgUrl(){
		return this.appImgUrl;
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

	public void setOuterLink(String outerLink){
		this.outerLink = outerLink;
	}

	public String getOuterLink(){
		return this.outerLink;
	}

	public void setSort(Integer sort){
		this.sort = sort;
	}

	public Integer getSort(){
		return this.sort;
	}

	@Override
	public String toString (){
		return "轮播图ID:"+(carouselId == null ? "空" : carouselId)+"，pc端轮播图地址:"+(pcImgUrl == null ? "空" : pcImgUrl)+"，移动端轮播图地址:"+(appImgUrl == null ? "空" : appImgUrl)+"，0 文章id 1 长图展示 2 外链:"+(objectType == null ? "空" : objectType)+"，文章id:"+(objectId == null ? "空" : objectId)+"，外部链接:"+(outerLink == null ? "空" : outerLink)+"，排序:"+(sort == null ? "空" : sort);
	}
}
