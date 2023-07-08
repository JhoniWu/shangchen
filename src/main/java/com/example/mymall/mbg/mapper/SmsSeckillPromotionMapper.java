package com.example.mymall.mbg.mapper;

import com.example.mymall.mbg.model.SmsSeckillPromotion;
import com.example.mymall.mbg.model.SmsSeckillPromotionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SmsSeckillPromotionMapper {
	long countByExample(SmsSeckillPromotionExample example);

	int deleteByExample(SmsSeckillPromotionExample example);

	int deleteByPrimaryKey(Long id);

	int insert(SmsSeckillPromotion record);

	int insertSelective(SmsSeckillPromotion record);

	List<SmsSeckillPromotion> selectByExample(SmsSeckillPromotionExample example);

	SmsSeckillPromotion selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") SmsSeckillPromotion record, @Param("example") SmsSeckillPromotionExample example);

	int updateByExample(@Param("record") SmsSeckillPromotion record, @Param("example") SmsSeckillPromotionExample example);

	int updateByPrimaryKeySelective(SmsSeckillPromotion record);

	int updateByPrimaryKey(SmsSeckillPromotion record);
}