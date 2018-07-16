package com.v5ent.web.service;

import java.util.Date;
import java.util.List;

import com.v5ent.core.base.api.PaginatorResponse;
import com.v5ent.core.datatable.DataTable;
import com.v5ent.core.datatable.DataTableReturn;
import com.v5ent.core.generic.GenericService;
import com.v5ent.core.orm.paging.Page;
import com.v5ent.web.model.SysConfig;
 /**
 * 
 * @描述： 实体Bean
 * 
 * @创建人： Mignet
 * 
 * @创建时间：2016年07月08日 14:46:57
 * 
 * Copyright (c) 深圳米格网络科技有限公司-版权所有
 */
public interface SysConfigService extends GenericService<SysConfig,Long>{

	/**
	 * 查询SysConfig列表,为data-tables封装
	 * @param dataTable
	 * @return
	 */
	DataTableReturn selectByDatatables(DataTable dataTable);
	
	/**
	 * 查询所有的配置
	 * 
	 * @return
	 */
	public List<SysConfig> getSystemConfigs();

	public List<SysConfig> querySystemConfigsByConditon(String string);

	public String getValuesByKey(String key);

	public String getImageUrl(String imgpath);

	public String getValuesByKey(String key, Integer appType);
	
	public List<SysConfig> querySysConfigByName(String configName);
	public List<SysConfig> queryfuzzily(SysConfig condit);

	/**
	 * 根据key查配置信息
	 * @param confType
	 * @param confKey
	 * @param appType
	 * @return
	 */
	SysConfig querySysConfigByKey(String confType, String confKey, int appType);
	
	/**
	 * 查询value配置信息
	 * @param key
	 * @param appType
	 * @return
	 */
	public String getValuesByKey(String confType, String confKey, int appType);

	/**
	 * 更新configValue
	 * @param configKey
	 * @param configValue
	 * @param createTime
	 */
	void updateSysConfigByKey(String configKey, String configValue, Date createTime);
	
}
