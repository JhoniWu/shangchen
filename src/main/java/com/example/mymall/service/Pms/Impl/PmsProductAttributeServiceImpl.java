package com.example.mymall.service.Pms.Impl;

import com.example.mymall.mbg.mapper.PmsProductAttributeCategoryMapper;
import com.example.mymall.mbg.mapper.PmsProductAttributeMapper;
import com.example.mymall.mbg.model.PmsProductAttribute;
import com.example.mymall.mbg.model.PmsProductAttributeCategory;
import com.example.mymall.mbg.model.PmsProductAttributeExample;
import com.example.mymall.service.Pms.PmsProductAttributeService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PmsProductAttributeServiceImpl implements PmsProductAttributeService {

	@Autowired
	private PmsProductAttributeMapper pmsProductAttributeMapper;
	@Autowired
	private PmsProductAttributeCategoryMapper pmsProductAttributeCategoryMapper;

	@Override
	public List<PmsProductAttribute> listAllAttribute() {
		return pmsProductAttributeMapper.selectByExample(new PmsProductAttributeExample());
	}

	@Override
	public int createAttribute(PmsProductAttribute pmsProductAttributes) {
		int count = pmsProductAttributeMapper.insertSelective(pmsProductAttributes);
		return count;
	}

	@Override
	public int updateAttribute(Long id, PmsProductAttribute pmsProductAttribute) {
		pmsProductAttribute.setId(id);
		return pmsProductAttributeMapper.updateByPrimaryKeySelective(pmsProductAttribute);
	}

	@Override
	public int deleteAttribute(Long id) {
		return pmsProductAttributeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int deleteIds(List<Long> ids) {
		PmsProductAttribute pmsProductAttribute = pmsProductAttributeMapper.selectByPrimaryKey(ids.get(0));
		Integer type = pmsProductAttribute.getType();
		PmsProductAttributeCategory pmsProductAttributeCategory = pmsProductAttributeCategoryMapper
			.selectByPrimaryKey(pmsProductAttribute.getProductAttributeCategoryId());
		PmsProductAttributeExample example = new PmsProductAttributeExample();
		example.createCriteria().andIdIn(ids);
		int count = pmsProductAttributeMapper.deleteByExample(example);
		if (type == 0) {
			if (pmsProductAttributeCategory.getAttributeCount() >= count) {
				pmsProductAttributeCategory.setAttributeCount(pmsProductAttributeCategory.getAttributeCount());
			} else {
				pmsProductAttributeCategory.setAttributeCount(0);
			}
		} else if (type == 1) {
			if (pmsProductAttributeCategory.getParamCount() >= count) {
				pmsProductAttributeCategory.setParamCount(pmsProductAttributeCategory.getParamCount() - count);
			} else {
				pmsProductAttributeCategory.setParamCount(0);
			}
		}
		pmsProductAttributeCategoryMapper.updateByPrimaryKey(pmsProductAttributeCategory);
		return count;
	}

	@Override
	public List<PmsProductAttribute> listAttribute(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return pmsProductAttributeMapper.selectByExample(new PmsProductAttributeExample());
	}

	@Override
	public PmsProductAttribute getAttribute(Long id) {
		return pmsProductAttributeMapper.selectByPrimaryKey(id);
	}
}
