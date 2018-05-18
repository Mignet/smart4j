package com.v5ent.web.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.v5ent.core.datatable.DataTable;
import com.v5ent.core.generic.GenericDao;
import com.v5ent.web.model.SysConfig;

 /**
 * 
 * @描述： Dao接口
 * 
 * @创建人： Mignet
 * 
 * @创建时间：2016年07月08日 16:50:33
 * 
 * Copyright (c) 深圳米格网络科技有限公司-版权所有
 */
public interface SysConfigMapper extends GenericDao<SysConfig,Long>{
	
	 /**
     * 封装DataTable对象查询
     * @param dt
     * @param page
     * @return
     */
	List<SysConfig> selectBySearchInfo(@Param("dt")DataTable dt,RowBounds page);
	List<SysConfig> selectByName(SysConfig sysConfig);
	
	/**
	 * 根据key更新
	 * @param sysConfig
	 */
	void updateSysConfigByKey(SysConfig sysConfig);

}
