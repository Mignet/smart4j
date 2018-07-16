<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<script type="text/javascript" src="app/biz/tag/tag-list.js"></script>
<!-- 管理员才有下列权限 -->
<shiro:hasRole name="admin">
<input type="hidden" id="shiro_admin" />
</shiro:hasRole>
<table id="dtable" class="table table-bordered" cellspacing="0" width="100%">
        <thead>
            <tr>
	            <th>标签ID:</th>
	            <th>标签名称:</th>
	            <th>状态:</th>
	            <th>创建日期:</th>
            </tr>
        </thead>
 
    </table>


