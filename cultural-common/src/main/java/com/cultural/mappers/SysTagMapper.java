package com.cultural.mappers;

import org.apache.ibatis.annotations.Param;

/**
 *  数据库操作接口
 */
public interface SysTagMapper<T,P> extends BaseMapper<T,P> {

	/**
	 * 根据TagId更新
	 */
	 Integer updateByTagId(@Param("bean") T t,@Param("tagId") Integer tagId);


	/**
	 * 根据TagId删除
	 */
	 Integer deleteByTagId(@Param("tagId") Integer tagId);


	/**
	 * 根据TagId获取对象
	 */
	 T selectByTagId(@Param("tagId") Integer tagId);


	/**
	 * 根据tagName获取对象
	 * @param tagName
	 * @return
	 */
	 T selectByTagName(@Param("tagName") String tagName);
}
