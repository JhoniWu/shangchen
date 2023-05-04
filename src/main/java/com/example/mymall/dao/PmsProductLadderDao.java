package com.example.mymall.dao;

import com.example.mymall.mbg.model.PmsProductLadder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: MyMall
 * @description: 会员接替价格自定义Dao
 * @author: Max Wu
 * @create: 2023-05-03 10:40
 **/
public interface PmsProductLadderDao {
	/**
	 * 批量创建
	 */
	int insertList(@Param("list") List<PmsProductLadder> productLadderList);
}
