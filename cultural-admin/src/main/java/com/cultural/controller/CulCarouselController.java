package com.cultural.controller;

import java.util.List;

import com.cultural.annotation.VerifyParam;
import com.cultural.entity.enums.CarouselTypeEnum;
import com.cultural.entity.query.CulCarouselQuery;
import com.cultural.entity.po.CulCarousel;
import com.cultural.entity.vo.ResponseVO;
import com.cultural.service.CulCarouselService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * Controller
 */
@RestController("culCarouselController")
@RequestMapping("/carousel")
public class CulCarouselController extends ABaseController {

    @Resource
    private CulCarouselService culCarouselService;

    /**
     * 根据条件分页查询
     */
    @RequestMapping("/loadDataList")
    public ResponseVO loadDataList(CulCarouselQuery query) {
        query.setOrderBy("sort asc");
        return getSuccessResponseVO(culCarouselService.findListByPage(query));
    }

    /**
     * 新增/修改
     */
    @RequestMapping("/saveCarousel")
    public ResponseVO saveCarousel(CulCarousel culCarousel) {
        culCarouselService.saveCarousel(culCarousel);
        return getSuccessResponseVO(null);
    }

    /**
     * 删除
     */
    @RequestMapping("/delCarousel")
    public ResponseVO delCarousel(@VerifyParam(required = true) Integer carouselId) {
        culCarouselService.deleteAppCarouselByCarouselId(carouselId);
        return getSuccessResponseVO(null);
    }

    /**
     * 排序
     */
    @RequestMapping("/changeSort")
    public ResponseVO changeCarousel(@VerifyParam(required = true) String carouselIds) {
        culCarouselService.changeSort(carouselIds);
        return getSuccessResponseVO(null);
    }
}