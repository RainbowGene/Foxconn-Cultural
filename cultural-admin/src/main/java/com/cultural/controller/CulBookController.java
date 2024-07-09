package com.cultural.controller;

import java.util.List;

import com.cultural.annotation.GlobalInterceptor;
import com.cultural.annotation.VerifyParam;
import com.cultural.entity.dto.SessionUserAdminDto;
import com.cultural.entity.enums.EditorTypeEnum;
import com.cultural.entity.enums.ResponseCodeEnum;
import com.cultural.entity.po.CulArticle;
import com.cultural.entity.query.CulBookQuery;
import com.cultural.entity.po.CulBook;
import com.cultural.entity.vo.ResponseVO;
import com.cultural.exception.BusinessException;
import com.cultural.service.CulBookService;
import com.cultural.utils.StringTools;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Controller
 */
@RestController("culBookController")
@RequestMapping("/post")
public class CulBookController extends ABaseController {

    @Resource
    private CulBookService culBookService;

    /**
     * 根据条件分页查询
     */
    @RequestMapping("/bookList")
    @GlobalInterceptor
    public ResponseVO loadDataList(CulBookQuery query) {
        query.setOrderBy("post_time desc");
        return getSuccessResponseVO(culBookService.findListByPage(query));
    }

    @RequestMapping("/postBook")
    @GlobalInterceptor
    public ResponseVO postArticle(HttpSession session,
                                  MultipartFile cover,
                                  Integer bookId,
                                  Integer columnId,
                                  @VerifyParam(required = true, max = 150) String bookName,
                                  @VerifyParam(required = true) MultipartFile bookFile,
                                  String summary) {
        bookName = StringTools.escapeTitle(bookName);
        SessionUserAdminDto userAdminDto = getUserAdminFromSession(session);
        CulBook culBook = new CulBook();
        if (bookId != null) {
            culBook.setBookId(bookId);
        }
        if (bookFile == null) {
            throw new BusinessException("请上传正确的PDF文件");
        }
        culBook.setColumnId(columnId);
        culBook.setBookName(bookName);
        culBook.setSummary(summary);
        culBook.setUserId(userAdminDto.getUserid());
        culBook.setUserName(userAdminDto.getUserName());
        culBookService.postBook(culBook, cover, bookFile); // 
        return getSuccessResponseVO(culBook.getBookId());
    }


    @RequestMapping("/delBook")
    @GlobalInterceptor
    public ResponseVO delBook(@VerifyParam(required = true) int bookId) {
        culBookService.deleteBook(bookId);
        return getSuccessResponseVO(null);
    }
}