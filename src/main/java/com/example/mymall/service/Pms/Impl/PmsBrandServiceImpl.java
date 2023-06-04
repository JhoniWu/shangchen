package com.example.mymall.service.Pms.Impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.example.mymall.mbg.mapper.PmsBrandMapper;
import com.example.mymall.mbg.model.PmsBrand;
import com.example.mymall.mbg.model.PmsBrandExample;
import com.example.mymall.service.Pms.PmsBrandService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

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
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

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
		String key = "shop:brand:" + id;
		String shop = stringRedisTemplate.opsForValue().get(key);
		if (StrUtil.isNotBlank(shop)) {
			PmsBrand pmsBrand = JSONUtil.toBean(shop, PmsBrand.class);
			return pmsBrand;
		}
		PmsBrand pmsBrandsa = brandMapper.selectByPrimaryKey(id);
		String jsonStr = JSONUtil.toJsonStr(pmsBrandsa);
		stringRedisTemplate.opsForValue().set(key, jsonStr, 30, TimeUnit.MINUTES);
		return pmsBrandsa;
	}
}
