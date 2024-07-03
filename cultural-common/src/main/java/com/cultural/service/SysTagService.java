package com.cultural.service;

import java.util.List;

import com.cultural.entity.query.SysTagQuery;
import com.cultural.entity.po.SysTag;
import com.cultural.entity.vo.PaginationResultVO;


/**
 *  业务接口
 */
public interface SysTagService {

	/**
	 * 根据条件查询列表
	 */
	List<SysTag> findListByParam(SysTagQuery param);

	/**
	 * 根据条件查询列表
	 */
	Integer findCountByParam(SysTagQuery param);

	/**
	 * 分页查询
	 */
	PaginationResultVO<SysTag> findListByPage(SysTagQuery param);

	/**
	 * 新增
	 */
	Integer add(SysTag bean);

	/**
	 * 批量新增
	 */
	Integer addBatch(List<SysTag> listBean);

	/**
	 * 批量新增/修改
	 */
	Integer addOrUpdateBatch(List<SysTag> listBean);

	/**
	 * 多条件更新
	 */
	Integer updateByParam(SysTag bean,SysTagQuery param);

	/**
	 * 多条件删除
	 */
	Integer deleteByParam(SysTagQuery param);

	/**
	 * 根据TagId查询对象
	 */
	SysTag getSysTagByTagId(Integer tagId);


	/**
	 * 根据TagId修改
	 */
	Integer updateSysTagByTagId(SysTag bean,Integer tagId);


	/**
	 * 根据TagId删除
	 */
	Integer deleteSysTagByTagId(Integer tagId);

    void saveTag(SysTag sysTag);
}