package com.example.mymall.service.Pms;

import com.example.mymall.mbg.model.PmsComment;

import java.util.List;

/**
 * @program: MyMall
 * @description: 商品评论Dao
 * @author: Max Wu
 * @create: 2023-05-06 20:23
 **/
public interface PmsCommentService {
	int create(PmsComment pmsComment);

	int update(Long id, PmsComment pmsComment);

	int delete(Long id);

	PmsComment select(Long id, Long productId);

	List<PmsComment> getList(Long productId, Integer pageNum, Integer pageSize);

	List<PmsComment> listAll(Long productId);
}
