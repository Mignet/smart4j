<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<script type="text/javascript" src="app/biz/order/order-list.js"></script>
<!-- 管理员才有下列权限 -->
<shiro:hasRole name="admin">
<input type="hidden" id="shiro_admin" />
</shiro:hasRole>
<table id="dtable" class="table table-bordered" cellspacing="0" width="100%">
        <thead>
            <tr>
	            <th>自增编号:</th>
	            <th>方案编号:</th>
	            <th>产品名称:</th>
	            <th>投资时间:</th>
	            <th>投资金额:</th>
	            <th>提交用户:</th>
	            <th>投资参与人:</th>
	            <th>提交时间:</th>
	            <th>已支付:</th>
            </tr>
        </thead>
 
    </table>


