package com.example.mymall.service.Wms.impl;

import com.example.mymall.mbg.mapper.WmsWareInfoMapper;
import com.example.mymall.mbg.model.WmsWareInfo;
import com.example.mymall.mbg.model.WmsWareInfoExample;
import com.example.mymall.service.Wms.WareInfoService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: MyMall
 * @description:
 * @author: Max Wu
 * @create: 2023-06-03 10:48
 **/
@Service
public class WareInfoServiceImpl implements WareInfoService {
	@Autowired
	private WmsWareInfoMapper wareInfoMapper;

	@Override
	public List<WmsWareInfo> queryPage(Integer pageSize, Integer pageNum) {
		PageHelper.startPage(pageSize, pageNum);
		WmsWareInfoExample example = new WmsWareInfoExample();
		return wareInfoMapper.selectByExample(example);
	}
}
