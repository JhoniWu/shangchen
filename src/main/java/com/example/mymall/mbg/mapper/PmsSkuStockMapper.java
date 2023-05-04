package com.example.mymall.mbg.mapper;

import com.example.mymall.mbg.model.PmsSkuStock;
import com.example.mymall.mbg.model.PmsSkuStockExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PmsSkuStockMapper {
	long countByExample(PmsSkuStockExample example);

	int deleteByExample(PmsSkuStockExample example);

	int deleteByPrimaryKey(Long id);

	int insert(PmsSkuStock record);

	int insertSelective(PmsSkuStock record);

	List<PmsSkuStock> selectByExample(PmsSkuStockExample example);

	PmsSkuStock selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") PmsSkuStock record, @Param("example") PmsSkuStockExample example);

	int updateByExample(@Param("record") PmsSkuStock record, @Param("example") PmsSkuStockExample example);

	int updateByPrimaryKeySelective(PmsSkuStock record);

	int updateByPrimaryKey(PmsSkuStock record);
}