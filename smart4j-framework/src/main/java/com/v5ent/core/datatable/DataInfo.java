package com.v5ent.core.datatable;

import java.util.Map;


/**
 * CRUD数据
 * @author Mignet
 *
 */
public class DataInfo <D>{
	public static final String ACTION_CREATE= "create";
	public static final String ACTION_EDIT= "edit";
	public static final String ACTION_REMOVE= "remove";
	
	/**
	 *  On create: create 
	 *  On edit: edit 
	 *  On remove: remove
	 */
	private String action;
	/**
	 * An object containing the row ids to act upon and edited data for those rows. Each key / value pair representing a different row where the object keys are the row ids and an inner object is the data for the row.
	 * LinkedHashMap
	 */
	private Map<String,D> data;
	
	public Map<String,D> getData() {
		return data;
	}
	public void setData(Map<String,D> data) {
		this.data = data;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
}
