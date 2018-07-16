package com.v5ent.web.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.v5ent.core.datatable.DataTable;
import com.v5ent.core.generic.GenericDao;
import com.v5ent.web.model.Banner;

 /**
 * 
 * @描述： Dao接口
 * 
 * @创建人： Mignet
 * 
 * @创建时间：2018年05月19日 14:43:55
 * 
 * Copyright (c) 深圳米格云链网络科技有限公司-版权所有
 */
public interface BannerMapper extends GenericDao<Banner,Long>{
	
	 /**
     * 封装DataTable对象查询
     * @param dt
     * @param page
     * @return
     */
	List<Banner> selectBySearchInfo(@Param("dt")DataTable dt,RowBounds page);
}
