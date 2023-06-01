package com.example.mymall.dao;

import com.example.mymall.dto.SmsCouponParam;
import org.apache.ibatis.annotations.Param;

/**
 * @program: MyMall
 * @description:
 * @author: Max Wu
 * @create: 2023-06-01 16:26
 **/
public interface SmsCouponDao {
	SmsCouponParam getItem(@Param("id") Long id);
}
