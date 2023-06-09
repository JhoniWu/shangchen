package com.example.mymall.controller.ware;

import com.example.mymall.common.CommonResult;
import com.example.mymall.mbg.mapper.WmsWareOrderTaskMapper;
import com.example.mymall.mbg.model.WmsWareOrderTask;
import com.example.mymall.service.Wms.WareOrderTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @program: MyMall
 * @description:
 * @author: Max Wu
 * @create: 2023-06-09 17:42
 **/
public class WareOrderTaskController {
	@Autowired
	private WareOrderTaskService wareOrderTaskService;

	@Autowired
	private WmsWareOrderTaskMapper mapper;

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	//@RequiresPermissions("ware:wareordertaskdetail:list")
	public CommonResult list(@RequestParam("pageSize") Integer pageSize, @RequestParam("pageNum") Integer pageNum) {
		List<WmsWareOrderTask> wmsWareOrderTask = wareOrderTaskService.queryPage(pageSize, pageNum);
		return CommonResult.success(wmsWareOrderTask);
	}


	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	//@RequiresPermissions("ware:wareordertaskdetail:info")
	public CommonResult info(@PathVariable("id") Long id) {
		WmsWareOrderTask wareOrderTask = mapper.selectByPrimaryKey(id);

		return CommonResult.success(wareOrderTask);
	}

	/**
	 * 保存
	 */
	@RequestMapping("/save")
	//@RequiresPermissions("ware:wareordertaskdetail:save")
	public CommonResult save(@RequestBody WmsWareOrderTask wareOrderTask) {
		mapper.insert(wareOrderTask);

		return CommonResult.success("");
	}

	/**
	 * 修改
	 */
	@RequestMapping("/update")
	//@RequiresPermissions("ware:wareordertaskdetail:update")
	public CommonResult update(@RequestBody WmsWareOrderTask wareOrderTask) {
		mapper.updateByPrimaryKeySelective(wareOrderTask);

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
