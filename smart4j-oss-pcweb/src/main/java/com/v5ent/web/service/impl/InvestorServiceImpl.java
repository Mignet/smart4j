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

import com.v5ent.web.model.Investor;
import com.v5ent.web.dao.InvestorMapper;
import com.v5ent.web.service.InvestorService;
import com.v5ent.web.service.impl.InvestorServiceImpl;


 /**
 * 
 * @描述：InvestorService 服务实现类
 * 
 * @创建人： Mignet
 * 
 * @创建时间：2018年05月19日 11:25:32
 * 
 * Copyright (c) 深圳米格云链网络科技有限公司-版权所有
 */
@Service("investorService")
public class InvestorServiceImpl extends GenericServiceImpl<Investor, Long> implements InvestorService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(InvestorServiceImpl.class);
	
	@Resource
	private InvestorMapper investorMapper;
	
	@Override
    public GenericDao<Investor, Long> getDao() {
        return investorMapper;
    }
    
    @Override
	public DataTableReturn selectByDatatables(DataTable dt) {
		DataTableReturn tableReturn = new DataTableReturn();
		tableReturn.setDraw(dt.getDraw()+1);
		LOGGER.debug(" -- Investor -- 排序和模糊查询 ");
		Page<Investor> page = new Page<Investor>(dt.getStart()/dt.getLength()+1,dt.getLength());
		List<Investor> list = this.investorMapper.selectBySearchInfo(dt,page);
		tableReturn.setData(list);
		tableReturn.setRecordsFiltered(page.getTotalCount());
		tableReturn.setRecordsTotal(page.getTotalCount());
		return tableReturn;
	}

}
