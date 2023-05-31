package com.example.mymall.controller;

import com.example.mymall.common.CommonResult;
import com.example.mymall.mbg.mapper.PmsProductOperateLogMapper;
import com.example.mymall.mbg.mapper.PmsProductVertifyRecordMapper;
import com.example.mymall.mbg.model.PmsProductVertifyRecord;
import com.example.mymall.mbg.model.PmsProductVertifyRecordExample;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: MyMall
 * @description: 商品审核记录
 * @author: Max Wu
 * @create: 2023-05-31 09:22
 **/
@RestController
@RequestMapping("/check")
public class PmsProductVertifyRecordController {
	@Autowired
	private PmsProductVertifyRecordMapper pmsProductVertifyRecordMapper;
	@Autowired
	private PmsProductOperateLogMapper pmsProductOperateLogMapper;

	@ApiOperation("获取所有审核记录")
	@RequestMapping(value = "/get/vertify", method = RequestMethod.GET)
	public CommonResult getVertify() {
		return CommonResult.success(pmsProductVertifyRecordMapper.selectByExample(new PmsProductVertifyRecordExample()));
	}

	@ApiOperation("增加某条审核记录")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public CommonResult addRecord(@RequestBody PmsProductVertifyRecord pmsProductVertifyRecord) {
		return CommonResult.success(pmsProductVertifyRecordMapper.insert(pmsProductVertifyRecord));
	}

	@ApiOperation("修改某条审核记录")
	@RequestMapping(value = "/set/{id}", method = RequestMethod.POST)
	public CommonResult<PmsProductVertifyRecord> setStatus(@RequestParam("id") Long id, @RequestParam("status") Integer status) {
		PmsProductVertifyRecord record = pmsProductVertifyRecordMapper.selectByPrimaryKey(id);
		record.setStatus(status);
		return CommonResult.success(record);

	}

	@ApiOperation("删除某条审核记录")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public CommonResult delete(@RequestParam("id") Long id) {
		return CommonResult.success(pmsProductVertifyRecordMapper.deleteByPrimaryKey(id));
	}
}
