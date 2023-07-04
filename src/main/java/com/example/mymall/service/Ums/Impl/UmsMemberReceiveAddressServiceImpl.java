package com.example.mymall.service.Ums.Impl;

import com.example.mymall.mbg.mapper.UmsMemberReceiveAddressMapper;
import com.example.mymall.mbg.model.UmsMemberReceiveAddress;
import com.example.mymall.mbg.model.UmsMemberReceiveAddressExample;
import com.example.mymall.service.Ums.UmsMemberReceiveAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: MyMall
 * @description:
 * @author: Max Wu
 * @create: 2023-07-03 09:18
 **/
@Service
public class UmsMemberReceiveAddressServiceImpl implements UmsMemberReceiveAddressService {

	@Autowired
	private UmsMemberReceiveAddressMapper addressMapper;

	@Override
	public int add(UmsMemberReceiveAddress address) {
		return addressMapper.insert(address);
	}

	@Override
	public int delete(Long id) {
		return addressMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int update(Long id, UmsMemberReceiveAddress address) {
		address.setId(id);
		return addressMapper.updateByPrimaryKeySelective(address);
	}

	@Override
	public List<UmsMemberReceiveAddress> list() {
		UmsMemberReceiveAddressExample example = new UmsMemberReceiveAddressExample();
		return addressMapper.selectByExample(example);
	}

	@Override
	public UmsMemberReceiveAddress getItem(Long id) {
		return addressMapper.selectByPrimaryKey(id);
	}
}
