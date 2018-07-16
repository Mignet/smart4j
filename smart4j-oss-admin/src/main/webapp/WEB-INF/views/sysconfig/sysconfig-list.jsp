<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<script type="text/javascript" src="app/sysconfig/sysconfig-list.js"></script>
<!-- 管理员才有下列权限 -->
<shiro:hasRole name="admin">
<input type="hidden" id="shiro_admin" />
</shiro:hasRole>
<table id="dtable" class="table table-bordered" cellspacing="0" width="100%">
        <thead>
            <tr>
            <th>流水号</th>
            <th>名称</th>
            <th>类别</th>
            <th>键</th>
            <th>值</th>
            <th>备注</th>
            <th>创建时间</th>
            <th>应用类别</th>
            </tr>
        </thead>
 
    </table>


