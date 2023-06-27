package com.example.mymall.service.Ums;

import com.example.mymall.mbg.model.UmsMember;

/**
 * @program: MyMall
 * @description:
 * @author: Max Wu
 * @create: 2023-06-27 15:33
 **/

public interface UmsMemberCacheService {
	/**
	 * 删除会员用户缓存
	 */
	void delMember(Long memberId);

	/**
	 * 获取会员用户缓存
	 */
	UmsMember getMember(String username);

	/**
	 * 设置会员用户缓存
	 */
	void setMember(UmsMember member);

	/**
	 * 设置验证码
	 */
	void setAuthCode(String telephone, String authCode);

	/**
	 * 获取验证码
	 */
	String getAuthCode(String telephone);
}
