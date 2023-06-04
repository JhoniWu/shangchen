package com.example.mymall.mbg.mapper;

import com.example.mymall.mbg.model.WmsWareInfo;
import com.example.mymall.mbg.model.WmsWareInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WmsWareInfoMapper {
	long countByExample(WmsWareInfoExample example);

	int deleteByExample(WmsWareInfoExample example);

	int deleteByPrimaryKey(Long id);

	int insert(WmsWareInfo record);

	int insertSelective(WmsWareInfo record);

	List<WmsWareInfo> selectByExample(WmsWareInfoExample example);

	WmsWareInfo selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") WmsWareInfo record, @Param("example") WmsWareInfoExample example);

	int updateByExample(@Param("record") WmsWareInfo record, @Param("example") WmsWareInfoExample example);

	int updateByPrimaryKeySelective(WmsWareInfo record);

	int updateByPrimaryKey(WmsWareInfo record);
}