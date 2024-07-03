package com.cultural.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.cultural.exception.BusinessException;
import org.springframework.stereotype.Service;

import com.cultural.entity.enums.PageSize;
import com.cultural.entity.query.SysTagQuery;
import com.cultural.entity.po.SysTag;
import com.cultural.entity.vo.PaginationResultVO;
import com.cultural.entity.query.SimplePage;
import com.cultural.mappers.SysTagMapper;
import com.cultural.service.SysTagService;
import com.cultural.utils.StringTools;


/**
 * 业务接口实现
 */
@Service("sysTagService")
public class SysTagServiceImpl implements SysTagService {

    @Resource
    private SysTagMapper<SysTag, SysTagQuery> sysTagMapper;

    /**
     * 根据条件查询列表
     */
    @Override
    public List<SysTag> findListByParam(SysTagQuery param) {
        return this.sysTagMapper.selectList(param);
    }

    /**
     * 根据条件查询列表
     */
    @Override
    public Integer findCountByParam(SysTagQuery param) {
        return this.sysTagMapper.selectCount(param);
    }

    /**
     * 分页查询方法
     */
    @Override
    public PaginationResultVO<SysTag> findListByPage(SysTagQuery param) {
        int count = this.findCountByParam(param);
        int pageSize = param.getPageSize() == null ? PageSize.SIZE15.getSize() : param.getPageSize();

        SimplePage page = new SimplePage(param.getPageNo(), count, pageSize);
        param.setSimplePage(page);
        List<SysTag> list = this.findListByParam(param);
        PaginationResultVO<SysTag> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
        return result;
    }

    /**
     * 新增
     */
    @Override
    public Integer add(SysTag bean) {
        return this.sysTagMapper.insert(bean);
    }

    /**
     * 批量新增
     */
    @Override
    public Integer addBatch(List<SysTag> listBean) {
        if (listBean == null || listBean.isEmpty()) {
            return 0;
        }
        return this.sysTagMapper.insertBatch(listBean);
    }

    /**
     * 批量新增或者修改
     */
    @Override
    public Integer addOrUpdateBatch(List<SysTag> listBean) {
        if (listBean == null || listBean.isEmpty()) {
            return 0;
        }
        return this.sysTagMapper.insertOrUpdateBatch(listBean);
    }

    /**
     * 多条件更新
     */
    @Override
    public Integer updateByParam(SysTag bean, SysTagQuery param) {
        StringTools.checkParam(param);
        return this.sysTagMapper.updateByParam(bean, param);
    }

    /**
     * 多条件删除
     */
    @Override
    public Integer deleteByParam(SysTagQuery param) {
        StringTools.checkParam(param);
        return this.sysTagMapper.deleteByParam(param);
    }

    /**
     * 根据TagId获取对象
     */
    @Override
    public SysTag getSysTagByTagId(Integer tagId) {
        return this.sysTagMapper.selectByTagId(tagId);
    }

    /**
     * 根据TagId修改
     */
    @Override
    public Integer updateSysTagByTagId(SysTag bean, Integer tagId) {
        return this.sysTagMapper.updateByTagId(bean, tagId);
    }

    /**
     * 根据TagId删除
     */
    @Override
    public Integer deleteSysTagByTagId(Integer tagId) {
        return this.sysTagMapper.deleteByTagId(tagId);
    }

    /**
     * 新增/修改 标签
     * @param sysTag
     */
    @Override
    public void saveTag(SysTag sysTag) {
        SysTag tagDb = sysTagMapper.selectByTagName(sysTag.getTagName());
        if (tagDb != null && (sysTag.getTagId() == null || !tagDb.getTagId().equals(sysTag.getTagId()))) {
            throw new BusinessException("已有同名标签");
        }
        if (sysTag.getTagId() == null) { // 新增
            sysTag.setCreateTime(new Date());
            // TODO 后续有type辨别，则定义枚举后在此赋值
            this.sysTagMapper.insert(sysTag);
        } else { // 修改
            sysTag.setLastUpdateTime(new Date());
            this.sysTagMapper.updateByTagId(sysTag, sysTag.getTagId());
        }
    }
}