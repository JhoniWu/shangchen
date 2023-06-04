package com.example.mymall.service.Wms.impl;

import com.example.mymall.mbg.mapper.WmsWareOrderTaskMapper;
import com.example.mymall.mbg.model.WmsWareOrderTask;
import com.example.mymall.mbg.model.WmsWareOrderTaskExample;
import com.example.mymall.service.Wms.WareOrderTaskService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: MyMall
 * @description:
 * @author: Max Wu
 * @create: 2023-06-03 10:39
 **/
@Service
public class WareOrderTaskServiceImpl implements WareOrderTaskService {
	@Autowired
	private WmsWareOrderTaskMapper wareOrderTaskMapper;

	@Override
	public List<WmsWareOrderTask> queryPage(Integer pageSize, Integer pageNum) {
		PageHelper.startPage(pageSize, pageNum);
		WmsWareOrderTaskExample example = new WmsWareOrderTaskExample();
		return wareOrderTaskMapper.selectByExample(example);
	}
}
