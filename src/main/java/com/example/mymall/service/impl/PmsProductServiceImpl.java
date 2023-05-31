package com.example.mymall.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.example.mymall.dao.*;
import com.example.mymall.dto.PmsProductParam;
import com.example.mymall.dto.PmsProductQueryParam;
import com.example.mymall.dto.PmsProductResult;
import com.example.mymall.mbg.mapper.*;
import com.example.mymall.mbg.model.*;
import com.example.mymall.service.PmsProductService;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: MyMall
 * @description: 商品管理service实现类
 * @author: Max Wu
 * @create: 2023-05-03 10:19
 **/
@Service
public class PmsProductServiceImpl implements PmsProductService {
	private static final Logger LOGGER = LoggerFactory.getLogger(PmsProductServiceImpl.class);
	@Autowired
	private PmsProductMapper pmsProductMapper;
	@Autowired
	private PmsMemberPriceDao memberPriceDao;
	@Autowired
	private PmsMemberPriceMapper memberPriceMapper;
	@Autowired
	private PmsProductLadderDao productLadderDao;
	@Autowired
	private PmsProductLadderMapper productLadderMapper;
	@Autowired
	private PmsProductFullReductionMapper productFullReductionMapper;
	@Autowired
	private PmsProductFullReductionDao productFullReductionDao;
	@Autowired
	private PmsSkuStockMapper skuStockMapper;
	@Autowired
	private PmsSkuStockDao skuStockDao;
	@Autowired
	private PmsProductAttributeValueMapper productAttributeValueMapper;
	@Autowired
	private PmsProductAttributeValueDao productAttributeValueDao;
	@Autowired
	private CmsSubjectProductRelationMapper subjectProductRelationMapper;
	@Autowired
	private CmsSubjectProductRelationDao subjectProductRelationDao;
	@Autowired
	private CmsPrefrenceAreaProductRelationMapper prefrenceAreaProductRelationMapper;
	@Autowired
	private CmsPrefrenceAreaProductRelationDao prefrenceAreaProductRelationDao;
	@Autowired
	private PmsProductDao productDao;
	@Autowired
	private PmsProductVertifyRecordDao productVertifyRecordDao;


	@Override
	public int create(PmsProductParam pmsProductParam) {
		int count;
		PmsProduct product = pmsProductParam;
		product.setId(null);
		pmsProductMapper.insertSelective(product);
		Long productId = product.getId();
		relateAndInsertList(memberPriceDao, pmsProductParam.getMemberPriceList(), productId);
		relateAndInsertList(productLadderDao, pmsProductParam.getProductLadderList(), productId);
		relateAndInsertList(productFullReductionDao, pmsProductParam.getProductFullReductionList(), productId);
		handleSkuStockCode(pmsProductParam.getSkuStockList(), productId);
		relateAndInsertList(skuStockDao, pmsProductParam.getSkuStockList(), productId);
		relateAndInsertList(productAttributeValueDao, pmsProductParam.getProductAttributeValueList(), productId);
		relateAndInsertList(subjectProductRelationDao, pmsProductParam.getSubjectProductRelationList(), productId);
		relateAndInsertList(prefrenceAreaProductRelationDao, pmsProductParam.getPrefrenceAreaProductRelationList(), productId);
		count = 1;
		return count;
	}

	@Override
	public PmsProductResult getUpdateInfo(Long id) {
		return productDao.getUpdateInfo(id);
	}

