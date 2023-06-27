package com.example.mymall.common.utils;

import com.example.mymall.common.ApiException;
import com.example.mymall.common.IErrorCode;

/**
 * @program: MyMall
 * @description:
 * @author: Max Wu
 * @create: 2023-06-27 17:06
 **/
public class Asserts {
	public static void fail(String message) {
		throw new ApiException(message);
	}

	public static void fail(IErrorCode errorCode) {
		throw new ApiException(errorCode);
	}
}
