package com.cultural.mappers;

import org.apache.ibatis.annotations.Param;

/**
 *  数据库操作接口
 */
public interface SysAreaMapper<T,P> extends BaseMapper<T,P> {

	/**
	 * 根据AreaId更新
	 */
	 Integer updateByAreaId(@Param("bean") T t,@Param("areaId") Integer areaId);


	/**
	 * 根据AreaId删除
	 */
	 Integer deleteByAreaId(@Param("areaId") Integer areaId);


	/**
	 * 根据AreaId获取对象
	 */
	 T selectByAreaId(@Param("areaId") Integer areaId);


}
