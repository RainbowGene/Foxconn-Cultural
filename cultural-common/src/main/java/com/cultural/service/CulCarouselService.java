package com.cultural.service;

import java.util.List;

import com.cultural.entity.query.CulCarouselQuery;
import com.cultural.entity.po.CulCarousel;
import com.cultural.entity.vo.PaginationResultVO;


/**
 *  业务接口
 */
public interface CulCarouselService {

	/**
	 * 根据条件查询列表
	 */
	List<CulCarousel> findListByParam(CulCarouselQuery param);

	/**
	 * 根据条件查询列表
	 */
	Integer findCountByParam(CulCarouselQuery param);

	/**
	 * 分页查询
	 */
	PaginationResultVO<CulCarousel> findListByPage(CulCarouselQuery param);

	/**
	 * 新增
	 */
	Integer add(CulCarousel bean);

	/**
	 * 批量新增
	 */
	Integer addBatch(List<CulCarousel> listBean);

	/**
	 * 批量新增/修改
	 */
	Integer addOrUpdateBatch(List<CulCarousel> listBean);

	/**
	 * 多条件更新
	 */
	Integer updateByParam(CulCarousel bean,CulCarouselQuery param);

	/**
	 * 多条件删除
	 */
	Integer deleteByParam(CulCarouselQuery param);

	/**
	 * 根据CarouselId查询对象
	 */
	CulCarousel getCulCarouselByCarouselId(Integer carouselId);


	/**
	 * 根据CarouselId修改
	 */
	Integer updateCulCarouselByCarouselId(CulCarousel bean,Integer carouselId);


	/**
	 * 根据CarouselId删除
	 */
	Integer deleteCulCarouselByCarouselId(Integer carouselId);

    void saveCarousel(CulCarousel appCarousel);

	Integer deleteAppCarouselByCarouselId(Integer carouselId);

	void changeSort(String carouselIds);
}