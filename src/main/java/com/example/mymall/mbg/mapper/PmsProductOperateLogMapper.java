package com.example.mymall.mbg.mapper;

import com.example.mymall.mbg.model.PmsProductOperateLog;
import com.example.mymall.mbg.model.PmsProductOperateLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PmsProductOperateLogMapper {
	long countByExample(PmsProductOperateLogExample example);

	int deleteByExample(PmsProductOperateLogExample example);

	int deleteByPrimaryKey(Long id);

	int insert(PmsProductOperateLog record);

	int insertSelective(PmsProductOperateLog record);

	List<PmsProductOperateLog> selectByExample(PmsProductOperateLogExample example);

	PmsProductOperateLog selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") PmsProductOperateLog record, @Param("example") PmsProductOperateLogExample example);

	int updateByExample(@Param("record") PmsProductOperateLog record, @Param("example") PmsProductOperateLogExample example);

	int updateByPrimaryKeySelective(PmsProductOperateLog record);

	int updateByPrimaryKey(PmsProductOperateLog record);
}