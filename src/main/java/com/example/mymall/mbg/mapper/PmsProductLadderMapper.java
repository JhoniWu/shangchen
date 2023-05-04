package com.example.mymall.mbg.mapper;

import com.example.mymall.mbg.model.PmsProductLadder;
import com.example.mymall.mbg.model.PmsProductLadderExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PmsProductLadderMapper {
	long countByExample(PmsProductLadderExample example);

	int deleteByExample(PmsProductLadderExample example);

	int deleteByPrimaryKey(Long id);

	int insert(PmsProductLadder record);

	int insertSelective(PmsProductLadder record);

	List<PmsProductLadder> selectByExample(PmsProductLadderExample example);

	PmsProductLadder selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") PmsProductLadder record, @Param("example") PmsProductLadderExample example);

	int updateByExample(@Param("record") PmsProductLadder record, @Param("example") PmsProductLadderExample example);

	int updateByPrimaryKeySelective(PmsProductLadder record);

	int updateByPrimaryKey(PmsProductLadder record);
}