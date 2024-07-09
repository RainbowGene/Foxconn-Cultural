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
public class CulArticle implements Serializable {


	/**
	 * 文章id
	 */
	private String articleId;

	/**
	 * 所属栏目id
	 */
	private Integer columnId;

	/**
	 * 所属栏目名
	 */
	private String columnName;

	/**
	 * 父栏目id
	 */
	private Integer pColumnId;

	/**
	 * 所属父栏目名
	 */
	private String pColumnName;

	/**
	 * 发布人id
	 */
	private Integer userId;

	/**
	 * 发布人用户名
	 */
	private String userName;

	/**
	 * 发布人IP地址
	 */
	private String userIpAddress;

	/**
	 * 标题
	 */
	private String title;

	/**
	 * 封面
	 */
	private String cover;

	/**
	 * 标签组
	 */
	private String tags;

	/**
	 * 内容
	 */
	private String content;

	/**
	 * markdown内容
	 */
	private String markdownContent;

	/**
	 * 0 富文本 1 markdown
	 */
	private Integer editorType;

	/**
	 * 摘要
	 */
	private String summary;

	/**
	 * 发布时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date postTime;

	/**
	 * 最后一次修改时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date lastUpdateTime;

	/**
	 * 阅读量
	 */
	private Integer readCount;

	/**
	 * 点赞数
	 */
	private Integer goodCount;

	/**
	 * 评论数
	 */
	private Integer commentCount;

	/**
	 * 0未置顶 1已置顶
	 */
	private Integer topType;

	/**
	 * 0无附件 1有附件
	 */
	private Integer attachmentType;

	/**
	 * -1已删除 0待审核 1已审核
	 */
	private Integer status;


	public void setArticleId(String articleId){
		this.articleId = articleId;
	}

	public String getArticleId(){
		return this.articleId;
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

	public void setpColumnId(Integer pColumnId){
		this.pColumnId = pColumnId;
	}

	public Integer getpColumnId(){
		return this.pColumnId;
	}

	public void setpColumnName(String pColumnName){
		this.pColumnName = pColumnName;
	}

	public String getpColumnName(){
		return this.pColumnName;
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

	public void setUserIpAddress(String userIpAddress){
		this.userIpAddress = userIpAddress;
	}

	public String getUserIpAddress(){
		return this.userIpAddress;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return this.title;
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

	public void setContent(String content){
		this.content = content;
	}

	public String getContent(){
		return this.content;
	}

	public void setMarkdownContent(String markdownContent){
		this.markdownContent = markdownContent;
	}

	public String getMarkdownContent(){
		return this.markdownContent;
	}

	public void setEditorType(Integer editorType){
		this.editorType = editorType;
	}

	public Integer getEditorType(){
		return this.editorType;
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

	public void setGoodCount(Integer goodCount){
		this.goodCount = goodCount;
	}

	public Integer getGoodCount(){
		return this.goodCount;
	}

	public void setCommentCount(Integer commentCount){
		this.commentCount = commentCount;
	}

	public Integer getCommentCount(){
		return this.commentCount;
	}

	public void setTopType(Integer topType){
		this.topType = topType;
	}

	public Integer getTopType(){
		return this.topType;
	}

	public void setAttachmentType(Integer attachmentType){
		this.attachmentType = attachmentType;
	}

	public Integer getAttachmentType(){
		return this.attachmentType;
	}

	public void setStatus(Integer status){
		this.status = status;
	}

	public Integer getStatus(){
		return this.status;
	}

	@Override
	public String toString (){
		return "文章id:"+(articleId == null ? "空" : articleId)+"，所属栏目id:"+(columnId == null ? "空" : columnId)+"，所属栏目名:"+(columnName == null ? "空" : columnName)+"，父栏目id:"+(pColumnId == null ? "空" : pColumnId)+"，所属父栏目名:"+(pColumnName == null ? "空" : pColumnName)+"，发布人id:"+(userId == null ? "空" : userId)+"，发布人用户名:"+(userName == null ? "空" : userName)+"，发布人IP地址:"+(userIpAddress == null ? "空" : userIpAddress)+"，标题:"+(title == null ? "空" : title)+"，封面:"+(cover == null ? "空" : cover)+"，标签组:"+(tags == null ? "空" : tags)+"，内容:"+(content == null ? "空" : content)+"，markdown内容:"+(markdownContent == null ? "空" : markdownContent)+"，0 富文本 1 markdown:"+(editorType == null ? "空" : editorType)+"，摘要:"+(summary == null ? "空" : summary)+"，发布时间:"+(postTime == null ? "空" : DateUtil.format(postTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern()))+"，最后一次修改时间:"+(lastUpdateTime == null ? "空" : DateUtil.format(lastUpdateTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern()))+"，阅读量:"+(readCount == null ? "空" : readCount)+"，点赞数:"+(goodCount == null ? "空" : goodCount)+"，评论数:"+(commentCount == null ? "空" : commentCount)+"，0未置顶 1已置顶:"+(topType == null ? "空" : topType)+"，0无附件 1有附件:"+(attachmentType == null ? "空" : attachmentType)+"，-1已删除 0待审核 1已审核:"+(status == null ? "空" : status);
	}
}
