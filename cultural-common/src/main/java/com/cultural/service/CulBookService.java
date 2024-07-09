package com.cultural.service;

import java.util.List;

import com.cultural.entity.query.CulBookQuery;
import com.cultural.entity.po.CulBook;
import com.cultural.entity.vo.PaginationResultVO;
import org.springframework.web.multipart.MultipartFile;


/**
 *  业务接口
 */
public interface CulBookService {

	/**
	 * 根据条件查询列表
	 */
	List<CulBook> findListByParam(CulBookQuery param);

	/**
	 * 根据条件查询列表
	 */
	Integer findCountByParam(CulBookQuery param);

	/**
	 * 分页查询
	 */
	PaginationResultVO<CulBook> findListByPage(CulBookQuery param);

	/**
	 * 新增
	 */
	Integer add(CulBook bean);

	/**
	 * 批量新增
	 */
	Integer addBatch(List<CulBook> listBean);

	/**
	 * 批量新增/修改
	 */
	Integer addOrUpdateBatch(List<CulBook> listBean);

	/**
	 * 多条件更新
	 */
	Integer updateByParam(CulBook bean,CulBookQuery param);

	/**
	 * 多条件删除
	 */
	Integer deleteByParam(CulBookQuery param);

	/**
	 * 根据BookId查询对象
	 */
	CulBook getCulBookByBookId(Integer bookId);


	/**
	 * 根据BookId修改
	 */
	Integer updateCulBookByBookId(CulBook bean,Integer bookId);


	/**
	 * 根据BookId删除
	 */
	Integer deleteCulBookByBookId(Integer bookId);

    void postBook(CulBook culBook, MultipartFile cover, MultipartFile bookFile);

	void deleteBook(int bookId);
}