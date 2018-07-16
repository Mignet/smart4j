<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<script type="text/javascript" src="app/biz/customer/customer-list.js"></script>
<!-- 管理员才有下列权限 -->
<shiro:hasRole name="admin">
<input type="hidden" id="shiro_admin" />
</shiro:hasRole>
<table id="dtable" class="table table-bordered" cellspacing="0" width="100%">
        <thead>
            <tr>
	            <th>自增编号:</th>
	            <th>用户ID:</th>
	            <th>手机号:</th>
	            <th>昵称:</th>
	            <th>银行卡:</th>
	            <th>身份证:</th>
	            <th>预留手机号:</th>
	            <th>支付宝账号:</th>
	            <th>QQ:</th>
	            <th>邮箱:</th>
	            <th>登录密码:</th>
	            <th>总金额:</th>
	            <th>冻结金额:</th>
	            <th>注册时间:</th>
	            <th>:</th>
            </tr>
        </thead>
 
    </table>