	@Override
	public int update(Long id, PmsProductParam pmsProductParam) {
		int count;
		PmsProduct product = pmsProductParam;
		product.setId(id);
		pmsProductMapper.updateByPrimaryKeySelective(product);
		//会员价格
		PmsMemberPriceExample pmsMemberPriceExample = new PmsMemberPriceExample();
		pmsMemberPriceExample.createCriteria().andProductIdEqualTo(id);
		memberPriceMapper.deleteByExample(pmsMemberPriceExample);
		relateAndInsertList(memberPriceDao, pmsProductParam.getMemberPriceList(), id);
		//阶梯价格
		PmsProductLadderExample ladderExample = new PmsProductLadderExample();
		ladderExample.createCriteria().andProductIdEqualTo(id);
		productLadderMapper.deleteByExample(ladderExample);
		relateAndInsertList(productLadderDao, pmsProductParam.getProductLadderList(), id);
		//满减价格
		PmsProductFullReductionExample fullReductionExample = new PmsProductFullReductionExample();
		fullReductionExample.createCriteria().andProductIdEqualTo(id);
		productFullReductionMapper.deleteByExample(fullReductionExample);
		relateAndInsertList(productFullReductionDao, pmsProductParam.getProductFullReductionList(), id);
		//修改sku库存信息
		handleUpdateSkuStockList(id, pmsProductParam);
		//修改商品参数，添加自定义商品规格
		PmsProductAttributeValueExample productAttributeValueExample = new PmsProductAttributeValueExample();
		productAttributeValueExample.createCriteria().andProductIdEqualTo(id);
		productAttributeValueMapper.deleteByExample(productAttributeValueExample);
		relateAndInsertList(productAttributeValueDao, pmsProductParam.getProductFullReductionList(), id);
		//关联专题
		CmsSubjectProductRelationExample subjectProductRelationExample = new CmsSubjectProductRelationExample();
		subjectProductRelationExample.createCriteria().andProductIdEqualTo(id);
		subjectProductRelationMapper.deleteByExample(subjectProductRelationExample);
		relateAndInsertList(subjectProductRelationDao, pmsProductParam.getSubjectProductRelationList(), id);
		//关联优选
		CmsPrefrenceAreaProductRelationExample prefrenceAreaProductRelationExample = new CmsPrefrenceAreaProductRelationExample();
		prefrenceAreaProductRelationExample.createCriteria().andProductIdEqualTo(id);
		prefrenceAreaProductRelationMapper.deleteByExample(prefrenceAreaProductRelationExample);
		relateAndInsertList(prefrenceAreaProductRelationDao, pmsProductParam.getPrefrenceAreaProductRelationList(), id);
		count = 1;
		return count;
	}

	private void handleUpdateSkuStockList(Long id, PmsProductParam pmsProductParam) {
		//当前的sku信息
		List<PmsSkuStock> currSkuList = pmsProductParam.getSkuStockList();
		if (CollUtil.isEmpty(currSkuList)) {
			PmsSkuStockExample skuStockExample = new PmsSkuStockExample();
			skuStockExample.createCriteria().andProductIdEqualTo(id);
			skuStockMapper.deleteByExample(skuStockExample);
			return;
		}

		PmsSkuStockExample skuStockExample = new PmsSkuStockExample();
		skuStockExample.createCriteria().andProductIdEqualTo(id);
		List<PmsSkuStock> oriStuList = skuStockMapper.selectByExample(skuStockExample);
		List<PmsSkuStock> insertSkuList = currSkuList.stream().filter(item -> item.getId() == null)
			.collect(Collectors.toList());
		List<PmsSkuStock> updateSkuList = currSkuList.stream().filter(item -> item.getId() != null)
			.collect(Collectors.toList());

		List<Long> updateSkuIds = updateSkuList.stream().map(PmsSkuStock::getId).collect(Collectors.toList());

		//获取需要删除的sku信息
		List<PmsSkuStock> removeSkuList = oriStuList.stream().filter(item -> !updateSkuIds
			.contains(item.getId())).collect(Collectors.toList());
		handleSkuStockCode(insertSkuList, id);
		handleSkuStockCode(updateSkuList, id);
		//新增sku
		if (CollUtil.isNotEmpty(insertSkuList)) {
			relateAndInsertList(skuStockDao, insertSkuList, id);
		}

		//删除sku
		if (CollUtil.isNotEmpty(updateSkuList)) {
			for (PmsSkuStock item : updateSkuList) {
				skuStockMapper.updateByPrimaryKeySelective(item);
			}
		}

	}

