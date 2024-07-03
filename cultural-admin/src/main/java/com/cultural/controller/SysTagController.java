package com.cultural.controller;

import java.util.List;

import com.cultural.annotation.GlobalInterceptor;
import com.cultural.annotation.VerifyParam;
import com.cultural.entity.enums.PermissionCodeEnum;
import com.cultural.entity.po.SysAccount;
import com.cultural.entity.query.SysTagQuery;
import com.cultural.entity.po.SysTag;
import com.cultural.entity.vo.ResponseVO;
import com.cultural.service.SysTagService;
import com.cultural.utils.StringTools;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Controller
 */
@RestController("sysTagController")
@RequestMapping("/content")
public class SysTagController extends ABaseController {

    @Resource
    private SysTagService sysTagService;

    /**
     * 根据条件分页查询
     */
    @RequestMapping("/tagList")
    public ResponseVO tagList(SysTagQuery query) {
        query.setOrderBy("create_time desc");
        return getSuccessResponseVO(sysTagService.findListByPage(query));
    }

    /**
     * 添加/修改标签
     *
     * @param sysTag
     * @return
     */
    @RequestMapping("/saveTag")
    public ResponseVO saveAccount(@VerifyParam SysTag sysTag) {
        sysTagService.saveTag(sysTag);
        return getSuccessResponseVO(null);
    }

    /**
     * 删除标签
     * @param tagId
     * @return
     */
    @RequestMapping("/delTag")
    public ResponseVO delAccount(@VerifyParam Integer tagId) {
        sysTagService.deleteSysTagByTagId(tagId);
        return getSuccessResponseVO(null);
    }
}