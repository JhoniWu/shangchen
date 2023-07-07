package com.example.mymall.service.Pms;

import com.example.mymall.dto.PmsPortalProductDetail;
import com.example.mymall.dto.PmsProductCategoryNode;
import com.example.mymall.mbg.model.PmsProduct;

import java.util.List;

/**
 * @program: MyMall
 * @description: 前台商品管理
 * @author: Max Wu
 * @create: 2023-07-04 23:04
 **/
public interface PmsPortalProductService {
	/**
	 * 综合搜索商品
	 */
	List<PmsProduct> search(String keyword, Long brandId, Long productCategoryId, Integer pageNum, Integer pageSize, Integer sort);

	/**
	 * 以树形结构获取所有商品分类
	 */
	List<PmsProductCategoryNode> categoryTreeList();

	/**
	 * 获取前台商品详情
	 */
	PmsPortalProductDetail detail(Long id);
}
