package com.example.mymall.service.Ums;

import com.example.mymall.mbg.model.UmsAdmin;

import java.util.List;

/**
 * @program: MyMall
 * @description:
 * @author: Max Wu
 * @create: 2023-06-27 15:31
 **/

public interface UmsAdminCacheService {
	/**
	 * 删除后台用户缓存
	 */
	void delAdmin(Long adminId);

	/**
	 * 删除后台用户资源列表缓存
	 */
	void delResourceList(Long adminId);

	/**
	 * 当角色相关资源信息改变时删除相关后台用户缓存
	 */
	void delResourceListByRole(Long roleId);

	/**
	 * 当角色相关资源信息改变时删除相关后台用户缓存
	 */
	void delResourceListByRoleIds(List<Long> roleIds);

	/**
	 * 当资源信息改变时，删除资源项目后台用户缓存
	 */
	void delResourceListByResource(Long resourceId);

	/**
	 * 设置缓存后台用户信息
	 */
	void setAdmin(UmsAdmin admin);

	/**
	 * 获取缓存后台用户资源列表
	 */
	//List<UmsResource> getResourceList(Long adminId);

	/**
	 * 设置缓存后台用户资源列表
	 */
	//void setResourceList(Long adminId, List<UmsResource> resourceList);
}
