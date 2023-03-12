package com.example.mymall.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.example.mymall.common.CommonResult;
import com.example.mymall.service.RedisService;
import com.example.mymall.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import springfox.documentation.service.ApiListing;

import java.util.Random;

/**
 * @program: MyMall
 * @description: 会员管理Service实现类
 * @author: Max Wu
 * @create: 2023-03-11 21:44
 **/
@Service
public class UmsMemberServiceImpl implements UmsMemberService {
	@Autowired
	private RedisService redisService;

	@Value("${redis.key.prefix.authCode}")
	private String REDIS_KEY_PREFIX_AUTH_CODE;
	@Value("${redis.key.expire.authCode}")
	private Long AUTH_CODE_EXPIRE_SECONDS;

	@Override
	public CommonResult generateAuthCode(String telephone) {
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 6; i++) {
			sb.append(random.nextInt(10));
		}
		//验证码绑定手机号并存储到redis
		redisService.set(REDIS_KEY_PREFIX_AUTH_CODE + telephone, sb.toString());
		redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE + telephone, AUTH_CODE_EXPIRE_SECONDS);
		return CommonResult.success(sb.toString(), "获取验证码成功");
	}

	@Override
	public CommonResult verifyAuthCode(String telephone, String authCode) {
		if (StringUtils.isEmpty(authCode)) {
			return CommonResult.failed("请输入验证码");
		}
		String realAuthCode = redisService.get(REDIS_KEY_PREFIX_AUTH_CODE + telephone);
		boolean result = authCode.equals(realAuthCode);
		if (result) {
			return CommonResult.success(null, "验证校验成功");
		} else {
			return CommonResult.failed("验证不正确");
		}
	}


}
