package com.example.mymall.mbg.mapper;

import com.example.mymall.mbg.model.SmsSeckillSession;
import com.example.mymall.mbg.model.SmsSeckillSessionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SmsSeckillSessionMapper {
	long countByExample(SmsSeckillSessionExample example);

	int deleteByExample(SmsSeckillSessionExample example);

	int deleteByPrimaryKey(Long id);

	int insert(SmsSeckillSession record);

	int insertSelective(SmsSeckillSession record);

	List<SmsSeckillSession> selectByExample(SmsSeckillSessionExample example);

	SmsSeckillSession selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") SmsSeckillSession record, @Param("example") SmsSeckillSessionExample example);

	int updateByExample(@Param("record") SmsSeckillSession record, @Param("example") SmsSeckillSessionExample example);

	int updateByPrimaryKeySelective(SmsSeckillSession record);

	int updateByPrimaryKey(SmsSeckillSession record);
}