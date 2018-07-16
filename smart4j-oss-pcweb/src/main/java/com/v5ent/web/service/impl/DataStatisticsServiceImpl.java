package com.v5ent.web.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.v5ent.core.util.DateUtils;
import com.v5ent.web.dao.DataStatisticsMapper;
import com.v5ent.web.request.DataStatisticsRequest;
import com.v5ent.web.service.DataStatisticsService;

@Service("dataStatisticsService")
public class DataStatisticsServiceImpl implements DataStatisticsService {

	private static final Logger logger = LoggerFactory.getLogger(DataStatisticsServiceImpl.class);
	
	@Resource
	private DataStatisticsMapper dataStatisticsMapper;

	@Override
	public Map<String, Object> queryHomePageData(DataStatisticsRequest dataStatisticsRequest) {
		// TODO Auto-generated method stub
		String dateFormat="yyyy-MM-dd";
		if(dataStatisticsRequest.getDateFormat() != null){
			dateFormat = dataStatisticsRequest.getDateFormat();
		}
		
		if(dateFormat.equals("yyyy-MM-dd")){
			dataStatisticsRequest.setDateFormat("%Y-%m-%d");
		}else{
			dataStatisticsRequest.setDateFormat("%Y-%m-%d %H");
		}
		
				
		Map<String,Object> resultMap = new HashMap<String,Object>();
		Map<String,Object> homepageDataCount = dataStatisticsMapper.queryHomePageData(dataStatisticsRequest);
		resultMap.put("count", homepageDataCount);		
		
		List<Map<String,Object>> newCustomerTable = dataStatisticsMapper.queryNewCustomerTable(dataStatisticsRequest);				
		List<Object> list =  new ArrayList<Object>();
		List<String> strList = DateUtils.getBetweeenTime(dataStatisticsRequest.getStartTime(), dataStatisticsRequest.getEndTime(), dateFormat);
		/**
		 * 手动补全客户人数
		 */
		for(String str:strList){
			boolean isExist = false;
			for(Map<String,Object> item:newCustomerTable){
				if(item.get("registerCustomerTime") !=null && item.get("registerCustomerTime").equals(str)){
					isExist = true;
					item.put("registerCustomerTime", changDateStringtoHour(str));
					list.add(item);
					continue;
				}
				
			}
			if(!isExist){//没有查询数据手动补0
				Map<String,Object> temp = new HashMap<String,Object>();
				str = changDateStringtoHour(str);
				temp.put("registerCustomerTime", str);
				temp.put("registerCustomerNum", 0);
				list.add(temp);
			}else{
				
			}
		}
		resultMap.put("customer", list);
		
		List<Map<String,Object>> orderTable = dataStatisticsMapper.queryOrderTable(dataStatisticsRequest);
		List<Object> orderList =  new ArrayList<Object>();
		List<String> orderStrList = DateUtils.getBetweeenTime(dataStatisticsRequest.getStartTime(), dataStatisticsRequest.getEndTime(), dateFormat);
		/**
		 * 手动补全订单数量
		 */
		for(String str:orderStrList){
			boolean isExist = false;
			for(Map<String,Object> item:orderTable){
				if(item.get("orderCreateTime") !=null && item.get("orderCreateTime").equals(str)){
					isExist = true;
					item.put("orderCreateTime", changDateStringtoHour(str));
					orderList.add(item);
					continue;
				}
				
			}
			if(!isExist){//没有查询数据手动补0
				Map<String,Object> temp = new HashMap<String,Object>();
				str = changDateStringtoHour(str);
				temp.put("orderCreateTime", str);
				temp.put("orderNum", 0);
				orderList.add(temp);
			}else{
				
			}
		}
		resultMap.put("orderNum", orderList);
		
		List<Map<String,Object>> saleAmountTable = dataStatisticsMapper.querySaleAmount(dataStatisticsRequest);
		List<Object> saleAmountList =  new ArrayList<Object>();
		List<String> saleAmountStrList = DateUtils.getBetweeenTime(dataStatisticsRequest.getStartTime(), dataStatisticsRequest.getEndTime(), dateFormat);
		/**
		 * 手动补全销售记录
		 */
		for(String str:saleAmountStrList){
			boolean isExist = false;
			for(Map<String,Object> item:saleAmountTable){
				if(item.get("saleTime") !=null && item.get("saleTime").equals(str)){
					isExist = true;
					item.put("saleTime", changDateStringtoHour(str));
					saleAmountList.add(item);
					continue;
				}
				
			}
			if(!isExist){//没有查询数据手动补0
				Map<String,Object> temp = new HashMap<String,Object>();
				str = changDateStringtoHour(str);
				temp.put("saleTime", str);
				temp.put("saleAmount", 0);
				saleAmountList.add(temp);
			}else{
				
			}
		}
		resultMap.put("saleAmount", saleAmountList);
		
		return resultMap;
	}
	
	public String changDateStringtoHour(String dateString){
		String reg = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])\\s([0-1][0-9]|2[0-3])$";
		Pattern p = Pattern.compile(reg);
		Matcher matcher = p.matcher(dateString);
		String resultDate=null;
		if(matcher.matches()){
			Date tempDate = DateUtils.parse(dateString,"yyyy-MM-dd HH");
			resultDate = DateUtils.format(tempDate, "HH:mm");
		}else{
			resultDate = dateString; 
		}
		return resultDate;
	}

}
