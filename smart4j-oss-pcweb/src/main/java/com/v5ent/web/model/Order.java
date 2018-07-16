package com.v5ent.web.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
 import java.lang.Integer;
 import java.lang.String;
 import java.util.Date;
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
public class Order implements Serializable {
	
	private static final long serialVersionUID = 6373976360297088206L;
	
    /**
     *自增编号
     */
	private Integer id;
	
    /**
     *方案编号
     */
	private Long planId;
	
    /**
     *产品名称
     */
	private String name;
	
    /**
     *投资时间
     */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")   
	private Date investdate;
	
    /**
     *投资金额
     */
	private Integer amount;
	
    /**
     *提交用户
     */
	private String userId;
	
    /**
     *投资参与人
     */
	private Integer investId;
	
    /**
     *提交时间
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")   
	private Date createTime;
	
    /**
     *已支付
     */
	private Integer isPaid;
	
	public void setId(Integer id){
		this.id = id;
	}
	
	public Integer getId(){
		return id;
	}
	
	public void setPlanId(Long planId){
		this.planId = planId;
	}
	
	public Long getPlanId(){
		return planId;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setInvestdate(Date investdate){
		this.investdate = investdate;
	}
	
	public Date getInvestdate(){
		return investdate;
	}
	
	public void setAmount(Integer amount){
		this.amount = amount;
	}
	
	public Integer getAmount(){
		return amount;
	}
	
	public void setUserId(String userId){
		this.userId = userId;
	}
	
	public String getUserId(){
		return userId;
	}
	
	public void setInvestId(Integer investId){
		this.investId = investId;
	}
	
	public Integer getInvestId(){
		return investId;
	}
	
	public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}
	
	public Date getCreateTime(){
		return createTime;
	}
	
	public void setIsPaid(Integer isPaid){
		this.isPaid = isPaid;
	}
	
	public Integer getIsPaid(){
		return isPaid;
	}
	

	@Override
	public String toString() {
		return JSON.toJSONString(this, SerializerFeature.UseISO8601DateFormat);
	}

	public Plan getPlan() {
		return JSON.parseObject(name, Plan.class);
	}

	/*public void setPlan(Plan plan) {
		this.plan = plan;
	}*/
}

