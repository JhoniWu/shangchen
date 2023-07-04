package com.example.mymall.service.Oms.Impl;

import com.example.mymall.mbg.mapper.OmsOrderReturnReasonMapper;
import com.example.mymall.mbg.model.OmsOrderReturnReason;
import com.example.mymall.mbg.model.OmsOrderReturnReasonExample;
import com.example.mymall.service.Oms.OmsOrderReturnReasonService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @program: MyMall
 * @description: 订单原因管理service实现
 * @author: Max Wu
 * @create: 2023-07-04 13:50
 **/
@Service
public class OmsOrderReturnReasonServiceImpl implements OmsOrderReturnReasonService {
	@Autowired
	private OmsOrderReturnReasonMapper returnReasonMapper;

	@Override
	public int create(OmsOrderReturnReason returnReason) {
		returnReason.setCreateTime(new Date());
		return returnReasonMapper.insert(returnReason);
	}

	@Override
	public int update(Long id, OmsOrderReturnReason returnReason) {
		returnReason.setId(id);
		return returnReasonMapper.updateByPrimaryKey(returnReason);
	}

	@Override
	public int delete(List<Long> ids) {
		OmsOrderReturnReasonExample example = new OmsOrderReturnReasonExample();
		example.createCriteria().andIdIn(ids);
		return returnReasonMapper.deleteByExample(example);
	}

	@Override
	public List<OmsOrderReturnReason> list(Integer pageSize, Integer pageNum) {
		PageHelper.startPage(pageSize, pageNum);
		OmsOrderReturnReasonExample example = new OmsOrderReturnReasonExample();
		example.setOrderByClause("sort desc");
		return returnReasonMapper.selectByExample(example);
	}

	@Override
	public int updateStatus(List<Long> ids, Integer status) {
		if (!status.equals(0) && !status.equals(1)) {
			return 0;
		}
		OmsOrderReturnReason record = new OmsOrderReturnReason();
		record.setStatus(status);
		OmsOrderReturnReasonExample example = new OmsOrderReturnReasonExample();
		example.createCriteria().andIdIn(ids);
		return returnReasonMapper.updateByExample(record, example);
	}

	@Override
	public OmsOrderReturnReason getItem(Long id) {
		return returnReasonMapper.selectByPrimaryKey(id);
	}
}
