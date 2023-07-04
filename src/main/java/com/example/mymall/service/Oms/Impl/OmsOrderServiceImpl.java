package com.example.mymall.service.Oms.Impl;

import com.example.mymall.dao.OmsOrderDao;
import com.example.mymall.dao.OmsOrderOperateHistoryDao;
import com.example.mymall.dto.Oms.*;
import com.example.mymall.mbg.mapper.OmsOrderMapper;
import com.example.mymall.mbg.mapper.OmsOrderOperateHistoryMapper;
import com.example.mymall.mbg.model.OmsOrder;
import com.example.mymall.mbg.model.OmsOrderExample;
import com.example.mymall.mbg.model.OmsOrderOperateHistory;
import com.example.mymall.service.Oms.OmsOrderService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: MyMall
 * @description: 订单服务serviceImpl
 * @author: Max Wu
 * @create: 2023-07-03 15:00
 **/
public class OmsOrderServiceImpl implements OmsOrderService {

	@Autowired
	private OmsOrderMapper orderMapper;
	@Autowired
	private OmsOrderDao orderDao;
	@Autowired
	private OmsOrderOperateHistoryDao orderOperateHistoryDao;
	@Autowired
	private OmsOrderOperateHistoryMapper orderOperateHistoryMapper;

	@Override
	public List<OmsOrder> list(OmsOrderQueryParam queryParam, Integer pageSize, Integer pageNum) {
		PageHelper.startPage(pageNum, pageSize);
		return orderDao.getList(queryParam);
	}

	@Override
	public int delivery(List<OmsOrderDeliveryParam> deliveryParamList) {
		int count = orderDao.delivery(deliveryParamList);
		List<OmsOrderOperateHistory> operateHistoryList = deliveryParamList.stream()
			.map(omsOrderDeliveryParam -> {
				OmsOrderOperateHistory history = new OmsOrderOperateHistory();
				history.setOrderId(omsOrderDeliveryParam.getOrderId());
				history.setCreateTime(new Date());
				history.setOperateMan("后台管理员");
				history.setOrderStatus(2);
				history.setNote("完成发货");
				return history;
			}).collect(Collectors.toList());
		orderOperateHistoryDao.insertList(operateHistoryList);
		return count;
	}

	@Override
	public int close(List<Long> ids, String note) {
		OmsOrder record = new OmsOrder();
		record.setStatus(4);
		OmsOrderExample example = new OmsOrderExample();
		example.createCriteria().andDeleteStatusEqualTo(0).andIdIn(ids);
		int count = orderMapper.updateByExampleSelective(record, example);
		List<OmsOrderOperateHistory> historyList = ids.stream().map(orderId -> {
			OmsOrderOperateHistory history = new OmsOrderOperateHistory();
			history.setOrderId(orderId);
			history.setCreateTime(new Date());
			history.setOperateMan("后台管理员");
			history.setOrderStatus(4);
			history.setNote("订单关闭:" + note);
			return history;
		}).collect(Collectors.toList());
		orderOperateHistoryDao.insertList(historyList);
		return count;
	}

	@Override
	public int delete(List<Long> ids) {
		OmsOrder record = new OmsOrder();
		record.setDeleteStatus(1);
		OmsOrderExample example = new OmsOrderExample();
		example.createCriteria().andDeleteStatusEqualTo(0).andIdIn(ids);
		return orderMapper.updateByExampleSelective(record, example);
	}

	@Override
	public OmsOrderDetail detail(Long id) {
		return orderDao.getDetail(id);
	}

	/**
	 * 修改订单收货人信息
	 */
	@Override
	public int updateReceiverInfo(OmsReceiverInfoParam receiverInfoParam) {
		OmsOrder order = new OmsOrder();
		order.setId(receiverInfoParam.getOrderId());
		order.setReceiverName(receiverInfoParam.getReceiverName());
		order.setReceiverPhone(receiverInfoParam.getReceiverPhone());
		order.setReceiverPostCode(receiverInfoParam.getReceiverPostCode());
		order.setReceiverDetailAddress(receiverInfoParam.getReceiverDetailAddress());
		order.setReceiverProvince(receiverInfoParam.getReceiverProvince());
		order.setReceiverCity(receiverInfoParam.getReceiverCity());
		order.setReceiverRegion(receiverInfoParam.getReceiverRegion());
		order.setModifyTime(new Date());
		int count = orderMapper.updateByPrimaryKeySelective(order);

		//插入操作记录
		OmsOrderOperateHistory history = new OmsOrderOperateHistory();
		history.setOrderId(receiverInfoParam.getOrderId());
		history.setCreateTime(new Date());
		history.setOperateMan("后台管理员");
		history.setOrderStatus(receiverInfoParam.getStatus());
		history.setNote("修改收货人信息");
		orderOperateHistoryMapper.insert(history);
		return count;
	}

	/**
	 * 修改订单费用信息
	 */
	@Override
	public int updateMoneyInfo(OmsMoneyInfoParam moneyInfoParam) {
		OmsOrder order = new OmsOrder();
		order.setId(moneyInfoParam.getOrderId());
		order.setFreightAmount(moneyInfoParam.getFreightAmount());
		order.setDiscountAmount(moneyInfoParam.getDiscountAmount());
		order.setStatus(moneyInfoParam.getStatus());
		int count = orderMapper.updateByPrimaryKeySelective(order);

		//插入操作记录
		OmsOrderOperateHistory history = new OmsOrderOperateHistory();
		history.setId(moneyInfoParam.getOrderId());
		history.setCreateTime(new Date());
		history.setNote("修改费用信息");
		history.setOperateMan("后台管理员");
		history.setOrderStatus(moneyInfoParam.getStatus());
		orderOperateHistoryMapper.insert(history);
		return count;
	}

	@Override
	public int updateNote(Long id, String note, Integer status) {
		OmsOrder order = new OmsOrder();
		order.setId(id);
		order.setNote(note);
		order.setModifyTime(new Date());
		int count = orderMapper.updateByPrimaryKeySelective(order);
		OmsOrderOperateHistory history = new OmsOrderOperateHistory();
		history.setCreateTime(new Date());
		history.setOperateMan("后台管理员");
		history.setOrderStatus(status);
		history.setNote("修改备注信息；" + note);
		orderOperateHistoryMapper.insert(history);
		return count;
	}
}
