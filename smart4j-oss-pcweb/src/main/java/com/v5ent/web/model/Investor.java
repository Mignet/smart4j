package com.v5ent.web.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
 import java.lang.Integer;
 import java.lang.String;
 /**
 * 
 * @描述： 实体Bean
 * 
 * @创建人： Mignet
 * 
 * @创建时间：2018年05月19日 11:25:32
 * 
 * Copyright (c) 深圳米格云链网络科技有限公司-版权所有
 */
public class Investor implements Serializable {
	
	private static final long serialVersionUID = 1562070179618871707L;
	
    /**
     *自增编号
     */
	private Integer id;
	
    /**
     *用户ID
     */
	private String userId;
	
    /**
     *投资人号码
     */
	private String investPhone;
	
    /**
     *投资人姓名
     */
	private String investName;
	


	public void setId(Integer id){
		this.id = id;
	}
	
	public Integer getId(){
		return id;
	}
	
	public void setUserId(String userId){
		this.userId = userId;
	}
	
	public String getUserId(){
		return userId;
	}
	
	public void setInvestPhone(String investPhone){
		this.investPhone = investPhone;
	}
	
	public String getInvestPhone(){
		return investPhone;
	}
	
	public void setInvestName(String investName){
		this.investName = investName;
	}
	
	public String getInvestName(){
		return investName;
	}
	

	@Override
	public String toString() {
		return JSON.toJSONString(this, SerializerFeature.UseISO8601DateFormat);
	}
}

