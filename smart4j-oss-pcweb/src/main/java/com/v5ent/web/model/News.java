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
public class News implements Serializable {
	
	private static final long serialVersionUID = 4389740429366624435L;
	
    /**
     *自增id
     */
	private Integer id;
	
    /**
     *标题
     */
	private String title;
	
    /**
     *内容
     */
	private String content;
	
    /**
     *文章来源
     */
	private String tfrom;
	
    /**
     *创建时间
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")   
	private Date createTime;
	
    /**
     *状态
     */
	private Integer status;
	
    /**
     *类型 0:常见问答 1:官方公告 2:私信 3:网贷新闻 4.文章 5,关于 6.协议
     */
	private Integer type;
	
    /**
     *谁可以看，NUll表示公共
     */
	private String person;
	


	public void setId(Integer id){
		this.id = id;
	}
	
	public Integer getId(){
		return id;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public String getTitle(){
		return title;
	}
	
	public void setContent(String content){
		this.content = content;
	}
	
	public String getContent(){
		return content;
	}
	
	public void setTfrom(String tfrom){
		this.tfrom = tfrom;
	}
	
	public String getTfrom(){
		return tfrom;
	}
	
	public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}
	
	public Date getCreateTime(){
		return createTime;
	}
	
	public void setStatus(Integer status){
		this.status = status;
	}
	
	public Integer getStatus(){
		return status;
	}
	
	public void setType(Integer type){
		this.type = type;
	}
	
	public Integer getType(){
		return type;
	}
	
	public void setPerson(String person){
		this.person = person;
	}
	
	public String getPerson(){
		return person;
	}
	

	@Override
	public String toString() {
		return JSON.toJSONString(this, SerializerFeature.UseISO8601DateFormat);
	}
}

