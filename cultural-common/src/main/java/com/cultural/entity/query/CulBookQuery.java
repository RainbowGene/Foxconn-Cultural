package com.cultural.entity.query;

import java.util.Date;


/**
 * 参数
 */
public class CulBookQuery extends BaseParam {


	/**
	 * 电子书id
	 */
	private Integer bookId;

	/**
	 * 电子书名
	 */
	private String bookName;

	private String bookNameFuzzy;

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
	 * 摘要
	 */
	private String summary;

	private String summaryFuzzy;

	/**
	 * 上传时间
	 */
	private String postTime;

	private String postTimeStart;

	private String postTimeEnd;

	/**
	 * 上传地址
	 */
	private String bookUrl;

	private String bookUrlFuzzy;

	/**
	 * 最后一次修改时间
	 */
	private String lastUpdateTime;

	private String lastUpdateTimeStart;

	private String lastUpdateTimeEnd;

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

	private String userNameFuzzy;


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

	public void setBookNameFuzzy(String bookNameFuzzy){
		this.bookNameFuzzy = bookNameFuzzy;
	}

	public String getBookNameFuzzy(){
		return this.bookNameFuzzy;
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

	public void setBookUrl(String bookUrl){
		this.bookUrl = bookUrl;
	}

	public String getBookUrl(){
		return this.bookUrl;
	}

	public void setBookUrlFuzzy(String bookUrlFuzzy){
		this.bookUrlFuzzy = bookUrlFuzzy;
	}

	public String getBookUrlFuzzy(){
		return this.bookUrlFuzzy;
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

	public void setUserNameFuzzy(String userNameFuzzy){
		this.userNameFuzzy = userNameFuzzy;
	}

	public String getUserNameFuzzy(){
		return this.userNameFuzzy;
	}

}
