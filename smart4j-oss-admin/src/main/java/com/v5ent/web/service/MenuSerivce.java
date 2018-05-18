package com.v5ent.web.service;

import com.v5ent.core.datatable.DataTableReturn;
import com.v5ent.web.model.MenusModel;
import com.v5ent.web.request.CommonRequest;
import com.v5ent.web.response.MenuTreeResp;
import com.v5ent.web.response.MenusResp;

import java.util.List;

/**
 * Created by Mignet on 2016/6/22.
 *
 * @Author Libin
 * @Date 2016/6/22
 */
public interface MenuSerivce {

    public DataTableReturn findMenuList(CommonRequest<MenusModel> cfpCommonRequest) throws Exception;

    public List<MenusResp> findMenuAllList(CommonRequest<MenusModel> cfpCommonRequest) throws Exception;

    public MenusModel findMenuOne(MenusModel menusModel) throws Exception;

    public boolean saveMenus(MenusModel menusModel) throws Exception;

    public boolean deleteMenus(List<Integer> iids) throws Exception;

    public List<MenuTreeResp> findMenuTree() throws Exception;
}
