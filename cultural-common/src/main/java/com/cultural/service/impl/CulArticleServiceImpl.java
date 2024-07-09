package com.cultural.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.cultural.entity.constants.Constants;
import com.cultural.entity.dto.FileUploadDto;
import com.cultural.entity.enums.*;
import com.cultural.exception.BusinessException;
import com.cultural.utils.FileUtils;
import com.cultural.utils.ImageUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.cultural.entity.query.CulArticleQuery;
import com.cultural.entity.po.CulArticle;
import com.cultural.entity.vo.PaginationResultVO;
import com.cultural.entity.query.SimplePage;
import com.cultural.mappers.CulArticleMapper;
import com.cultural.service.CulArticleService;
import com.cultural.utils.StringTools;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


/**
 * 业务接口实现
 */
@Service("culArticleService")
public class CulArticleServiceImpl implements CulArticleService {

    @Resource
    private CulArticleMapper<CulArticle, CulArticleQuery> culArticleMapper;

    @Lazy
    @Resource
    private CulArticleServiceImpl culArticleService;


    @Resource
    private FileUtils fileUtils;

    @Resource
    private ImageUtils imageUtils;

    /**
     * 根据条件查询列表
     */
    @Override
    public List<CulArticle> findListByParam(CulArticleQuery param) {
        return this.culArticleMapper.selectList(param);
    }

    /**
     * 根据条件查询列表
     */
    @Override
    public Integer findCountByParam(CulArticleQuery param) {
        return this.culArticleMapper.selectCount(param);
    }

    /**
     * 分页查询方法
     */
    @Override
    public PaginationResultVO<CulArticle> findListByPage(CulArticleQuery param) {
        int count = this.findCountByParam(param);
        int pageSize = param.getPageSize() == null ? PageSize.SIZE15.getSize() : param.getPageSize();

        SimplePage page = new SimplePage(param.getPageNo(), count, pageSize);
        param.setSimplePage(page);
        List<CulArticle> list = this.findListByParam(param);
        PaginationResultVO<CulArticle> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
        return result;
    }

    /**
     * 新增
     */
    @Override
    public Integer add(CulArticle bean) {
        return this.culArticleMapper.insert(bean);
    }

    /**
     * 批量新增
     */
    @Override
    public Integer addBatch(List<CulArticle> listBean) {
        if (listBean == null || listBean.isEmpty()) {
            return 0;
        }
        return this.culArticleMapper.insertBatch(listBean);
    }

    /**
     * 批量新增或者修改
     */
    @Override
    public Integer addOrUpdateBatch(List<CulArticle> listBean) {
        if (listBean == null || listBean.isEmpty()) {
            return 0;
        }
        return this.culArticleMapper.insertOrUpdateBatch(listBean);
    }

    /**
     * 多条件更新
     */
    @Override
    public Integer updateByParam(CulArticle bean, CulArticleQuery param) {
        StringTools.checkParam(param);
        return this.culArticleMapper.updateByParam(bean, param);
    }

    /**
     * 多条件删除
     */
    @Override
    public Integer deleteByParam(CulArticleQuery param) {
        StringTools.checkParam(param);
        return this.culArticleMapper.deleteByParam(param);
    }

    /**
     * 根据ArticleId获取对象
     */
    @Override
    public CulArticle getCulArticleByArticleId(String articleId) {
        return this.culArticleMapper.selectByArticleId(articleId);
    }

    /**
     * 根据ArticleId修改
     */
    @Override
    public Integer updateCulArticleByArticleId(CulArticle bean, String articleId) {
        return this.culArticleMapper.updateByArticleId(bean, articleId);
    }

    /**
     * 根据ArticleId删除
     */
    @Override
    public Integer deleteCulArticleByArticleId(String articleId) {
        return this.culArticleMapper.deleteByArticleId(articleId);
    }

    /**
     * 批量删除
     *
     * @param articleIds
     */
    @Override
    public void delArticle(String articleIds) {
        String[] articleIdArray = articleIds.split(",");
        for (String articleId : articleIdArray) {
            culArticleService.delArticle(articleId);
        }
    }

    /**
     * 发布文章
     *
     * @param article
     * @param cover
     * @param attachment
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void postArticle(CulArticle article, MultipartFile cover, MultipartFile attachment) {
        article.setPostTime(new Date());
        article.setLastUpdateTime(new Date());

        if (cover != null) {
            FileUploadDto fileUploadDto = fileUtils.uploadFile2Local(cover, FileUploadTypeEnum.ARTICLE_COVER, Constants.FILE_FOLDER_IMAGE);
            article.setCover(fileUploadDto.getLocalPath());
        }

        //上传附件
//        if (attachment != null) {
//            article.setAttachmentType(Constants.ONE);
//            uploadAttachment(article, forumArticleAttachment, attachment, false);
//        } else {
//            article.setAttachmentType(Constants.ZERO);
//        }

        // 文章是否需要审核,此处先默认都要审核
        article.setStatus(ArticleStatusEnum.NO_AUDIT.getStatus());

        //替换图片
        String content = article.getContent();
        if (!StringTools.isEmpty(content)) {
            String month = imageUtils.resetImageHtml(content);
            //避免替换博客中template关键，所以前后带上/
            String replaceMonth = "/" + month + "/";
            content = content.replace(Constants.FILE_FOLDER_TEMP, replaceMonth);
            article.setContent(content);
            String markdownContent = article.getMarkdownContent();
            if (!StringTools.isEmpty(markdownContent)) {
                markdownContent = markdownContent.replace(Constants.FILE_FOLDER_TEMP, replaceMonth);
                article.setMarkdownContent(markdownContent);
            }
        }
        if (article.getArticleId() == null) { // 新增
            String articleId = StringTools.getRandomString(Constants.LENGTH_15); // 生成文章id随机数
            article.setArticleId(articleId);
            this.culArticleMapper.insert(article);
        } else { // 修改
            this.culArticleMapper.updateByArticleId(article, article.getArticleId());
        }
    }

    /**
     * 增加阅读数
     *
     * @param artcileId
     * @return
     */
    @Override
    public CulArticle readArticle(String artcileId) {
        CulArticle article = this.culArticleMapper.selectByArticleId(artcileId);
        if (article == null) {
            throw new BusinessException(ResponseCodeEnum.CODE_404);
        }
        if (ArticleStatusEnum.AUDIT.getStatus().equals(article.getStatus())) {
            culArticleMapper.updateArticleCount(UpdateArticleCountTypeEnum.READ_COUNT.getType(), 1, artcileId);
        }
        return article;
    }
}