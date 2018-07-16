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
 * @创建时间：2018年05月24日 13:38:43
 * 
 * Copyright (c) 深圳米格云链网络科技有限公司-版权所有
 */
public class Banner implements Serializable {
	
	private static final long serialVersionUID = 6766043149403358822L;
	
    /**
     *自增id
     */
	private Integer id;
	
    /**
     *名称
     */
	private String name;
	
    /**
     *图片地址
     */
	private String pic;
	
    /**
     *链接
     */
	private String link;
	
    /**
     *排序
     */
	private Integer sort;
	
    /**
     *状态0：1正常
     */
	private Integer status;
	


	public void setId(Integer id){
		this.id = id;
	}
	
	public Integer getId(){
		return id;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setPic(String pic){
		this.pic = pic;
	}
	
	public String getPic(){
		return pic;
	}
	
	public void setLink(String link){
		this.link = link;
	}
	
	public String getLink(){
		return link;
	}
	
	public void setSort(Integer sort){
		this.sort = sort;
	}
	
	public Integer getSort(){
		return sort;
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

