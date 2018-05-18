package com.v5ent.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.v5ent.core.datatable.DataTable;
import com.v5ent.core.datatable.DataTableReturn;
import com.v5ent.core.generic.GenericDao;
import com.v5ent.core.generic.GenericServiceImpl;
import com.v5ent.core.orm.paging.Page;
import com.v5ent.web.dao.SysThirdkeyConfigMapper;
import com.v5ent.web.model.SysThirdkeyConfig;
import com.v5ent.web.service.SysThirdkeyConfigService;


 /**
 * 
 * @描述：SysThirdkeyConfigService 服务实现类
 * 
 * @创建人： Mignet
 * 
 * @创建时间：2016年08月17日 11:16:29
 * 
 * Copyright (c) 深圳领会科技有限公司-版权所有
 */
@Service("sysThirdkeyConfigService")
public class SysThirdkeyConfigServiceImpl extends GenericServiceImpl<SysThirdkeyConfig, Long> implements SysThirdkeyConfigService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SysThirdkeyConfigServiceImpl.class);
	
	@Resource
	private SysThirdkeyConfigMapper sysThirdkeyConfigMapper;
	
	@Override
    public GenericDao<SysThirdkeyConfig, Long> getDao() {
        return sysThirdkeyConfigMapper;
    }
    
    @Override
	public DataTableReturn selectByDatatables(DataTable dt) {
		DataTableReturn tableReturn = new DataTableReturn();
		tableReturn.setDraw(dt.getDraw()+1);
		LOGGER.debug(" -- SysThirdkeyConfig -- 排序和模糊查询 ");
		Page<SysThirdkeyConfig> page = new Page<SysThirdkeyConfig>(dt.getStart()/dt.getLength()+1,dt.getLength());
		List<SysThirdkeyConfig> list = this.sysThirdkeyConfigMapper.selectBySearchInfo(dt,page);
		tableReturn.setData(list);
		tableReturn.setRecordsFiltered(page.getTotalCount());
		tableReturn.setRecordsTotal(page.getTotalCount());
		return tableReturn;
	}
}
