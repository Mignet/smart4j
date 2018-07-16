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
public class Plan implements Serializable {
	
	private static final long serialVersionUID = 3711965199176594964L;
	
    /**
     *
     */
	private Integer id;
	
    /**
     *平台id
     */
	private Long pid;
	
    /**
     *方案名称
     */
	private String name;
	
    /**
     *方案类型
     */
	private Integer type;
	
    /**
     *投资项目
     */
	private String product;
	
    /**
     *投资金额
     */
	private String mount;
	
    /**
     *投资上限
     */
	private String mountMax;
	
    /**
     *返利
     */
	private String fanli;
	
    /**
     *奖励
     */
	private String jiangli;
	
    /**
     *参考年化利率
     */
	private String yearate;
	
    /**
     *红包
     */
	private String hongbao;
	
    /**
     *体验金
     */
	private String tiyanjin;
	
    /**
     *其他
     */
	private String other;
	
    /**
     *周期
     */
	private String touzizhouqi;
	
    /**
     *总收益(参考)
     */
	private String shouyi;
	
    /**
     *综合年化(参考)
     */
	private String yearfee;
	
    /**
     *返利周期
     */
	private String fanlizhouqi;
	
    /**
     *状态
     */
	private Integer status;
	


	public void setId(Integer id){
		this.id = id;
	}
	
	public Integer getId(){
		return id;
	}
	
	public void setPid(Long pid){
		this.pid = pid;
	}
	
	public Long getPid(){
		return pid;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setType(Integer type){
		this.type = type;
	}
	
	public Integer getType(){
		return type;
	}
	
	public void setProduct(String product){
		this.product = product;
	}
	
	public String getProduct(){
		return product;
	}
	
	public void setMount(String mount){
		this.mount = mount;
	}
	
	public String getMount(){
		return mount;
	}
	
	public void setMountMax(String mountMax){
		this.mountMax = mountMax;
	}
	
	public String getMountMax(){
		return mountMax;
	}
	
	public void setFanli(String fanli){
		this.fanli = fanli;
	}
	
	public String getFanli(){
		return fanli;
	}
	
	public void setJiangli(String jiangli){
		this.jiangli = jiangli;
	}
	
	public String getJiangli(){
		return jiangli;
	}
	
	public void setYearate(String yearate){
		this.yearate = yearate;
	}
	
	public String getYearate(){
		return yearate;
	}
	
	public void setHongbao(String hongbao){
		this.hongbao = hongbao;
	}
	
	public String getHongbao(){
		return hongbao;
	}
	
	public void setTiyanjin(String tiyanjin){
		this.tiyanjin = tiyanjin;
	}
	
	public String getTiyanjin(){
		return tiyanjin;
	}
	
	public void setOther(String other){
		this.other = other;
	}
	
	public String getOther(){
		return other;
	}
	
	public void setTouzizhouqi(String touzizhouqi){
		this.touzizhouqi = touzizhouqi;
	}
	
	public String getTouzizhouqi(){
		return touzizhouqi;
	}
	
	public void setShouyi(String shouyi){
		this.shouyi = shouyi;
	}
	
	public String getShouyi(){
		return shouyi;
	}
	
	public void setYearfee(String yearfee){
		this.yearfee = yearfee;
	}
	
	public String getYearfee(){
		return yearfee;
	}
	
	public void setFanlizhouqi(String fanlizhouqi){
		this.fanlizhouqi = fanlizhouqi;
	}
	
	public String getFanlizhouqi(){
		return fanlizhouqi;
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

