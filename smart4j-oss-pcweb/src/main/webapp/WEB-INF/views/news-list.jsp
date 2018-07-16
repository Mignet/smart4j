<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="head.jsp"></jsp:include>
<div class="w_1200 box_w_b clearfix">
        <dl class="about_tab_th round_m_a">
    <dd>
        <c:choose> 
		  <c:when test="${type==1}">   
			<a href="/news.html?type=1" class="tab_light">官方公告</a>
			<a href="/news/8.html">关于我们</a>
		    <a href="/news.html?type=0">帮助中心</a>
		    <a href="/news/6.html">注册协议</a>
		    <a href="/news.html?type=3" >网贷资讯</a>
		  </c:when> 
		  <c:when test="${type==0}">
			<a href="/news.html?type=1">官方公告</a>
			<a href="/news/8.html">关于我们</a>
		    <a href="/news.html?type=0" class="tab_light">帮助中心</a>
		    <a href="/news/6.html">注册协议</a>
		    <a href="/news.html?type=3" >网贷资讯</a>
		  </c:when> 
		  <c:when test="${type==3}">
			<a href="/news.html?type=1">官方公告</a>
			<a href="/news/8.html">关于我们</a>
		    <a href="/news.html?type=0">帮助中心</a>
		    <a href="/news/6.html">注册协议</a>
		    <a href="/news.html?type=3" class="tab_light">网贷资讯</a>
		  </c:when> 
		  <c:when test="${type==6}">
			<a href="/news.html?type=1">官方公告</a>
			<a href="/news/8.html">关于我们</a>
		    <a href="/news.html?type=0">帮助中心</a>
		    <a href="/news/6.html" class="tab_light">注册协议</a>
		    <a href="/news.html?type=3">网贷资讯</a>
		  </c:when> 
		  <c:when test="${type==5}">
			<a href="/news.html?type=1">官方公告</a>
			<a href="/news/8.html" class="tab_light">关于我们</a>
		    <a href="/news.html?type=0">帮助中心</a>
		    <a href="/news/6.html">注册协议</a>
		    <a href="/news.html?type=3">网贷资讯</a>
		  </c:when> 
		  <c:otherwise>   
			<a href="/news.html?type=1">官方公告</a>
			<a href="/news/8.html">关于我们</a>
		    <a href="/news.html?type=0">帮助中心</a>
		    <a href="/news/6.html">注册协议</a>
		    <a href="/news.html?type=3">网贷资讯</a>
		  </c:otherwise> 
		</c:choose> 
        
    </dd>
</dl>
	<div class="white_box clearfix box_w_b">
	 	<c:choose> 
		  	<c:when test="${type==1}">   
            <h4 class="th_text">官方公告</h4>
			</c:when>
		  	<c:when test="${type==0}">   
            <h4 class="th_text">帮助中心</h4>
			</c:when>
		  	<c:when test="${type==3}">   
            <h4 class="th_text">网贷资讯</h4>
			</c:when>
		</c:choose>
            <ul class="ann_list">
                <c:forEach items="${news}" var="anew">
                    <li><span class="fr"><fmt:formatDate value="${anew.createTime }" pattern="yyyy-MM-dd" /></span>
                    <a href="/news/${anew.id}.html">${anew.title}</a></li>
                </c:forEach>
            </ul>

            <!-- <dl class="page">
			    <dt class="fl">共1页，每页30，共计12</dt>
			    <dd class="r_cell">
			            <em>上一页</em>
			                    <b>1</b>
			            <em>下一页</em>
			    </dd>
			</dl> -->

        </div>
       </div>
<jsp:include page="footer.jsp"></jsp:include>