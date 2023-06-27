package com.example.mymall.common;

/**
 * @program: MyMall
 * @description:
 * @author: Max Wu
 * @create: 2023-06-27 17:05
 **/
public class ApiException extends RuntimeException {
	private IErrorCode errorCode;

	public ApiException(IErrorCode errorCode) {
		super(errorCode.getMessage());
		this.errorCode = errorCode;
	}

	public ApiException(String message) {
		super(message);
	}

	public ApiException(Throwable cause) {
		super(cause);
	}

	public ApiException(String message, Throwable cause) {
		super(message, cause);
	}

	public IErrorCode getErrorCode() {
		return errorCode;
	}
}
