package com.cultural.entity.po;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import com.cultural.entity.enums.DateTimePatternEnum;
import com.cultural.utils.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;


/**
 * 
 */
public class SysTag implements Serializable {


	/**
	 * 标签id
	 */
	private Integer tagId;

	/**
	 * 标签名
	 */
	private String tagName;

	/**
	 * 标签类别
	 */
	private Integer tagType;

	/**
	 * 标签颜色
	 */
	private String tagColor;

	/**
	 * 创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	/**
	 * 最后一次修改时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date lastUpdateTime;


	public void setTagId(Integer tagId){
		this.tagId = tagId;
	}

	public Integer getTagId(){
		return this.tagId;
	}

	public void setTagName(String tagName){
		this.tagName = tagName;
	}

	public String getTagName(){
		return this.tagName;
	}

	public void setTagType(Integer tagType){
		this.tagType = tagType;
	}

	public Integer getTagType(){
		return this.tagType;
	}

	public void setTagColor(String tagColor){
		this.tagColor = tagColor;
	}

	public String getTagColor(){
		return this.tagColor;
	}

	public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}

	public Date getCreateTime(){
		return this.createTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime){
		this.lastUpdateTime = lastUpdateTime;
	}

	public Date getLastUpdateTime(){
		return this.lastUpdateTime;
	}

	@Override
	public String toString (){
		return "标签id:"+(tagId == null ? "空" : tagId)+"，标签名:"+(tagName == null ? "空" : tagName)+"，标签类别:"+(tagType == null ? "空" : tagType)+"，标签颜色:"+(tagColor == null ? "空" : tagColor)+"，创建时间:"+(createTime == null ? "空" : DateUtil.format(createTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern()))+"，最后一次修改时间:"+(lastUpdateTime == null ? "空" : DateUtil.format(lastUpdateTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern()));
	}
}
