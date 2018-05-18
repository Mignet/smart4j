package com.v5ent.xoss.util;

public class ErrorCode {
	private int code; //错误码
	private String desc; //描述
	public ErrorCode(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}
	
	public int getCode() {
		return code;
	}
	public String getDesc() {
		return desc;
	}
	public static final ErrorCode OP_SUCCESS = new ErrorCode(0, "成功");
	public static final ErrorCode SYSTEM_ERROR = new ErrorCode(99, "系统异常");
}