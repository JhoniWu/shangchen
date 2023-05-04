package com.example.mymall.service.PmsProduct;

import com.example.mymall.dto.PmsProductParam;
import com.example.mymall.dto.PmsProductQueryParam;
import com.example.mymall.dto.PmsProductResult;
import com.example.mymall.mbg.model.PmsProduct;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PmsProductService {
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)

	/**
	 * 根据商品编号获取更新信息
	 */
	PmsProductResult getUpdateInfo(Long id);

	/* 创建商品*/
	int create(PmsProductParam pmsProduct);

	/*
	 * 更新商品*/
	@Transactional
	int update(Long id, PmsProductParam pmsProduct);

	/*
	删除商品
	* */
	int delete(Long id);

	/**
	 * 分页查询商品
	 */
	List<PmsProduct> getList(PmsProductQueryParam productQueryParam, Integer pageNum, Integer pageSize);

	/**
	 * 批量修改审核状态
	 */
	@Transactional
	int UpdateVerifyStatus(List<Long> ids, Integer verifyStatus, String detail);

	/**
	 * 批量修改商品推荐状态
	 */
	int updateRecommendStatus(List<Long> ids, Integer newStatus);

	/**
	 * 批量删除商品
	 */
	int deleteStatus(List<Long> ids, Integer deleteStatus);

	/**
	 * 根据名称模糊查询
	 */
	List<PmsProduct> list(String keyword);

	/**
	 * 批量修改商品上架状态
	 */
	int updatePublishStatus(List<Long> ids, Integer publishStatus);

	/**
	 * 批量修改新品状态
	 */
	int updateNewStatus(List<Long> ids, Integer newStatus);

}
