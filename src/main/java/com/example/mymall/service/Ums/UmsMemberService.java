package com.example.mymall.service.Ums;

import com.example.mymall.mbg.model.UmsMember;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

public interface UmsMemberService {
	/**
	 * 生成验证码
	 */
	String generateAuthCode(String telephone);

	/**
	 * 根据用户名获取会员
	 */
	UmsMember getByUsername(String username);

	/**
	 * 根据会员编号获取会员
	 */
	UmsMember getById(Long id);

	/**
	 * 用户注册
	 */
	@Transactional
	void register(String username, String password, String telephone, String authCode);

	/**
	 * 修改密码
	 */
	@Transactional
	void updatePassword(String telephone, String password, String authCode);

	/**
	 * 获取当前登录会员
	 */
	UmsMember getCurrentMember();

	/**
	 * 根据会员id修改会员积分
	 */
	void updateIntegration(Long id, Integer integration);

	/**
	 * 登录后获取token
	 */
	String login(String username, String password);

	/**
	 * 获取用户信息
	 */
	UserDetails loadUserByUsername(String username);

	/**
	 * 刷新token
	 */
	String refreshToken(String token);
}
