package com.example.mymall.service.impl.PmsProductImpl.Attribute;

import com.example.mymall.mbg.mapper.PmsProductAttributeCategoryMapper;
import com.example.mymall.mbg.mapper.PmsProductAttributeMapper;
import com.example.mymall.mbg.model.PmsProductAttribute;
import com.example.mymall.mbg.model.PmsProductAttributeExample;
import com.example.mymall.service.PmsProduct.Attribute.PmsProductAttributeService;
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
	public List<PmsProductAttribute> listAttribute(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum,pageSize);
		return pmsProductAttributeMapper.selectByExample(new PmsProductAttributeExample());
	}

	@Override
	public PmsProductAttribute getAttribute(Long id) {
		return pmsProductAttributeMapper.selectByPrimaryKey(id);
	}
}
