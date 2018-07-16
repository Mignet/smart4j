<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<script type="text/javascript" src="app/biz/banner/banner-list.js"></script>
<!-- 管理员才有下列权限 -->
<shiro:hasRole name="admin">
<input type="hidden" id="shiro_admin" />
</shiro:hasRole>
<table id="dtable" class="table table-bordered" cellspacing="0" width="100%">
        <thead>
            <tr>
	            <th>自增id:</th>
	            <th>名称:</th>
	            <th>图片地址:</th>
	            <th>链接:</th>
	            <th>排序:</th>
	            <th>状态0：1正常:</th>
            </tr>
        </thead>
 
    </table>


