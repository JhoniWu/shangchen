package com.example.mymall.dao;

import com.example.mymall.mbg.model.PmsMemberPrice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 会员价格管理自定义dao
 */
public interface PmsMemberPriceDao {
	/**
	 * 批量创建
	 */
	int insertList(@Param("list") List<PmsMemberPrice> memberPriceList);
}
