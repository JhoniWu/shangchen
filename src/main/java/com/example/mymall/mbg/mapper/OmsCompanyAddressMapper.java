package com.example.mymall.mbg.mapper;

import com.example.mymall.mbg.model.OmsCompanyAddress;
import com.example.mymall.mbg.model.OmsCompanyAddressExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OmsCompanyAddressMapper {
	long countByExample(OmsCompanyAddressExample example);

	int deleteByExample(OmsCompanyAddressExample example);

	int deleteByPrimaryKey(Long id);

	int insert(OmsCompanyAddress record);

	int insertSelective(OmsCompanyAddress record);

	List<OmsCompanyAddress> selectByExample(OmsCompanyAddressExample example);

	OmsCompanyAddress selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") OmsCompanyAddress record, @Param("example") OmsCompanyAddressExample example);

	int updateByExample(@Param("record") OmsCompanyAddress record, @Param("example") OmsCompanyAddressExample example);

	int updateByPrimaryKeySelective(OmsCompanyAddress record);

	int updateByPrimaryKey(OmsCompanyAddress record);
}