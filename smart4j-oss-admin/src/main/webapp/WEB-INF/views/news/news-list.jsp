<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<script type="text/javascript" src="app/biz/news/news-list.js"></script>
<!-- 管理员才有下列权限 -->
<shiro:hasRole name="admin">
<input type="hidden" id="shiro_admin" />
</shiro:hasRole>
<table id="dtable" class="table table-bordered" cellspacing="0" width="100%">
        <thead>
            <tr>
	            <th>自增id:</th>
	            <th>标题:</th>
	            <th>内容:</th>
	            <th>文章来源:</th>
	            <th>创建时间:</th>
	            <th>状态:</th>
	            <th>类型 0:常见问答 1:官方公告 2:私信 3:网贷新闻 4.文章 5,关于 6.协议:</th>
	            <th>谁可以看，NUll表示公共:</th>
            </tr>
        </thead>
 
    </table>


