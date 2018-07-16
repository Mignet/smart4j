<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<base href=" <%=basePath%>"> 
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="renderer" content="webkit"/>
    <meta name="viewport" content="width=1200"/>
    <title>理财返利_P2P网贷理财返利平台 - 信一返利网</title>
    <meta name="keywords" content="理财返利,理财返利网,理财返利平台,P2P返利,网贷返利,返利网"/>
    <meta name="description"
          content="信一返利网是一个理财返利平台隶属于互金网络旗下为您提供理财返利、P2P返利、网贷返利、投资返利等全方位高收益理财返利活动；价格优，服务好，返利快，公司运营。安全、轻松、好收益！"/>
    
    <link rel="stylesheet" type="text/css" href="assets/css/v1.css">
    <link rel="stylesheet" href="layui/css/layui.css">
    <script src="layui/layui.all.js"></script>
    <script>var ACCOUNT_IS_LOGIN = '${ACCOUNT_IS_LOGIN}';</script>
    <script src="js/jquery.min.js"></script>
    <script src="js/jquery.cookie.js"></script>
    <script src="js/jquery.easing.compatibility.js"></script>
    <script src="tipso/src/tipso.min.js"></script>
    <link rel="stylesheet" href="tipso/src/tipso.min.css">
    <script src="js/plupload/plupload.full.min.js"></script>
    <script src="assets/js/core.js"></script>
    <!--[if lt IE 9]>
        <script type="text/javascript" src="/js/html5.js"></script>
    <![endif]-->
</head>
<body>

    <div class="headerwrap" id="headerWrap">
    <div class="header_t min_1200">
        <dl class="header_t w_1200">
            <dt class="fl">
                
                <span class="fl" style="margin-right:2em">
                    <span class="h_a h_a_1 png"></span>
                    服务时间：<b class="font_14">9:00~23:00</b>
                </span>
                <span class="fl qq_box" style="margin-right:2em">
                    <span class="h_a h_a_2 png"></span>
                    官方QQ群
                    <div class="sec_qq">
                    <span class="sec_arrow png"></span>
                        <p><a target="_blank" href="//shang.qq.com/wpa/qunwpa?idkey=9ec032c4e60362a701bdb57c1f13cb57b32494b3aa870fefcd5e6ed9ab004693"><img src="images/icon/qq.gif" alt="qq" width="23" height="16">信一官方群：652512403</a></p>
                    </div>
                </span>
                <span class="fl qq_box">
                    <span class="h_a h_a_3 png"></span>
                    官方微信
                    <div class="sec_qq">
                    <span class="sec_arrow png"></span>
                        <p><img src="images/icon/wx_qr.png" alt="微信二维码" width="200" height="200"></p>
                    </div>
                </span>
            </dt>
            <dd class="fr">
            <c:choose>
			    <c:when test="${ACCOUNT_IS_LOGIN}">
			      	<span class="yellow_link"><a href="#">${customerInfo.name!=null&&customerInfo.name!=''?customerInfo.name:customerInfo.phone}</a></span>
				  	<em class="china">|</em>
				  	<a href="/news.html?type=2">消息</a>
					<em class="china">|</em>
					<a href="/news.html?type=1" style="color:orangered">新公告 <b>0</b></a>
					<em class="china">|</em>
					<a href="/account.html">余额：<b class="yellow_link">¥${customerInfo.money}.00</b></a>
					<em class="china">|</em>
					<a href="/account.html">会员中心</a> 
					<em class="china">|</em>
					<a href="/account/logout.html">退出</a>
			    </c:when>
			    <c:otherwise>
			    	<a href="#" onclick="$('#register-popup').show();return false">免费注册</a>
			       	<em class="china">|</em>
			       	<a href="#" onclick="$('#login-popup').show();return false">登录</a>
			    </c:otherwise>
			</c:choose>
                    <em class="china">|</em>
                <a href="/news.html?type=0">帮助</a>
            </dd>
        </dl>
    </div>
    <div class="header_c min_1200">
        <div class="w_1200">
            <h1 class="logo png_img fl"><a href="/"><img src="images/logo.png" alt="信一返利"></a></h1>
            <div class="tnav" id="slideNav">
            <c:choose>
            	<c:when test="${page==0 }">
            	<span><a href="/" class="current_nav">首页</a></span>
                <span><a href="/search.html?type=1">首投</a></span>
                <span><a href="/search.html?type=2">复投</a></span>
                <span><a href="/newbie.html" >新手指南</a></span>
            	</c:when>
            	<c:when test="${page==1 }">
            	<span><a href="/" >首页</a></span>
                <span><a href="/search.html?type=1" class="current_nav">首投</a></span>
                <span><a href="/search.html?type=2">复投</a></span>
                <span><a href="/newbie.html" >新手指南</a></span>
            	</c:when>
            	<c:when test="${page==2 }">
            	<span><a href="/">首页</a></span>
                <span><a href="/search.html?type=1">首投</a></span>
                <span><a href="/search.html?type=2" class="current_nav">复投</a></span>
                <span><a href="/newbie.html" >新手指南</a></span>
            	</c:when>
            	<c:when test="${page==3 }">
            	<span><a href="/">首页</a></span>
                <span><a href="/search.html?type=1">首投</a></span>
                <span><a href="/search.html?type=2" >复投</a></span>
                <span><a href="/newbie.html" class="current_nav">新手指南</a></span>
            	</c:when>
            	<c:otherwise>
	                <span><a href="/" >首页</a></span>
	                <span><a href="/search.html?type=1">首投</a></span>
	                <span><a href="/search.html?type=2">复投</a></span>
	                <span><a href="/newbie.html" >新手指南</a></span>
            	</c:otherwise>
            </c:choose>
            </div>
        </div>
    </div>
