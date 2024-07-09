package com.cultural.service.impl;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.cultural.entity.config.AppConfig;
import com.cultural.entity.constants.Constants;
import com.cultural.entity.dto.FileUploadDto;
import com.cultural.entity.enums.FileUploadTypeEnum;
import com.cultural.exception.BusinessException;
import com.cultural.utils.FileUtils;
import org.springframework.stereotype.Service;

import com.cultural.entity.enums.PageSize;
import com.cultural.entity.query.CulBookQuery;
import com.cultural.entity.po.CulBook;
import com.cultural.entity.vo.PaginationResultVO;
import com.cultural.entity.query.SimplePage;
import com.cultural.mappers.CulBookMapper;
import com.cultural.service.CulBookService;
import com.cultural.utils.StringTools;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


/**
 * 业务接口实现
 */
@Service("culBookService")
public class CulBookServiceImpl implements CulBookService {

    @Resource
    private CulBookMapper<CulBook, CulBookQuery> culBookMapper;

    @Resource
    private FileUtils fileUtils;

    @Resource
    private AppConfig appConfig;

    /**
     * 根据条件查询列表
     */
    @Override
    public List<CulBook> findListByParam(CulBookQuery param) {
        return this.culBookMapper.selectList(param);
    }

    /**
     * 根据条件查询列表
     */
    @Override
    public Integer findCountByParam(CulBookQuery param) {
        return this.culBookMapper.selectCount(param);
    }

    /**
     * 分页查询方法
     */
    @Override
    public PaginationResultVO<CulBook> findListByPage(CulBookQuery param) {
        int count = this.findCountByParam(param);
        int pageSize = param.getPageSize() == null ? PageSize.SIZE15.getSize() : param.getPageSize();

        SimplePage page = new SimplePage(param.getPageNo(), count, pageSize);
        param.setSimplePage(page);
        List<CulBook> list = this.findListByParam(param);
        PaginationResultVO<CulBook> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
        return result;
    }

    /**
     * 新增
     */
    @Override
    public Integer add(CulBook bean) {
        return this.culBookMapper.insert(bean);
    }

    /**
     * 批量新增
     */
    @Override
    public Integer addBatch(List<CulBook> listBean) {
        if (listBean == null || listBean.isEmpty()) {
            return 0;
        }
        return this.culBookMapper.insertBatch(listBean);
    }

    /**
     * 批量新增或者修改
     */
    @Override
    public Integer addOrUpdateBatch(List<CulBook> listBean) {
        if (listBean == null || listBean.isEmpty()) {
            return 0;
        }
        return this.culBookMapper.insertOrUpdateBatch(listBean);
    }

    /**
     * 多条件更新
     */
    @Override
    public Integer updateByParam(CulBook bean, CulBookQuery param) {
        StringTools.checkParam(param);
        return this.culBookMapper.updateByParam(bean, param);
    }

    /**
     * 多条件删除
     */
    @Override
    public Integer deleteByParam(CulBookQuery param) {
        StringTools.checkParam(param);
        return this.culBookMapper.deleteByParam(param);
    }

    /**
     * 根据BookId获取对象
     */
    @Override
    public CulBook getCulBookByBookId(Integer bookId) {
        return this.culBookMapper.selectByBookId(bookId);
    }

    /**
     * 根据BookId修改
     */
    @Override
    public Integer updateCulBookByBookId(CulBook bean, Integer bookId) {
        return this.culBookMapper.updateByBookId(bean, bookId);
    }

    /**
     * 根据BookId删除
     */
    @Override
    public Integer deleteCulBookByBookId(Integer bookId) {
        return this.culBookMapper.deleteByBookId(bookId);
    }

    /**
     * 电子书上传
     *
     * @param culBook
     * @param cover
     * @param bookFile
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void postBook(CulBook culBook, MultipartFile cover, MultipartFile bookFile) {
        culBook.setPostTime(new Date());
        culBook.setLastUpdateTime(new Date());

        if (cover != null) {
            FileUploadDto fileUploadDto = fileUtils.uploadFile2Local(cover, FileUploadTypeEnum.ARTICLE_COVER, Constants.FILE_FOLDER_IMAGE);
            culBook.setCover(fileUploadDto.getLocalPath());
        }

        //上传电子书
        if (bookFile != null) {
            uploadBook(culBook, bookFile, false);
        }

    }

    /**
     * 上传电子书
     *
     * @param file
     * @param isUpdate 是否是修改,修改则要删除原文件
     */
    public void uploadBook(CulBook culBook, MultipartFile file, Boolean isUpdate) {
        // TODO 电子书大小限制，可以由后续系统设置模块控制 待完成...
        long allowSize = 10 * Constants.FILE_SIZE_1M;  // 最大10m
        if (file.getSize() > allowSize) {
            throw new BusinessException("附件最大只能10MB");
        }
        CulBook dbInfo = null;
        if (isUpdate) { // 如果是修改，删除之前对应的pdf
            CulBookQuery query = new CulBookQuery();
            query.setBookId(culBook.getBookId());
            List<CulBook> culBookList = this.culBookMapper.selectList(query); // 查询需要修改的信息
            if (!culBookList.isEmpty()) {
                dbInfo = culBookList.get(0);
                new File(appConfig.getProjectFolder() + Constants.FILE_FOLDER_FILE + dbInfo.getBookUrl()).delete();
            }
        }
        // 上传
        FileUploadDto fileUploadDto = fileUtils.uploadFile2Local(file, FileUploadTypeEnum.BOOK_PDF, Constants.FILE_FOLDER_FILE);
        if (dbInfo == null) { // 新增
            culBook.setBookUrl(fileUploadDto.getLocalPath());
            culBookMapper.insert(culBook);
        } else { // 修改
            CulBook updateInfo = new CulBook();
            updateInfo.setBookUrl(fileUploadDto.getLocalPath());
            culBookMapper.updateByBookId(updateInfo, culBook.getBookId());
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteBook(int bookId) {
        // 删除文件
        CulBook dbInfo = null;
        CulBookQuery query = new CulBookQuery();
        query.setBookId(bookId);
        List<CulBook> culBookList = this.culBookMapper.selectList(query); // 查询需要修改的信息
        if (!culBookList.isEmpty()) {
            dbInfo = culBookList.get(0);
            // 不知道这里为什么要加个 file 组成完整路径，封面的则不用
            new File(appConfig.getProjectFolder() + "file"+ Constants.FILE_FOLDER_FILE + dbInfo.getBookUrl()).delete();
        }
        culBookMapper.deleteByBookId(bookId);
    }
}