package com.cultural.mappers;

import org.apache.ibatis.annotations.Param;

/**
 *  数据库操作接口
 */
public interface CulCarouselMapper<T,P> extends BaseMapper<T,P> {

	/**
	 * 根据CarouselId更新
	 */
	 Integer updateByCarouselId(@Param("bean") T t,@Param("carouselId") Integer carouselId);


	/**
	 * 根据CarouselId删除
	 */
	 Integer deleteByCarouselId(@Param("carouselId") Integer carouselId);


	/**
	 * 根据CarouselId获取对象
	 */
	 T selectByCarouselId(@Param("carouselId") Integer carouselId);


}