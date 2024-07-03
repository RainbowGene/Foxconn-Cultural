package com.cultural.controller;

import java.util.List;

import com.cultural.annotation.VerifyParam;
import com.cultural.entity.constants.Constants;
import com.cultural.entity.dto.FileUploadDto;
import com.cultural.entity.enums.ColumnStatusEnum;
import com.cultural.entity.enums.FileUploadTypeEnum;
import com.cultural.entity.enums.ResponseCodeEnum;
import com.cultural.entity.query.SysColumnQuery;
import com.cultural.entity.po.SysColumn;
import com.cultural.entity.vo.ResponseVO;
import com.cultural.exception.BusinessException;
import com.cultural.service.SysColumnService;
import com.cultural.utils.FileUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * Controller
 */
@RestController("sysColumnController")
@RequestMapping("/content")
public class SysColumnController extends ABaseController {

    @Resource
    private SysColumnService sysColumnService;

    @Resource
    private FileUtils fileUtils;

    /**
     * 根据条件分页查询
     */
    @RequestMapping("/columnList")
    public ResponseVO loadDataList(SysColumnQuery query) {
        query.setFormat2Tree(true);
        query.setOrderBy("sort asc");
        List<SysColumn> sysMenuList = sysColumnService.findListByParam(query);
        return getSuccessResponseVO(sysMenuList);
    }

    /***
     * 新增栏目
     * @param sysColumn
     * @return
     */
    @RequestMapping("/saveColumn")
    public ResponseVO saveMenu(@VerifyParam SysColumn sysColumn,MultipartFile cover) {
        if(cover!=null){ // 上传了封面图
            FileUploadDto uploadDto = fileUtils.uploadFile2Local(cover, FileUploadTypeEnum.ARTICLE_COVER, Constants.FILE_FOLDER_IMAGE);
            sysColumn.setIconPath(uploadDto.getLocalPath());
        }
        sysColumnService.saveColumn(sysColumn);
        return getSuccessResponseVO(null);
    }

    /***
     * 删除栏目
     * @param
     * @return
     */
    @RequestMapping("/delColumn")
    public ResponseVO delMenu(@VerifyParam(required = true) Integer columnId) {
        sysColumnService.deleteSysColumnByColumnId(columnId);
        return getSuccessResponseVO(null);
    }

    /**
     * 启用/禁用栏目
     *
     * @param columnId
     * @return
     */
    @RequestMapping("/opColStatus")
    public ResponseVO opColStatus(@VerifyParam Integer columnId,
                                  @VerifyParam(required = true) Integer status) {
        ColumnStatusEnum userStatusEnum = ColumnStatusEnum.getByStatus(status);
        if (userStatusEnum == null) {
            throw new BusinessException(ResponseCodeEnum.CODE_600);
        }
        SysColumn updateInfo = new SysColumn();
        updateInfo.setStatus(status);
        sysColumnService.updateSysColumnByColumnId(updateInfo, columnId);
        return getSuccessResponseVO(null);
    }

    /**
     * 上移下移
     */
//    @RequestMapping("/changeSort")
//    public ResponseVO changeSort(@VerifyParam(required = true) String categoryIds) {
//        sysColumnService.changeSort(categoryIds);
//        return getSuccessResponseVO(null);
//    }


    /**
     * 根据类型加载所有分类
     * @param type
     * @return
     */
    @RequestMapping("/loadAllColumn4Select")
    public ResponseVO loadAllColumn4Select(@VerifyParam(required = true) Integer type) {
        List<SysColumn> list = sysColumnService.loadAllColumnByType(type);
        return getSuccessResponseVO(list);
    }
}