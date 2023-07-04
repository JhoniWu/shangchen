package com.example.mymall.service.Oms;

import com.example.mymall.mbg.model.OmsOrderSetting;

/**
 * @program: MyMall
 * @description: 订单设置管理service
 * @author: Max Wu
 * @create: 2023-07-04 13:46
 **/
public interface OmsOrderSettingService {
	OmsOrderSetting getItem(Long id);

	int update(Long id, OmsOrderSetting orderSetting);
}
