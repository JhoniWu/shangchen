package com.example.mymall.service.impl;

import com.example.mymall.mbg.mapper.PmsCommentMapper;
import com.example.mymall.mbg.model.PmsComment;
import com.example.mymall.mbg.model.PmsCommentExample;
import com.example.mymall.service.PmsCommentService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: MyMall
 * @description: 商品回复service实现类
 * @author: Max Wu
 * @create: 2023-05-06 20:26
 **/
@Service
public class PmsCommentServiceImpl implements PmsCommentService {
	@Autowired
	private PmsCommentMapper commentMapper;


	@Override
	public int create(PmsComment pmsComment) {
		return commentMapper.insertSelective(pmsComment);
	}

	@Override
	public int update(Long id, PmsComment pmsComment) {
		pmsComment.setId(id);
		return commentMapper.updateByPrimaryKeySelective(pmsComment);
	}

	@Override
	public int delete(Long id) {
		return commentMapper.deleteByPrimaryKey(id);
	}

	@Override
	public PmsComment select(Long id, Long productId) {
		return commentMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<PmsComment> getList(Long productId, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		PmsCommentExample example = new PmsCommentExample();
		example.createCriteria().andProductIdEqualTo(productId);
		return commentMapper.selectByExample(example);
	}

	@Override
	public List<PmsComment> listAll(Long productId) {
		PmsCommentExample example = new PmsCommentExample();
		example.createCriteria().andProductIdEqualTo(productId);
		return commentMapper.selectByExample(example);
	}
}
