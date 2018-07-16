<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="clearfix footer min_1200">
    <div class="clearfix footer w_1200">
        <ul class="fl footer_ul list_3">
            <li>
                <h5><span class="round_r f_arrow png"></span>关于我们</h5>
                <p><a href="/news/8.html">了解官方</a></p>
                <p><a href="/news/8.html">加入我们</a></p>
                <p><a href="/news/8.html">合作联系</a></p>
            </li>
            <li>
                <h5><span class="round_r f_arrow f_arrow2 png"></span>帮助中心</h5>
                <p><a href="/newbie.html">新手指南</a></p>
                <p><a href="/news.html?type=0">注册登录</a></p>
                <p><a href="/news.html?type=0">投资流程</a></p>
                <p><a href="/news.html?type=0">提现申请</a></p>
            </li>
            <li>
                <h5><span class="round_r f_arrow f_arrow3 png"></span>产品服务</h5>
                <p><a href="/search.html?type=1">首投活动</a></p>
                <p><a href="/search.html?type=2">复投活动</a></p>
            </li>
        </ul>
        <div class="r_cell footer_share">
            <h5><span class="round_r f_arrow f_arrow4 png"></span>关注我们</h5>
            <div class="d">
                <span class="fr">
                    <img src="images/icon/wap_qrcode.png" alt="" width="100" height="100"><p>手机wap端</p>
                </span>
                <span class="fl">
                    <img src="images/icon/wechat_qrcode.png" alt="" width="100" height="100"><p>关微微信公众号</p>
                </span>
            </div>
        </div>
    </div>
</div>

<div class="min_1200 clearfix footer_d">
    <dl class="w_1200 clearfix footer_d">
        <dt class="fl">
            <a href="#">理财返利</a>
            <em class="china">|</em>
            <a href="/search.html?type=1">首投活动</a>
            <em class="china">|</em>
            <a href="/search.html?type=2">复投活动</a>
            <em class="china">|</em>
            <a href="/news.html?type=1">官方公告</a>
            <em class="china">|</em>
            <a href="/news.html?type=0">帮助中心</a>
            <p>&copy; 2018 信一网络科技有限公司 <a href="#">理财返利平台</a> </p>
        </dt>
        <dd class="r_cell">
            <a href="#" class="f_a"></a>
            <a href="#" class="f_a f_a2"></a>
            <a href="#" class="f_a f_a3"></a>
            <a href="#" class="f_a f_a4"></a>
            <a href="#" class="f_a f_a5"></a>
            <a href="#" class="f_a f_a6"></a>
        </dd>
    </dl>
</div>

    <div class="ftool" id="ftool">
    <div class="ftool_top ftool_item">
        <a href="#" class="top_ftoolab ftoolab png" id="ftoolTop"></a>
    </div>
    <!-- <div class="ftool_tel ftool_item">
        
        <a href="//tb.53kf.com/webCompany.php?arg=10164381&style=1&u_cust_id=&u_cust_name=" target="_blank" class="tel_ftoolab ftoolab png"></a>
        <div class="ftool_code ftool_code_s">在线客服
            <div class="ftool_code_gt">◆</div>
        </div>
    </div> -->
    <div class="ftool_wechat ftool_item">
        <a href="#" class="wechat_ftoolab ftoolab png"></a>
        <div class="ftool_code">
            <img src="images/icon/wap_qrcode.png" alt="" class="ftool_code_img"/>
            <div class="ftool_code_gt">◆</div>
        </div>
    </div>
    <div class="ftool_qq ftool_item">
        <a href="#" class="qq_ftoolab ftoolab png"></a>
        <div class="ftool_code ftool_code_qq">
            <p><a target="_blank" href="//wpa.qq.com/msgrd?v=3&uin=414628710&site=qq&menu=yes"><img border="0" src="images/icon/qq.gif" alt="点击这里给我发消息" title="点击这里给我发消息"/></a> 客服 QQ：414628710</p>
            <div class="ftool_code_gt">◆</div>
        </div>
    </div>
    <div class="ftool_phone ftool_item">
        <a href="#" class="phone_ftoolab ftoolab png"></a>
        <div class="ftool_code">
            <img src="images/icon/wechat_qrcode.png" alt="" class="ftool_code_img"/>
            <div class="ftool_code_gt">◆</div>
        </div>
    </div>
</div>


    <script src="assets/js/index.js"></script>
    


<div id="send-mobile-code-popup" class="cd-popup" style="display:none">
    <div class="cd-popup-container">
        <div class="login_box">
            <h1></h1>
            <dl class="login_fill">
                <form method="post" action="">
                    <input type="hidden" name="type" value="">
                    <dt>
                    <div class="input_div">
                            <span class="f_ma">
                                <a href="#" id="send-mobile-code-popup-img"><img src="images/captcha.png" width="100"
                                                                                 height="30"></a>
                            </span>
                        <span class="fl login_arrow login_arrow3 png"></span>
                        <div class="r_cell">
                            <input type="text" name="captcha" class="login_text" placeholder="图像验证码">
                            <input type="hidden" name="mobile" value="">
                        </div>
                        <input type="hidden" name="captcha_data" value="">
                    </div>
                    </dt>
                    <dd style="margin:1em 0 0em 0;">
                        <input type="submit" class="shop_btn login_btn" value="获取手机验证码">
                    </dd>
                </form>
            </dl>
        </div>
        <a href="#" onclick="$('#send-mobile-code-popup').hide();return false" class="cd-popup-close"></a>
    </div>
</div>

<!-- <script>
    var _hmt = _hmt || [];
    (function () {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?ba001070a9b2ab85e9ebf49d3c34b14f";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();
</script> -->
<!-- <script type="text/javascript" src="//tb.53kf.com/kf.php?arg=10164381&style=1&u_cust_id=&u_cust_name="></script> -->
</body>
</html>