package com.example.mymall.mbg.mapper;

import com.example.mymall.mbg.model.SmsCoupon;
import com.example.mymall.mbg.model.SmsCouponExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SmsCouponMapper {
	long countByExample(SmsCouponExample example);

	int deleteByExample(SmsCouponExample example);

	int deleteByPrimaryKey(Long id);

	int insert(SmsCoupon record);

	int insertSelective(SmsCoupon record);

	List<SmsCoupon> selectByExample(SmsCouponExample example);

	SmsCoupon selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") SmsCoupon record, @Param("example") SmsCouponExample example);

	int updateByExample(@Param("record") SmsCoupon record, @Param("example") SmsCouponExample example);

	int updateByPrimaryKeySelective(SmsCoupon record);

	int updateByPrimaryKey(SmsCoupon record);
}