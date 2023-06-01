package com.example.mymall.mbg.mapper;

import com.example.mymall.mbg.model.SmsCouponHistory;
import com.example.mymall.mbg.model.SmsCouponHistoryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SmsCouponHistoryMapper {
	long countByExample(SmsCouponHistoryExample example);

	int deleteByExample(SmsCouponHistoryExample example);

	int deleteByPrimaryKey(Long id);

	int insert(SmsCouponHistory record);

	int insertSelective(SmsCouponHistory record);

	List<SmsCouponHistory> selectByExample(SmsCouponHistoryExample example);

	SmsCouponHistory selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") SmsCouponHistory record, @Param("example") SmsCouponHistoryExample example);

	int updateByExample(@Param("record") SmsCouponHistory record, @Param("example") SmsCouponHistoryExample example);

	int updateByPrimaryKeySelective(SmsCouponHistory record);

	int updateByPrimaryKey(SmsCouponHistory record);
}