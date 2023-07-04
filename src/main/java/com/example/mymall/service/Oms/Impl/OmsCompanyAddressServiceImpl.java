package com.example.mymall.service.Oms.Impl;

import com.example.mymall.mbg.mapper.OmsCompanyAddressMapper;
import com.example.mymall.mbg.model.OmsCompanyAddress;
import com.example.mymall.mbg.model.OmsCompanyAddressExample;
import com.example.mymall.service.Oms.OmsCompanyAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: MyMall
 * @description: 收货地址管理
 * @author: Max Wu
 * @create: 2023-07-04 14:36
 **/
@Service
public class OmsCompanyAddressServiceImpl implements OmsCompanyAddressService {
	@Autowired
	private OmsCompanyAddressMapper addressMapper;

	@Override
	public List<OmsCompanyAddress> list() {
		return addressMapper.selectByExample(new OmsCompanyAddressExample());
	}
}
