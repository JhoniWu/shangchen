package com.example.mymall.service.impl;

import com.example.mymall.nosql.mongodb.document.MemberReadHistory;
import com.example.mymall.nosql.mongodb.repository.MemberReadHistoryRepository;
import com.example.mymall.service.MemberReadHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: MyMall
 * @description: 商品浏览记录impl
 * @author: Max Wu
 * @create: 2023-05-08 15:58
 **/
@Service
public class MemberReadHistoryServiceImpl implements MemberReadHistoryService {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	@Autowired
	private MemberReadHistoryRepository memberReadHistoryRepository;

	@Override
	public int create(MemberReadHistory memberReadHistory) {
		memberReadHistory.setId(null);
		memberReadHistory.setCreateTime(new Date());
		memberReadHistoryRepository.save(memberReadHistory);
		return 1;
	}

	@Override
	public int delete(List<String> ids) {
		List<MemberReadHistory> deleteList = new ArrayList<>();
		for (String id : ids) {
			MemberReadHistory memberReadHistory = new MemberReadHistory();
			memberReadHistory.setId(id);
			deleteList.add(memberReadHistory);
		}
		memberReadHistoryRepository.deleteAll(deleteList);
		return ids.size();
	}

	@Override
	public List<MemberReadHistory> list(Long memberId) {
		return memberReadHistoryRepository.findByMemberIdOrderByCreateTimeDesc(memberId);
	}
}
