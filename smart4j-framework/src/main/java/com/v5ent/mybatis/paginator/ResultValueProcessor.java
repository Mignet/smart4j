package com.v5ent.mybatis.paginator;

public interface ResultValueProcessor<T> {
	
	public abstract Object process(T value);
}
