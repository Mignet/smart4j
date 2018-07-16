package com.v5ent.web.dao;

import java.util.List;
import java.util.Map;

import com.v5ent.web.request.DataStatisticsRequest;

public interface DataStatisticsMapper  {

	Map<String, Object> queryHomePageData(DataStatisticsRequest dataStatisticsRequest);

	List<Map<String,Object>> queryNewCustomerTable(DataStatisticsRequest dataStatisticsRequest);

	List<Map<String,Object>> queryOrderTable(DataStatisticsRequest dataStatisticsRequest);

	List<Map<String,Object>> querySaleAmount(DataStatisticsRequest dataStatisticsRequest);
 
}
