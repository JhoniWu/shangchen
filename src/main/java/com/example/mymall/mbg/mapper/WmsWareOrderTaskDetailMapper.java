package com.example.mymall.mbg.mapper;

import com.example.mymall.mbg.model.WmsWareOrderTaskDetail;
import com.example.mymall.mbg.model.WmsWareOrderTaskDetailExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WmsWareOrderTaskDetailMapper {
	long countByExample(WmsWareOrderTaskDetailExample example);

	int deleteByExample(WmsWareOrderTaskDetailExample example);

	int deleteByPrimaryKey(Long id);

	int insert(WmsWareOrderTaskDetail record);

	int insertSelective(WmsWareOrderTaskDetail record);

	List<WmsWareOrderTaskDetail> selectByExample(WmsWareOrderTaskDetailExample example);

	WmsWareOrderTaskDetail selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") WmsWareOrderTaskDetail record, @Param("example") WmsWareOrderTaskDetailExample example);

	int updateByExample(@Param("record") WmsWareOrderTaskDetail record, @Param("example") WmsWareOrderTaskDetailExample example);

	int updateByPrimaryKeySelective(WmsWareOrderTaskDetail record);

	int updateByPrimaryKey(WmsWareOrderTaskDetail record);
}