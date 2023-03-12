package com.example.mymall.service.impl;

import com.example.mymall.mbg.mapper.PmsBrandMapper;
import com.example.mymall.mbg.model.PmsBrand;
import com.example.mymall.mbg.model.PmsBrandExample;
import com.example.mymall.service.PmsBrandService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: MyMall
 * @description: PmsBrandService实现类
 * @author: Max Wu
 * @create: 2023-03-03 15:29
 **/
@Service
public class PmsBrandServiceImpl implements PmsBrandService {

	@Autowired
	private PmsBrandMapper brandMapper;

	@Override
	public List<PmsBrand> listAllBrand() {
		return brandMapper.selectByExample(new PmsBrandExample());
	}

	@Override
	public int createBrand(PmsBrand brand) {
		return brandMapper.insertSelective(brand);
	}

	@Override
	public int updateBrand(Long id, PmsBrand brand) {
		brand.setId(id);
		return brandMapper.updateByPrimaryKeySelective(brand);
	}

	@Override
	public int deleteBrand(Long id) {
		return brandMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<PmsBrand> listBrand(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum , pageSize);
		return brandMapper.selectByExample(new PmsBrandExample());
	}

	@Override
	public PmsBrand getBrand(Long id) {
		return brandMapper.selectByPrimaryKey(id);
	}
}
