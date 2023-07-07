package com.example.mymall.service.Oms;

import com.example.mymall.dto.portal.OmsOrderReturnApplyParam;

/**
 * @program: MyMall
 * @description: 前台订单退货管理
 * @author: Max Wu
 * @create: 2023-07-05 15:09
 **/
public interface OmsPortalOrderReturnApplyService {
	/**
	 * 提交申请
	 */
	int create(OmsOrderReturnApplyParam returnApply);
}
