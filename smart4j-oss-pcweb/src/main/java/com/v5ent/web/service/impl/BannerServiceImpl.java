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

import com.v5ent.web.model.Banner;
import com.v5ent.web.dao.BannerMapper;
import com.v5ent.web.service.BannerService;
import com.v5ent.web.service.impl.BannerServiceImpl;


 /**
 * 
 * @描述：BannerService 服务实现类
 * 
 * @创建人： Mignet
 * 
 * @创建时间：2018年05月19日 14:43:55
 * 
 * Copyright (c) 深圳米格云链网络科技有限公司-版权所有
 */
@Service("bannerService")
public class BannerServiceImpl extends GenericServiceImpl<Banner, Long> implements BannerService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BannerServiceImpl.class);
	
	@Resource
	private BannerMapper bannerMapper;
	
	@Override
    public GenericDao<Banner, Long> getDao() {
        return bannerMapper;
    }
    
    @Override
	public DataTableReturn selectByDatatables(DataTable dt) {
		DataTableReturn tableReturn = new DataTableReturn();
		tableReturn.setDraw(dt.getDraw()+1);
		LOGGER.debug(" -- Banner -- 排序和模糊查询 ");
		Page<Banner> page = new Page<Banner>(dt.getStart()/dt.getLength()+1,dt.getLength());
		List<Banner> list = this.bannerMapper.selectBySearchInfo(dt,page);
		tableReturn.setData(list);
		tableReturn.setRecordsFiltered(page.getTotalCount());
		tableReturn.setRecordsTotal(page.getTotalCount());
		return tableReturn;
	}

}
