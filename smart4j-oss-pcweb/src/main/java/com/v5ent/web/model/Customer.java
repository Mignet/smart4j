package com.v5ent.web.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
 import java.lang.Integer;
 import java.lang.String;
 import java.util.Date;

import org.apache.commons.lang.StringUtils;
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
public class Customer implements Serializable {
	
	private static final long serialVersionUID = 238210782897001483L;
	
    /**
     *自增编号
     */
	private Long id;
	
    /**
     *用户ID
     */
	private String userid;
	
    /**
     *手机号
     */
	private String mobile;
	
    /**
     *昵称
     */
	private String name;
	
    /**
     *银行卡
     */
	private String bankcard;
	
    /**
     *身份证
     */
	private String idcard;
	
    /**
     *预留手机号
     */
	private String phone;
	
    /**
     *支付宝账号
     */
	private String zfb;
	
    /**
     *QQ
     */
	private String qq;
	
    /**
     *邮箱
     */
	private String email;
	
    /**
     *登录密码
     */
	private String password;
	
    /**
     *总金额-账户余额
     */
	private Integer money;
	
	/**
	 * 投资总额
	 */
	private Integer total;
	
    /**
     *冻结金额
     */
	private Integer freeze;
	
    /**
     *注册时间
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")   
	private Date createTime;
	
    /**
     *状态 1正常
     */
	private Integer status;
	


	public void setId(Long id){
		this.id = id;
	}
	
	public Long getId(){
		return id;
	}
	
	public void setUserid(String userid){
		this.userid = userid;
	}
	
	public String getUserid(){
		return userid;
	}
	
	public void setMobile(String mobile){
		this.mobile = mobile;
	}
	
	public String getMobile(){
		return mobile;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setBankcard(String bankcard){
		this.bankcard = bankcard;
	}
	
	public String getBankcard(){
		return bankcard;
	}
	
	public void setIdcard(String idcard){
		this.idcard = idcard;
	}
	
	public String getIdcard(){
		return idcard;
	}
	
	public void setPhone(String phone){
		this.phone = phone;
	}
	
	public String getPhone(){
		return StringUtils.isBlank(phone)?null:phone.substring(0, 3)+"XXXX"+phone.substring(7,11);
	}
	
	public void setZfb(String zfb){
		this.zfb = zfb;
	}
	
	public String getZfb(){
		return zfb;
	}
	
	public void setQq(String qq){
		this.qq = qq;
	}
	
	public String getQq(){
		return qq;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setMoney(Integer money){
		this.money = money;
	}
	
	public Integer getMoney(){
		return money;
	}
	
	public void setFreeze(Integer freeze){
		this.freeze = freeze;
	}
	
	public Integer getFreeze(){
		return freeze;
	}
	
	public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}
	
	public Date getCreateTime(){
		return createTime;
	}
	
	public Integer getTotal() {
		return total;
	}
	
	public void setTotal(Integer total) {
		this.total = total;
	}

	public void setStatus(Integer status){
		this.status = status;
	}
	
	public Integer getStatus(){
		return status;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this, SerializerFeature.UseISO8601DateFormat);
	}
}

