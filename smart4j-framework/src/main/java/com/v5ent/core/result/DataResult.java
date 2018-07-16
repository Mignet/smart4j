package com.v5ent.core.result;


/***
 * 带数据的返回结果
 * @author Mignet
 * @param <T>
 */
public class DataResult<T> extends Result {

	private static final long serialVersionUID = 4633474224384690560L;
	/**
     * 数据
     */
    private T data;


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 返回数据和消息
     *
     * @param data
     * @param message
     */
    public DataResult(T data,boolean success,String message) {
    	super(true,message);
        this.data = data;
    }
    /**
     * 返回消息
     *
     * @param data
     * @param message
     */
    public DataResult(boolean success, String message) {
    	super(success,message);
    }

    /**
     * 成功返回数据
     *
     * @param data
     */
    public DataResult(T data) {
    	super(true,"");
        this.data = data;
    }
}