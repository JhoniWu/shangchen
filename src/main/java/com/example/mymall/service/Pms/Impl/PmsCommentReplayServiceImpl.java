package com.example.mymall.service.Pms.Impl;

import com.example.mymall.mbg.mapper.PmsCommentReplayMapper;
import com.example.mymall.mbg.model.PmsCommentReplay;
import com.example.mymall.mbg.model.PmsCommentReplayExample;
import com.example.mymall.service.Pms.PmsCommentReplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: MyMall
 * @description: 商品评价回复表
 * @author: Max Wu
 * @create: 2023-05-07 13:27
 **/
@Service
public class PmsCommentReplayServiceImpl implements PmsCommentReplayService {
	@Autowired
	private PmsCommentReplayMapper commentReplayMapper;

	@Override
	public int create(PmsCommentReplay pmsCommentReplay) {
		return commentReplayMapper.insertSelective(pmsCommentReplay);
	}

	@Override
	public int update(Long id, PmsCommentReplay pmsCommentReplay) {
		pmsCommentReplay.setId(id);
		return commentReplayMapper.updateByPrimaryKey(pmsCommentReplay);
	}

	@Override
	public int delete(Long id) {
		return commentReplayMapper.deleteByPrimaryKey(id);
	}

	@Override
	public PmsCommentReplay select(Long id) {
		return commentReplayMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<PmsCommentReplay> getList(Long CommentId) {
		PmsCommentReplayExample example = new PmsCommentReplayExample();
		example.createCriteria().andCommentIdEqualTo(CommentId);
		return commentReplayMapper.selectByExample(example);
	}
}
