package com.example.mymall.service.Oms;

import com.example.mymall.dto.Oms.CartPromotionItem;
import com.example.mymall.mbg.model.OmsCartItem;

import java.util.List;

/**
 * @program: MyMall
 * @description:
 * @author: Max Wu
 * @create: 2023-06-28 00:00
 **/
public interface OmsPromotionService {
	/**
	 * 计算购物车中的促销活动信息
	 */
	List<CartPromotionItem> calcCartPromotion(List<OmsCartItem> cartItemList);
}
