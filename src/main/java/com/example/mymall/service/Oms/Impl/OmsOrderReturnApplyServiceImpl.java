package com.example.mymall.service.Oms.Impl;

import com.example.mymall.dao.OmsOrderReturnApplyDao;
import com.example.mymall.dto.Oms.OmsOrderReturnApplyResult;
import com.example.mymall.dto.Oms.OmsReturnApplyQueryParam;
import com.example.mymall.dto.Oms.OmsUpdateStatusParam;
import com.example.mymall.mbg.mapper.OmsOrderReturnApplyMapper;
import com.example.mymall.mbg.model.OmsOrderReturnApply;
import com.example.mymall.mbg.model.OmsOrderReturnApplyExample;
import com.example.mymall.service.Oms.OmsOrderReturnApplyService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * @program: MyMall
 * @description: 订单退货管理
 * @author: Max Wu
 * @create: 2023-07-04 14:10
 **/
public class OmsOrderReturnApplyServiceImpl implements OmsOrderReturnApplyService {
	@Autowired
	private OmsOrderReturnApplyDao returnApplyDao;
	@Autowired
	private OmsOrderReturnApplyMapper returnApplyMapper;

	@Override
	public List<OmsOrderReturnApply> list(OmsReturnApplyQueryParam queryParam, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return returnApplyDao.getList(queryParam);
	}

	@Override
	public int delete(List<Long> ids) {
		OmsOrderReturnApplyExample example = new OmsOrderReturnApplyExample();
		example.createCriteria().andIdIn(ids).andStatusEqualTo(3);
		return returnApplyMapper.deleteByExample(example);
	}

	@Override
	public int updateStatus(Long id, OmsUpdateStatusParam statusParam) {
		Integer status = statusParam.getStatus();
		OmsOrderReturnApply returnApply = new OmsOrderReturnApply();
		if (status.equals(1)) {
			//确认退货
			returnApply.setId(id);
			returnApply.setStatus(1);
			returnApply.setReturnAmount(statusParam.getReturnAmount());
			returnApply.setCompanyAddressId(statusParam.getCompanyAddressId());
			returnApply.setHandleTime(new Date());
			returnApply.setHandleMan(statusParam.getHandleMan());
			returnApply.setHandleNote(statusParam.getHandleNote());
		} else if (status.equals(2)) {
			//完成退货
			returnApply.setId(id);
			returnApply.setStatus(2);
			returnApply.setReceiveTime(new Date());
			returnApply.setReceiveMan(statusParam.getReceiveMan());
			returnApply.setReceiveNote(statusParam.getReceiveNote());
		} else if (status.equals(3)) {
			//拒绝退货
			returnApply.setId(id);
			returnApply.setStatus(3);
			returnApply.setHandleTime(new Date());
			returnApply.setHandleMan(statusParam.getHandleMan());
			returnApply.setHandleNote(statusParam.getHandleNote());
		} else {
			return 0;
		}
		return returnApplyMapper.updateByPrimaryKeySelective(returnApply);
	}

	@Override
	public OmsOrderReturnApplyResult getItem(Long id) {
		return returnApplyDao.getDetail(id);
	}
}
