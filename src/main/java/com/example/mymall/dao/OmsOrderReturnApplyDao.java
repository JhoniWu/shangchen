package com.example.mymall.dao;

/**
 * @program: MyMall
 * @description:
 * @author: Max Wu
 * @create: 2023-07-04 14:28
 **/

import com.example.mymall.dto.OmsOrderReturnApplyResult;
import com.example.mymall.dto.OmsReturnApplyQueryParam;
import com.example.mymall.mbg.model.OmsOrderReturnApply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单退货申请自定义Dao
 * Created by macro on 2018/10/18.
 */
public interface OmsOrderReturnApplyDao {
	/**
	 * 查询申请列表
	 */
	List<OmsOrderReturnApply> getList(@Param("queryParam") OmsReturnApplyQueryParam queryParam);

	/**
	 * 获取申请详情
	 */
	OmsOrderReturnApplyResult getDetail(@Param("id") Long id);
}
