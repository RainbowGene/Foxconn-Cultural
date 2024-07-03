package com.cultural.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.cultural.entity.po.SysColumn;
import com.cultural.entity.query.SysColumnQuery;
import com.cultural.exception.BusinessException;
import org.springframework.stereotype.Service;

import com.cultural.entity.enums.PageSize;
import com.cultural.entity.query.SysAreaQuery;
import com.cultural.entity.po.SysArea;
import com.cultural.entity.vo.PaginationResultVO;
import com.cultural.entity.query.SimplePage;
import com.cultural.mappers.SysAreaMapper;
import com.cultural.service.SysAreaService;
import com.cultural.utils.StringTools;
import org.springframework.transaction.annotation.Transactional;


/**
 * 业务接口实现
 */
@Service("sysAreaService")
public class SysAreaServiceImpl implements SysAreaService {

    @Resource
    private SysAreaMapper<SysArea, SysAreaQuery> sysAreaMapper;

    /**
     * 根据条件查询列表
     */
    @Override
    public List<SysArea> findListByParam(SysAreaQuery param) {
        List<SysArea> sysAreas = this.sysAreaMapper.selectList(param);
        if (param.getFormate2Tree() != null && param.getFormate2Tree()) { // 需要转为树形
            sysAreas = convertLine2tree4Menu(sysAreas, 0);
        }
        return sysAreas;
    }

    @Override
    public List<SysArea> convertLine2tree4Menu(List<SysArea> datalist, Integer pid) {
        List<SysArea> children = new ArrayList<>();
        for (SysArea c : datalist) {
            if (c.getAreaId() != null && c.getpId() != null && c.getpId().equals(pid)) {
                c.setChildren(convertLine2tree4Menu(datalist, c.getAreaId()));
                children.add(c);
            }
        }
        return children;
    }

    /**
     * 根据条件查询列表
     */
    @Override
    public Integer findCountByParam(SysAreaQuery param) {
        return this.sysAreaMapper.selectCount(param);
    }

    /**
     * 分页查询方法
     */
    @Override
    public PaginationResultVO<SysArea> findListByPage(SysAreaQuery param) {
        int count = this.findCountByParam(param);
        int pageSize = param.getPageSize() == null ? PageSize.SIZE15.getSize() : param.getPageSize();

        SimplePage page = new SimplePage(param.getPageNo(), count, pageSize);
        param.setSimplePage(page);
        List<SysArea> list = this.findListByParam(param);
        PaginationResultVO<SysArea> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveArea(SysArea sysArea) {
        if (sysArea.getAreaId() == null) { // 新增
            this.sysAreaMapper.insert(sysArea);
        } else { // 修改
            SysArea dbInfo = this.sysAreaMapper.selectByAreaId(sysArea.getAreaId());
            if (dbInfo == null) {
                throw new BusinessException("不存在的地区！");
            }
            this.sysAreaMapper.updateByAreaId(sysArea, sysArea.getAreaId());
        }
        // 判断地区名是否重复
        SysAreaQuery query = new SysAreaQuery();
        query.setAreaName(sysArea.getAreaName());
        query.setType(query.getType());
        Integer count = this.sysAreaMapper.selectCount(query);
        if (count > 1) {
            throw new BusinessException("已有相同类型的重复地区");
        }
    }

    /**
     * 新增
     */
    @Override
    public Integer add(SysArea bean) {
        return this.sysAreaMapper.insert(bean);
    }

    /**
     * 批量新增
     */
    @Override
    public Integer addBatch(List<SysArea> listBean) {
        if (listBean == null || listBean.isEmpty()) {
            return 0;
        }
        return this.sysAreaMapper.insertBatch(listBean);
    }

    /**
     * 批量新增或者修改
     */
    @Override
    public Integer addOrUpdateBatch(List<SysArea> listBean) {
        if (listBean == null || listBean.isEmpty()) {
            return 0;
        }
        return this.sysAreaMapper.insertOrUpdateBatch(listBean);
    }

    /**
     * 多条件更新
     */
    @Override
    public Integer updateByParam(SysArea bean, SysAreaQuery param) {
        StringTools.checkParam(param);
        return this.sysAreaMapper.updateByParam(bean, param);
    }

    /**
     * 多条件删除
     */
    @Override
    public Integer deleteByParam(SysAreaQuery param) {
        StringTools.checkParam(param);
        return this.sysAreaMapper.deleteByParam(param);
    }

    /**
     * 根据AreaId获取对象
     */
    @Override
    public SysArea getSysAreaByAreaId(Integer areaId) {
        return this.sysAreaMapper.selectByAreaId(areaId);
    }

    /**
     * 根据AreaId修改
     */
    @Override
    public Integer updateSysAreaByAreaId(SysArea bean, Integer areaId) {
        return this.sysAreaMapper.updateByAreaId(bean, areaId);
    }

    /**
     * 根据AreaId删除
     */
    @Override
    public Integer deleteSysAreaByAreaId(Integer areaId) {
        return this.sysAreaMapper.deleteByAreaId(areaId);
    }
}