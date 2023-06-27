package com.example.mymall.service.Ums.Impl;

import com.alibaba.druid.util.StringUtils;
import com.example.mymall.common.utils.Asserts;
import com.example.mymall.common.utils.JwtTokenUtil;
import com.example.mymall.dto.MemberDetails;
import com.example.mymall.mbg.mapper.UmsMemberLevelMapper;
import com.example.mymall.mbg.mapper.UmsMemberMapper;
import com.example.mymall.mbg.model.UmsMember;
import com.example.mymall.mbg.model.UmsMemberExample;
import com.example.mymall.mbg.model.UmsMemberLevel;
import com.example.mymall.mbg.model.UmsMemberLevelExample;
import com.example.mymall.service.RedisService;
import com.example.mymall.service.Ums.UmsMemberCacheService;
import com.example.mymall.service.Ums.UmsMemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @program: MyMall
 * @description: 会员管理Service实现类
 * @author: Max Wu
 * @create: 2023-03-11 21:44
 **/
@Service
public class UmsMemberServiceImpl implements UmsMemberService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UmsMemberServiceImpl.class);
	@Autowired
	private RedisService redisService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private UmsMemberMapper memberMapper;
	@Autowired
	private UmsMemberLevelMapper memberLevelMapper;
	@Autowired
	private UmsMemberCacheService memberCacheService;
	@Value("${redis.key.authCode}")
	private String REDIS_KEY_PREFIX_AUTH_CODE;
	@Value("${redis.expire.authCode}")
	private Long AUTH_CODE_EXPIRE_SECONDS;

	@Override
	public String generateAuthCode(String telephone) {
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 6; i++) {
			sb.append(random.nextInt(10));
		}
		//验证码绑定手机号并存储到redis
		redisService.set(REDIS_KEY_PREFIX_AUTH_CODE + telephone, sb.toString());
		redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE + telephone, AUTH_CODE_EXPIRE_SECONDS);
		return sb.toString();
	}

	public Boolean verifyAuthCode(String telephone, String authCode) {
		if (StringUtils.isEmpty(authCode)) {
			return false;
		}
		String realAuthCode = memberCacheService.getAuthCode(telephone);
		return authCode.equals(realAuthCode);
	}

	@Override
	public UmsMember getByUsername(String username) {
		UmsMember member = memberCacheService.getMember(username);
		if (member != null) {
			return member;
		}
		UmsMemberExample example = new UmsMemberExample();
		example.createCriteria().andUsernameEqualTo(username);
		List<UmsMember> memberList = memberMapper.selectByExample(example);
		if (!CollectionUtils.isEmpty(memberList)) {
			member = memberList.get(0);
			memberCacheService.setMember(member);
			return member;
		}
		return null;
	}

	@Override
	public UmsMember getById(Long id) {
		return memberMapper.selectByPrimaryKey(id);
	}

	@Override
	public void register(String username, String password, String telephone, String authCode) {
		//验证验证码
		if (!verifyAuthCode(telephone, authCode)) {
			Asserts.fail("验证码错误");
		}
		//查询是否已有该用户
		UmsMemberExample example = new UmsMemberExample();
		example.createCriteria().andUsernameEqualTo(username);
		example.or(example.createCriteria().andPhoneEqualTo(telephone));
		List<UmsMember> umsMembers = memberMapper.selectByExample(example);
		if (umsMembers.size() > 0) {
			Asserts.fail("用户已存在");
		}
		//没有该用户进行添加操作
		UmsMember member = new UmsMember();
		member.setUsername(username);
		member.setPassword(password);
		member.setPhone(telephone);
		member.setCreateTime(new Date());
		member.setStatus(1);
		//获取默认会员等级并设置
		UmsMemberLevelExample levelExample = new UmsMemberLevelExample();
		levelExample.createCriteria().andDefaultStatusEqualTo(1);
		List<UmsMemberLevel> memberLevelList = memberLevelMapper.selectByExample(levelExample);
		if (!CollectionUtils.isEmpty(memberLevelList)) {
			member.setMemberLevelId(memberLevelList.get(0).getId());
		}
		memberMapper.insert(member);
		member.setPassword(null);
	}

	@Override
	public void updatePassword(String telephone, String password, String authCode) {
		//判断账号是否存在
		UmsMemberExample example = new UmsMemberExample();
		example.createCriteria().andPhoneEqualTo(telephone);
		List<UmsMember> umsMembers = memberMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(umsMembers)) {
			Asserts.fail("该账号不存在");
		}
		//验证验证码
		if (!verifyAuthCode(telephone, authCode)) {
			Asserts.fail("验证码错误");
		}
		//修改密码
		UmsMember member = umsMembers.get(0);
		member.setPassword(password);
		memberMapper.updateByPrimaryKeySelective(member);
		memberCacheService.delMember(member.getId());
	}

	/**
	 * 获取当前登录会员
	 */
	@Override
	public UmsMember getCurrentMember() {
		SecurityContext ctx = SecurityContextHolder.getContext();
		Authentication auth = ctx.getAuthentication();
		MemberDetails details = (MemberDetails) auth.getPrincipal();
		return details.getUmsMember();
	}

	@Override
	public void updateIntegration(Long id, Integer integration) {
		UmsMember record = new UmsMember();
		record.setId(id);
		record.setIntegration(integration);
		memberMapper.updateByPrimaryKeySelective(record);
		memberCacheService.delMember(id);
	}

	@Override
	public String login(String username, String password) {
		String token = null;
		try {
			UserDetails userDetails = loadUserByUsername(username);
			if (!passwordEncoder.matches(password, userDetails.getPassword())) {
				throw new BadCredentialsException("密码不正确");
			}
			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
				userDetails, null, userDetails.getAuthorities()
			);
			SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			token = jwtTokenUtil.generateToken(userDetails);
		} catch (AuthenticationException e) {
			LOGGER.warn("登录异常:{}", e.getMessage());
		}
		return token;
	}

	@Override
	public UserDetails loadUserByUsername(String username) {
		UmsMember member = getByUsername(username);
		if (member != null) {
			return new MemberDetails(member);
		}
		throw new UsernameNotFoundException("用户名或密码错误");
	}

	@Override
	public String refreshToken(String token) {
		return jwtTokenUtil.refreshToken(token);
	}
}
