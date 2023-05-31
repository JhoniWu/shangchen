package com.example.mymall.nosql.mongodb.repository;

import com.example.mymall.nosql.mongodb.document.MemberReadHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @program: MyMall
 * @description: 会员商品浏览历史Repository
 * @author: Max Wu
 * @create: 2023-05-08 15:50
 **/
public interface MemberReadHistoryRepository extends MongoRepository<MemberReadHistory, String> {
	/**
	 * 根据会员id按时间倒序获取浏览记录
	 *
	 * @param memberId 会员id
	 */
	List<MemberReadHistory> findByMemberIdOrderByCreateTimeDesc(Long memberId);
}
