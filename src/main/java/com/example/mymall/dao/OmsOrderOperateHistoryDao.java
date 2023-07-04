package com.example.mymall.dao;

import com.example.mymall.mbg.model.OmsOrderOperateHistory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: MyMall
 * @description: 订单操作记录自定义Dao
 * @author: Max Wu
 * @create: 2023-07-03 15:30
 **/
public interface OmsOrderOperateHistoryDao {
	/**
	 * 批量创建
	 */
	int insertList(@Param("list") List<OmsOrderOperateHistory> orderOperateHistoryList);
}
