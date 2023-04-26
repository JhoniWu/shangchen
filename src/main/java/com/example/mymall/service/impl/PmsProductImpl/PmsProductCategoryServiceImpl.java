package com.example.mymall.service.impl.PmsProductImpl;

import com.example.mymall.mbg.mapper.PmsProductCategoryMapper;
import com.example.mymall.mbg.model.PmsProductCategory;
import com.example.mymall.mbg.model.PmsProductCategoryExample;
import com.example.mymall.service.PmsProduct.PmsProductCategoryService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: MyMall
 * @description:
 * @author: Max Wu
 * @create: 2023-04-26 19:17
 **/
@Service
public class PmsProductCategoryServiceImpl implements PmsProductCategoryService {

	@Autowired
	private PmsProductCategoryMapper pmsProductCategoryMapper;

	@Override
	public List<PmsProductCategory> listAllCategory() {
		return pmsProductCategoryMapper.selectByExample(new PmsProductCategoryExample());
	}

	@Override
	public int createCategory(PmsProductCategory pmsProductCategory) {
		return pmsProductCategoryMapper.insertSelective(pmsProductCategory);
	}

	@Override
	public int updateCategory(Long id, PmsProductCategory pmsProductCategory) {
		pmsProductCategory.setId(id);
		return pmsProductCategoryMapper.updateByPrimaryKeySelective(pmsProductCategory);
	}

	@Override
	public int deleteCategory(Long id) {
		return pmsProductCategoryMapper.deleteByPrimaryKey(id);
	}

	@Override
	public PmsProductCategory getCategory(Long id) {
		return pmsProductCategoryMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<PmsProductCategory> listCateGory(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum,pageSize);
		return pmsProductCategoryMapper.selectByExample(new PmsProductCategoryExample());
	}
}
