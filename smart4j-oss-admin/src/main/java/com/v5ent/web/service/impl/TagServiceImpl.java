package com.v5ent.web.service.impl;

import java.util.List;
import java.lang.Long;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.v5ent.core.datatable.DataTable;
import com.v5ent.core.datatable.DataTableReturn;
import com.v5ent.core.generic.GenericDao;
import com.v5ent.core.generic.GenericServiceImpl;
import com.v5ent.core.orm.paging.Page;

import com.v5ent.web.model.Tag;
import com.v5ent.web.dao.TagMapper;
import com.v5ent.web.service.TagService;
import com.v5ent.web.service.impl.TagServiceImpl;


 /**
 * 
 * @描述：TagService 服务实现类
 * 
 * @创建人： Mignet
 * 
 * @创建时间：2018年05月19日 11:25:32
 * 
 * Copyright (c) 深圳米格云链网络科技有限公司-版权所有
 */
@Service("tagService")
public class TagServiceImpl extends GenericServiceImpl<Tag, Long> implements TagService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TagServiceImpl.class);
	
	@Resource
	private TagMapper tagMapper;
	
	@Override
    public GenericDao<Tag, Long> getDao() {
        return tagMapper;
    }
    
    @Override
	public DataTableReturn selectByDatatables(DataTable dt) {
		DataTableReturn tableReturn = new DataTableReturn();
		tableReturn.setDraw(dt.getDraw()+1);
		LOGGER.debug(" -- Tag -- 排序和模糊查询 ");
		Page<Tag> page = new Page<Tag>(dt.getStart()/dt.getLength()+1,dt.getLength());
		List<Tag> list = this.tagMapper.selectBySearchInfo(dt,page);
		tableReturn.setData(list);
		tableReturn.setRecordsFiltered(page.getTotalCount());
		tableReturn.setRecordsTotal(page.getTotalCount());
		return tableReturn;
	}

}
