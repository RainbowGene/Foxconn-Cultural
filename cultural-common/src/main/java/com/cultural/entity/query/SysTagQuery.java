package com.cultural.entity.query;

import java.util.Date;


/**
 * 参数
 */
public class SysTagQuery extends BaseParam {


	/**
	 * 标签id
	 */
	private Integer tagId;

	/**
	 * 标签名
	 */
	private String tagName;

	private String tagNameFuzzy;

	/**
	 * 标签类别
	 */
	private Integer tagType;

	/**
	 * 标签颜色
	 */
	private String tagColor;

	private String tagColorFuzzy;

	/**
	 * 创建时间
	 */
	private String createTime;

	private String createTimeStart;

	private String createTimeEnd;

	/**
	 * 最后一次修改时间
	 */
	private String lastUpdateTime;

	private String lastUpdateTimeStart;

	private String lastUpdateTimeEnd;


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

	public void setTagNameFuzzy(String tagNameFuzzy){
		this.tagNameFuzzy = tagNameFuzzy;
	}

	public String getTagNameFuzzy(){
		return this.tagNameFuzzy;
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

	public void setTagColorFuzzy(String tagColorFuzzy){
		this.tagColorFuzzy = tagColorFuzzy;
	}

	public String getTagColorFuzzy(){
		return this.tagColorFuzzy;
	}

	public void setCreateTime(String createTime){
		this.createTime = createTime;
	}

	public String getCreateTime(){
		return this.createTime;
	}

	public void setCreateTimeStart(String createTimeStart){
		this.createTimeStart = createTimeStart;
	}

	public String getCreateTimeStart(){
		return this.createTimeStart;
	}
	public void setCreateTimeEnd(String createTimeEnd){
		this.createTimeEnd = createTimeEnd;
	}

	public String getCreateTimeEnd(){
		return this.createTimeEnd;
	}

	public void setLastUpdateTime(String lastUpdateTime){
		this.lastUpdateTime = lastUpdateTime;
	}

	public String getLastUpdateTime(){
		return this.lastUpdateTime;
	}

	public void setLastUpdateTimeStart(String lastUpdateTimeStart){
		this.lastUpdateTimeStart = lastUpdateTimeStart;
	}

	public String getLastUpdateTimeStart(){
		return this.lastUpdateTimeStart;
	}
	public void setLastUpdateTimeEnd(String lastUpdateTimeEnd){
		this.lastUpdateTimeEnd = lastUpdateTimeEnd;
	}

	public String getLastUpdateTimeEnd(){
		return this.lastUpdateTimeEnd;
	}

}
