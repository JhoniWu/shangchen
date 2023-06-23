package com.example.mymall.controller.ware;

import com.example.mymall.common.CommonResult;
import com.example.mymall.mbg.mapper.WmsPurchaseDetailMapper;
import com.example.mymall.mbg.model.WmsPurchaseDetail;
import com.example.mymall.service.Wms.PurchaseDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: MyMall
 * @description:
 * @author: Max Wu
 * @create: 2023-06-09 17:42
 **/
@RestController
@RequestMapping("/ware/purchasedetail")
public class PurchaseDetailController {
	@Autowired
	private PurchaseDetailService purchaseDetailService;

	@Autowired
	private WmsPurchaseDetailMapper mapper;

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	//@RequiresPermissions("ware:wareordertaskdetail:list")
	public CommonResult list(@RequestBody WmsPurchaseDetail detail, @RequestParam("pageSize") Integer pageSize, @RequestParam("pageNum") Integer pageNum) {
		List<WmsPurchaseDetail> wmsPurchaseDetail = purchaseDetailService.queryPage(detail, pageSize, pageNum);
		return CommonResult.success(wmsPurchaseDetail);
	}


	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	//@RequiresPermissions("ware:wareordertaskdetail:info")
	public CommonResult info(@PathVariable("id") Long id) {
		WmsPurchaseDetail de = mapper.selectByPrimaryKey(id);

		return CommonResult.success(de);
	}

	/**
	 * 保存
	 */
	@RequestMapping("/save")
	//@RequiresPermissions("ware:wareordertaskdetail:save")
	public CommonResult save(@RequestBody WmsPurchaseDetail detail) {
		mapper.insert(detail);

		return CommonResult.success("");
	}

	/**
	 * 修改
	 */
	@RequestMapping("/update")
	//@RequiresPermissions("ware:wareordertaskdetail:update")
	public CommonResult update(@RequestBody WmsPurchaseDetail detail) {
		mapper.updateByPrimaryKeySelective(detail);

		return CommonResult.success("");
	}

	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	//@RequiresPermissions("ware:wareordertaskdetail:delete")
	public CommonResult delete(@RequestBody Long[] ids) {
		for (Long o : ids) {
			mapper.deleteByPrimaryKey(o);
		}
		return CommonResult.success("");
	}
}
