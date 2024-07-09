package com.cultural.mappers;

import org.apache.ibatis.annotations.Param;

/**
 *  数据库操作接口
 */
public interface CulBookMapper<T,P> extends BaseMapper<T,P> {

	/**
	 * 根据BookId更新
	 */
	 Integer updateByBookId(@Param("bean") T t,@Param("bookId") Integer bookId);


	/**
	 * 根据BookId删除
	 */
	 Integer deleteByBookId(@Param("bookId") Integer bookId);


	/**
	 * 根据BookId获取对象
	 */
	 T selectByBookId(@Param("bookId") Integer bookId);


}
