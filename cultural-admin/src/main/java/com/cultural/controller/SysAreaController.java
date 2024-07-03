package com.cultural.controller;

import java.util.ArrayList;
import java.util.List;

import com.cultural.annotation.VerifyParam;
import com.cultural.entity.constants.Constants;
import com.cultural.entity.dto.FileUploadDto;
import com.cultural.entity.enums.FileUploadTypeEnum;
import com.cultural.entity.po.SysColumn;
import com.cultural.entity.query.SysAreaQuery;
import com.cultural.entity.po.SysArea;
import com.cultural.entity.vo.ResponseVO;
import com.cultural.service.SysAreaService;
import com.cultural.utils.FileUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * Controller
 */
@RestController("sysAreaController")
@RequestMapping("/content")
public class SysAreaController extends ABaseController {

    @Resource
    private SysAreaService sysAreaService;

    @Resource
    private FileUtils fileUtils;

    /**
     * 根据条件分页查询
     */
    @RequestMapping("/areaList")
    public ResponseVO areaList(SysAreaQuery query) {
        query.setFormate2Tree(true);
        query.setOrderBy("sort asc");
        List<SysArea> sysAreas = sysAreaService.findListByParam(query);
        return getSuccessResponseVO(sysAreas);
    }

    /***
     * 新增地区
     * @param
     * @return
     */
    @RequestMapping("/saveArea")
    public ResponseVO saveArea(Integer areaId,
                               @VerifyParam(required = true) String areaName,
                               @VerifyParam(required = true) Integer pId,
                               @VerifyParam(required = true) Integer type,
                               String areaDes,
                               Integer sort,
                               String imgUrls) {
        SysArea sysArea = new SysArea();
        sysArea.setAreaId(areaId);
        sysArea.setAreaName(areaName);
        sysArea.setpId(pId);
        sysArea.setAreaDes(areaDes);
        sysArea.setType(type);
        sysArea.setSort(sort);
        sysArea.setImgUrl(imgUrls);
        sysAreaService.saveArea(sysArea);
        return getSuccessResponseVO(null);
    }

    /**
     * 删除园区
     *
     * @param areaId
     * @return
     */
    @RequestMapping("/delArea")
    public ResponseVO delArea(@VerifyParam(required = true) Integer areaId) {
        sysAreaService.deleteSysAreaByAreaId(areaId);
        return getSuccessResponseVO(null);
    }
}