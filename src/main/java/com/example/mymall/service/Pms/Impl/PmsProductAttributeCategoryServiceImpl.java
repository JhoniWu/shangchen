package com.example.mymall.service.Pms.Impl;

import com.example.mymall.dao.PmsProductAttributeCategoryDao;
import com.example.mymall.dto.PmsProductAttributeCategoryItem;
import com.example.mymall.mbg.mapper.PmsProductAttributeCategoryMapper;
import com.example.mymall.mbg.model.PmsProductAttributeCategory;
import com.example.mymall.mbg.model.PmsProductAttributeCategoryExample;
import com.example.mymall.service.Pms.PmsProductAttributeCategoryService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PmsProductAttributeCategoryServiceImpl implements PmsProductAttributeCategoryService {

	@Autowired
	private PmsProductAttributeCategoryMapper ppam;
	@Autowired
	private PmsProductAttributeCategoryDao pmsProductAttributeCategoryDao;


	@Override
	public List<PmsProductAttributeCategory> listAllAttributeCategory() {
		return ppam.selectByExample(new PmsProductAttributeCategoryExample());
	}

	@Override
	public int createAttributeCategory(String name) {
		PmsProductAttributeCategory p = new PmsProductAttributeCategory();
		p.setName(name);
		return ppam.insert(p);
	}

	@Override
	public int updateAttributeCategory(Long id, PmsProductAttributeCategory pmsProductAttributeCategory) {
		pmsProductAttributeCategory.setId(id);
		return ppam.updateByPrimaryKeySelective(pmsProductAttributeCategory);
	}

	@Override
	public int deleteAttributeCategory(Long id) {
		return ppam.deleteByPrimaryKey(id);
	}

	@Override
	public List<PmsProductAttributeCategory> listAttributeCategory(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return ppam.selectByExample(new PmsProductAttributeCategoryExample());
	}

	@Override
	public PmsProductAttributeCategory getAttributeCategory(Long id) {
		return ppam.selectByPrimaryKey(id);
	}

	@Override
	public List<PmsProductAttributeCategoryItem> getListWithAttr() {
		return pmsProductAttributeCategoryDao.getListWithAttr();
	}
}
