package com.example.mymall.service.Pms.Impl;

import com.example.mymall.dao.HomeDao;
import com.example.mymall.mbg.mapper.PmsBrandMapper;
import com.example.mymall.mbg.mapper.PmsProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: MyMall
 * @description: 前台品牌管理ServiceImpl
 * @author: Max Wu
 * @create: 2023-07-04 23:06
 **/
@Service
public class PmsPortalBrandServiceImpl {
	@Autowired
	private HomeDao homeDao;
	@Autowired
	private PmsBrandMapper brandMapper;
	@Autowired
	private PmsProductMapper productMapper;

}
