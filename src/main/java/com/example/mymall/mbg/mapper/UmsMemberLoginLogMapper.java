package com.example.mymall.mbg.mapper;

import com.example.mymall.mbg.model.UmsMemberLoginLog;
import com.example.mymall.mbg.model.UmsMemberLoginLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UmsMemberLoginLogMapper {
	long countByExample(UmsMemberLoginLogExample example);

	int deleteByExample(UmsMemberLoginLogExample example);

	int deleteByPrimaryKey(Long id);

	int insert(UmsMemberLoginLog record);

	int insertSelective(UmsMemberLoginLog record);

	List<UmsMemberLoginLog> selectByExample(UmsMemberLoginLogExample example);

	UmsMemberLoginLog selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") UmsMemberLoginLog record, @Param("example") UmsMemberLoginLogExample example);

	int updateByExample(@Param("record") UmsMemberLoginLog record, @Param("example") UmsMemberLoginLogExample example);

	int updateByPrimaryKeySelective(UmsMemberLoginLog record);

	int updateByPrimaryKey(UmsMemberLoginLog record);
}