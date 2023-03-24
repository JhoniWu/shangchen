package com.example.mymall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类
 */
@Configuration
@MapperScan(basePackages = {"com.example.mymall.mbg.mapper","com.example.mymall.dao"})
public class MyBatisConfig {
}
