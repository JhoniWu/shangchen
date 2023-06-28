package com.example.mymall.dao;

import com.example.mymall.dto.Oms.CartProduct;
import com.example.mymall.dto.Oms.PromotionProduct;
import com.example.mymall.mbg.model.SmsCoupon;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: MyMall
 * @description:
 * @author: Max Wu
 * @create: 2023-06-27 23:58
 **/
public interface PortalProductDao {
	/**
	 * 获取购物车商品信息
	 */
	CartProduct getCartProduct(@Param("id") Long id);

	/**
	 * 获取促销商品信息列表
	 */
	List<PromotionProduct> getPromotionProductList(@Param("ids") List<Long> ids);

	/**
	 * 获取可用优惠券列表
	 */
	List<SmsCoupon> getAvailableCouponList(@Param("productId") Long productId, @Param("productCategoryId") Long productCategoryId);

}
