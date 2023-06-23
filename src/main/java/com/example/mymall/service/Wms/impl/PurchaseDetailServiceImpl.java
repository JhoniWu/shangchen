package com.example.mymall.service.Wms.impl;

import com.example.mymall.mbg.mapper.WmsPurchaseDetailMapper;
import com.example.mymall.mbg.model.WmsPurchaseDetail;
import com.example.mymall.mbg.model.WmsPurchaseDetailExample;
import com.example.mymall.service.Wms.PurchaseDetailService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: MyMall
 * @description:
 * @author: Max Wu
 * @create: 2023-06-09 17:21
 **/
@Service
public class PurchaseDetailServiceImpl implements PurchaseDetailService {

	@Autowired
	private WmsPurchaseDetailMapper purchaseDetailMapper;

	@Override
	public List<WmsPurchaseDetail> queryPage(WmsPurchaseDetail detail, Integer pageSize, Integer pageNum) {
		PageHelper.startPage(pageNum, pageSize);
		WmsPurchaseDetailExample example = new WmsPurchaseDetailExample();
		WmsPurchaseDetailExample.Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(detail.getId());
		criteria.andPurchaseIdEqualTo(detail.getPurchaseId());
		criteria.andSkuIdEqualTo(detail.getSkuId());
		criteria.andStatusEqualTo(detail.getStatus());
		criteria.andWareIdEqualTo(detail.getWareId());

		return purchaseDetailMapper.selectByExample(example);
	}

	@Override
	public List<WmsPurchaseDetail> listDetailByPurchaseId(Long id) {
		WmsPurchaseDetailExample example = new WmsPurchaseDetailExample();
		example.createCriteria().andPurchaseIdEqualTo(id);
		List<WmsPurchaseDetail> purchase = purchaseDetailMapper.selectByExample(example);
		return purchase;
	}
}
