package com.cultural.mappers;

import org.apache.ibatis.annotations.Param;

/**
 *  数据库操作接口
 */
public interface SysColumnMapper<T,P> extends BaseMapper<T,P> {

	/**
	 * 根据ColumnId更新
	 */
	 Integer updateByColumnId(@Param("bean") T t,@Param("columnId") Integer columnId);


	/**
	 * 根据ColumnId删除
	 */
	 Integer deleteByColumnId(@Param("columnId") Integer columnId);


	/**
	 * 根据ColumnId获取对象
	 */
	 T selectByColumnId(@Param("columnId") Integer columnId);

	void updateColumnName(@Param("columnName") String columnName, @Param("columnId") Integer columnId);
}
