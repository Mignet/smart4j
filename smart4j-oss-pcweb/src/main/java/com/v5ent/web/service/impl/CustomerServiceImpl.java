package com.v5ent.web.service.impl;

import java.util.List;
import java.util.Map;
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

import com.v5ent.web.model.Customer;
import com.v5ent.web.dao.CustomerMapper;
import com.v5ent.web.service.CustomerService;
import com.v5ent.web.service.impl.CustomerServiceImpl;


 /**
 * 
 * @描述：CustomerService 服务实现类
 * 
 * @创建人： Mignet
 * 
 * @创建时间：2018年05月19日 11:25:32
 * 
 * Copyright (c) 深圳米格云链网络科技有限公司-版权所有
 */
@Service("customerService")
public class CustomerServiceImpl extends GenericServiceImpl<Customer, Long> implements CustomerService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	@Resource
	private CustomerMapper customerMapper;
	
	@Override
    public GenericDao<Customer, Long> getDao() {
        return customerMapper;
    }
    
    @Override
	public DataTableReturn selectByDatatables(DataTable dt) {
		DataTableReturn tableReturn = new DataTableReturn();
		tableReturn.setDraw(dt.getDraw()+1);
		LOGGER.debug(" -- Customer -- 排序和模糊查询 ");
		Page<Customer> page = new Page<Customer>(dt.getStart()/dt.getLength()+1,dt.getLength());
		List<Customer> list = this.customerMapper.selectBySearchInfo(dt,page);
		tableReturn.setData(list);
		tableReturn.setRecordsFiltered(page.getTotalCount());
		tableReturn.setRecordsTotal(page.getTotalCount());
		return tableReturn;
	}

	@Override
	public List<Map<String,String>> selectTop10() {
		return customerMapper.selectTop10();
	}

}
