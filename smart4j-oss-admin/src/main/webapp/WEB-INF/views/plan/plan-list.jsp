<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<script type="text/javascript" src="app/biz/plan/plan-list.js"></script>
<!-- 管理员才有下列权限 -->
<shiro:hasRole name="admin">
<input type="hidden" id="shiro_admin" />
</shiro:hasRole>
<table id="dtable" class="table table-bordered" cellspacing="0" width="100%">
        <thead>
            <tr>
	            <th>序号</th>
	            <th>平台id</th>
	            <th>方案名称:</th>
	            <th>方案类型:</th>
	            <th>投资项目:</th>
	            <th>投资金额:</th>
	            <th>投资上限:</th>
	            <th>返利:</th>
	            <th>奖励:</th>
	            <th>参考年化利率:</th>
	            <th>红包:</th>
	            <th>体验金:</th>
	            <th>其他:</th>
	            <th>周期:</th>
	            <th>总收益(参考):</th>
	            <th>综合年化(参考):</th>
	            <th>返利周期:</th>
	            <th>状态:</th>
            </tr>
        </thead>
 
    </table>


