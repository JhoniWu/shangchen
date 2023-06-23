package com.example.mymall.controller.ware;

import com.example.mymall.common.CommonResult;
import com.example.mymall.mbg.mapper.WmsWareInfoMapper;
import com.example.mymall.mbg.model.WmsWareInfo;
import com.example.mymall.service.Wms.WareInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: MyMall
 * @description:
 * @author: Max Wu
 * @create: 2023-06-09 17:42
 **/
@RequestMapping("/ware/info")
@RestController
public class WareInfoController {
	@Autowired
	private WareInfoService WareInfoService;

	@Autowired
	private WmsWareInfoMapper mapper;

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	//@RequiresPermissions("ware:wareordertaskdetail:list")
	public CommonResult list(@RequestParam("pageSize") Integer pageSize, @RequestParam("pageNum") Integer pageNum) {
		List<WmsWareInfo> wmsWareInfo = WareInfoService.queryPage(pageSize, pageNum);
		return CommonResult.success(wmsWareInfo);
	}


	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	//@RequiresPermissions("ware:wareordertaskdetail:info")
	public CommonResult info(@PathVariable("id") Long id) {
		WmsWareInfo wmsWareInfo = mapper.selectByPrimaryKey(id);

		return CommonResult.success(wmsWareInfo);
	}

	/**
	 * 保存
	 */
	@RequestMapping("/save")
	//@RequiresPermissions("ware:wareordertaskdetail:save")
	public CommonResult save(@RequestBody WmsWareInfo wareInfo) {
		mapper.insert(wareInfo);

		return CommonResult.success("");
	}

	/**
	 * 修改
	 */
	@RequestMapping("/update")
	//@RequiresPermissions("ware:wareordertaskdetail:update")
	public CommonResult update(@RequestBody WmsWareInfo wareInfo) {
		mapper.updateByPrimaryKeySelective(wareInfo);

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
