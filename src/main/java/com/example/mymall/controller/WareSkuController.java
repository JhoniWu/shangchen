package com.example.mymall.controller;

import com.example.mymall.common.CommonResult;
import com.example.mymall.mbg.model.WmsWareSku;
import com.example.mymall.service.Wms.WareSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @program: MyMall
 * @description:
 * @author: Max Wu
 * @create: 2023-06-09 17:43
 **/
@RestController
@RequestMapping("/ware/waresku")
public class WareSkuController {
	@Autowired
	private WareSkuService wareSkuService;

	@RequestMapping("/list")
	public CommonResult<List<WmsWareSku>> list(@RequestBody WmsWareSku sku, @RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize) {
		List<WmsWareSku> list = wareSkuService.queryPage(pageSize, pageNum);
		return CommonResult.success(list);
	}

	@RequestMapping("/info/{id}")
	public CommonResult info(@PathVariable("id") Long id) {
		WmsWareSku sku = wareSkuService.getById(id);
		return CommonResult.success(sku);
	}

	/**
	 * 保存
	 */
	@RequestMapping("/save")
	//@RequiresPermissions("ware:waresku:save")
	public CommonResult save(@RequestBody WmsWareSku wareSku) {
		wareSkuService.save(wareSku);

		return CommonResult.success("成功");
	}

	/**
	 * 修改
	 */
	@RequestMapping("/update")
	//@RequiresPermissions("ware:waresku:update")
	public CommonResult update(@RequestBody WmsWareSku wareSku) {
		wareSkuService.updateById(wareSku);

		return CommonResult.success("");
	}

	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	//@RequiresPermissions("ware:waresku:delete")
	public CommonResult delete(@RequestBody Long[] ids) {
		wareSkuService.removeByIds(Arrays.asList(ids));

		return CommonResult.success("");
	}
}
