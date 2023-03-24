package com.example.mymall.dto;

import com.example.mymall.mbg.model.UmsAdmin;
import com.example.mymall.mbg.model.UmsAdminExample;
import com.example.mymall.mbg.model.UmsPermission;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: MyMall
 * @description: SpringSecurity需要的用户详情
 * @author: Max Wu
 * @create: 2023-03-13 15:07
 **/
public class AdminUserDetails implements UserDetails {
	private UmsAdmin umsAdmin;
	private List<UmsPermission> permissionList;
	public AdminUserDetails(UmsAdmin umsAdmin, List<UmsPermission> permissionList){
		this.umsAdmin = umsAdmin;
		this.permissionList = permissionList;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		//返回当前用户权限
		return permissionList.stream()
			.filter(permission -> permission.getValue()!=null)
			.map(permission ->new SimpleGrantedAuthority(permission.getValue()))
			.collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		return umsAdmin.getPassword();
	}

	@Override
	public String getUsername() {
		return umsAdmin.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return umsAdmin.getStatus().equals(1);
	}
}
