package com.example.mymall.config;

import com.example.mymall.component.JwtAuthenticationTokenFilter;
import com.example.mymall.component.RestAuthenticationEntryPoint;
import com.example.mymall.component.RestfulAccessDeniedHandler;
import com.example.mymall.dto.AdminUserDetails;
import com.example.mymall.mbg.model.UmsAdmin;
import com.example.mymall.mbg.model.UmsPermission;
import com.example.mymall.service.Ums.UmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.List;

/**
 * @program: MyMall
 * @description: SpringSecurity的配置
 * @author: Max Wu
 * @create: 2023-03-12 11:31
 **/
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	@Lazy
	private UmsAdminService umsAdminService;
	@Autowired
	private RestfulAccessDeniedHandler restfulAccessDeniedHandler;
	@Autowired
	private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf()// 由于使用的是JWT，我们这里不需要csrf
			.disable()
                .sessionManagement()// 基于token，所以不需要session
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.authorizeRequests()
			.antMatchers(HttpMethod.GET, // 允许对于网站静态资源的无授权访问
				"/",
				"/*.html",
				"/favicon.ico",
				"/**/*.html",
				"/**/*.css",
				"/**/*.js",
				"/swagger-resources/**",
				"/v2/api-docs/**")
			.permitAll()
			.antMatchers("/admin/login", "/admin/register", "/sso/getAuthCode", "/sso/register", "/sso/login")// 对登录注册要允许匿名访问
			.permitAll()
                .antMatchers(HttpMethod.OPTIONS)//跨域请求会先进行一次options请求
			.permitAll()
			.anyRequest()
			.authenticated();
		//禁用缓存
		httpSecurity.headers().cacheControl();
		//添加JWT filter
		httpSecurity.addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
		httpSecurity.exceptionHandling()
			.accessDeniedHandler(restfulAccessDeniedHandler)
			.authenticationEntryPoint(restAuthenticationEntryPoint);
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService())
			.passwordEncoder(passwordEncoder());
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public UserDetailsService userDetailsService() {
		//获取登录用户信息
		return username -> {
			UmsAdmin admin = umsAdminService.getAdminByUsername(username);
			if (admin != null) {
				List<UmsPermission> permissionList = umsAdminService.getPermissionList(admin.getId());
				return new AdminUserDetails(admin,permissionList);
			}
			throw new UsernameNotFoundException("用户名或密码错误");
		};
	}
	@Bean
	public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter(){
		return new JwtAuthenticationTokenFilter();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
}
