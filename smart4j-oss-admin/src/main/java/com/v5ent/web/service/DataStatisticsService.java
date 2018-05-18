package com.v5ent.web.service;

import java.util.Map;

import com.v5ent.web.request.DataStatisticsRequest;

/**
 * 
 * @描述：数据统计
 *
 * @author hxb
 * @时间 2016年4月8日下午5:43:30
 *
 */
public interface DataStatisticsService {

	Map<String, Object> queryHomePageData(DataStatisticsRequest dataStatisticsRequest);
	
}
