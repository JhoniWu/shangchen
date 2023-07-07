package com.example.mymall.service.Oms;

import com.example.mymall.dto.OmsOrderReturnApplyResult;
import com.example.mymall.dto.OmsReturnApplyQueryParam;
import com.example.mymall.dto.OmsUpdateStatusParam;
import com.example.mymall.mbg.model.OmsOrderReturnApply;

import java.util.List;

/**
 * @program: MyMall
 * @description: 订单退货管理service
 * @author: Max Wu
 * @create: 2023-07-04 14:10
 **/
public interface OmsOrderReturnApplyService {
	List<OmsOrderReturnApply> list(OmsReturnApplyQueryParam queryParam, Integer pageNum, Integer pageSize);

	int delete(List<Long> ids);

	int updateStatus(Long id, OmsUpdateStatusParam statusParam);

	OmsOrderReturnApplyResult getItem(Long id);
}
