package com.example.mymall.mbg.mapper;

import com.example.mymall.mbg.model.OmsOrderReturnReason;
import com.example.mymall.mbg.model.OmsOrderReturnReasonExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OmsOrderReturnReasonMapper {
	long countByExample(OmsOrderReturnReasonExample example);

	int deleteByExample(OmsOrderReturnReasonExample example);

	int deleteByPrimaryKey(Long id);

	int insert(OmsOrderReturnReason record);

	int insertSelective(OmsOrderReturnReason record);

	List<OmsOrderReturnReason> selectByExample(OmsOrderReturnReasonExample example);

	OmsOrderReturnReason selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") OmsOrderReturnReason record, @Param("example") OmsOrderReturnReasonExample example);

	int updateByExample(@Param("record") OmsOrderReturnReason record, @Param("example") OmsOrderReturnReasonExample example);

	int updateByPrimaryKeySelective(OmsOrderReturnReason record);

	int updateByPrimaryKey(OmsOrderReturnReason record);
}