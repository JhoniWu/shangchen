package com.example.mymall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类
 */
@Configuration
@MapperScan("com.example.mymall.mbg.mapper")
public class MyBatisConfig {

}
