package com.v5ent.web.request;

import com.v5ent.core.datatable.DataTable;

/**
 *
 * @Author Libin
 * @Date 2016/6/1
 */
public class CommonRequest<T> extends DataTable {
    private String searchValue;
    private String startDate;
    private String endDate;

    private  T  params;

    private int pageIndex;




    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }


    public T getParams() {
        return params;
    }

    public void setParams(T params) {
        this.params = params;
    }

    public int getPageIndex() {
        return (getStart() / getLength())+1;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }
}
