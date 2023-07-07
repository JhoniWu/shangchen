package com.example.mymall.service.Wms.impl;

import com.example.mymall.dto.MergeVo;
import com.example.mymall.dto.PurchaseDoneVo;
import com.example.mymall.dto.PurchaseItemDoneVo;
import com.example.mymall.dto.WareConstant;
import com.example.mymall.mbg.mapper.WmsPurchaseDetailMapper;
import com.example.mymall.mbg.mapper.WmsPurchaseMapper;
import com.example.mymall.mbg.model.WmsPurchase;
import com.example.mymall.mbg.model.WmsPurchaseDetail;
import com.example.mymall.mbg.model.WmsPurchaseDetailExample;
import com.example.mymall.mbg.model.WmsPurchaseExample;
import com.example.mymall.service.Wms.PurchaseDetailService;
import com.example.mymall.service.Wms.PurchaseService;
import com.example.mymall.service.Wms.WareSkuService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: MyMall
 * @description:
 * @author: Max Wu
 * @create: 2023-06-05 14:19
 **/
@Service
public class PurchaseServiceImpl implements PurchaseService {
	@Autowired
	private PurchaseDetailService purchaseDetailService;

	@Autowired
	private WmsPurchaseMapper purchaseMapper;

	@Autowired
	private WmsPurchaseDetailMapper purchaseDetailMapper;

	@Autowired
	private WareSkuService wareSkuService;

	@Override
	public List<WmsPurchase> queryPage(WmsPurchase purchase, Integer pageSize, Integer pageNum) {
		PageHelper.startPage(pageNum, pageSize);
		WmsPurchaseExample example = new WmsPurchaseExample();
		WmsPurchaseExample.Criteria criteria = example.createCriteria();
		try {
			Class<?> purchaseClass = purchase.getClass();
			Field[] fields = purchaseClass.getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
				Object value = field.get(purchase);
				if (value != null) {
					String fieldName = field.getName();
					String methodName = "and" + StringUtils.capitalize(fieldName) + "EqualTo";
					Method method = criteria.getClass().getMethod(methodName, field.getType());
					method.invoke(criteria, value);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return purchaseMapper.selectByExample(example);

	}

	@Override
	public List<WmsPurchase> queryPageUnreceivePurchase(WmsPurchase purchase, Integer pageSize, Integer pageNum) {
		List<WmsPurchase> list = queryPage(purchase, pageSize, pageNum);
		Iterator<WmsPurchase> iterator = list.iterator();
		while (iterator.hasNext()) {
			WmsPurchase o = iterator.next();
			if (o.getStatus() != 0 && o.getStatus() != 1) {
				iterator.remove();
			}
		}
		return list;
	}

	@Override
	public void mergePurchase(MergeVo mergeVo) {
		Long purchaseId = mergeVo.getPurchaseId();
		if (purchaseId == null) {
			WmsPurchase purchase = new WmsPurchase();
			purchase.setStatus(WareConstant.PurchaseStatusEnum.CREATED.getCode());
			purchase.setCreateTime(new Date());
			purchase.setUpdateTime(new Date());

			purchaseMapper.insert(purchase);
			purchaseId = purchase.getId();
		}
//正在采购的采购单不能合并
		if (purchaseId != 0 && purchaseId != 1) {
			return;
		}

		List<Long> items = mergeVo.getItems();
		Long finalPurchaseId = purchaseId;
		List<WmsPurchaseDetail> collect = items.stream().map(i -> {
			WmsPurchaseDetail detail = new WmsPurchaseDetail();
			detail.setId(i);
			detail.setPurchaseId(finalPurchaseId);
			detail.setStatus(WareConstant.PurchaseDetailStatusEnum.ASSIGNED.getCode());
			return detail;
		}).collect(Collectors.toList());
		for (WmsPurchaseDetail o : collect) {
			purchaseDetailMapper.updateByPrimaryKey(o);
		}
		WmsPurchase purchase = new WmsPurchase();
		purchase.setId(purchaseId);
		purchase.setUpdateTime(new Date());
		purchaseMapper.updateByPrimaryKey(purchase);
	}

	/**
	 * @param ids 采购单Id
	 */
	@Override
	public void received(List<Long> ids) {
		//确认当前采购单是新建或者已分配状态
		//
		//
		List<WmsPurchase> collect = ids.stream().map(id -> {
			WmsPurchase byId = purchaseMapper.selectByPrimaryKey(id);
			return byId;
		}).filter(item -> {
			if (item.getStatus() == WareConstant.PurchaseStatusEnum.CREATED.getCode() ||
				item.getStatus() == WareConstant.PurchaseStatusEnum.ASSIGNED.getCode()) {
				return true;
			}
			return false;
		}).map(item -> {
			item.setStatus(WareConstant.PurchaseStatusEnum.RECEIVE.getCode());
			item.setUpdateTime(new Date());
			return item;
		}).collect(Collectors.toList());

		for (WmsPurchase o : collect) {
			purchaseMapper.updateByPrimaryKey(o);
		}

		//3、改变采购项的状态
		collect.forEach((item) -> {
			WmsPurchaseDetailExample example = new WmsPurchaseDetailExample();
			example.createCriteria().andIdEqualTo(item.getId());
			List<WmsPurchaseDetail> entities = purchaseDetailService.listDetailByPurchaseId(item.getId());
			List<WmsPurchaseDetail> detailEntities = entities.stream().map(entity -> {
				WmsPurchaseDetail entity1 = new WmsPurchaseDetail();
				entity1.setId(entity.getId());
				entity1.setStatus(WareConstant.PurchaseDetailStatusEnum.BUYING.getCode());
				return entity1;
			}).collect(Collectors.toList());
			for (WmsPurchaseDetail o : detailEntities) {
				purchaseDetailMapper.updateByPrimaryKey(o);
			}
		});

	}

	@Override
	public void done(PurchaseDoneVo doneVo) {
		//改变采购单状态
		//改变采购项状态
		//入库

		Long id = doneVo.getId();
		Boolean flag = true;
		List<PurchaseItemDoneVo> items = doneVo.getItems();

		List<WmsPurchaseDetail> updates = new ArrayList<>();
		for (PurchaseItemDoneVo item : items) {
			WmsPurchaseDetail detailEntity = new WmsPurchaseDetail();
			if (item.getStatus() == WareConstant.PurchaseDetailStatusEnum.HASERROR.getCode()) {
				flag = false;
				detailEntity.setStatus(item.getStatus());
			} else {
				detailEntity.setStatus(WareConstant.PurchaseDetailStatusEnum.FINISH.getCode());
				////3、将成功采购的进行入库
				WmsPurchaseDetail entity = purchaseDetailMapper.selectByPrimaryKey(id);
				wareSkuService.addStock(entity.getSkuId(), entity.getWareId(),
					entity.getSkuNum());
			}
			detailEntity.setId(item.getItemId());
			updates.add(detailEntity);
		}

		for (WmsPurchaseDetail o : updates) {
			purchaseDetailMapper.updateByPrimaryKey(o);
		}

		WmsPurchase purchase = new WmsPurchase();
		purchase.setId(id);
		purchase.setStatus(flag ? WareConstant.PurchaseStatusEnum.FINISH.getCode() : WareConstant.PurchaseStatusEnum.HASERROR.getCode());
		purchase.setUpdateTime(new Date());
		purchaseMapper.updateByPrimaryKey(purchase);
	}

}
