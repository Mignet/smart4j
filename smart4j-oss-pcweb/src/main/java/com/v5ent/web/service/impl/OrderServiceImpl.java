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

import com.v5ent.web.model.Order;
import com.v5ent.web.dao.OrderMapper;
import com.v5ent.web.service.OrderService;
import com.v5ent.web.service.impl.OrderServiceImpl;


 /**
 * 
 * @描述：OrderService 服务实现类
 * 
 * @创建人： Mignet
 * 
 * @创建时间：2018年05月19日 11:25:32
 * 
 * Copyright (c) 深圳米格云链网络科技有限公司-版权所有
 */
@Service("orderService")
public class OrderServiceImpl extends GenericServiceImpl<Order, Long> implements OrderService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);
	
	@Resource
	private OrderMapper orderMapper;
	
	@Override
    public GenericDao<Order, Long> getDao() {
        return orderMapper;
    }
    
    @Override
	public DataTableReturn selectByDatatables(DataTable dt) {
		DataTableReturn tableReturn = new DataTableReturn();
		tableReturn.setDraw(dt.getDraw()+1);
		LOGGER.debug(" -- Order -- 排序和模糊查询 ");
		Page<Order> page = new Page<Order>(dt.getStart()/dt.getLength()+1,dt.getLength());
		List<Order> list = this.orderMapper.selectBySearchInfo(dt,page);
		tableReturn.setData(list);
		tableReturn.setRecordsFiltered(page.getTotalCount());
		tableReturn.setRecordsTotal(page.getTotalCount());
		return tableReturn;
	}

}
