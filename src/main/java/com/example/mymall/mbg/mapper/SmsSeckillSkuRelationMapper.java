package com.example.mymall.mbg.mapper;

import com.example.mymall.mbg.model.SmsSeckillSkuRelation;
import com.example.mymall.mbg.model.SmsSeckillSkuRelationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SmsSeckillSkuRelationMapper {
	long countByExample(SmsSeckillSkuRelationExample example);

	int deleteByExample(SmsSeckillSkuRelationExample example);

	int deleteByPrimaryKey(Long id);

	int insert(SmsSeckillSkuRelation record);

	int insertSelective(SmsSeckillSkuRelation record);

	List<SmsSeckillSkuRelation> selectByExample(SmsSeckillSkuRelationExample example);

	SmsSeckillSkuRelation selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") SmsSeckillSkuRelation record, @Param("example") SmsSeckillSkuRelationExample example);

	int updateByExample(@Param("record") SmsSeckillSkuRelation record, @Param("example") SmsSeckillSkuRelationExample example);

	int updateByPrimaryKeySelective(SmsSeckillSkuRelation record);

	int updateByPrimaryKey(SmsSeckillSkuRelation record);
}