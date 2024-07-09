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
public class CulBook implements Serializable {


	/**
	 * 电子书id
	 */
	private Integer bookId;

	/**
	 * 电子书名
	 */
	private String bookName;

	/**
	 * 所属栏目id
	 */
	private Integer columnId;

	/**
	 * 所属栏目名
	 */
	private String columnName;

	/**
	 * 封面
	 */
	private String cover;

	/**
	 * 标签组
	 */
	private String tags;

	/**
	 * 摘要
	 */
	private String summary;

	/**
	 * 上传时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date postTime;

	/**
	 * 上传地址
	 */
	private String bookUrl;

	/**
	 * 最后一次修改时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date lastUpdateTime;

	/**
	 * 阅读数
	 */
	private Integer readCount;

	/**
	 * 点赞数
	 */
	private Integer likeCount;

	/**
	 * 0 不置顶 1 置顶
	 */
	private Integer topType;

	/**
	 * 0 屏蔽 1 展示 -1 已删
	 */
	private Integer status;

	/**
	 * 发布人id
	 */
	private Integer userId;

	/**
	 * 发布人
	 */
	private String userName;


	public void setBookId(Integer bookId){
		this.bookId = bookId;
	}

	public Integer getBookId(){
		return this.bookId;
	}

	public void setBookName(String bookName){
		this.bookName = bookName;
	}

	public String getBookName(){
		return this.bookName;
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

	public void setCover(String cover){
		this.cover = cover;
	}

	public String getCover(){
		return this.cover;
	}

	public void setTags(String tags){
		this.tags = tags;
	}

	public String getTags(){
		return this.tags;
	}

	public void setSummary(String summary){
		this.summary = summary;
	}

	public String getSummary(){
		return this.summary;
	}

	public void setPostTime(Date postTime){
		this.postTime = postTime;
	}

	public Date getPostTime(){
		return this.postTime;
	}

	public void setBookUrl(String bookUrl){
		this.bookUrl = bookUrl;
	}

	public String getBookUrl(){
		return this.bookUrl;
	}

	public void setLastUpdateTime(Date lastUpdateTime){
		this.lastUpdateTime = lastUpdateTime;
	}

	public Date getLastUpdateTime(){
		return this.lastUpdateTime;
	}

	public void setReadCount(Integer readCount){
		this.readCount = readCount;
	}

	public Integer getReadCount(){
		return this.readCount;
	}

	public void setLikeCount(Integer likeCount){
		this.likeCount = likeCount;
	}

	public Integer getLikeCount(){
		return this.likeCount;
	}

	public void setTopType(Integer topType){
		this.topType = topType;
	}

	public Integer getTopType(){
		return this.topType;
	}

	public void setStatus(Integer status){
		this.status = status;
	}

	public Integer getStatus(){
		return this.status;
	}

	public void setUserId(Integer userId){
		this.userId = userId;
	}

	public Integer getUserId(){
		return this.userId;
	}

	public void setUserName(String userName){
		this.userName = userName;
	}

	public String getUserName(){
		return this.userName;
	}

	@Override
	public String toString (){
		return "电子书id:"+(bookId == null ? "空" : bookId)+"，电子书名:"+(bookName == null ? "空" : bookName)+"，所属栏目id:"+(columnId == null ? "空" : columnId)+"，所属栏目名:"+(columnName == null ? "空" : columnName)+"，封面:"+(cover == null ? "空" : cover)+"，标签组:"+(tags == null ? "空" : tags)+"，摘要:"+(summary == null ? "空" : summary)+"，上传时间:"+(postTime == null ? "空" : DateUtil.format(postTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern()))+"，上传地址:"+(bookUrl == null ? "空" : bookUrl)+"，最后一次修改时间:"+(lastUpdateTime == null ? "空" : DateUtil.format(lastUpdateTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern()))+"，阅读数:"+(readCount == null ? "空" : readCount)+"，点赞数:"+(likeCount == null ? "空" : likeCount)+"，0 不置顶 1 置顶:"+(topType == null ? "空" : topType)+"，0 屏蔽 1 展示 -1 已删:"+(status == null ? "空" : status)+"，发布人id:"+(userId == null ? "空" : userId)+"，发布人:"+(userName == null ? "空" : userName);
	}
}
