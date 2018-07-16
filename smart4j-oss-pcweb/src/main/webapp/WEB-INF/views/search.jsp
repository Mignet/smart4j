<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="head.jsp"></jsp:include>
<!-- start index home page -->
<dl class="site_th w_1200">
        <dd>当前位置：<a href="/">信一理财</a><em class="china">&gt;</em>平台列表</dd>
    </dl>

    <div class="w_1200 box_w_b clearfix png_img h_tab">
        <div class="activity_header">
        <dl class="i_tab_nav round_m_a">
            <dd>
             <c:choose>
                <c:when test="${rcType=='A'}">
                	<a href="/search.html">全部</a>
                    <a href="/search.html?rcType=A" class="tab_light">A 保守型</a>
                    <a href="/search.html?rcType=B">B 稳健型</a>
                    <a href="/search.html?rcType=C">C 进取型</a>
                    <a href="/search.html?rcType=D">D 激进型</a>
                    <a href="/search.html?rcType=E">E 高返型</a>
                </c:when>
                <c:when test="${rcType=='B'}">
                	<a href="/search.html">全部</a>
                    <a href="/search.html?rcType=A">A 保守型</a>
                    <a href="/search.html?rcType=B" class="tab_light">B 稳健型</a>
                    <a href="/search.html?rcType=C">C 进取型</a>
                    <a href="/search.html?rcType=D">D 激进型</a>
                    <a href="/search.html?rcType=E">E 高返型</a>
                </c:when>
                <c:when test="${rcType=='C'}">
                	<a href="/search.html">全部</a>
                    <a href="/search.html?rcType=A">A 保守型</a>
                    <a href="/search.html?rcType=B">B 稳健型</a>
                    <a href="/search.html?rcType=C" class="tab_light">C 进取型</a>
                    <a href="/search.html?rcType=D">D 激进型</a>
                    <a href="/search.html?rcType=E">E 高返型</a>
                </c:when>
                <c:when test="${rcType=='D'}">
                	<a href="/search.html">全部</a>
                    <a href="/search.html?rcType=A">A 保守型</a>
                    <a href="/search.html?rcType=B">B 稳健型</a>
                    <a href="/search.html?rcType=C">C 进取型</a>
                    <a href="/search.html?rcType=D" class="tab_light">D 激进型</a>
                    <a href="/search.html?rcType=E">E 高返型</a>
                </c:when>
                <c:when test="${rcType=='E'}">
                	<a href="/search.html">全部</a>
                    <a href="/search.html?rcType=A">A 保守型</a>
                    <a href="/search.html?rcType=B">B 稳健型</a>
                    <a href="/search.html?rcType=C">C 进取型</a>
                    <a href="/search.html?rcType=D">D 激进型</a>
                    <a href="/search.html?rcType=E" class="tab_light">E 高返型</a>
                </c:when>
                <c:otherwise>
                	<a href="/search.html" class="tab_light">全部</a>
                    <a href="/search.html?rcType=A">A 保守型</a>
                    <a href="/search.html?rcType=B">B 稳健型</a>
                    <a href="/search.html?rcType=C">C 进取型</a>
                    <a href="/search.html?rcType=D">D 激进型</a>
                    <a href="/search.html?rcType=E">E 高返型</a>
                </c:otherwise>
             </c:choose>
            </dd>
        </dl>
        <form method="get" action="/search.html">
            <input type="text" name="name" class="fill_text" value="">
            <button type="submit" class="shop_btn">搜索</button>
        </form>
        </div>
        <div class="activity_filter">
            <dl>
                <dt>投资类型：</dt>
                <dd>
                <c:choose>
                <c:when test="${page==1 }">
                	<a href="/search.html">全部</a>
                    <a href="/search.html?type=1" class="active">首投</a>
                    <a href="/search.html?type=2">复投</a>
                </c:when>
                <c:when test="${page==2 }">
                	<a href="/search.html">全部</a>
                    <a href="/search.html?type=1">首投</a>
                    <a href="/search.html?type=2" class="active">复投</a>
                </c:when>
                <c:otherwise>
                	<a href="/search.html" class="active">全部</a>
                    <a href="/search.html?type=1">首投</a>
                    <a href="/search.html?type=2">复投</a>
                </c:otherwise>
                </c:choose>
                </dd>
            </dl>
            <!-- 
            <dl>
                <dt>投资天数：</dt>
                <dd><a href="?" class="active">全部</a><a href="?dmin=1&amp;dmax=7">1-7天</a><a href="?dmin=8&amp;dmax=15">8-15天</a><a href="?dmin=16&amp;dmax=35">一月</a><a href="?dmin=36&amp;dmax=50">一月半</a><a href="?dmin=51&amp;dmax=70">二月</a><a href="?dmin=71&amp;dmax=100">三月</a><a href="?dmin=101&amp;dmax=0">三个月以上</a></dd>
            </dl>
             -->
        </div>

        

        <div class="white_box clearfix i_box">
            
            <ul class="h_list i_list hover_ul">
                <c:forEach items="${platforms}" var="hp">
            	<li class="transition_a li_o">
                <a href="/a/${hp.id}.html" class="box clearfix transition_a">
                    <div class="fl brand_logo_l">
                        <div class="brand_logo_t">
                            <img src="${hp.logo}" alt="${hp.name}" width="120" height="50">
                            <div class="f_text_box">
                            <c:choose>
                            <c:when test="${hp.aors==1 }">
                                <p><span class="text_box round_s">首投</span></p>
                            </c:when>
                            <c:when test="${hp.aors==2 }">
                            	<p><span class="text_box text_box_orange round_s">复投</span></p>
                            </c:when>
                            <c:when test="${hp.aors==3 }">
                                <p><span class="text_box round_s">首投</span></p>
                            	<p><span class="text_box text_box_orange round_s">复投</span></p>
                            </c:when>
                            </c:choose>
                            </div>
                        </div>
                    </div>
                    <div class="r_cell">
                        <div class="fr h_list_btn">
                            <span class="shop_btn round_s transition_a">立即参与</span>
                        </div>
                        <div class="r_cell">
                         投 <b class="font_20">${hp.mount}</b> 获得
                            <b class="orange_text font_20">${hp.maxIncome }</b> 元，年化
                            <b class="orange_text font_20">≈ ${hp.maxYearrate }%</b>
                            ，已有 <b class="font_20">${hp.maxInvestors }</b> 人参加活动
                            <ul class="tags">
                                <li>风控评级：${hp.rcLevel }</li>
                                <li>${hp.rcTypeMsg }</li>
                                <c:forEach items="${hp.tags.split(',') }" var="tag">
                                	<li>${tag}</li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                </a>
            	</li>
            </c:forEach>
            </ul>
            <!-- 
            <dl class="page">
			    <dt class="fl">共2页，每页100，共计114</dt>
			    <dd class="r_cell">
			            <em>上一页</em>
			                    <b>1</b>
			                    <a href="/first/p2">2</a>
			            <a href="/first/p2">下一页</a>
			    </dd>
			</dl>
             -->
        </div>
    </div>
<jsp:include page="footer.jsp"></jsp:include>    