package com.example.mymall.mbg.mapper;

import com.example.mymall.mbg.model.SmsSeckillSkuNotice;
import com.example.mymall.mbg.model.SmsSeckillSkuNoticeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SmsSeckillSkuNoticeMapper {
	long countByExample(SmsSeckillSkuNoticeExample example);

	int deleteByExample(SmsSeckillSkuNoticeExample example);

	int deleteByPrimaryKey(Long id);

	int insert(SmsSeckillSkuNotice record);

	int insertSelective(SmsSeckillSkuNotice record);

	List<SmsSeckillSkuNotice> selectByExample(SmsSeckillSkuNoticeExample example);

	SmsSeckillSkuNotice selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") SmsSeckillSkuNotice record, @Param("example") SmsSeckillSkuNoticeExample example);

	int updateByExample(@Param("record") SmsSeckillSkuNotice record, @Param("example") SmsSeckillSkuNoticeExample example);

	int updateByPrimaryKeySelective(SmsSeckillSkuNotice record);

	int updateByPrimaryKey(SmsSeckillSkuNotice record);
}