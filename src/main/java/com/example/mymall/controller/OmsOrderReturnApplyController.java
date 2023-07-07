package com.example.mymall.controller;

import com.example.mymall.common.CommonPage;
import com.example.mymall.common.CommonResult;
import com.example.mymall.dto.OmsOrderReturnApplyResult;
import com.example.mymall.dto.OmsReturnApplyQueryParam;
import com.example.mymall.dto.OmsUpdateStatusParam;
import com.example.mymall.mbg.model.OmsOrderReturnApply;
import com.example.mymall.service.Oms.OmsOrderReturnApplyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: MyMall
 * @description: 订单退货申请管理Controller
 * @author: Max Wu
 * @create: 2023-07-04 16:30
 **/
@RestController
@Api(tags = "OmsOrderReturnApplyController", description = "订单退货申请")
@RequestMapping("/returnApply")
public class OmsOrderReturnApplyController {
	@Autowired
	private OmsOrderReturnApplyService returnApplyService;

	@ApiOperation("分页查询退货申请")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public CommonResult<CommonPage<OmsOrderReturnApply>> list(OmsReturnApplyQueryParam queryParam,
															  @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
															  @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
		List<OmsOrderReturnApply> returnApplyList = returnApplyService.list(queryParam, pageSize, pageNum);
		return CommonResult.success(CommonPage.restPage(returnApplyList));
	}

	@ApiOperation("批量删除退货申请")
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public CommonResult delete(@RequestParam("ids") List<Long> ids) {
		int count = returnApplyService.delete(ids);
		if (count > 0) {
			return CommonResult.success(count);
		}
		return CommonResult.failed();
	}

	@ApiOperation("获取退货申请详情")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public CommonResult getItem(@PathVariable Long id) {
		OmsOrderReturnApplyResult result = returnApplyService.getItem(id);
		return CommonResult.success(result);
	}

	@ApiOperation("修改退货申请状态")
	@RequestMapping(value = "/update/status/{id}", method = RequestMethod.POST)
	@ResponseBody
	public CommonResult updateStatus(@PathVariable Long id, @RequestBody OmsUpdateStatusParam statusParam) {
		int count = returnApplyService.updateStatus(id, statusParam);
		if (count > 0) {
			return CommonResult.success(count);
		}
		return CommonResult.failed();
	}
}
