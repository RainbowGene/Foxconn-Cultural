package com.cultural.service;

import java.util.List;

import com.cultural.entity.query.SysColumnQuery;
import com.cultural.entity.po.SysColumn;
import com.cultural.entity.vo.PaginationResultVO;


/**
 * 业务接口
 */
public interface SysColumnService {

    /**
     * 根据条件查询列表
     */
    List<SysColumn> findListByParam(SysColumnQuery param);

    /**
     * 根据条件查询列表
     */
    Integer findCountByParam(SysColumnQuery param);

    /**
     * 分页查询
     */
    PaginationResultVO<SysColumn> findListByPage(SysColumnQuery param);

    /**
     * 新增
     */
    Integer add(SysColumn bean);

    /**
     * 批量新增
     */
    Integer addBatch(List<SysColumn> listBean);

    /**
     * 批量新增/修改
     */
    Integer addOrUpdateBatch(List<SysColumn> listBean);

    /**
     * 多条件更新
     */
    Integer updateByParam(SysColumn bean, SysColumnQuery param);

    /**
     * 多条件删除
     */
    Integer deleteByParam(SysColumnQuery param);

    /**
     * 根据ColumnId查询对象
     */
    SysColumn getSysColumnByColumnId(Integer columnId);


    /**
     * 根据ColumnId修改
     */
    Integer updateSysColumnByColumnId(SysColumn bean, Integer columnId);


    /**
     * 根据ColumnId删除
     */
    Integer deleteSysColumnByColumnId(Integer columnId);

    /**
     * 栏目集合 线性->树形
     *
     * @param datalist
     * @param pid
     * @return
     */
    List<SysColumn> convertLine2tree4Menu(List<SysColumn> datalist, Integer pid);

    /**
     * 新增/修改栏目
     * @param sysColumn
     */
    void saveColumn(SysColumn sysColumn);

    /**
     * 栏目 上移/下移
     * @param categoryIds
     */
    void changeSort(String categoryIds);

    List<SysColumn> loadAllColumnByType(Integer type);
}