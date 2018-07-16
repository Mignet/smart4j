<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<jsp:include page="head.jsp"></jsp:include>
<!-- start index home page -->

    <!--star动画-->
    <div class="banner">
        <ul class="bd">
            <c:forEach items="${banners}" var="banner">
	            <li style="background-image:url(${banner.pic});"><a href="${banner.link}"></a></li>
			</c:forEach>
        </ul>
        <ul class="hd"></ul>
        <div class="btn btn_l prev transition_a">&lt;</div>
        <div class="btn btn_r next transition_a">&gt;</div>
    </div>
    <!--end动画-->

    <div class="h_data">
        <div class="h_data_w min_1200">
            <div class="w_1200">
                <div class="hide_box">
                    <ul class="h_data_c list_4">
                        <li>累计总投资额：<b class="yellow_text">8.97</b>亿</li>
                        <li>累计返利金额：<b class="yellow_text">2671.6</b>万</li>
                        <li>累计注册用户：<b class="yellow_text">4547</b>人</li>
                        <li>稳健运营：<b class="yellow_text">415</b>天</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <!--end数据-->

    <div class="white_box min_1200">
        <div class="white_box w_1200">
            <div class="hide_box">
                <ul class="list_5 h_tool clearfix">
                    <li><span class="b_arrow b_arrow3 png"></span><h5>返利价高</h5>
                        <p>返利价格高</p></li>
                    <li><span class="b_arrow png"></span><h5>返利快速</h5>
                        <p>提交订单后<br>1-3个工作日返现</p></li>
                    <li><span class="b_arrow b_arrow2 png"></span><h5>公司保障</h5>
                        <p>公司运营，一手渠道<br>返现有保障</p></li>
                    <li><span class="b_arrow b_arrow4 png"></span><h5>风险量化</h5>
                        <p>所有活动附带风控评级<br>风险一目了然</p></li>
                    <li><span class="b_arrow b_arrow5 png"></span><h5>独家风控</h5>
                        <p>线上分析，线下考察<br>Ｎ道风控手段</p></li>
                </ul>
            </div>
        </div>
    </div>
    <!--end白色背景-->


    <div class="w_1200 box_w">
        <div class="hide_box">
            <ul class="list_3 h_rec hover_ul">
                <c:forEach items="${top}" var="tp">
                
                <li class="li_o"><a href="/a/${tp.id}.html" class="box transition_a">
                    <span class="f_rec png">热门</span>
                    <div class="brand_logo png_img round_r">
                        <div class="brand_logo_border round_r">
                        <c:choose>
                        <c:when test="${tp.aors==1 }">
                            <span class="text_box f_text_box round_s">首投</span>
                        </c:when>
                        <c:when test="${tp.aors==2 }">
                            <span class="text_box f_text_box_orange round_s">复投</span>
                        </c:when>
                        <c:when test="${tp.aors==3 }">
                            <span class="text_box f_text_box round_s">首投</span>
                            <span class="text_box f_text_box_orange round_s">复投</span>
                        </c:when>
                        </c:choose>
                            <img src="${tp.logo}" alt="" width="100" height="40">
                        </div>
                    </div>
                    <div class="text">
                        <p>投${tp.mount}获得<b class="font_20 orange_text">${tp.maxIncome }</b>元，
                            年化<b class="font_20 orange_text">≈ ${tp.maxYearrate}%</b></p>
                        <p>已有<b class="font_20">${tp.maxInvestors }</b>人参加活动</p>
                    </div>
                    <ul class="tag_ul clearfix list_2">
                        <li><span class="tag_a round_m">融资：${tp.bgRz }</span></li>
                        <li><span class="tag_a round_m">背景：${tp.bgPt }</span></li>
                        <li><span class="tag_a tag_a_box round_m">风控评级：${tp.rcLevel }</span></li>
                        <li><span class="tag_a tag_a_box round_m">${tp.rcTypeMsg }</span></li>
                    </ul>
                    <div class="text_line hide1">	&nbsp;
                            	优势：
                                <c:forEach items="${tp.tags.split(',') }" var="tag">
                                	<span class="m_l">${tag}</span>
                                </c:forEach>
                    
                    </div>
                    <div class="btn"><span class="shop_btn round_s transition_a">我要参加</span></div>
                </a>
                </li>
                </c:forEach>
            </ul>
        </div>
    </div>

    <div class="w_1200 box_w clearfix white_box png_img">
        <ul class="h_list hover_ul">
            <c:forEach items="${hot}" var="hp">
            <li class="transition_a li_o">
                <a href="/a/${hp.id}.html" class="box clearfix transition_a">
                    <div class="fl brand_logo_l">
                        <div class="brand_logo_t">
                            <img src="${hp.logo}" alt="${hp.name}" width="120" height="50">
                            <div class="f_text_box">
                            <c:choose>
                            	<c:when test="${hp.aors == 1 }">
    	                            <p><span class="text_box round_s">首投</span></p>
                            	</c:when>
                            	<c:when test="${hp.aors == 2 }">
	                            	<p><span class="text_box text_box_orange round_s">复投</span></p>
                            	</c:when>
                            	<c:when test="${hp.aors == 3 }">
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
    </div>

    <div class="w_1200 box_w clearfix">
        <div class="fl w_390 h_460 white_box">
            <h4 class="h_th"><span class="fr"><a href="/news.html?type=0" target="_blank">查看更多+</a></span><b class="fl">常见问答</b></h4>
            <ul class="h_qa font_15">
                 <c:forEach items="${help}" var="qa" varStatus="s">
                    <li><span class="round_s qa_text">Q${s.count }</span><a href="/news/${qa.id}.html" target="_blank">${qa.title }</a></li>
                </c:forEach>
            </ul>
        </div>
        <div class="fl w_390 h_460 white_box">
            <h4 class="h_th"><span class="fr"><a href="/news.html?type=1" target="_blank">查看更多+</a></span><b class="fl">官方公告</b></h4>
            <ul class="h_ann font_15">
                <c:forEach items="${anno}" var="annew">
                    <li class="hide1"><a href="/news/${annew.id}.html" target="_blank">${annew.title}</a></li>
                </c:forEach>
            </ul>
        </div>
        <div class="fr w_390 h_460 white_box">
            <h4 class="h_th"><b class="fl">本月投资排行</b></h4>
            <ul class="h_top font_15">
                <c:forEach items="${hotCustomers}"  var ="cu" varStatus="status">
	                <li>
	                <i>${status.count }</i> 
	                <%-- <a href="/space/3575" target="_blank" rel="nofollow">
	                ${cu.name!=null?cu.name:cu.mobile }
	                </a>  --%>
	                ${cu.name!=null?cu.name:cu.phone }
	                <b>¥<fmt:formatNumber type="number" value="${cu.total }" pattern="0.00" maxFractionDigits="2"/></b>
	                </li>
                </c:forEach>
            </ul>
        </div>
    </div>

    <div class="w_1200 box_w clearfix white_box" style="padding-bottom:20px;">
        <h4 class="h_th"><span class="fr"><a href="/news.html?type=3" target="_blank">查看更多+</a></span><b class="fl">网贷资讯</b></h4>
                <c:forEach items="${news}" var="anew" varStatus="s">
                <c:if test="${(s.index%5)==0}">
                <div class="fl w_390">
                <ul class="h_qa font_15">
                </c:if>
                    <li class="hide1"><a href="/news/${anew.id}.html" target="_blank">${anew.title }</a></li>
                <c:if test="${s.count==news.size() || ((s.index+1)%5)==0}">
                </ul>
                </div>
                </c:if>
                </c:forEach>
    </div>

    

    <div class="w_1200 box_w clearfix white_box png_img">
        <h4 class="h_th"><b class="fl">合作伙伴</b></h4>
        <ul class="list_5 h_brand clearfix">
            <c:forEach items="${partner}" var="p">
	            <li><a href="https://www.baidu.com/s?wd=${p.name }" class="box">
	                <div class="black transition_a">${p.bgPt }</div>
	                <img src="${p.logo}" alt="${p.name}" width="170" height="60"></a>
	            </li>
            </c:forEach>
            
        </ul>
        <p class="flink">友情链接：
	        <a href="//www.wdzj.com/" target="_blank">网贷之家</a> 
	        <a href="//ipc.ducaishe.com/" target="_blank">神盾风控</a> 
	        <a href="//www.xianhuokaihu.net/" target="_blank">青岛汇海</a> 
	        <a href="//www.xinguanjia.cc/" target="_blank">信管家</a> 
	        <a href="//www.sofanyong.cn/" target="_blank">外汇返佣</a> 
	        <a href="//www.schyhj.com/" target="_blank">成都配资</a> 
	        <a href="//www.chlnahhce.com/" target="_blank">黄河商品交易市场</a> 
	        <a href="//www.xapeizi.cn/" target="_blank">西安配资公司</a> 
	        <a href="//www.ttgupiao.cn/" target="_blank">股票配资平台</a> 
	        <a href="//www.sxrong.com/" target="_blank">p2p理财平台</a> 
	        <a href="//www.taocai360.com/" target="_blank">股票配资</a> 
	        <a href="https://www.wddashi.com/" target="_blank">网贷大师</a> 
	        <a href="//www.scjzttz.com/" target="_blank">成都股票配资公司</a>
	        <a href="//www.whkjc.com/" target="_blank">外汇学习网</a> 
	        <a href="//www.njchengduihuipiao.com/" target="_blank">承兑汇票贴现</a> 
	        <a href="//www.zqdh.com.cn/" target="_blank">外汇开户</a> 
	        <a href="//www.chuanrong888.com/" target="_blank">成都贷款</a> 
	        <a href="//www.zuopos.com/" target="_blank">POS机申请</a> 
	        <a href="//www.lufaxy.com/" target="_blank">陆长网</a> 
	        <a href="//www.huipiao7.com/" target="_blank">承兑汇票</a> 
        </p>
        <div class="btn_c"><a href="//wpa.qq.com/msgrd?v=3&uin=414628710&site=qq&menu=yes" class="shop_btn transition_a round_s" target="_blank">成为合作伙伴</a></div>
    </div>

    <!-- end index home page -->
<jsp:include page="footer.jsp"></jsp:include>    