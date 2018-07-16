package com.v5ent.web.model;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.v5ent.web.enums.RcTypeEnum;
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
public class Platform implements Serializable {
	
	private static final long serialVersionUID = 8897076253001981891L;
	
    /**
     *自增主键
     */
	private Long id;
	
    /**
     *平台名称
     */
	private String name;
	
    /**
     *平台logo
     */
	private String logo;
	
    /**
     *首投还是复投1首投2复投3都可以
     */
	private Integer aors;
	
    /**
     *标签id，逗号分隔
     */
	private String tags;
	
    /**
     *风控信息-类型:ABCDE进取型
     */
	private String rcType;
	
    /**
     *风控信息-等级CCCBBA
     */
	private String rcLevel;
	
    /**
     *融资背景
     */
	private String bgRz;
	
    /**
     *平台背景
     */
	private String bgPt;
	
    /**
     *银行存管
     */
	private String bank;
	
    /**
     *ICP
     */
	private String icp;
	
    /**
     *提现速度
     */
	private String txSpeed;
	
    /**
     *所属公司
     */
	private String cname;
	
    /**
     *注册资本
     */
	private String zczb;
	
    /**
     *上线时间
     */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")   
	private Date onlinetime;
	
    /**
     *平台介绍
     */
	private String memo;
	
    /**
     *神盾风控地址
     */
	private String url;
	
	/**
	 * 注册地址
	 */
	private String link;
	
    /**
     *详细说明
     */
	private String detail;
	
    /**
     *最小投资天数
     */
	private Integer dmin;
	
    /**
     *最大投资天数
     */
	private Integer dmax;
	
	private String mount;
	private String maxIncome;
	private String maxYearrate;
	private Integer maxInvestors;
	
    /**
     *推荐
     */
	private Integer tui;
	
    /**
     *状态：0审核，1上线，2，暂停
     */
	private Integer status;
	
    /**
     *是否要求截图
     */
	private Integer requiredImage;
	
    /**
     *是否要求用户名
     */
	private Integer requiredName;
	


	public void setId(Long id){
		this.id = id;
	}
	
	public Long getId(){
		return id;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setLogo(String logo){
		this.logo = logo;
	}
	
	public String getLogo(){
		return logo;
	}
	
	public void setAors(Integer aors){
		this.aors = aors;
	}
	
	public Integer getAors(){
		return aors;
	}
	
	public void setTags(String tags){
		this.tags = tags;
	}
	
	public String getTags(){
		return tags;
	}
	
	public void setRcType(String rcType){
		this.rcType = rcType;
	}
	
	public String getRcType(){
		return rcType;
	}
	
	public String getRcTypeMsg(){
		return RcTypeEnum.valueOf(rcType).getMessage();
	}
	
	public void setRcLevel(String rcLevel){
		this.rcLevel = rcLevel;
	}
	
	public String getRcLevel(){
		return rcLevel;
	}
	
	public void setBgRz(String bgRz){
		this.bgRz = bgRz;
	}
	
	public String getBgRz(){
		return bgRz;
	}
	
	public void setBgPt(String bgPt){
		this.bgPt = bgPt;
	}
	
	public String getBgPt(){
		return bgPt;
	}
	
	public void setBank(String bank){
		this.bank = bank;
	}
	
	public String getBank(){
		return bank;
	}
	
	public void setIcp(String icp){
		this.icp = icp;
	}
	
	public String getIcp(){
		return icp;
	}
	
	public void setTxSpeed(String txSpeed){
		this.txSpeed = txSpeed;
	}
	
	public String getTxSpeed(){
		return txSpeed;
	}
	
	public void setCname(String cname){
		this.cname = cname;
	}
	
	public String getCname(){
		return cname;
	}
	
	public void setZczb(String zczb){
		this.zczb = zczb;
	}
	
	public String getZczb(){
		return zczb;
	}
	
	public void setOnlinetime(Date onlinetime){
		this.onlinetime = onlinetime;
	}
	
	public Date getOnlinetime(){
		return onlinetime;
	}
	
	public void setMemo(String memo){
		this.memo = memo;
	}
	
	public String getMemo(){
		return memo;
	}
	
	public void setUrl(String url){
		this.url = url;
	}
	
	public String getUrl(){
		return url;
	}
	
	public void setLink(String link){
		this.link = link;
	}
	
	public String getLink(){
		return link;
	}
	
	public void setDetail(String detail){
		this.detail = detail;
	}
	
	public String getDetail(){
		return detail;
	}
	
	public void setDmin(Integer dmin){
		this.dmin = dmin;
	}
	
	public Integer getDmin(){
		return dmin;
	}
	
	public void setDmax(Integer dmax){
		this.dmax = dmax;
	}
	
	public Integer getDmax(){
		return dmax;
	}
	
	public void setTui(Integer tui){
		this.tui = tui;
	}
	
	public Integer getTui(){
		return tui;
	}
	
	public void setStatus(Integer status){
		this.status = status;
	}
	
	public Integer getStatus(){
		return status;
	}
	
	public void setRequiredImage(Integer requiredImage){
		this.requiredImage = requiredImage;
	}
	
	public Integer getRequiredImage(){
		return requiredImage;
	}
	
	public void setRequiredName(Integer requiredName){
		this.requiredName = requiredName;
	}
	
	public Integer getRequiredName(){
		return requiredName;
	}
	

	@Override
	public String toString() {
		return JSON.toJSONString(this, SerializerFeature.UseISO8601DateFormat);
	}

	public String getMaxIncome() {
		return maxIncome;
	}

	public void setMaxIncome(String maxIncome) {
		this.maxIncome = maxIncome;
	}

	public String getMaxYearrate() {
		return maxYearrate;
	}

	public void setMaxYearrate(String maxYearrate) {
		this.maxYearrate = maxYearrate;
	}

	public Integer getMaxInvestors() {
		return maxInvestors;
	}

	public void setMaxInvestors(Integer maxInvestors) {
		this.maxInvestors = maxInvestors;
	}

	public String getMount() {
		return mount;
	}

	public void setMount(String mount) {
		this.mount = mount;
	}
}

