package com.cultural.service;

import java.util.List;

import com.cultural.entity.query.SysAreaQuery;
import com.cultural.entity.po.SysArea;
import com.cultural.entity.vo.PaginationResultVO;


/**
 *  业务接口
 */
public interface SysAreaService {

	/**
	 * 根据条件查询列表
	 */
	List<SysArea> findListByParam(SysAreaQuery param);

	/**
	 * 根据条件查询列表
	 */
	Integer findCountByParam(SysAreaQuery param);

	/**
	 * 分页查询
	 */
	PaginationResultVO<SysArea> findListByPage(SysAreaQuery param);

	/**
	 * 新增
	 */
	Integer add(SysArea bean);

	/**
	 * 批量新增
	 */
	Integer addBatch(List<SysArea> listBean);

	/**
	 * 批量新增/修改
	 */
	Integer addOrUpdateBatch(List<SysArea> listBean);

	/**
	 * 多条件更新
	 */
	Integer updateByParam(SysArea bean,SysAreaQuery param);

	/**
	 * 多条件删除
	 */
	Integer deleteByParam(SysAreaQuery param);

	/**
	 * 根据AreaId查询对象
	 */
	SysArea getSysAreaByAreaId(Integer areaId);


	/**
	 * 根据AreaId修改
	 */
	Integer updateSysAreaByAreaId(SysArea bean,Integer areaId);


	/**
	 * 根据AreaId删除
	 */
	Integer deleteSysAreaByAreaId(Integer areaId);


	List<SysArea> convertLine2tree4Menu(List<SysArea> datalist, Integer pid);

	/**
	 * 新增/修改园区
	 * @param sysArea
	 */
	void saveArea(SysArea sysArea);
}