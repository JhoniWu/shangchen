package com.example.mymall.service.Oms.Impl;

import com.example.mymall.mbg.mapper.OmsOrderSettingMapper;
import com.example.mymall.mbg.model.OmsOrderSetting;
import com.example.mymall.service.Oms.OmsOrderSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: MyMall
 * @description: 订单设置管理Service实现类
 * @author: Max Wu
 * @create: 2023-07-04 13:46
 **/
@Service
public class OmsOrderSettingServiceImpl implements OmsOrderSettingService {
	@Autowired
	private OmsOrderSettingMapper orderSettingMapper;


	@Override
	public OmsOrderSetting getItem(Long id) {
		return orderSettingMapper.selectByPrimaryKey(id);
	}

	@Override
	public int update(Long id, OmsOrderSetting orderSetting) {
		orderSetting.setId(id);
		return orderSettingMapper.updateByPrimaryKey(orderSetting);
	}
}
