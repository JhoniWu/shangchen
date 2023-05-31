package com.example.mymall.common.utils;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @program: MyMall
 * @description:
 * @author: Max Wu
 * @create: 2023-05-24 10:52
 **/
@Data
public class RedisData {
	private LocalDateTime expireTime;
	private Object data;
}