</div>

<c:if test="${!ACCOUNT_IS_LOGIN}">
    <div id="login-popup" class="cd-popup" style="display:none">
    <div class="cd-popup-container">
        <div class="login_box">
            <h1>账号登录</h1>
            <dl class="login_fill">
                <form method="post" action="/login" id="login-form">
                    <dt>
                        <div class="input_div">
                            <span class="fl login_arrow png"></span>
                            <div class="r_cell"><input type="text" id="login-popup-mobile" name="mobile" class="login_text" placeholder="手机号"></div>
                        </div>
                        <div class="input_div">
                            <span class="fl login_arrow login_arrow2 png"></span>
                            <div class="r_cell"><input type="password" name="password" class="login_text" placeholder="密码"></div>
                        </div>
                        <div class="d">
                            <!-- <span class="fr"><a href="/reset_password">忘记密码？</a></span> -->
                            <span class="sel_box">
                                <input type="checkbox" id="a-1" name="remember" value="yes"/>
                                <label for="a-1">自动登录</label>
                            </span>
                        </div>
                    </dt>
                    <dd><input type="submit" class="shop_btn login_btn" value="立即登录"></dd>
                    <dd style="padding-top:20px;text-align:center">
                        <a href="#" onclick="$('#login-popup').hide();$('#register-popup').show();return false">注册账号</a>
                    </dd>
                </form>
            </dl>
            
        </div>
        <a href="#" onclick="$('#login-popup').hide();return false" class="cd-popup-close"></a>
    </div>
</div>

<div id="register-popup" class="cd-popup" style="display:none">
    <div class="cd-popup-container">
        <div class="login_box">
            <h1>账号注册</h1>
            <dl class="login_fill">
                <form method="post" action="/register" id="register-form">
                    <dt>
                        <div class="input_div">
                            <span class="fl login_arrow png"></span>
                            <div class="r_cell"><input type="text" id="register-popup-mobile" name="mobile" class="login_text" placeholder="手机号码"></div>
                        </div>
                        <div class="input_div">
                            <span class="f_ma">
                                <a href="#" id="register_captcha_btn"><img id="register_captcha_image" src="images/captcha.png" width="100" height="30"></a>
                            </span>
                            <span class="fl login_arrow login_arrow3 png"></span>
                            <div class="r_cell"><input type="text" name="captcha" class="login_text" placeholder="验证码" id="register_captcha_input"></div>
                            <input type="hidden" name="captcha_data" id="register_captcha_data" value="">
                        </div>
                        <div class="dd">
                            <label for="register-agreement">
                                <input type="checkbox" id="register-agreement" name="agreement" checked>
                                我已同意<a href="/news/6.html" target="_blank">《信一返利网站服务协议》</a>
                            </label>
                        </div>
                    </dt>
                    <dd style="margin:1em 0 0em 0;">
                        <input type="submit" class="shop_btn login_btn" id="register-submit" value="立即注册">
                    </dd>
                </form>
            </dl>
        </div>
        <a href="#" onclick="$('#register-popup').hide();return false" class="cd-popup-close"></a>
    </div>
</div>

