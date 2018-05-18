package com.v5ent.web.service;

import com.v5ent.core.datatable.DataTable;
import com.v5ent.core.datatable.DataTableReturn;
import com.v5ent.core.generic.GenericService;
import com.v5ent.web.model.SysThirdkeyConfig;
 /**
 * 
 * @描述： SysThirdkeyConfigService服务接口
 * 
 * @创建人： Mignet
 * 
 * @创建时间：2016年08月17日 11:16:29
 * 
 * Copyright (c) 深圳领会科技有限公司-版权所有
 */
public interface SysThirdkeyConfigService extends GenericService<SysThirdkeyConfig,Long>{

	/**
	 * 查询SysThirdkeyConfig列表,为data-tables封装
	 * @param dataTable
	 * @return
	 */
	DataTableReturn selectByDatatables(DataTable dataTable);
}
