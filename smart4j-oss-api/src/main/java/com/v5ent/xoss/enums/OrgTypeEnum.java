package com.v5ent.xoss.enums;

import com.v5ent.core.base.KeyValueEnum;

public enum OrgTypeEnum implements KeyValueEnum{
	
	APP(1,"app"),
	THIRD(2,"third");
	
	OrgTypeEnum(int key,String value){
		this.key = key;
		this.value = value;
	}
	
	private int key;
	private String value;
	
	public int getKey() {
		return key;
	}
	
	public String getValue() {
		return value;
	}
}
