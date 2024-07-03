package com.cultural.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.cultural.entity.enums.ColumnStatusEnum;
import com.cultural.entity.enums.ColumnTypeEnum;
import com.cultural.entity.enums.ResponseCodeEnum;
import com.cultural.exception.BusinessException;
import com.mysql.cj.x.protobuf.MysqlxCrud;
import org.springframework.stereotype.Service;

import com.cultural.entity.enums.PageSize;
import com.cultural.entity.query.SysColumnQuery;
import com.cultural.entity.po.SysColumn;
import com.cultural.entity.vo.PaginationResultVO;
import com.cultural.entity.query.SimplePage;
import com.cultural.mappers.SysColumnMapper;
import com.cultural.service.SysColumnService;
import com.cultural.utils.StringTools;
import org.springframework.transaction.annotation.Transactional;


/**
 * 业务接口实现
 */
@Service("sysColumnService")
public class SysColumnServiceImpl implements SysColumnService {

    @Resource
    private SysColumnMapper<SysColumn, SysColumnQuery> sysColumnMapper;

    /**
     * 根据条件查询列表
     */
    @Override
    public List<SysColumn> findListByParam(SysColumnQuery param) {
        List<SysColumn> sysColumns = this.sysColumnMapper.selectList(param);
        if (param.getFormat2Tree() != null && param.getFormat2Tree()) { // 需要转为树形
            sysColumns = convertLine2tree4Menu(sysColumns, 0);
        }
        return sysColumns;
    }

    @Override
    public List<SysColumn> convertLine2tree4Menu(List<SysColumn> datalist, Integer pid) {
        List<SysColumn> children = new ArrayList<>();
        for (SysColumn c : datalist) {
            if (c.getColumnId() != null && c.getpId() != null && c.getpId().equals(pid)) {
                c.setChildren(convertLine2tree4Menu(datalist, c.getColumnId()));
                children.add(c);
            }
        }
        return children;
    }

    /**
     * 根据条件查询列表
     */
    @Override
    public Integer findCountByParam(SysColumnQuery param) {
        return this.sysColumnMapper.selectCount(param);
    }

    /**
     * 分页查询方法
     */
    @Override
    public PaginationResultVO<SysColumn> findListByPage(SysColumnQuery param) {
        int count = this.findCountByParam(param);
        int pageSize = param.getPageSize() == null ? PageSize.SIZE15.getSize() : param.getPageSize();

        SimplePage page = new SimplePage(param.getPageNo(), count, pageSize);
        param.setSimplePage(page);
        List<SysColumn> list = this.findListByParam(param);
        PaginationResultVO<SysColumn> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
        return result;
    }

    /**
     * 新增
     */
    @Override
    public Integer add(SysColumn bean) {
        return this.sysColumnMapper.insert(bean);
    }

    /**
     * 批量新增
     */
    @Override
    public Integer addBatch(List<SysColumn> listBean) {
        if (listBean == null || listBean.isEmpty()) {
            return 0;
        }
        return this.sysColumnMapper.insertBatch(listBean);
    }

    /**
     * 批量新增或者修改
     */
    @Override
    public Integer addOrUpdateBatch(List<SysColumn> listBean) {
        if (listBean == null || listBean.isEmpty()) {
            return 0;
        }
        return this.sysColumnMapper.insertOrUpdateBatch(listBean);
    }

    /**
     * 多条件更新
     */
    @Override
    public Integer updateByParam(SysColumn bean, SysColumnQuery param) {
        StringTools.checkParam(param);
        return this.sysColumnMapper.updateByParam(bean, param);
    }

    /**
     * 多条件删除
     */
    @Override
    public Integer deleteByParam(SysColumnQuery param) {
        StringTools.checkParam(param);
        return this.sysColumnMapper.deleteByParam(param);
    }

    /**
     * 根据ColumnId获取对象
     */
    @Override
    public SysColumn getSysColumnByColumnId(Integer columnId) {
        return this.sysColumnMapper.selectByColumnId(columnId);
    }

    /**
     * 根据ColumnId修改
     */
    @Override
    public Integer updateSysColumnByColumnId(SysColumn bean, Integer columnId) {
        return this.sysColumnMapper.updateByColumnId(bean, columnId);
    }

    /**
     * 根据ColumnId删除
     */
    @Override
    public Integer deleteSysColumnByColumnId(Integer columnId) {
        return this.sysColumnMapper.deleteByColumnId(columnId);
    }

    /**
     * 新增栏目
     *
     * @param sysColumn
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveColumn(SysColumn sysColumn) {
        if (sysColumn.getColumnId() == null) { // 新增
            this.sysColumnMapper.insert(sysColumn);
        } else { // 修改
            this.sysColumnMapper.updateByColumnId(sysColumn, sysColumn.getColumnId());
        }
        // 判断栏目名是否重复
        SysColumnQuery sysColumnQuery = new SysColumnQuery();
        sysColumnQuery.setColumnName(sysColumn.getColumnName());
        sysColumnQuery.setType(sysColumnQuery.getType());
        Integer count = this.sysColumnMapper.selectCount(sysColumnQuery);
        if (count > 1) {
            throw new BusinessException("已有相同类型的重复栏目");
        }
    }

    /**
     * 栏目 上移/下移
     *
     * @param columnIds
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void changeSort(String columnIds) {
        String[] columnIdArray = columnIds.split(",");
        Integer index = 1;
        for (String cIdStr : columnIdArray) {
            Integer cId = Integer.parseInt(cIdStr);
            SysColumn sysColumn = new SysColumn();
            sysColumn.setSort(index);
            sysColumnMapper.updateByColumnId(sysColumn, cId);
            index++;
        }
    }

    @Override
    public List<SysColumn> loadAllColumnByType(Integer type) {
        ColumnTypeEnum typeEnum = ColumnTypeEnum.getByType(type);
        if (typeEnum == null) {
            throw new BusinessException(ResponseCodeEnum.CODE_600);
        }
        SysColumnQuery columnQuery = new SysColumnQuery();
        columnQuery.setOrderBy("sort asc");
        columnQuery.setType(type);
        return this.sysColumnMapper.selectList(columnQuery);
    }
}