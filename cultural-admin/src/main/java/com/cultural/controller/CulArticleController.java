package com.cultural.controller;

import java.util.List;

import com.cultural.annotation.GlobalInterceptor;
import com.cultural.annotation.VerifyParam;
import com.cultural.entity.dto.SessionUserAdminDto;
import com.cultural.entity.enums.EditorTypeEnum;
import com.cultural.entity.enums.ResponseCodeEnum;
import com.cultural.entity.query.CulArticleQuery;
import com.cultural.entity.po.CulArticle;
import com.cultural.entity.vo.ResponseVO;
import com.cultural.exception.BusinessException;
import com.cultural.service.CulArticleService;
import com.cultural.utils.StringTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Controller
 */
@RestController("culArticleController")
@RequestMapping("/post")
public class CulArticleController extends ABaseController {

    private static final Logger logger = LoggerFactory.getLogger(CulArticleController.class);

    @Resource
    private CulArticleService culArticleService;

    /**
     * 根据条件分页查询
     */
    @RequestMapping("/articleList")
    public ResponseVO loadDataList(CulArticleQuery query) {
        query.setOrderBy("post_time desc");
        return getSuccessResponseVO(culArticleService.findListByPage(query));
    }

    /**
     * 发布文章
     */
    @RequestMapping("/postArticle")
    @GlobalInterceptor
    public ResponseVO postArticle(HttpSession session,
                                  MultipartFile cover,
                                  MultipartFile attachment,
                                  String articleId,
                                  Integer integral,
                                  Integer pColumnId,
                                  Integer columnId,
                                  @VerifyParam(required = true, max = 150) String title,
                                  @VerifyParam String content,
                                  String markdownContent,
                                  @VerifyParam(required = true) Integer editorType,
                                  @VerifyParam(max = 200) String summary) {
        title = StringTools.escapeTitle(title);
        SessionUserAdminDto userAdminDto = getUserAdminFromSession(session);
        CulArticle culArticle = new CulArticle();
        if (articleId != null) {
            culArticle.setArticleId(articleId);
        }
        culArticle.setpColumnId(pColumnId);
        culArticle.setColumnId(columnId);
        culArticle.setTitle(title);
        culArticle.setContent(content);
        if (EditorTypeEnum.MARKDOWN.getType().equals(editorType) && StringTools.isEmpty(markdownContent)) {
            throw new BusinessException(ResponseCodeEnum.CODE_600);
        }
        culArticle.setMarkdownContent(markdownContent);
        culArticle.setEditorType(editorType);
        culArticle.setSummary(summary);
        culArticle.setUserId(userAdminDto.getUserid());
        culArticle.setUserName(userAdminDto.getUserName());
//        culArticle.setUserIpAddress(userDto.getProvince());
        // 附件信息
//        culArticleAttachment culArticleAttachment = new culArticleAttachment();
//        culArticleAttachment.setIntegral(integral == null ? 0 : integral);
        culArticleService.postArticle(culArticle, cover, attachment);
        return getSuccessResponseVO(culArticle.getArticleId());
    }

    /**
     * 删除文章，可批量
     *
     * @param articleIds
     * @return
     */
    @RequestMapping("/delArticle")
    @GlobalInterceptor
    public ResponseVO delArticle(@VerifyParam(required = true) String articleIds) {
        culArticleService.delArticle(articleIds);
        return getSuccessResponseVO(null);
    }
}