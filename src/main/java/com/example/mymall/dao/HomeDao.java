package com.example.mymall.dao;

import com.example.mymall.dto.FlashPromotionProduct;
import com.example.mymall.mbg.model.CmsSubject;
import com.example.mymall.mbg.model.PmsBrand;
import com.example.mymall.mbg.model.PmsProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: MyMall
 * @description: 首页内容管理自定义dao
 * @author: Max Wu
 * @create: 2023-07-05 14:46
 **/
public interface HomeDao {
	/**
	 * 获取推荐品牌
	 */
	List<PmsBrand> getRecommendBrandList(@Param("offset") Integer offset, @Param("limit") Integer limit);

	/**
	 * 获取秒杀商品
	 */
	List<FlashPromotionProduct> getFlashProductList(@Param("flashPromotionId") Long flashPromotionId, @Param("sessionId") Long sessionId);

	/**
	 * 获取新品推荐
	 */
	List<PmsProduct> getNewProductList(@Param("offset") Integer offset, @Param("limit") Integer limit);

	/**
	 * 获取人气推荐
	 */
	List<PmsProduct> getHotProductList(@Param("offset") Integer offset, @Param("limit") Integer limit);

	/**
	 * 获取推荐专题
	 */
	List<CmsSubject> getRecommendSubjectList(@Param("offset") Integer offset, @Param("limit") Integer limit);

}
