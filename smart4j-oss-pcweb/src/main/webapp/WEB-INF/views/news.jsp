<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="head.jsp"></jsp:include>
<div class="w_1200 box_w_b clearfix">
        <dl class="about_tab_th round_m_a">
    <dd>
        <c:choose> 
		  <c:when test="${news.type==1}">   
			<a href="/news.html?type=1" class="tab_light">官方公告</a>
			<a href="/news/8.html">关于我们</a>
		    <a href="/news.html?type=0">帮助中心</a>
		    <a href="/news/6.html">注册协议</a>
		    <a href="/news.html?type=3" >网贷资讯</a>
		  </c:when> 
		  <c:when test="${news.type==0}">
			<a href="/news.html?type=1">官方公告</a>
			<a href="/news/8.html">关于我们</a>
		    <a href="/news.html?type=0" class="tab_light">帮助中心</a>
		    <a href="/news/6.html">注册协议</a>
		    <a href="/news.html?type=3" >网贷资讯</a>
		  </c:when> 
		  <c:when test="${news.type==3}">
			<a href="/news.html?type=1">官方公告</a>
			<a href="/news/8.html">关于我们</a>
		    <a href="/news.html?type=0">帮助中心</a>
		    <a href="/news/6.html">注册协议</a>
		    <a href="/news.html?type=3" class="tab_light">网贷资讯</a>
		  </c:when> 
		  <c:when test="${news.id==6}">
			<a href="/news.html?type=1">官方公告</a>
			<a href="/news/8.html">关于我们</a>
		    <a href="/news.html?type=0">帮助中心</a>
		    <a href="/news/6.html" class="tab_light">注册协议</a>
		    <a href="/news.html?type=3">网贷资讯</a>
		  </c:when> 
		  <c:when test="${news.id==8}">
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
        	<c:if test="${news.id!=6 && news.id!=8 }">
            <dl class="site_th d_site_th">
                <dd>
                    当前位置：
                    <a href="/">首页</a>
                    <em class="china">&gt;</em>
                    
                        <a href="/news.html?type=${news.type}">资讯列表</a>
                        
                    
                    <em class="china">&gt;</em>
                    ${news.title }
                </dd>
            </dl>
            </c:if>
            <div class="d_wen clearfix">
            	<c:if test="${news.id!=6 && news.id!=8 }">
                <h2>${news.title }</h2>
                <div class="text_o">
			                    发布时间：<fmt:formatDate value="${news.createTime }" pattern="yyyy年MM月dd日" />
			                    <span class="m_t_b">来源于：${news.tfrom }</span>
			                    发布人：管理员
                </div>
                </c:if>
                <div class="cms-content">${news.content }</div>
            </div>
            
            <!-- <h4 class="th_text">更多网贷资讯</h4>
            <ul class="ann_list ann_other">
                
                    <li><span class="fr">2018-05-23</span><a href="/news/125">首批金控集团监管试点名单传出 包括蚂蚁金服</a></li>
                
                    <li><span class="fr">2018-05-22</span><a href="/news/124">乐信发布一季报：规模翻番 净利润暴涨160%</a></li>
                
                    <li><span class="fr">2018-05-22</span><a href="/news/123">e租宝案38家关联公司宣判：111人受审 罚金超20亿</a></li>
                
                    <li><span class="fr">2018-05-21</span><a href="/news/122">互联网金融产品风险多样且隐蔽 投资人保护很重要</a></li>
                
                    <li><span class="fr">2018-05-21</span><a href="/news/121">余额宝再接入一基金产品 目前已对接4只货基</a></li>
                
            </ul> -->
            
        </div>
    </div>

<jsp:include page="footer.jsp"></jsp:include>