<div id="register-info-popup" class="cd-popup" style="display:none">
    <div class="cd-popup-container" style="margin-top:150px;">
        <div class="login_box">
            <h1>账号注册</h1>
            <dl class="login_fill">
                <form method="post" action="/register" id="register-info-form">
                    <dt>
                        <div class="input_div">
                            <span class="fl login_arrow png"></span>
                            <div class="r_cell"><input type="text" id="register-info-popup-mobile" name="mobile"
                                                       class="login_text" readonly></div>
                        </div>
                        <div class="input_div">
                            <span class="f_ma2"><a href="#" id="resend-mobile-code">重新发送验证码</a></span>
                            <span class="fl login_arrow login_arrow3 png"></span>
                            <div class="r_cell"><input type="text" id="register-info-popup-mobile-code"
                                                       name="mobile_code"
                                                       class="login_text" placeholder="手机验证码"></div>
                        </div>
                        <div class="input_div">
                            <span class="fl login_arrow login_arrow_qq png"></span>
                            <div class="r_cell"><input type="text" name="qq" class="login_text"
                                                       placeholder="QQ号码,用于客服联系"></div>
                        </div>
                        <div class="input_div">
                            <span class="fl login_arrow login_arrow2 png"></span>
                            <div class="r_cell"><input type="password" class="login_text" name="password"
                                                       placeholder="设置登录密码"></div>
                        </div>
                        
                    </dt>
                    <dd style="margin:1em 0 0em 0;">
                        <input type="submit" class="shop_btn login_btn" value="完成注册">
                    </dd>
                </form>
            </dl>
        </div>
        <a href="#" onclick="$('#register-info-popup').hide();return false" class="cd-popup-close"></a>
    </div>
</div>

<script>
(function(){
    function getCaptcha() {
        $('#register_captcha_input').val('');
        $.getJSON('/api/captcha/new.json',function(r){
            $('#register_captcha_image').attr('src', r.image);
            $('#register_captcha_data').val(r.key);
        });
    }

    $('#register_captcha_btn').click(function () {
        getCaptcha();
        return false;
    });

    $('#register_captcha_input').focus(function(){
        if ($('#register_captcha_data').val() == '') {
            getCaptcha();
        }
    });

    var resendMobileCode = $('#resend-mobile-code');
    var resendMobileCodeData = null;
    var mobileCodeSendWait = 60;

    function mobileCodeWait() {
        if (mobileCodeSendWait > 0) {
            mobileCodeSendWait--;
            resendMobileCode.text('重新发送验证码(' + mobileCodeSendWait + ')');
            setTimeout(mobileCodeWait, 1000);
        } else {
            resendMobileCode.text('重新发送验证码');
        }
    }

    resendMobileCode.click(function () {
        if (mobileCodeSendWait == 0) {
            $.post('/api/mobile/send_code_encrypt', {'mobile': resendMobileCodeData,
                'type': 10 }, function () {
                mobileCodeSendWait = 60;
                mobileCodeWait();
            });
        }
        return false;
    });

    $('#register-form').submit(function () {
        var mobile = $('#register-popup-mobile').val();
        if($('#register-popup-mobile').val()==''){
        	layer.msg('手机号未输入');
        	return false;
        }
        if($('#register_captcha_input').val()==''){
        	layer.msg('验证码未输入');
        	return false;
        }
        if($('#register_captcha_input').val()!=$('#register_captcha_data').val()){
        	layer.msg('验证码不正确');
        	return false;
        }
        $.post('/api/account/register_send_code', $(this).serializeArray(), function (data) {
        	console.log(data);
        	if (!data.success && data.message == '已经注册') {
                layer.msg('您已经注册过，可以直接登录');
                $('#register-popup').hide();
                $('#login-popup').show();
                $('#login-popup-mobile').val(mobile);
                return;
        	}
            if (!data.success) {
                layer.msg(data.message);
                return;
            }
          //询问框

            layer.confirm('注册成功，默认密码是手机号后六位,请及时修改您的密码！', {
              btn: ['OK'] //按钮
            }, function(){
              //layer.msg('的确很重要', {icon: 1});
              location.reload();
              //setTimeout(function(){location.reload();},5000);
            });
            //layer.msg('注册成功，默认密码是手机号后六位,请及时修改您的密码！');
            $('#register-popup').hide();
            /* $('#register-info-popup').show();
            $('#register-info-popup-mobile').attr('value', mobile);
            $('#register-info-popup-mobile-code').focus();
            resendMobileCodeData = data.mobileEncrypt;
            mobileCodeWait(); */
            
            
        });
        return false;
    });

 /*    $.form('#register-info-form', '/account/register_send_code', function (data) {
        window._hmt.push(['_trackEvent', 'account', 'register']);
        layer.msg("注册成功!");
        setTimeout(function () {
          location.reload();
        }, 2000);
    }); */

    $('#register-agreement').click(function () {
        $('#register-submit').attr('disabled', !$(this).is(':checked'));
    });

    $('#login-form').submit(function () {
        $.post('/api/account/login', $(this).serializeArray(), function (data) {
            if (!data.success) {
                var v = [{field:'mobile',message:data.message}];
                $.formErrorsRender('#login-form', v);
                return;
            }
            console.log(data);
            location.reload();
        });
        return false;
    });
})();
</script>
</c:if>
