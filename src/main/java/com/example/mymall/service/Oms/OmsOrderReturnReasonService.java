package com.example.mymall.service.Oms;

import com.example.mymall.mbg.model.OmsOrderReturnReason;

import java.util.List;

/**
 * @program: MyMall
 * @description: 订单原因管理service
 * @author: Max Wu
 * @create: 2023-07-04 13:49
 **/
public interface OmsOrderReturnReasonService {
	int create(OmsOrderReturnReason returnReason);

	int update(Long id, OmsOrderReturnReason returnReason);

	int delete(List<Long> ids);

	List<OmsOrderReturnReason> list(Integer pageSize, Integer pageNum);

	int updateStatus(List<Long> ids, Integer status);

	OmsOrderReturnReason getItem(Long id);
}
