package com.v5ent.core.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.beanutils.PropertyUtilsBean;
import org.apache.commons.lang.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

public class CommonUtils {
	
	protected final static Logger LOGGER = LoggerFactory.getLogger(CommonUtils.class);
	

	/**
	 * 将请求不定长参数转化成post或者get请求所需要的参数对象list
	 * @param objectParams  请求参数,不定长参数，可以为多个
	 * @return
	 */
	public static List<NameValuePair> getNameValuePairList(Object... objectParams){
		
		/**
		 * 将请求的参数转化成Map<String,String> 对象
		 */
		Map<String,String> paramsMap = getMapPairList(objectParams);
		LOGGER.info("请求的参数:{}",JSONObject.toJSONString(paramsMap));
		
        /**
         * 将所有的参数转化成get,post请求 所需要的对象
         */
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        for(String key:paramsMap.keySet()){
        	formparams.add(new BasicNameValuePair(key,paramsMap.get(key)));  
        }
		return formparams;
	}
	
	/**
	 * Map
	 * 将请求不定长参数转化成post或者get请求所需要的参数对象list
	 * @param objectParams  请求参数,不定长参数，可以为多个
	 * @return
	 */
	public static Map<String,String> getMapPairList(Object... objectParams){
		
		/**
		 * 将请求的参数转化成Map<String,String> 对象
		 */
		Map<String,String> paramsMap = new HashMap<String,String>();
		if(objectParams!=null && objectParams.length>0){
			for(Object obj:objectParams){
				Map<String,String> map = obj2Map(obj);
				paramsMap.putAll(map);
			}
		}
		
		return paramsMap;
	}
	
	/**
	 * 将object对象转化成Map<String,String>
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	private static Map<String,String> obj2Map(Object obj){
		 Map<String,String> ret = new HashMap<String,String>();
		 if(obj==null){
			return ret;
		 }
		 if(obj instanceof Map){
			 Map<Object, Object> middleMap = (Map<Object,Object>)obj;
			 for(Object objm : middleMap.keySet()){
				 ret.put(objm.toString(), middleMap.get(objm).toString()); 
			 }
			 return ret;
		 }
		 Class<?> clazz = obj.getClass();
		 while(clazz!=null){
			 Field[] fields = clazz.getDeclaredFields();
			 for(Field field:fields){
				 String name = field.getName();
				 field.setAccessible(true);
				 Object value = null;
				try {
					value = field.get(obj);
				} catch (Exception e) {
					LOGGER.info("将object对象转化成Map<String,String>异常：{}",e);
				}
				 field.setAccessible(false);
				 if(value!=null){
					 ret.put(name, value.toString());
				 }
			 }
			 clazz = clazz.getSuperclass();
		 }
		 return ret;
	}
	
	/**
	 * TreeMap
	 * 将请求不定长参数转化成post或者get请求所需要的参数对象list
	 * @param objectParams  请求参数,不定长参数，可以为多个
	 * @return
	 */
	public static TreeMap<String,String> getTreeMapPairList(Object... objectParams){
		
		/**
		 * 将请求的参数转化成Map<String,String> 对象
		 */
		TreeMap<String, String> paramsMap = new TreeMap<String, String>(); 
		if(objectParams!=null && objectParams.length>0){
			for(Object obj:objectParams){
				TreeMap<String, String> map = beanToSortMap(obj);
				paramsMap.putAll(map);
			}
		}
		
		return paramsMap;
	}
	
	@SuppressWarnings("unchecked")
	public static TreeMap<String, String> beanToSortMap(Object obj) { 
		TreeMap<String, String> params = new TreeMap<String, String>();
		 if(obj == null){
			return params;
		 }
		 if(obj instanceof Map){
			 Map<Object, Object> middleMap = (Map<Object,Object>)obj;
			 for(Object objm : middleMap.keySet()){
				 params.put(objm.toString(), middleMap.get(objm).toString()); 
			 }
			 return params;
		 }
        try { 
            PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean(); 
            PropertyDescriptor[] descriptors = propertyUtilsBean.getPropertyDescriptors(obj); 
            for (int i = 0; i < descriptors.length; i++) { 
                String name = descriptors[i].getName(); 
                if (!StringUtils.equals(name, "class")) {
                	Object o = propertyUtilsBean.getNestedProperty(obj, name);
                	if(o != null)
                		params.put(name, o.toString()); 
                } 
            } 
        } catch (Exception e) { 
        	e.printStackTrace(); 
        } 
        return params; 
	}
}
