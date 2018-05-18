package com.v5ent.mybatis.paginator.processor;

import java.text.DecimalFormat;

import com.v5ent.mybatis.paginator.ResultValueProcessor;

public class DefaultDecimalProcessor implements ResultValueProcessor<Object> {
	private  DecimalFormat df = null;
	
	public DefaultDecimalProcessor(){
		this("###,###.##");
	}
	
	public DefaultDecimalProcessor(String formate){
		df = new DecimalFormat(formate);
	}
	
	@Override
	public Object process(Object value) {
		return df.format(value);
	}

}
