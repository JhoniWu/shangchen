package com.example.mymall.service.Wms.impl;

import com.example.mymall.mbg.mapper.WmsWareOrderTaskDetailMapper;
import com.example.mymall.mbg.model.WmsWareOrderTaskDetail;
import com.example.mymall.mbg.model.WmsWareOrderTaskDetailExample;
import com.example.mymall.service.Wms.WareOrderTaskDetailService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @program: MyMall
 * @description:
 * @author: Max Wu
 * @create: 2023-06-03 10:45
 **/
public class WareOrderTaskDetailServiceImpl implements WareOrderTaskDetailService {
	@Autowired
	private WmsWareOrderTaskDetailMapper wareOrderTaskDetailMapper;

	@Override
	public List<WmsWareOrderTaskDetail> queryPage(Integer pageSize, Integer pageNum) {
		PageHelper.startPage(pageSize, pageNum);
		WmsWareOrderTaskDetailExample example = new WmsWareOrderTaskDetailExample();
		return wareOrderTaskDetailMapper.selectByExample(example);
	}
}
