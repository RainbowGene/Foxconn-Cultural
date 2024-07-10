package com.cultural.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cultural.entity.enums.PageSize;
import com.cultural.entity.query.CulCarouselQuery;
import com.cultural.entity.po.CulCarousel;
import com.cultural.entity.vo.PaginationResultVO;
import com.cultural.entity.query.SimplePage;
import com.cultural.mappers.CulCarouselMapper;
import com.cultural.service.CulCarouselService;
import com.cultural.utils.StringTools;


/**
 * 业务接口实现
 */
@Service("culCarouselService")
public class CulCarouselServiceImpl implements CulCarouselService {

    @Resource
    private CulCarouselMapper<CulCarousel, CulCarouselQuery> culCarouselMapper;

    /**
     * 根据条件查询列表
     */
    @Override
    public List<CulCarousel> findListByParam(CulCarouselQuery param) {
        return this.culCarouselMapper.selectList(param);
    }

    /**
     * 根据条件查询列表
     */
    @Override
    public Integer findCountByParam(CulCarouselQuery param) {
        return this.culCarouselMapper.selectCount(param);
    }

    /**
     * 分页查询方法
     */
    @Override
    public PaginationResultVO<CulCarousel> findListByPage(CulCarouselQuery param) {
        int count = this.findCountByParam(param);
        int pageSize = param.getPageSize() == null ? PageSize.SIZE15.getSize() : param.getPageSize();

        SimplePage page = new SimplePage(param.getPageNo(), count, pageSize);
        param.setSimplePage(page);
        List<CulCarousel> list = this.findListByParam(param);
        PaginationResultVO<CulCarousel> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
        return result;
    }

    /**
     * 新增
     */
    @Override
    public Integer add(CulCarousel bean) {
        return this.culCarouselMapper.insert(bean);
    }

    /**
     * 批量新增
     */
    @Override
    public Integer addBatch(List<CulCarousel> listBean) {
        if (listBean == null || listBean.isEmpty()) {
            return 0;
        }
        return this.culCarouselMapper.insertBatch(listBean);
    }

    /**
     * 批量新增或者修改
     */
    @Override
    public Integer addOrUpdateBatch(List<CulCarousel> listBean) {
        if (listBean == null || listBean.isEmpty()) {
            return 0;
        }
        return this.culCarouselMapper.insertOrUpdateBatch(listBean);
    }

    /**
     * 多条件更新
     */
    @Override
    public Integer updateByParam(CulCarousel bean, CulCarouselQuery param) {
        StringTools.checkParam(param);
        return this.culCarouselMapper.updateByParam(bean, param);
    }

    /**
     * 多条件删除
     */
    @Override
    public Integer deleteByParam(CulCarouselQuery param) {
        StringTools.checkParam(param);
        return this.culCarouselMapper.deleteByParam(param);
    }

    /**
     * 根据CarouselId获取对象
     */
    @Override
    public CulCarousel getCulCarouselByCarouselId(Integer carouselId) {
        return this.culCarouselMapper.selectByCarouselId(carouselId);
    }

    /**
     * 根据CarouselId修改
     */
    @Override
    public Integer updateCulCarouselByCarouselId(CulCarousel bean, Integer carouselId) {
        return this.culCarouselMapper.updateByCarouselId(bean, carouselId);
    }

    /**
     * 根据CarouselId删除
     */
    @Override
    public Integer deleteCulCarouselByCarouselId(Integer carouselId) {
        return this.culCarouselMapper.deleteByCarouselId(carouselId);
    }

    @Override
    public void saveCarousel(CulCarousel bean) {
        if (bean.getCarouselId() == null) {  // 新增
            CulCarouselQuery appCarouselQuery = new CulCarouselQuery();
            Integer count = culCarouselMapper.selectCount(appCarouselQuery);
            bean.setSort(count + 1);
            this.culCarouselMapper.insert(bean);
        } else {
            this.culCarouselMapper.updateByCarouselId(bean, bean.getCarouselId());
        }
    }

	@Override
	public Integer deleteAppCarouselByCarouselId(Integer carouselId) {
		return this.culCarouselMapper.deleteByCarouselId(carouselId);
	}

	@Override
	public void changeSort(String carouselIds) {
		String[] carouselIdArray = carouselIds.split(",");
		Integer index = 1;
		for (String carouselIdStr : carouselIdArray) {
			Integer carouselId = Integer.parseInt(carouselIdStr);
			CulCarousel appCarousel = new CulCarousel();
			appCarousel.setSort(index);
			culCarouselMapper.updateByCarouselId(appCarousel, carouselId);
			index++;
		}
	}
}