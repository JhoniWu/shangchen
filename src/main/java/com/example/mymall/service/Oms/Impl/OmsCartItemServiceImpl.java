package com.example.mymall.service.Oms.Impl;

import com.example.mymall.dao.Oms.CartProduct;
import com.example.mymall.dao.Oms.CartPromotionItem;
import com.example.mymall.mbg.mapper.OmsCartItemMapper;
import com.example.mymall.mbg.model.OmsCartItem;
import com.example.mymall.service.Oms.OmsCartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: MyMall
 * @description:
 * @author: Max Wu
 * @create: 2023-06-27 15:15
 **/
@Service
public class OmsCartItemServiceImpl implements OmsCartItemService {

	@Autowired
	private OmsCartItemMapper omsCartItemMapper;

	@Override
	public int add(OmsCartItem cartItem) {
		return 0;
	}

	@Override
	public List<OmsCartItem> list(Long memberId) {
		return null;
	}

	@Override
	public List<CartPromotionItem> listPromotion(Long memberId, List<Long> cartsIds) {
		return null;
	}

	@Override
	public int updateQuantity(Long id, Long memberId, Integer quantity) {
		return 0;
	}

	@Override
	public int delete(Long memberId, List<Long> ids) {
		return 0;
	}

	@Override
	public CartProduct getCartProduct(Long productId) {
		return null;
	}

	@Override
	public int updateAttr(OmsCartItem cartItem) {
		return 0;
	}

	@Override
	public int clear(Long memberId) {
		return 0;
	}
}
