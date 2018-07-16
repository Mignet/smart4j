package com.v5ent.web.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.v5ent.core.datatable.DataTable;
import com.v5ent.core.generic.GenericDao;
import com.v5ent.web.model.Customer;

 /**
 * 
 * @描述： Dao接口
 * 
 * @创建人： Mignet
 * 
 * @创建时间：2018年05月19日 11:25:32
 * 
 * Copyright (c) 深圳米格云链网络科技有限公司-版权所有
 */
public interface CustomerMapper extends GenericDao<Customer,Long>{
	
	 /**
     * 封装DataTable对象查询
     * @param dt
     * @param page
     * @return
     */
	List<Customer> selectBySearchInfo(@Param("dt")DataTable dt,RowBounds page);
	
	List<Map<String,String>> selectTop10();
}
