<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<script type="text/javascript" src="app/biz/platform/platform-list.js"></script>
<!-- 管理员才有下列权限 -->
<shiro:hasRole name="admin">
<input type="hidden" id="shiro_admin" />
</shiro:hasRole>
<table id="dtable" class="table table-bordered" cellspacing="0" width="100%">
        <thead>
            <tr>
	            <th>序号</th>
	            <th>名称</th>
	            <th>logo</th>
	            <th>首复投</th>
	            <th>标签</th>
	            <th>风控类型</th>
	            <th>风控等级</th>
	            <th>融资背景</th>
	            <th>平台背景</th>
	            <th>银行存管</th>
	            <th>ICP</th>
	            <th>提现速度</th>
	            <th>所属公司</th>
	            <th>注册资本</th>
	            <th>上线时间</th>
	            <th>平台介绍</th>
	            <th>注册地址</th>
	            <th>神盾风控</th>
	            <th>详细说明</th>
	            <th>最小天数</th>
	            <th>最大天数</th>
	            <th>推荐</th>
	            <th>状态</th>
	            <th>是否截图</th>
	            <th>是否用户名</th>
            </tr>
        </thead>
 
    </table>


