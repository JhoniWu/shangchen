package com.example.mymall.service.Ums.Impl;

import com.example.mymall.mbg.mapper.UmsMemberLevelMapper;
import com.example.mymall.mbg.model.UmsMemberLevel;
import com.example.mymall.mbg.model.UmsMemberLevelExample;
import com.example.mymall.service.Ums.UmsMemberLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: MyMall
 * @description:
 * @author: Max Wu
 * @create: 2023-06-27 15:41
 **/
@Service
public class UmsMemberLevelServiceImpl implements UmsMemberLevelService {
	@Autowired
	private UmsMemberLevelMapper umsMemberLevelMapper;

	@Override
	public List<UmsMemberLevel> list(Integer defaultStatus) {
		UmsMemberLevelExample example = new UmsMemberLevelExample();
		example.createCriteria().andDefaultStatusEqualTo(defaultStatus);
		return umsMemberLevelMapper.selectByExample(example);
	}
}
