package com.v5ent.core.base.api;
/**
 * 
 * @描述：分页数据包装
 *
 * @author Bob
 * @时间  2015年8月20日下午1:45:06
 *
 */
public interface PaginatorDecoration<T> {
	
	public abstract T doInvoke(Object item);
}
