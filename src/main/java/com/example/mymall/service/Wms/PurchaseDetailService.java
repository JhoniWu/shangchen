package com.example.mymall.service.Wms;

import com.example.mymall.mbg.model.WmsPurchaseDetail;

import java.util.List;

/**
 * @program: MyMall
 * @description:
 * @author: Max Wu
 * @create: 2023-06-02 16:42
 **/
public interface PurchaseDetailService {
	List<WmsPurchaseDetail> queryPage(WmsPurchaseDetail detail, Integer pageSize, Integer pageNum);

	List<WmsPurchaseDetail> listDetailByPurchaseId(Long id);
}
