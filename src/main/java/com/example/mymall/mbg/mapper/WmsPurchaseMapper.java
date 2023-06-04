package com.example.mymall.mbg.mapper;

import com.example.mymall.mbg.model.WmsPurchase;
import com.example.mymall.mbg.model.WmsPurchaseExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WmsPurchaseMapper {
	long countByExample(WmsPurchaseExample example);

	int deleteByExample(WmsPurchaseExample example);

	int deleteByPrimaryKey(Long id);

	int insert(WmsPurchase record);

	int insertSelective(WmsPurchase record);

	List<WmsPurchase> selectByExample(WmsPurchaseExample example);

	WmsPurchase selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") WmsPurchase record, @Param("example") WmsPurchaseExample example);

	int updateByExample(@Param("record") WmsPurchase record, @Param("example") WmsPurchaseExample example);

	int updateByPrimaryKeySelective(WmsPurchase record);

	int updateByPrimaryKey(WmsPurchase record);
}