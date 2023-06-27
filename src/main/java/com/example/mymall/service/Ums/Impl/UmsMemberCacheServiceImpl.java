package com.example.mymall.service.Ums.Impl;

import com.example.mymall.mbg.mapper.UmsMemberMapper;
import com.example.mymall.mbg.model.UmsMember;
import com.example.mymall.service.RedisService;
import com.example.mymall.service.Ums.UmsMemberCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @program: MyMall
 * @description: 用户缓存服务实现类
 * @author: Max Wu
 * @create: 2023-06-27 15:59
 **/
@Service
public class UmsMemberCacheServiceImpl implements UmsMemberCacheService {
	@Autowired
	private RedisService redisService;
	@Autowired
	private UmsMemberMapper memberMapper;
	@Value("${redis.database}")
	private String REDIS_DATABASE;
	@Value("${redis.expire.common}")
	private Long REDIS_EXPIRE;
	@Value("${redis.expire.authCode}")
	private Long REDIS_EXPIRE_AUTH_CODE;
	@Value("${redis.key.member}")
	private String REDIS_KEY_MEMBER;
	@Value("${redis.key.authCode}")
	private String REDIS_KEY_AUTH_CODE;


	@Override
	public void delMember(Long memberId) {
		UmsMember umsMember = memberMapper.selectByPrimaryKey(memberId);
		if (umsMember != null) {
			String key = REDIS_DATABASE + ":" + REDIS_KEY_MEMBER + ":" + umsMember.getUsername();
			redisService.del(key);
		}
	}

	@Override
	public UmsMember getMember(String username) {
		String key = REDIS_DATABASE + ":" + REDIS_KEY_MEMBER + ":" + username;
		return (UmsMember) redisService.get(key);
	}

	@Override
	public void setMember(UmsMember member) {
		String key = REDIS_DATABASE + ":" + REDIS_KEY_MEMBER + ":" + member.getUsername();
		redisService.set(key, member, REDIS_EXPIRE);
	}

	@Override
	public void setAuthCode(String telephone, String authCode) {
		String key = REDIS_DATABASE + ":" + REDIS_KEY_AUTH_CODE + ":" + telephone;
		redisService.set(key, authCode, REDIS_EXPIRE_AUTH_CODE);
	}

	@Override
	public String getAuthCode(String telephone) {
		String key = REDIS_DATABASE + ":" + REDIS_KEY_AUTH_CODE + ":" + telephone;
		return (String) redisService.get(key);
	}
}
