<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<script type="text/javascript" src="app/biz/investor/investor-list.js"></script>
<!-- 管理员才有下列权限 -->
<shiro:hasRole name="admin">
<input type="hidden" id="shiro_admin" />
</shiro:hasRole>
<table id="dtable" class="table table-bordered" cellspacing="0" width="100%">
        <thead>
            <tr>
	            <th>自增编号:</th>
	            <th>用户ID:</th>
	            <th>投资人号码:</th>
	            <th>投资人姓名:</th>
            </tr>
        </thead>
 
    </table>