	@Override
	public int delete(Long id) {
		return pmsProductMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<PmsProduct> getList(PmsProductQueryParam productQueryParam, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		PmsProductExample productExample = new PmsProductExample();
		PmsProductExample.Criteria criteria = productExample.createCriteria();
		criteria.andDeleteStatusEqualTo(0);
		if (productQueryParam.getPublishStatus() != null) {
			criteria.andPublishStatusEqualTo(productQueryParam.getPublishStatus());
		}
		if (productQueryParam.getVerifyStatus() != null) {
			criteria.andVerifyStatusEqualTo(productQueryParam.getVerifyStatus());
		}
		if (!StrUtil.isEmpty(productQueryParam.getKeyword())) {
			criteria.andNameLike("%" + productQueryParam.getKeyword() + "%");
		}
		if (!StrUtil.isEmpty(productQueryParam.getProductSn())) {
			criteria.andProductSnEqualTo(productQueryParam.getProductSn());
		}
		if (productQueryParam.getBrandId() != null) {
			criteria.andBrandIdEqualTo(productQueryParam.getBrandId());
		}
		if (productQueryParam.getProductCategoryId() != null) {
			criteria.andProductCategoryIdEqualTo(productQueryParam.getProductCategoryId());
		}
		return pmsProductMapper.selectByExample(productExample);
	}

	@Override
	public int UpdateVerifyStatus(List<Long> ids, Integer verifyStatus, String detail) {
		PmsProduct product = new PmsProduct();
		product.setVerifyStatus(verifyStatus);
		PmsProductExample example = new PmsProductExample();
		example.createCriteria().andIdIn(ids);
		List<PmsProductVertifyRecord> list = new ArrayList<>();
		int count = pmsProductMapper.updateByExampleSelective(product, example);
		//修改完审核状态后插入审核记录
		for (Long id : ids) {
			PmsProductVertifyRecord record = new PmsProductVertifyRecord();
			record.setProductId(id);
			record.setCreateTime(new Date());
			record.setDetail(detail);
			record.setStatus(verifyStatus);
			record.setVertifyMan("test");
			list.add(record);
		}

		productVertifyRecordDao.insertList(list);
		return count;

	}

	@Override
	public int updateRecommendStatus(List<Long> ids, Integer newStatus) {
		PmsProduct record = new PmsProduct();
		record.setRecommandStatus(newStatus);
		PmsProductExample example = new PmsProductExample();
		example.createCriteria().andIdIn(ids);
		return pmsProductMapper.updateByExampleSelective(record, example);

	}

	@Override
	public int deleteStatus(List<Long> ids, Integer deleteStatus) {
		PmsProduct pmsProduct = new PmsProduct();
		pmsProduct.setDeleteStatus(deleteStatus);
		PmsProductExample example = new PmsProductExample();
		example.createCriteria().andIdIn(ids);
		return pmsProductMapper.updateByExampleSelective(pmsProduct, example);
	}

	@Override
	public List<PmsProduct> list(String keyword) {
		PmsProductExample productExample = new PmsProductExample();
		PmsProductExample.Criteria criteria = productExample.createCriteria();
		criteria.andDeleteStatusEqualTo(0);
		if (!StrUtil.isEmpty(keyword)) {
			criteria.andNameLike("%" + keyword + "%");
			productExample.or().andDeleteStatusEqualTo(0).andProductSnLike("%" + keyword + "%");
		}
		return pmsProductMapper.selectByExample(productExample);
	}

	@Override
	public int updatePublishStatus(List<Long> ids, Integer publishStatus) {
		PmsProduct record = new PmsProduct();
		record.setPublishStatus(publishStatus);
		PmsProductExample example = new PmsProductExample();
		example.createCriteria().andIdIn(ids);
		return pmsProductMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateNewStatus(List<Long> ids, Integer newStatus) {
		PmsProduct product = new PmsProduct();
		product.setNewStatus(newStatus);
		PmsProductExample example = new PmsProductExample();
		example.createCriteria().andIdIn(ids);
		return pmsProductMapper.updateByExampleSelective(product, example);
	}

	private void relateAndInsertList(Object dao, List dataList, Long productId) {
		try {
			if (CollectionUtils.isEmpty(dataList)) return;
			for (Object o : dataList) {
				Method setId = o.getClass().getMethod("setId", Long.class);
				setId.invoke(o, (Long) null);
				Method setProductId = o.getClass().getMethod("setProductId", Long.class);
				setProductId.invoke(o, productId);
			}
			Method insertList = dao.getClass().getMethod("insertList", List.class);
			insertList.invoke(dao, dataList);
		} catch (Exception e) {
			LOGGER.warn("创建产品出错:{}", e.getMessage());
			throw new RuntimeException(e.getMessage());
		}
	}

	private void handleSkuStockCode(List<PmsSkuStock> skuStockList, Long productId) {
		if (CollectionUtils.isEmpty(skuStockList)) return;
		for (int i = 0; i < skuStockList.size(); i++) {
			PmsSkuStock skuStock = skuStockList.get(i);
			if (StrUtil.isEmpty(skuStock.getSkuCode())) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
				StringBuilder sb = new StringBuilder();
				//DATE
				sb.append(sdf.format(new Date()));
				sb.append(String.format("%04d", productId));
				sb.append(String.format("%03d", i + 1));
				skuStock.setSkuCode(sb.toString());
			}
		}
	}
}
