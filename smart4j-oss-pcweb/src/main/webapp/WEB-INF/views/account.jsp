<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="head.jsp"></jsp:include>
<dl class="site_th w_1200">
        <dd>当前位置：<a href="/">信一理财</a><em class="china">&gt;</em>会员中心</dd>
    </dl>

    <div class="clearfix w_1200 i_center white_box">
        <div class="fl w_200 l_box">
            <dl class="l_club">
                <dt class="round_img">
                    <a href="/account.html">
                        <img src="/images/icon/photo_100.png" alt="" width="100" height="100">
                        <h4>${customerInfo.name!=null&&customerInfo.name!=''?customerInfo.name:customerInfo.phone}</h4>
                        
                    </a>
                </dt>
                <!-- <dd><a href="/message">消息
                
                </a></dd>
                <dd><a href="/account/notice">公告
                
                </a></dd> -->
                <dd><a href="/account.html?key=order">交单记录</a></dd>
                <dd><a href="/account.html?key=investor">投资人</a></dd>
               <!--  <dd><a href="/account/withdraw">提现</a></dd>
                <dd><a href="/account/balance">余额记录</a></dd>
                <dd><a href="/account/credits">积分</a></dd> -->
                <dd><a href="/account.html?key=setting">帐号设置</a></dd>
            </dl>
        </div>
        <!--end左边-->
        <div class="fr w_950 r_box">
            <c:if test="${key=='index'}">
    <h4 class="r_th"><b class="fl th_line_b">会员中心</b></h4>

    <div class="money_box gray_bj clearfix">
        <!-- <span class="fr"><a href="/account/withdraw" class="shop_btn round_s">去提现</a></span> -->
        <div class="r_cell">
            用户余额：
            <b class="orange_text font_30"><span class="eng font_18">&yen;</span>0.00</b>
            <span class="m_l_b">
                累计返利金额：
                <b class="orange_text font_30"><span class="eng font_18">&yen;</span>0.00</b>
            </span>
            <!-- <span class="m_l_b">
                积分：
                <b class="orange_text font_30">0</b>
            </span> -->
        </div>
    </div>

    <ul class="list_3 clearfix r_tool">
        <li>
            <a href="/account.html?key=setting"><span class="round_r tool_a png"></span><h4>手机绑定</h4></a>
            
                <p><span class="note_box_text round_m">已绑定</span></p>
            
        </li>
       <!--  <li>
            <a href="/account.html?key=setting"><span class="round_r tool_a tool_a2 png"></span><h4>通知邮箱</h4></a>
                <p><span class="note_box_text round_m note_box_gray">未绑定</span></p>
        </li> -->
        <li>
            <a href="/account.html?key=setting"><span class="round_r tool_a tool_a3 png"></span><h4>提现账号</h4></a>
            	<c:choose><c:when test="${customerInfo.zfb!=null &&customerInfo.zfb!='' }">
            		<p><span class="note_box_text round_m">已绑定</span></p>
            	</c:when>
            	<c:otherwise>
                	<p><span class="note_box_text round_m note_box_gray">未绑定</span></p>
                </c:otherwise>
            </c:choose>
        </li>
    </ul>
     </c:if>
     
     <c:if test="${key=='order'}">
	    <h4 class="r_th"><b class="fl th_line_b">交单记录</b></h4>
		    <!-- <div class="invest_order_stat">
		        累计投资: <b>¥0.0</b>
		        累计收益: <b><span title="返现">¥0.0</span> +
		        <span title="平台收益">¥0.0</span> =
		        <span title="合计">¥0.0</span></b>
		        综合年化: <b>0.0%</b>
		    </div> -->
		    <ul class="order_list">
		    <c:forEach items="${orders }" var="o">
		        <li>
			        <span class="order_list_logo"><fmt:formatDate value="${o.investdate }" pattern="yyyy年MM月dd日" /></span>
			        <span class="order_list_status">${o.isPaid==0?'审核中':'已发放' }</span>
			        <span class="order_list_desc">
			        ${
			        '平台'.concat(o.planId).concat('-').concat(o.plan.name).concat('-').concat(o.plan.product)
			        .concat('投资金额[').concat(o.plan.mount).concat('-').concat(o.plan.mountMax)
			        .concat(']-信一返利:').concat(o.plan.fanli).concat('%')
			        }
			        </span>
			        <span class="order_list_interest">投资额<b>${o.amount}</b></span>
			        <span class="order_list_rebate">返利<b>${o.amount*o.plan.fanli/100}<i></i></b></span>
			        <!-- <span class="order_list_detail">查看详情</span> -->
		        </li>
		    </c:forEach>
		    </ul>
		    <!-- <dl class="page">
		    <dt class="fl">共页，每页，共计</dt>
		    <dd class="r_cell">
		            <em>上一页</em>
		            <em>下一页</em>
		    </dd>
		</dl> -->
     </c:if>
     <c:if test="${key=='setting'}">
    <h4 class="r_th"><b class="fl th_line_b">帐号设置</b></h4>
    <ul class="safety_ul clearfix">
        <li class="clearfix">
            <span class="fr">
                <c:choose>
	            <c:when test="${customerInfo.name!=null}">
                <a href="#" class="safety_modify" id="nickname-change-btn">修改</a>
                </c:when>
	            <c:otherwise>
                <a href="#" class="safety_btn" id="nickname-change-btn">设置</a>
                </c:otherwise>
                </c:choose>
            </span>
            <span class="r_cell">
                <h5>昵称</h5>
                <c:choose>
	                <c:when test="${customerInfo.name!=null}">
	                	<p>昵称：${customerInfo.name }</p>
	                </c:when>
	                <c:otherwise>
	                    <p>您可以设置一个昵称用于公开显示。</p>
	                </c:otherwise>
                </c:choose>
            </span>
        </li>
        <!-- <li class="clearfix">
            <span class="fr">
            	<a href="#" class="safety_modify" id="mobile-change-btn">修改</a></span>
            <span class="r_cell">
                <h5>手机验证</h5>
                <p>您验证的手机： ${customerInfo.phone}</p>
            </span>
        </li> -->
        <li class="clearfix">
            <span class="fr">
	            <c:choose>
		            <c:when test="${customerInfo.qq !=null}">
	                <a href="#" class="safety_modify" id="qq-change-btn">修改</a>
	                </c:when>
		            <c:otherwise>
	                <a href="#" class="safety_btn" id="qq-change-btn">设置</a>
	                </c:otherwise>
                </c:choose>
            </span>
            <span class="r_cell">
                <h5>联系QQ</h5>
                <c:choose>
	                <c:when test="${customerInfo.qq!=null}">
                    <p>您的联系QQ：${customerInfo.qq}</p>
                     </c:when>
	            	<c:otherwise>
	                <p>您可以设置一个QQ方便沟通。</p>
                	</c:otherwise>
                </c:choose>
            </span>
        </li>
        <!-- 
        <li class="clearfix">
            <span class="fr">
                <a href="#" class="safety_btn" id="email-change-btn">
                    设置
                </a>
            </span>
            <span class="r_cell">
                <h5>通知邮箱</h5>
                
                    <p>用于接收通知信息，账户余额变动提醒，业务处理通知等。</p>
                
            </span>
        </li>
         -->
        <li class="clearfix">
            <span class="fr">
	             <c:choose>
		            <c:when test="${customerInfo.zfb !=null && customerInfo.zfb !=''}">
	                <a href="#" class="safety_modify" id="alipay-change-btn">修改</a>
	                </c:when>
		            <c:otherwise>
	                <a href="#" class="safety_btn" id="alipay-change-btn">设置</a>
	                </c:otherwise>
                </c:choose>
            </span>
            <span class="r_cell">
                <h5>提现帐号 </h5>
                <c:choose>
                <c:when test="${customerInfo.zfb !=null && customerInfo.zfb !=''}">
                	<p>您的支付宝账号：${customerInfo.zfb}</p>
                </c:when>
	            <c:otherwise>
                    <p>请先设置好账号，系统会核实，并对交单自动汇款。</p>
                </c:otherwise>
                </c:choose>
            </span>
        </li>
        
        <li class="clearfix">
            <span class="fr">
            	<a href="#" class="safety_modify" id="password-change-btn">修改</a>
            </span>
            <span class="r_cell">
                <h5>登录密码</h5>
                <p class="orange_text">互联网账号存在被盗风险，建议您定期更改密码以保护账户安全。</p>
            </span>
        </li>
        <!-- <li class="clearfix">
            <span class="fr"><a href="#" class="safety_modify" id="space-open-change-btn">开放</a></span>
            <span class="r_cell">
                <h5>空间访问权限</h5>
                <p class="orange_text">您可以关闭或者开放他人对您的空间的访问。当前状态：<b id="space-open-status">关闭</b></p>
            </span>
        </li> -->
    </ul>

    <div class="cd-popup" id="change-mobile-popup" style="display:none">
        <div class="cd-popup-container set_box">
            <ul class="pass_step clearfix">
                <div class="order_step_line"></div>
                <li class="first active">
                    <div class="order_step_line"></div>
                    <span class="round_r step_num_b">1</span>
                    <p>验证身份</p></li>
                <li>
                    <div class="order_step_line"></div>
                    <span class="round_r step_num_b">2</span>
                    <p>修改已验证手机</p></li>
                <li class="last">
                    <div class="order_step_line"></div>
                    <span class="round_r step_num_b">3</span>
                    <p>完成</p></li>
            </ul>
            <form method="post" action="">
                <input type="hidden" name="mobile" value="2beHx5td6PqAWQIW4b6xZga3HSIxsQG26DMu">
                <input type="hidden" name="type" value="50">
                <table class="fill_table blue_link">
                    <tr>
                        <th>已验证手机：</th>
                        <td><b class="font_20">${customerInfo.mobile}</b></td>
                    </tr>
                    <tr>
                        <th><label>请填写手机校验码：</label></th>
                        <td>
                            <input type="text" style="width:140px;" class="fill_text" name="code">
                            <a href="#" class="m_l send-user-mobile-code" data-mobile-code-type="50">获取验证码</a>
                        </td>
                    </tr>
                    <tfoot>
                    <tr>
                        <th></th>
                        <td><input type="submit" class="shop_btn round_s" value="下一步"></td>
                    </tr>
                    </tfoot>
                </table>
            </form>
            <a href="#" class="cd-popup-close"></a>
        </div>
    </div>
    <div class="cd-popup" id="change-mobile-new-popup" style="display:none">
        <div class="set_box cd-popup-container">
            <ul class="pass_step clearfix">
                <div class="order_step_line"></div>
                <li class="first active">
                    <div class="order_step_line"></div>
                    <span class="round_r step_num_b">1</span>
                    <p>验证身份</p></li>
                <li class="active">
                    <div class="order_step_line"></div>
                    <span class="round_r step_num_b">2</span>
                    <p>修改已验证手机</p></li>
                <li class="last">
                    <div class="order_step_line"></div>
                    <span class="round_r step_num_b">3</span>
                    <p>完成</p></li>
            </ul>
            <form method="post" action="">
                <input type="hidden" name="old_mobile" value="2beHx5td6PqAWQIW4b6xZga3HSIxsQG26DMu">
                <input type="hidden" name="old_mobile_code" value="">
                <table class="fill_table blue_link">
                    <tr>
                        <th><label>新手机号：</label></th>
                        <td><input type="text" class="fill_text" name="mobile"></td>
                    </tr>
                    <tr>
                        <th><label>新手机验证码：</label></th>
                        <td><input type="text" style="width:140px;" class="fill_text" name="mobile_code">
                            <a href="#" class="m_l"
                               onclick="return $.sendMobile('#change-mobile-new-popup input[name=mobile]', 51);">获取验证码</a>
                        </td>
                    </tr>
                    <tfoot>
                    <tr>
                        <th></th>
                        <td><input type="submit" class="shop_btn round_s" value="完成"></td>
                    </tr>
                    </tfoot>
                </table>
            </form>
            <a href="#" class="cd-popup-close"></a>
        </div>
    </div>
    <div class="cd-popup" id="change-mobile-complete-popup" style="display:none">
        <div class="set_box cd-popup-container">
            <div class="ok_box_s pass_ok orange_link link_line">
                <img src="/images/icon/ok_s.png" alt="" width="80" height="80">
                <h4>新手机设置成功！</h4>
                <p><a href="?" class="shop_btn round_s">确定</a></p>
            </div>
        </div>
    </div>

    <div class="cd-popup" id="change-nickname-popup" style="display:none">
        <div class="cd-popup-container">
            <div class="login_box">
                <h1>设置昵称</h1>
                <form method="post" action="">
                    <dl class="login_fill">
                        <dt>
                            <div class="input_div">
                                <input type="text" class="login_text" name="nickname" placeholder="昵称">
                            </div>
                        </dt>
                        <dd style="margin:1em 0 0em 0;">
                            <input type="submit" class="shop_btn login_btn" value="确定">
                        </dd>
                    </dl>
                </form>
            </div>
            <a href="#" class="cd-popup-close"></a>
        </div>
    </div>

    <div class="cd-popup" id="change-qq-popup" style="display:none">
        <div class="cd-popup-container">
            <div class="login_box">
                <h1>设置联系QQ</h1>
                <form method="post" action="">
                    <dl class="login_fill">
                        <dt>
                            <div class="input_div">
                                <input type="text" class="login_text" name="qq" placeholder="QQ号码">
                            </div>
                        </dt>
                        <dd style="margin:1em 0 0em 0;">
                            <input type="submit" class="shop_btn login_btn" value="确定">
                        </dd>
                    </dl>
                </form>
            </div>
            <a href="#" class="cd-popup-close"></a>
        </div>
    </div>

    <div class="cd-popup" id="change-email-popup" style="display:none">
        <div class="cd-popup-container">
            <div class="login_box">
                <h1>设置通知邮箱</h1>
                <form method="post" action="">
                    <dl class="login_fill">
                        <dt>
                            <div class="input_div">
                                <input type="text" class="login_text" name="email" placeholder="邮箱地址">
                            </div>
                        </dt>
                        <dd style="margin:1em 0 0em 0;">
                            <input type="submit" class="shop_btn login_btn" value="确定">
                        </dd>
                    </dl>
                </form>
            </div>
            <a href="#" class="cd-popup-close"></a>
        </div>
    </div>

    <div class="cd-popup" id="change-alipay-popup" style="display:none">
        <div class="cd-popup-container set_box">
            <ul class="pass_step clearfix">
            
                <div class="order_step_line"></div>
                <li class="first active">
                    <div class="order_step_line"></div>
                    <span class="round_r step_num_b">1</span>
                    <p>验证身份</p></li>
                <li>
                
                    <div class="order_step_line"></div>
                    <span class="round_r step_num_b">2</span>
                    <p>修改提现账号</p></li>
                <li class="last">
                    <div class="order_step_line"></div>
                    <span class="round_r step_num_b">3</span>
                    <p>完成</p></li>
            </ul>
            <form method="post" action="">
                <input type="hidden" name="mobile" value="2beHx5td6PqAWQIW4b6xZga3HSIxsQG26DMu">
                <input type="hidden" name="type" value="60">
                <table class="fill_table blue_link">
                    <tr>
                        <th>验证手机：</th>
                        <td><b class="font_20">${customerInfo.mobile}</b></td>
                    </tr>
                    <tr>
                        <th><label>请填写手机校验码：</label></th>
                        <td>
                            <input type="text" style="width:140px;" class="fill_text" name="code">
                            <a href="#" class="m_l send-user-mobile-code"  data-mobile-code-type="60">获取验证码</a>
                        </td>
                    </tr>
                    <tfoot>
                    <tr>
                        <th></th>
                        <td><input type="submit" class="shop_btn round_s" value="下一步"></td>
                    </tr>
                    </tfoot>
                </table>
            </form>
            <a href="#" class="cd-popup-close"></a>
        </div>
    </div>
    <div class="cd-popup" id="change-alipay-set-popup" style="display:none">
        <div class="set_box cd-popup-container">
            <ul class="pass_step clearfix">
                <div class="order_step_line"></div>
                <li class="first active">
                    <div class="order_step_line"></div>
                    <span class="round_r step_num_b">1</span>
                    <p>验证身份</p></li>
                <li class="active">
                    <div class="order_step_line"></div>
                    <span class="round_r step_num_b">2</span>
                    <p>修改提现账号</p></li>
                <li class="last">
                    <div class="order_step_line"></div>
                    <span class="round_r step_num_b">3</span>
                    <p>完成</p></li>
            </ul>
            <form method="post" action="">
                <input type="hidden" name="mobile" value="2beHx5td6PqAWQIW4b6xZga3HSIxsQG26DMu">
                <input type="hidden" name="mobile_code" value="">
                <table class="fill_table blue_link">
                    <tr>
                        <th><label>支付宝账号：</label></th>
                        <td><input type="text" class="fill_text" name="alipay"></td>
                    </tr>
                    <tr>
                        <th></th>
                        <td style="line-height:150%;">您可以直接填写您的支付宝帐号<br>也可以在帐号后面空一格并加上您的支付宝帐号姓名<br>例如: 18888888888 张三</td>
                    </tr>
                    <tfoot>
                    <tr>
                        <th></th>
                        <td><input type="submit" class="shop_btn round_s" value="完成"></td>
                    </tr>
                    </tfoot>
                </table>
            </form>
            <a href="#" class="cd-popup-close"></a>
        </div>
    </div>
    <div class="cd-popup" id="change-alipay-complete-popup" style="display:none">
        <div class="set_box cd-popup-container">
            <div class="ok_box_s pass_ok orange_link link_line">
                <img src="/images/icon/ok_s.png" alt="" width="80" height="80">
                <h4>提现账号设置成功！</h4>
                <p><a href="?" class="shop_btn round_s">确定</a></p>
            </div>
        </div>
    </div>

    <div class="cd-popup" id="change-password-popup" style="display:none">
        <div class="cd-popup-container">
            <div class="login_box">
                <h1>修改登录密码</h1>
                <form method="post" action="">
                    <dl class="login_fill">
                        <div class="input_div">
                            <span class="fl login_arrow login_arrow2 png"></span>
                            <div class="r_cell"><input type="password" name="password" class="login_text" placeholder="原密码"></div>
                        </div>
                        <div class="input_div">
                            <span class="fl login_arrow login_arrow2 png"></span>
                            <div class="r_cell"><input type="password" name="new_password" class="login_text" placeholder="新密码"></div>
                        </div>
                        <div class="input_div">
                            <span class="fl login_arrow login_arrow2 png"></span>
                            <div class="r_cell"><input type="password" name="new_password_confirm" class="login_text" placeholder="新密码确认"></div>
                        </div>
                        <div class="dd" style="padding: 10px;color: gray">
                            修改成功需要您重新登录
                        </div>
                        <dd style="margin:1em 0 0em 0;">
                            <input type="submit" class="shop_btn login_btn" value="确定">
                        </dd>
                    </dl>
                </form>
            </div>
            <a href="#" class="cd-popup-close"></a>
        </div>
    </div>

    <script>
        (function () {
            $('.cd-popup-close').click(function () {
                $('.cd-popup').hide();
                return false;
            });

            // 发送用户手机号验证码
            var mobileCodeSendWait = 0;
            var mobileCodeSendBtn = $('.send-user-mobile-code');
            function mobileCodeWait() {
                if (mobileCodeSendWait > 0) {
                    mobileCodeSendWait--;
                    mobileCodeSendBtn.text('重新发送验证码(' + mobileCodeSendWait + ')');
                    setTimeout(mobileCodeWait, 1000);
                } else {
                    mobileCodeSendBtn.text('重新发送验证码');
                }
            }
            mobileCodeSendBtn.click(function () {
                if (mobileCodeSendWait == 0) {
                    $.post('/api/mobile/send_code_encrypt', {mobile: '2beHx5td6PqAWQIW4b6xZga3HSIxsQG26DMu',
                        type: $(this).data('mobile-code-type')}, function (data) {
                        if (data.statusCode != 0) {
                            layer.msg(data.errorMessage);
                            return;
                        }
                        mobileCodeSendWait = 60;
                        mobileCodeWait();
                        layer.msg('已经发送验证码');
                    });
                }
                return false;
            });

            // 修改手机号
            $('#mobile-change-btn').click(function () {
                $('#change-mobile-popup').show();
                return false;
            });
            $.form('#change-mobile-popup form', '/api/mobile/encrypt_code_valid', function (data) {
                $('.cd-popup').hide();
                $('#change-mobile-new-popup').show();
                $('input[name=old_mobile_code]').val(data.code);
            });
            // 修改手机号，第二步
            $.form('#change-mobile-new-popup form', '/api/account/update_user_mobile', function (data) {
                $('.cd-popup').hide();
                $('#change-mobile-complete-popup').show();
            });

            // 修改昵称
            $('#nickname-change-btn').click(function () {
                $('#change-nickname-popup').show();
                return false;
            });
            $.form('#change-nickname-popup form', '/api/account/update_user_nickname', function (data) {
                layer.msg('昵称设置完成');
                $('.cd-popup').hide();
                setTimeout(function () {
                    location.reload();
                }, 1500);
            });

            // 修改邮箱
            $('#email-change-btn').click(function () {
                $('#change-email-popup').show();
                return false;
            });
            $.form('#change-email-popup form', '/api/account/update_user_email', function (data) {
                layer.msg('通知邮箱设置完成');
                $('.cd-popup').hide();
                setTimeout(function () {
                    location.reload();
                }, 1500);
            });

            // 修改QQ
            $('#qq-change-btn').click(function () {
                $('#change-qq-popup').show();
                return false;
            });
            $.form('#change-qq-popup form', '/api/account/update_user_qq', function (data) {
                layer.msg('联系QQ设置完成');
                $('.cd-popup').hide();
                setTimeout(function () {
                    location.reload();
                }, 1500);
            });

            // 提现账号
            $('#alipay-change-btn').click(function () {
                /* $('#change-alipay-popup').show(); */
                $('#change-alipay-set-popup').show();
                return false;
            });
           /*  $.form('#change-alipay-popup form', '/api/mobile/encrypt_code_valid', function (data) {
                $('.cd-popup').hide();
                $('#change-alipay-set-popup').show();
                $('#change-alipay-set-popup input[name=mobile_code]').val(data.code);
            }); */
            $.form('#change-alipay-set-popup form', '/api/account/update_user_alipay', function (data) {
                $('.cd-popup').hide();
                $('#change-alipay-complete-popup').show();
            });

            // 修改密码
            $('#password-change-btn').click(function () {
                $('#change-password-popup').show();
                return false;
            });
            $.form('#change-password-popup form', '/api/account/update_user_password', function (data) {
                layer.msg('新密码更新完成');
                $('.cd-popup').hide();
                setTimeout(function () {
                    location.reload();
                }, 1500);
            });

            // 空间权限设置
            $('#space-open-change-btn').click(function () {
                var $this = $(this);
                if ($this.text() == '正在设置') return;
                $this.text('正在设置');
                $.post('/api/space/toggle_open', function (data) {
                    $this.text(data.is_open ? '关闭' : '开启');
                    $('#space-open-status').text(data.is_open ? '开启' : '关闭');
                });
                return false;
            });
        })();
    </script>
     </c:if>
		
		<c:if test="${key=='investor'}">
		<h4 class="r_th"><b class="fl th_line_b">投资人</b></h4>

    <table class="list_table_o" style="margin-top:20px">
        <thead>
        <tr>
            <th width="25%">手机号</th>
            <th>真实姓名</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${investors }" var="inv">
	        <tr>
	            <td>${inv.investPhone }</td>
	            <td>${inv.investName }</td>
	            <td><a href="/api/account/investor?delid=${inv.id }" class="del_admin">删除</a></td>
	        </tr>
        </c:forEach>
        </tbody>
    </table>

    <div class="add_order">
        <a href="#" onclick="$('#add-investor').show();return false;" class="round_s add_s_btn">添加新帐号</a>
        <div class="add_fill_none" id="add-investor">
            <h4 class="th_a">使用新帐号</h4>
            <form action="" method="post" id="add-investor-form">
            <table class="fill_table">
                <tr>
                    <th><label for="phone1">手机号码</label></th>
                    <td><input type="text" class="fill_text" name="mobile">
                        <span class="note_orange">在平台投资所使用的手机号码</span>
                    </td>
                </tr>
                <tr>
                    <th><label for="name1">真实姓名</label></th>
                    <td>
                        <input type="text" class="fill_text" name="name">
                        <span class="note_gray">对应的真实姓名</span>
                    </td>
                </tr>
                <tfoot>
                <tr>
                    <th></th>
                    <td><input type="submit" class="shop_btn round_s" value="确定"></td>
                </tr>
                </tfoot>
            </table>
            </form>
        </div>
    </div>

<script>
$.form('#add-investor-form', '/api/account/investor', function (data) {
    location.reload();
});
</script>
		
		</c:if>
        </div>
    </div>

<jsp:include page="footer.jsp"></jsp:include>