package com.example.mymall.service.Pms;

import com.example.mymall.mbg.model.PmsCommentReplay;

import java.util.List;

/**
 * @program: MyMall
 * @description: 产品评价回复表
 * @author: Max Wu
 * @create: 2023-05-06 20:48
 **/
public interface PmsCommentReplayService {
	int create(PmsCommentReplay pmsCommentReplay);

	int update(Long id, PmsCommentReplay pmsCommentReplay);

	int delete(Long id);

	PmsCommentReplay select(Long id);

	List<PmsCommentReplay> getList(Long CommentId);
}
