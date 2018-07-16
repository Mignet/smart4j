package com.v5ent.web.service;

import com.v5ent.core.datatable.DataTable;
import com.v5ent.core.datatable.DataTableReturn;
import com.v5ent.core.generic.GenericService;
import com.v5ent.web.model.Tag;
import com.v5ent.web.service.TagService;
 /**
 * 
 * @描述： TagService服务接口
 * 
 * @创建人： Mignet
 * 
 * @创建时间：2018年05月19日 11:25:32
 * 
 * Copyright (c) 深圳米格云链网络科技有限公司-版权所有
 */
public interface TagService extends GenericService<Tag,Long>{

	/**
	 * 查询Tag列表,为data-tables封装
	 * @param dataTable
	 * @return
	 */
	DataTableReturn selectByDatatables(DataTable dataTable);
}
