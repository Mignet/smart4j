package com.v5ent.web.response;

import com.v5ent.web.model.MenusModel;

/**
 * Created by Mignet on 2016/6/23.
 *
 * @Author Libin
 * @Date 2016/6/23
 */
public class MenusResp extends MenusModel {
    private String parentName;

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }
}
