package com.cultural.mappers;

import org.apache.ibatis.annotations.Param;

/**
 * 数据库操作接口
 */
public interface CulArticleMapper<T, P> extends BaseMapper<T, P> {

    /**
     * 根据ArticleId更新
     */
    Integer updateByArticleId(@Param("bean") T t, @Param("articleId") String articleId);


    /**
     * 根据ArticleId删除
     */
    Integer deleteByArticleId(@Param("articleId") String articleId);


    /**
     * 根据ArticleId获取对象
     */
    T selectByArticleId(@Param("articleId") String articleId);


    /**
     * 增加阅读数
     * @param updateType
     * @param changeCount
     * @param articleId
     */
    void updateArticleCount(@Param("updateType") Integer updateType, @Param("changeCount") Integer changeCount, @Param("articleId") String articleId);
}
