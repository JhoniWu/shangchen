package com.example.mymall.controller.Wms;

import com.example.mymall.common.CommonResult;
import com.example.mymall.dto.Wms.MergeVo;
import com.example.mymall.dto.Wms.PurchaseDoneVo;
import com.example.mymall.mbg.mapper.WmsPurchaseMapper;
import com.example.mymall.mbg.model.WmsPurchase;
import com.example.mymall.service.Wms.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @program: MyMall
 * @description:
 * @author: Max Wu
 * @create: 2023-06-09 17:42
 **/
@RequestMapping("/ware/purchase")
@RestController
public class PurchaseController {
	@Autowired
	private PurchaseService purchaseService;
	@Autowired
	private WmsPurchaseMapper mapper;

	///ware/purchase/done
	@PostMapping("/done")
	public CommonResult finish(@RequestBody PurchaseDoneVo doneVo) {

		purchaseService.done(doneVo);

		return CommonResult.success("");
	}

	/**
	 * 领取采购单
	 * 采购员领取采购单列表，改变采购单的状态，
	 *
	 * @return
	 */
	@PostMapping("/received")
	public CommonResult received(@RequestBody List<Long> ids) {

		purchaseService.received(ids);

		return CommonResult.success("");
	}

	///ware/purchase/unreceive/list
	///ware/purchase/merge
	@PostMapping("/merge")
	public CommonResult merge(@RequestBody MergeVo mergeVo) {

		purchaseService.mergePurchase(mergeVo);
		return CommonResult.success("");
	}

	@RequestMapping("/unreceive/list")
	//@RequiresPermissions("ware:purchase:list")
	public CommonResult unreceivelist(@RequestBody WmsPurchase purchase, @RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize) {
		List<WmsPurchase> list = purchaseService.queryPageUnreceivePurchase(purchase, pageSize, pageNum);

		return CommonResult.success("");
	}

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	//@RequiresPermissions("ware:purchase:list")
	public CommonResult list(@RequestBody WmsPurchase purchase, @RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize) {
		List<WmsPurchase> list = purchaseService.queryPage(purchase, pageSize, pageNum);

		return CommonResult.success(list);
	}


	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	//@RequiresPermissions("ware:purchase:info")
	public CommonResult info(@PathVariable("id") Long id) {
		WmsPurchase purchase = mapper.selectByPrimaryKey(id);

		return CommonResult.success(purchase);
	}

	/**
	 * 保存
	 */
	@RequestMapping("/save")
	//@RequiresPermissions("ware:purchase:save")
	public CommonResult save(@RequestBody WmsPurchase purchase) {
		purchase.setUpdateTime(new Date());
		purchase.setCreateTime(new Date());
		mapper.insert(purchase);

		return CommonResult.success("");
	}

	/**
	 * 修改
	 */
	@RequestMapping("/update")
	//@RequiresPermissions("ware:purchase:update")
	public CommonResult update(@RequestBody WmsPurchase purchase) {
		mapper.updateByPrimaryKey(purchase);

		return CommonResult.success("");
	}

	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	//@RequiresPermissions("ware:purchase:delete")
	public CommonResult delete(@RequestBody Long[] ids) {
		for (Long id : ids) {
			mapper.deleteByPrimaryKey(id);
		}

		return CommonResult.success("");
	}
}
