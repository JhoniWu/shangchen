package com.example.mymall.dao;

import com.example.mymall.mbg.model.PmsProductVertifyRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: MyMall
 * @description: 商品审核日志管理自定义Dao
 * @author: Max Wu
 * @create: 2023-05-03 17:13
 **/
public interface PmsProductVertifyRecordDao {
	/**
	 * 批量创建
	 */
	int insertList(@Param("list") List<PmsProductVertifyRecord> list);
}
