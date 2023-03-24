package com.example.mymall.service.impl;

import com.example.mymall.common.utils.JwtTokenUtil;
import com.example.mymall.dao.UmsAdminRoleRelationDao;
import com.example.mymall.mbg.mapper.UmsAdminMapper;
import com.example.mymall.mbg.model.UmsAdmin;
import com.example.mymall.mbg.model.UmsAdminExample;
import com.example.mymall.mbg.model.UmsPermission;
import com.example.mymall.service.UmsAdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @program: MyMall
 * @description: user管理实现类
 * @author: Max Wu
 * @create: 2023-03-12 21:02
 **/
@Service
@Transactional
public class UmsAdminServiceImpl implements UmsAdminService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UmsAdminServiceImpl.class);

	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private PasswordEncoder passwordEncoder;
    @Value("${jwt.tokenHead}")
	private String tokenHead;
	@Autowired
	private UmsAdminMapper umsAdminMapper;
	@Autowired
	private UmsAdminRoleRelationDao adminRoleRelationDao;

	@Override
	public UmsAdmin getAdminByUsername(String username) {
		UmsAdminExample example = new UmsAdminExample();
		example.createCriteria().andUsernameEqualTo(username);
		List<UmsAdmin> adminList = umsAdminMapper.selectByExample(example);
		if(adminList != null && adminList.size() > 0 ){
			return adminList.get(0);
		}
		return null;
	}

	@Override
	public UmsAdmin register(UmsAdmin umsAdminParam) {
		UmsAdmin umsAdmin = new UmsAdmin();
		BeanUtils.copyProperties(umsAdminParam, umsAdmin);
		umsAdmin.setCreateTime(new Date());
		umsAdmin.setStatus(1);
		UmsAdminExample example = new UmsAdminExample();
		example.createCriteria().andUsernameEqualTo(umsAdmin.getUsername());
		List<UmsAdmin> umsAdminList = umsAdminMapper.selectByExample(example);
		if(umsAdminList.size()>0 ){
			return null;
		}
		String encodePassword = passwordEncoder.encode(umsAdmin.getPassword());
        umsAdmin.setPassword(encodePassword);
        umsAdminMapper.insert(umsAdmin);
		return umsAdmin;
	}

	@Override
	public String login(String username, String password) {
		String token = null;
		try{
			UserDetails userDetails = userDetailsService.loadUserByUsername(username);
			if(!passwordEncoder.matches(password,userDetails.getPassword())){
				throw new BadCredentialsException("密码不正确");
			}
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
			token = jwtTokenUtil.generateToken(userDetails);
		} catch (AuthenticationException e) {
			LOGGER.warn("登录异常:{}", e.getMessage());
		}
		return token;
	}

	@Override
	public List<UmsPermission> getPermissionList(Long adminId) {
		return adminRoleRelationDao.getPermissionList(adminId);
	}
}
