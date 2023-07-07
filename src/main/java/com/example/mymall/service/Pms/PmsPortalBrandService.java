package com.example.mymall.service.Pms;

import com.example.mymall.common.CommonPage;
import com.example.mymall.mbg.model.PmsBrand;
import com.example.mymall.mbg.model.PmsProduct;

import java.util.List;

/**
 * @program: MyMall
 * @description: 前台品牌管理Service
 * @author: Max Wu
 * @create: 2023-07-04 23:05
 **/
public interface PmsPortalBrandService {
	/**
	 * 分页获取推荐品牌
	 */
	List<PmsBrand> recommendList(Integer pageNum, Integer pageSize);

	/**
	 * 获取品牌详情
	 */
	PmsBrand detail(Long brandId);

	/**
	 * 分页获取品牌关联商品
	 */
	CommonPage<PmsProduct> productList(Long brandId, Integer pageNum, Integer pageSize);

}
