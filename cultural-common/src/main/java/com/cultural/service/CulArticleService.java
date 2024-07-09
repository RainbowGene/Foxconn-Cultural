package com.cultural.service;

import java.util.List;

import com.cultural.entity.query.CulArticleQuery;
import com.cultural.entity.po.CulArticle;
import com.cultural.entity.vo.PaginationResultVO;
import org.springframework.web.multipart.MultipartFile;


/**
 * 业务接口
 */
public interface CulArticleService {

    /**
     * 根据条件查询列表
     */
    List<CulArticle> findListByParam(CulArticleQuery param);

    /**
     * 根据条件查询列表
     */
    Integer findCountByParam(CulArticleQuery param);

    /**
     * 分页查询
     */
    PaginationResultVO<CulArticle> findListByPage(CulArticleQuery param);

    /**
     * 新增
     */
    Integer add(CulArticle bean);

    /**
     * 批量新增
     */
    Integer addBatch(List<CulArticle> listBean);

    /**
     * 批量新增/修改
     */
    Integer addOrUpdateBatch(List<CulArticle> listBean);

    /**
     * 多条件更新
     */
    Integer updateByParam(CulArticle bean, CulArticleQuery param);

    /**
     * 多条件删除
     */
    Integer deleteByParam(CulArticleQuery param);

    /**
     * 根据ArticleId查询对象
     */
    CulArticle getCulArticleByArticleId(String articleId);


    /**
     * 根据ArticleId修改
     */
    Integer updateCulArticleByArticleId(CulArticle bean, String articleId);


    /**
     * 根据ArticleId删除
     */
    Integer deleteCulArticleByArticleId(String articleId);

    void delArticle(String articleIds);

    void postArticle(CulArticle culArticle, MultipartFile cover, MultipartFile attachment);

    CulArticle readArticle(String artcileId);
}