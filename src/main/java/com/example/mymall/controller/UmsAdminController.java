package com.example.mymall.controller;

import com.example.mymall.common.CommonResult;
import com.example.mymall.dto.UmsAdminLoginParam;
import com.example.mymall.mbg.model.UmsAdmin;
import com.example.mymall.mbg.model.UmsPermission;
import com.example.mymall.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: MyMall
 * @description: 后台用户管理
 * @author: Max Wu
 * @create: 2023-03-15 10:35
 **/
@Controller
@Api(tags = "UmsAdminController", description = "后台用户管理")
@RequestMapping("/admin")
public class UmsAdminController {
	@Autowired
	private UmsAdminService adminService;
	@Value("${jwt.tokenHeader}")
	private String tokenHeader;
	@Value("${jwt.tokenHead}")
	private String tokenHead;

	@ApiOperation(value = "用户注册")
	@RequestMapping(value = "/register" , method = RequestMethod.POST)
	@ResponseBody
	public CommonResult<UmsAdmin> register(@RequestBody UmsAdmin umsAdminParam , BindingResult result){
		UmsAdmin umsAdmin = adminService.register(umsAdminParam);
		if(umsAdmin == null) {
			CommonResult.failed();
		}
		return CommonResult.success(umsAdmin);
	}

	@ApiOperation(value = "登录以后返回token")
	@RequestMapping(value = "/login" , method = RequestMethod.POST)
	@ResponseBody
	public CommonResult login(@RequestBody UmsAdminLoginParam umsAdminLoginParam ,BindingResult result) {
		String token = adminService.login(umsAdminLoginParam.getUsername(), umsAdminLoginParam.getPassword());
		if(token == null) {
			return CommonResult.validateFailed("用户名或密码错误");
		}
		Map<String, String> tokenMap = new HashMap<>();
		tokenMap.put("token" , token);
		tokenMap.put("tokenHead",tokenHead);
		return CommonResult.success(tokenMap);
	}

    @ApiOperation("获取用户所有权限（包括+-权限）")
    @RequestMapping(value = "/permission/{adminId}", method = RequestMethod.GET)
	@ResponseBody
	public CommonResult<List<UmsPermission>> getPermissionList(@PathVariable Long adminId){
		List<UmsPermission> permissionList = adminService.getPermissionList(adminId);
		return CommonResult.success(permissionList);
	}

}
