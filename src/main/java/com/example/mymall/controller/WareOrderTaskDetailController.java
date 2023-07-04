package com.example.mymall.controller;

import com.example.mymall.common.CommonResult;
import com.example.mymall.mbg.mapper.WmsWareOrderTaskDetailMapper;
import com.example.mymall.mbg.model.WmsWareOrderTaskDetail;
import com.example.mymall.service.Wms.WareOrderTaskDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: MyMall
 * @description:
 * @author: Max Wu
 * @create: 2023-06-09 17:43
 **/
@RequestMapping("/ware/ordertaskdetail")
@RestController
public class WareOrderTaskDetailController {
	@Autowired
	private WareOrderTaskDetailService wareOrderTaskDetailService;

	@Autowired
	private WmsWareOrderTaskDetailMapper mapper;

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	//@RequiresPermissions("ware:wareordertaskdetail:list")
	public CommonResult list(@RequestParam("pageSize") Integer pageSize, @RequestParam("pageNum") Integer pageNum) {
		List<WmsWareOrderTaskDetail> wmsWareOrderTaskDetails = wareOrderTaskDetailService.queryPage(pageSize, pageNum);
		return CommonResult.success(wmsWareOrderTaskDetails);
	}


	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	//@RequiresPermissions("ware:wareordertaskdetail:info")
	public CommonResult info(@PathVariable("id") Long id) {
		WmsWareOrderTaskDetail wareOrderTaskDetail = mapper.selectByPrimaryKey(id);

		return CommonResult.success(wareOrderTaskDetail);
	}

	/**
	 * 保存
	 */
	@RequestMapping("/save")
	//@RequiresPermissions("ware:wareordertaskdetail:save")
	public CommonResult save(@RequestBody WmsWareOrderTaskDetail wareOrderTaskDetail) {
		mapper.insert(wareOrderTaskDetail);

		return CommonResult.success("");
	}

	/**
	 * 修改
	 */
	@RequestMapping("/update")
	//@RequiresPermissions("ware:wareordertaskdetail:update")
	public CommonResult update(@RequestBody WmsWareOrderTaskDetail wareOrderTaskDetail) {
		mapper.updateByPrimaryKeySelective(wareOrderTaskDetail);

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
