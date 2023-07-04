package com.example.mymall.service.Ums;

import com.example.mymall.mbg.model.UmsAdmin;
import com.example.mymall.mbg.model.UmsPermission;

import java.util.List;

public interface UmsAdminService {
	/**
	 * 根据用户名获取后台管理员
	 */
	UmsAdmin getAdminByUsername(String username);

	/**
	 * 注册功能
	 */
	UmsAdmin register(UmsAdmin umsAdminParam);

	/**
	 * 登录功能
	 * @param username 用户名
	 * @param password 密码
	 * @return 生成的JWT的token
	 */
	String login(String username, String password);

	/**
	 * 获取用户所有权限（包括角色权限和+-权限）
	 */
	List<UmsPermission> getPermissionList(Long adminId);

	/**
	 * 刷新token
	 */
	String refreshToken(String oldToken);

	/**
	 * 根据用户id获取用户
	 */
	UmsAdmin getItem(Long id);

	/**
	 * 根据用户名或者昵称分页查询
	 */

	/**
	 * 获取缓存服务
	 */
	UmsAdminCacheService getCacheService();

	/**
	 * 修改密码
	 */

}
