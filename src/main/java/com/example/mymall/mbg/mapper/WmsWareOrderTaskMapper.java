package com.example.mymall.mbg.mapper;

import com.example.mymall.mbg.model.WmsWareOrderTask;
import com.example.mymall.mbg.model.WmsWareOrderTaskExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WmsWareOrderTaskMapper {
	long countByExample(WmsWareOrderTaskExample example);

	int deleteByExample(WmsWareOrderTaskExample example);

	int deleteByPrimaryKey(Long id);

	int insert(WmsWareOrderTask record);

	int insertSelective(WmsWareOrderTask record);

	List<WmsWareOrderTask> selectByExample(WmsWareOrderTaskExample example);

	WmsWareOrderTask selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") WmsWareOrderTask record, @Param("example") WmsWareOrderTaskExample example);

	int updateByExample(@Param("record") WmsWareOrderTask record, @Param("example") WmsWareOrderTaskExample example);

	int updateByPrimaryKeySelective(WmsWareOrderTask record);

	int updateByPrimaryKey(WmsWareOrderTask record);
}