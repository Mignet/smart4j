package com.v5ent.web.enums;

public enum RcTypeEnum{
	A("A","保守型"),
	B("B","稳健型"),
	C("C","进取型"),
	D("D","激进型"),
	E("E","高返型");
	
	RcTypeEnum(String code,String message){
		this.code = code;
		this.message = message;
	}

	private String code;
	private String message;
	
	public String getCode() {
		return code;
	}
	public String getMessage() {
		return message;
	}
	
}
