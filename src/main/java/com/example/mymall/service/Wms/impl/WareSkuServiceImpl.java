package com.example.mymall.service.Wms.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mymall.dao.Wms.WmsWareSkuDao;
import com.example.mymall.mbg.mapper.WmsWareSkuMapper;
import com.example.mymall.mbg.model.WmsWareSku;
import com.example.mymall.mbg.model.WmsWareSkuExample;
import com.example.mymall.service.Wms.WareSkuService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @program: MyMall
 * @description:
 * @author: Max Wu
 * @create: 2023-06-03 10:12
 **/
public class WareSkuServiceImpl extends ServiceImpl<WmsWareSkuDao, WmsWareSku> implements WareSkuService {
	@Autowired
	private WmsWareSkuMapper wareSkuMapper;
	@Autowired
	private WmsWareSkuDao wareSkuDao;

	@Override
	public List<WmsWareSku> queryPage(Integer pageSize, Integer pageNum) {
		PageHelper.startPage(pageNum, pageSize);
		WmsWareSkuExample example = new WmsWareSkuExample();
		return wareSkuMapper.selectByExample(example);
	}

	@Override
	public void addStock(Long skuId, Long wareId, Integer skuNum) {
		//1、判断如果还没有这个库存记录新增
		WmsWareSkuExample example = new WmsWareSkuExample();
		example.createCriteria().andSkuIdEqualTo(skuId).andWareIdEqualTo(wareId);
		List<WmsWareSku> entities = wareSkuMapper.selectByExample(example);
		if (entities == null || entities.size() == 0) {
			WmsWareSku sku = new WmsWareSku();
			sku.setSkuId(skuId);
			sku.setStock(skuNum);
			sku.setWareId(wareId);
			sku.setStockLocked(0);

			//TODO 远程查询sku的名字，如果失败，整个事务无需回滚
			//1、自己catch异常
			//TODO 还可以用什么办法让异常出现以后不回滚？高级
			wareSkuMapper.insert(sku);
		} else {
			wareSkuDao.addStock(skuId, wareId, skuNum);
		}
	}
}
