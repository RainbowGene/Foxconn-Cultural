package com.cultural.entity.query;

import java.util.Date;


/**
 * 参数
 */
public class CulArticleQuery extends BaseParam {


	/**
	 * 文章id
	 */
	private String articleId;

	private String articleIdFuzzy;

	/**
	 * 所属栏目id
	 */
	private Integer columnId;

	/**
	 * 所属栏目名
	 */
	private String columnName;

	private String columnNameFuzzy;

	/**
	 * 父栏目id
	 */
	private Integer pColumnId;

	/**
	 * 所属父栏目名
	 */
	private String pColumnName;

	private String pColumnNameFuzzy;

	/**
	 * 发布人id
	 */
	private Integer userId;

	/**
	 * 发布人用户名
	 */
	private String userName;

	private String userNameFuzzy;

	/**
	 * 发布人IP地址
	 */
	private String userIpAddress;

	private String userIpAddressFuzzy;

	/**
	 * 标题
	 */
	private String title;

	private String titleFuzzy;

	/**
	 * 封面
	 */
	private String cover;

	private String coverFuzzy;

	/**
	 * 标签组
	 */
	private String tags;

	private String tagsFuzzy;

	/**
	 * 内容
	 */
	private String content;

	private String contentFuzzy;

	/**
	 * markdown内容
	 */
	private String markdownContent;

	private String markdownContentFuzzy;

	/**
	 * 0 富文本 1 markdown
	 */
	private Integer editorType;

	/**
	 * 摘要
	 */
	private String summary;

	private String summaryFuzzy;

	/**
	 * 发布时间
	 */
	private String postTime;

	private String postTimeStart;

	private String postTimeEnd;

	/**
	 * 最后一次修改时间
	 */
	private String lastUpdateTime;

	private String lastUpdateTimeStart;

	private String lastUpdateTimeEnd;

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

	public void setArticleIdFuzzy(String articleIdFuzzy){
		this.articleIdFuzzy = articleIdFuzzy;
	}

	public String getArticleIdFuzzy(){
		return this.articleIdFuzzy;
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

	public void setpColumnNameFuzzy(String pColumnNameFuzzy){
		this.pColumnNameFuzzy = pColumnNameFuzzy;
	}

	public String getpColumnNameFuzzy(){
		return this.pColumnNameFuzzy;
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

	public void setUserNameFuzzy(String userNameFuzzy){
		this.userNameFuzzy = userNameFuzzy;
	}

	public String getUserNameFuzzy(){
		return this.userNameFuzzy;
	}

	public void setUserIpAddress(String userIpAddress){
		this.userIpAddress = userIpAddress;
	}

	public String getUserIpAddress(){
		return this.userIpAddress;
	}

	public void setUserIpAddressFuzzy(String userIpAddressFuzzy){
		this.userIpAddressFuzzy = userIpAddressFuzzy;
	}

	public String getUserIpAddressFuzzy(){
		return this.userIpAddressFuzzy;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return this.title;
	}

	public void setTitleFuzzy(String titleFuzzy){
		this.titleFuzzy = titleFuzzy;
	}

	public String getTitleFuzzy(){
		return this.titleFuzzy;
	}

	public void setCover(String cover){
		this.cover = cover;
	}

	public String getCover(){
		return this.cover;
	}

	public void setCoverFuzzy(String coverFuzzy){
		this.coverFuzzy = coverFuzzy;
	}

	public String getCoverFuzzy(){
		return this.coverFuzzy;
	}

	public void setTags(String tags){
		this.tags = tags;
	}

	public String getTags(){
		return this.tags;
	}

	public void setTagsFuzzy(String tagsFuzzy){
		this.tagsFuzzy = tagsFuzzy;
	}

	public String getTagsFuzzy(){
		return this.tagsFuzzy;
	}

	public void setContent(String content){
		this.content = content;
	}

	public String getContent(){
		return this.content;
	}

	public void setContentFuzzy(String contentFuzzy){
		this.contentFuzzy = contentFuzzy;
	}

	public String getContentFuzzy(){
		return this.contentFuzzy;
	}

	public void setMarkdownContent(String markdownContent){
		this.markdownContent = markdownContent;
	}

	public String getMarkdownContent(){
		return this.markdownContent;
	}

	public void setMarkdownContentFuzzy(String markdownContentFuzzy){
		this.markdownContentFuzzy = markdownContentFuzzy;
	}

	public String getMarkdownContentFuzzy(){
		return this.markdownContentFuzzy;
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

	public void setSummaryFuzzy(String summaryFuzzy){
		this.summaryFuzzy = summaryFuzzy;
	}

	public String getSummaryFuzzy(){
		return this.summaryFuzzy;
	}

	public void setPostTime(String postTime){
		this.postTime = postTime;
	}

	public String getPostTime(){
		return this.postTime;
	}

	public void setPostTimeStart(String postTimeStart){
		this.postTimeStart = postTimeStart;
	}

	public String getPostTimeStart(){
		return this.postTimeStart;
	}
	public void setPostTimeEnd(String postTimeEnd){
		this.postTimeEnd = postTimeEnd;
	}

	public String getPostTimeEnd(){
		return this.postTimeEnd;
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

}
