package com.example.mymall.service.Oms.Impl;

import com.example.mymall.dto.OmsOrderReturnApplyResult;
import com.example.mymall.dto.portal.OmsOrderReturnApplyParam;
import com.example.mymall.mbg.mapper.OmsOrderReturnApplyMapper;
import com.example.mymall.mbg.model.OmsOrderReturnApply;
import com.example.mymall.service.Oms.OmsPortalOrderReturnApplyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @program: MyMall
 * @description: 前台订单退后管理
 * @author: Max Wu
 * @create: 2023-07-05 15:10
 **/
@Service
public class OmsPortalOrderReturnApplyServiceImpl implements OmsPortalOrderReturnApplyService {
	@Autowired
	private OmsOrderReturnApplyMapper returnApplyMapper;

	@Override
	public int create(OmsOrderReturnApplyParam returnApply) {
		OmsOrderReturnApply apply = new OmsOrderReturnApplyResult();
		BeanUtils.copyProperties(returnApply, apply);
		apply.setCreateTime(new Date());
		apply.setStatus(0);
		return returnApplyMapper.insert(apply);
	}
}
