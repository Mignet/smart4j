<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="head.jsp"></jsp:include>
<!-- start index home page -->

<!--  <dl class="site_th w_1200">
        <dd>当前位置：<a href="/">信一返利</a>
            <em class="china">&gt;</em>
            
            
                <a href="/first">首投活动</a>
                <em class="china">&gt;</em>
                <a href="/first/A">保守区</a>
            
            <em class="china">&gt;</em>
            第1期
        </dd>
    </dl> -->

    <div class="w_1200 box_d clearfix" style="margin-top:1em;">
        <table>
        <tr><td class="w_750 white_box">
            <h2 class="display_th clearfix">
                <div class="fr">
                    <p>
                        <div class="text_box_box round_m">
                            <span class="text_box_th round_m">${platform.rcTypeMsg }</span>
                            <span>${platform.rcType }</span>
                        </div>
                    </p>
                </div>
                <div class="r_cell png_img">
                    <div class="brand_logo_t">
                        <img src="${platform.logo}" alt="${platform.name }" height="40">
                        <c:choose> 
						  <c:when test="${platform.aors==3}">   
						   	<span class="text_box round_s">首投</span>
						    <span class="text_box text_box_orange round_s">复投</span>
						  </c:when> 
						  <c:when test="${platform.aors==2}">   
						    <span class="text_box text_box_orange round_s">复投</span>
						  </c:when> 
						  <c:otherwise>   
						    <span class="text_box round_s">首投</span>
						  </c:otherwise> 
						</c:choose> 
                    </div>
                </div>
            </h2>
            <ul class="display_note clearfix" id="activity-info-area">
                <li class="clearfix li_o">
                    <span class="fl">最高返利方案：</span>
                    <div class="r_cell">
                        投 ${mount}
                        获得<b class="orange_text font_20">${maxMount}</b>元，
                        年化<b class="orange_text font_20">≈ ${maxYear }%</b>
                        (方案: <b>${maxPlan }</b>)
                        <div class="btn">
                            
                            <a href="#" id="activity-join-btn"
                               class="shop_btn round_s transition_a">立即参与</a>
                            
                            <a href="#" id="activity-calc" class="shop_btn calc_btn">试算</a>
                            <span class="m_l_b">已有<b class="orange_text font_20">${platform.maxInvestors }</b>人参加</span>
                            
                        </div>
                    </div>
                </li>
                
                <li class="clearfix li_o">
                    <span class="fl">平台介绍：</span>
                    <div class="r_cell">
                        ${platform.memo }
                        <div class="display_key round_m_a">
                             <c:forEach items="${platform.tags.split(',') }" var="tag">
                                	<a href="javascript:;">${tag}</a>
                                </c:forEach>
                               <a href="${platform.url==null?'http://ipc.ducaishe.com/Home/Index/details.html?name='.concat(platform.name):platform.url }" target="_blank">查看神盾风控报告</a>
                        </div>
                    </div>
                </li>
            </ul>
            <div id="activity-join-area-loading" class="display_note clearfix"
                 style="display:none;border-top: 1px solid #eee;text-align:center;padding: 30px 0;">
                获取中,请稍等...
            </div>
            <div id="activity-join-area-error" class="display_note clearfix"
                 style="display:none;border-top: 1px solid #eee;text-align:center;padding: 30px 0;color:red;"></div>
            <div id="activity-join-area-success" class="display_note clearfix"
                 style="display:none;border-top: 1px solid #eee;text-align:center;padding: 30px 0;">
                <p style="margin-bottom:20px;">已经收到您提交的信息，您可以在会员中心查看处理进度</p>
                <a href="#" id="activity-join-area-success-detail-btn" class="layui-btn layui-btn-normal" target="_blank">查看详细信息</a>
                <button type="button" class="layui-btn layui-btn-normal" id="activity-join-area-success-btn">完成</button>
            </div>
            <div id="activity-join-area-first" class="display_note clearfix"
                 style="display:none;border-top: 1px solid #eee;text-align:center;padding: 30px 0;">
                <p style="margin-bottom:20px;">第一步：前往平台投资 <span class="china">&gt;&gt;</span> 第二步：投资完成回来交单</p>
                
                    <a href="/api/a/${platform.id}/open" class="layui-btn layui-btn-danger"
                           target="_blank">1.打开投资链接</a>
                
                <a href="#" class="layui-btn layui-btn-warm" id="activity-first-submit-btn">2.投资完成填写回单</a>
            </div>
            <div id="activity-join-area" class="display_note clearfix" style="display:none;border-top: 1px solid #eee;">
                <div class="act-join-title">
                    <a href="#" class="layui-btn layui-btn-primary layui-btn-mini" id="activity-submit-back-btn">&lt; 返回</a>
                    <i class="layui-icon">&#xe63c;</i> 第二步：填写回单
                </div>
                <form class="layui-form act-join-form" action="" method="post" id="activity-form">
                    <input type="hidden" name="activity_id" value="65">
                    <div class="layui-form-item">
                        <label class="layui-form-label">投资人</label>
                        <div class="layui-input-inline" style="width: 320px;">
                            <select name="investor" lay-verify="required">
                                <option></option>
                            </select>
                        </div>
                        <div class="select-right layui-word-aux">
                            <button type="button" id="add-investor-btn" class="layui-btn layui-btn-small layui-btn-normal">
                                <i class="layui-icon">&#xe608;</i> 添加
                            </button>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">投资方案</label>
                        <div class="layui-input-inline">
                            <select name="plan" lay-verify="required">
                                <option></option>
                            </select>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">投资金额</label>
                        <div class="layui-input-inline">
                            <input type="text" name="deposit" lay-verify="required|number" placeholder="￥"
                                   autocomplete="off" class="layui-input">
                        </div>
                        <div class="layui-form-mid layui-word-aux">请填写数字，例如：15000</div>
                    </div>
                    <div class="layui-form-item" style="display:none" id="activity-join-form-username">
                        <label class="layui-form-label">用户名</label>
                        <div class="layui-input-inline">
                            <input type="text" name="username" placeholder="对方平台要求提供用户名"
                                   autocomplete="off" class="layui-input">
                        </div>
                        <div class="layui-form-mid layui-word-aux">请输入在投资平台注册的用户名</div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">投资日期</label>
                        <div class="layui-input-inline" style="width:120px">
                            <input class="layui-input" id="invDate" name="date" lay-verify="required|date" placeholder="点击选择日期" >
                        </div>
                        <div class="layui-input-inline" style="display:none" id="activity-join-form-images">
                            <div class="layui-form-mid">投资截图</div>
                            <button type="button" class="layui-btn layui-btn-normal" id="activity-join-form-images-btn" style="width:123px;">
                                <i class="layui-icon">&#xe62f;</i>
                                <span>上传</span>
                            </button>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-input-block">
                            <button class="layui-btn layui-btn-warm" lay-submit lay-filter="postOrder">立即交单</button>
                            <span style="margin-left:10px;">严禁交假单，违者封号处理</span>
                        </div>
                    </div>
                </form>
            </div>
        </td>
        <td width="30"></td>
        <td class="w_420 white_box">
            <ul class="display_data clearfix">
                <li class="clearfix li_o">
                    <span class="fl text_l">风控信息</span>
                    <div class="r_cell r_text">
                        <ul class="tag_ul clearfix tag_ul_green list_2">
                            <li><span class="tag_a tag_a_box round_m">风控评级：${platform.rcLevel }</span></li>
                            <li><span class="tag_a tag_a_box round_m">${platform.rcTypeMsg }</span></li>
                        </ul>
                    </div>
                </li>
                <li class="clearfix li_o">
                    <span class="fl text_l">背景</span>
                    <div class="r_cell text_c r_text">
                        <div class="fr w_5">
                            <div class="text_box_g round_s">平台背景：${platform.bgPt }</div>
                        </div>
                        <div class="fl w_5">
                            <div class="text_box_g round_s">融资背景：${platform.bgRz }</div>
                        </div>
                    </div>
                </li>
                <li class="clearfix li_o">
                    <span class="fl text_l">银行存管</span>
                    <div class="r_cell r_text">
                        <div class="text_box_g round_s">${platform.bank }</div>
                    </div>
                </li>
                
                <li class="clearfix li_o">
                    <span class="fl text_l">ICP证</span>
                    <div class="r_cell r_text">
                        <div class="text_box_g round_s">${platform.icp }</div>
                    </div>
                </li>
                <li class="clearfix li_o">
                    <span class="fl text_l">提现速度</span>
                    <div class="r_cell r_text">
                        <div class="text_box_g round_s">${platform.txSpeed }</div>
                    </div>
                </li>
                <li class="clearfix li_o">
                    <span class="fl text_l">基本资料</span>
                    <div class="r_cell r_text">
                        <div class="text_box_g round_s">${platform.cname }</div>
                        <div class="o_text o_text">
                            <div class="fr w_5">
                                <div class="text_box_g round_s">上线：<fmt:formatDate value="${platform.onlinetime }" pattern="yyyy年MM月dd日" /></div>
                            </div>
                            <div class="fl w_5">
                                <div class="text_box_g round_s">注册资本：${platform.zczb }</div>
                            </div>
                        </div>
                    </div>
                </li>
                <li class="clearfix li_o li_more">
                    <span class="fl text_l">友情提示</span>
                    <div class="r_cell r_text text_c">
                        <div class="text_box_g text_box_g2 round_s">理财不等于存款，网贷有风险，投资需谨慎</div>
                    </div>
                </li>
            </ul>
            <p style="padding:25px;padding-top:0;color:#888;">免责声明：返利频道页面中的活动均来自平台方，仅作活动展示，不代表平台安全性，不构成投资建议！投资有风险，参考收益不代表最终真实到手收益。请谨慎选择参与活动，信一返利网将不承担相关责任！</p>
        <td></tr></table>
    </div>
	<!-- 方案 -->
    <div class="w_1200 box_d clearfix white_box">
        <table class="list_table">
            <thead>
            <tr>
                <th>#</th>
                <th>方案</th>
                <th>投资项目</th>
                <th>投资金额</th>
                <th width="80" class="orange_text">信一返利</th>
                <th width="10"></th>
                <th width="80" class="orange_text">信一奖励</th>
                <th>参考年化利率</th>
                <th>红包</th>
                <th>体验金</th>
                <th>其他</th>
                <th>周期</th>
                <th>总收益(参考)</th>
                <th>综合年化(参考)</th>
                <th>返利周期</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${planList}" var="plan" varStatus="s">
	            <tr>
	                <td width="30">${s.count}</td>
	                <td>
	                    <span class="text_box round_s">${plan.type==0?"首投":"复投"}</span>
	                    
	                    <b class="gray_text_b">${plan.name}</b>
	                </td>
	                <td>${plan.product}</td>
	                <td><b class="gray_text_b">${plan.mount} - ${plan.mountMax}</b></td>
	                <td><b class="orange_text">${plan.fanli}%</b></td>
	                <td><b style="font-size:16px;">+</b></td>
	                <td>${plan.jiangli}</td>                
	                <td>${plan.yearate}%</td>
	                <td>¥${plan.hongbao}</td>
	                <td>收益:¥${plan.tiyanjin}</td>
	                <td>¥${plan.other}</td>
	                <td>≈ ${plan.touzizhouqi}天</td>
	                <td>≈ ${plan.shouyi}+</td>
	                <td>≈ ${plan.yearfee}%</td>
	                <td>${plan.fanlizhouqi}</td>
	            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <div class="w_1200 box_d clearfix white_box">
        <div class="display_explain">
            <h4 class="d_th_line"><b>详细说明</b></h4>
            <div class="d_text">
	            <p style="margin-bottom:15px;padding-bottom:15px;border-bottom:1px solid #eee">
					${platform.detail }
				</p>
			</div>
        </div>
    </div>

    <div class="w_1200 box_d clearfix white_box">
        <h4 class="d_th_line"><b>QQ群</b></h4>
        <div class="qq_box_more clearfix">
            <p><a target="_blank" href="//shang.qq.com/wpa/qunwpa?idkey=9ec032c4e60362a701bdb57c1f13cb57b32494b3aa870fefcd5e6ed9ab004693"><img src="/images/icon/qq.gif" alt="qq" width="23" height="16">信一官方群：652512403</a></p>
        </div>
    </div>

    <div class="w_1200 box_d clearfix white_box">
        <h4 class="d_th_line"><b>免责声明</b></h4>
        <div class="d_text">
            <p>
                返利频道页面中的活动均来自平台方，仅作活动展示，不代表平台安全性，不构成投资建议！投资有风险，参考收益不代表最终真实到手收益。
                请谨慎选择参与活动，信一返利网将不承担相关责任！
            </p>
        </div>
    </div>

    

<div id="add-investor-temp" style="display: none;">
<form class="layui-form add-investor-form" action="" method="post" id="add-investor-form">
  <div class="layui-form-item">
    <label class="layui-form-label">手机号码</label>
    <div class="layui-input-block">
      <input type="text" name="mobile" required  lay-verify="required|phone" placeholder="请输入手机号码" autocomplete="off" class="layui-input">
    </div>
  </div>
    <div class="layui-form-item">
    <label class="layui-form-label">真实姓名</label>
    <div class="layui-input-block">
      <input type="text" name="name" required  lay-verify="required" placeholder="真实姓名" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn layui-btn-normal" lay-submit lay-filter="postInvestor">添加</button>
    </div>
  </div>
</form>
</div>
<div id="activity-get-qrcode-popup" class="cd-popup" style="display:none">
    <div class="cd-popup-container">
        <div class="login_box">
            <h1>请用手机扫描下方二维码</h1>
            <div id="activity-get-qrcode-popup-content" style="padding:20px;text-align:center;"></div>
        </div>
        <a href="#" onclick="$('#activity-get-qrcode-popup').hide();return false" class="cd-popup-close"></a>
    </div>
</div>

<div id="upload-popup" class="cd-popup" style="display:none">
    <div class="cd-popup-container">
        <div class="login_box">
            <h1>正在上传图片</h1>
            <dl class="login_fill">
            </dl>
        </div>
    </div>
</div>

<div id="clac-popup" class="cd-popup" style="display:none">
    <div class="cd-popup-container">
        <div class="login_box" style="padding-bottom:15px;">
            <h1>投资收益试算</h1>
            <form class="layui-form" action="" id="clac-form" style="margin-top:20px;">
            <div class="layui-form-item">
                <label class="layui-form-label">投资方案</label>
                <div class="layui-input-inline">
                    <select name="plan" lay-verify="required">
                        <c:forEach items="${planList}" var="plan">
                        	<option value="${plan.fanli},${plan.jiangli},${plan.yearate},${plan.touzizhouqi},${plan.type==1?0:(plan.hongbao+plan.other)}">${plan.name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">投资金额</label>
                <div class="layui-input-inline" style="width:120px;">
                    <input type="text" name="deposit" lay-verify="required|number" placeholder="￥" value="${mount}"
                           autocomplete="off" class="layui-input">
                </div>
                <div class="layui-input-inline" style="width:60px;">
                    <button class="layui-btn layui-btn-warm" style="padding:0;text-align:center;width:100%" lay-submit lay-filter="clac">计算</button>
                </div>
            </div>
            <dl id="clac-result">
                <dt>信一返现</dt><dd class="_r"><b></b> 元</dd>
                <dt>信一奖励</dt><dd class="_rp"><b></b> 元</dd>
                <dt>赠送积分</dt><dd class="_c"><b></b></dd>
                <dt>平台收益</dt><dd class="_p">≈ <b></b> 元</dd>
                <dt>总计可得</dt><dd class="_t">≈ <b></b> 元</dd>
            </dl>
            </form>
        </div>
        <a href="#" onclick="$('#clac-popup').hide();return false" class="cd-popup-close"></a>
    </div>
</div>

<script>

(function(){
	/* var now = new Date();
	$('#invDate').val(now.getFullYear()+"-"+(now.getMonth()+1)+"-"+now.getDate()); */
	layui.use('laydate', function(){
		  var laydate = layui.laydate;
		  
		  //执行一个laydate实例
		  laydate.render({
		    elem: '#invDate' //指定元素
		    ,value:new Date()
		    ,min: -30
		    ,max: 0
		  });
		});
    var form = layui.form;
    var uploadPopup = $('#upload-popup');
    var joinBtn = $('#activity-join-btn');
    var infoArea = $('#activity-info-area');
    var joinArea = $('#activity-join-area');
    var joinAreaLoading = $('#activity-join-area-loading');
    var joinAreaError = $('#activity-join-area-error');
    var joinAreaSuccess = $('#activity-join-area-success');
    var joinAreaSuccessBtn = $('#activity-join-area-success-btn');
    var joinFirst = $('#activity-join-area-first');
    var firstSubmitBtn = $('#activity-first-submit-btn');
    var investorEmpty = false;
    var requiredImage = false;
    var uploadedFiles = [];

    $('#activity-submit-back-btn').click(function () {
        infoArea.hide();
        joinAreaLoading.hide();
        joinArea.hide();
        joinFirst.show();
        return false;
    });

    firstSubmitBtn.click(function () {
        joinFirst.hide();
        joinAreaLoading.show();
        $.get('/api/a/${platform.id}/join', function (data) {
            joinAreaLoading.hide();
            if (data.statusCode != 0) {
                joinAreaError.show().text(data.errorMessage);
                return;
            }

            uploadedFiles = [];
            joinArea.show();

            if (data.requiredUsername) {
                $('#activity-join-form-username').show();
                $('#activity-join-form-username [name=username]').attr('lay-verify', 'required');
            } else {
                $('#activity-join-form-username').hide();
                $('#activity-join-form-username [name=username]').removeAttr('lay-verify');
            }

            if (data.requiredImage) {
                $('#activity-join-form-images').show();
                requiredImage = true;
            } else {
                $('#activity-join-form-images').hide();
                requiredImage = false;
            }

            var investor = $("select[name='investor']", joinArea);
            if (data.investorList.length > 0) {
                investor.empty();
                $.each(data.investorList, function(i, n){
                    investor.append("<option value='"+ n.id +"'>"+ n.investPhone + "  " +  n.investName +"  (已参与"+ (n.count? n.count:0) +"次)</option>");
                });
                investorEmpty = false;
            } else {
                investor.append('<option>请添加投资人</option>');
                investorEmpty = true;
            }

            var plan = $("select[name='plan']", joinArea);
            plan.empty();
            $.each(data.planList, function(i, n){
                plan.append("<option value='"+ n.id +"'>"+ n.name + ' - ' + n.product + "</option>");
            });

            form.render('select');
        });

        return false;
    });

    joinBtn.click(function () {
        if (!${ACCOUNT_IS_LOGIN}) {
            $('#login-popup').show();
            return false;
        }
        if (${platform.status==0}) {
        	layer.msg('活动不可参与');
            return false;
        }
        infoArea.hide();
        joinFirst.show();
        return false;
    });

    joinAreaSuccessBtn.click(function () {
        location.reload();
        /*
        infoArea.show();
        joinAreaSuccess.hide();
        $('#activity-form')[0].reset();
        $('#activity-join-form-images-btn span').text('上传');
        */
    });

    var uploader = new plupload.Uploader({
        browse_button: 'activity-join-form-images-btn',
        flash_swf_url: '/js/plupload/Moxie.swf',
        silverlight_xap_url: '/js/plupload/Moxie.xap',
        file_data_name: 'image',
        url: '/api/upload/upload_image?loginToken=',
        filters : {
            max_file_size : '1mb',
            mime_types: [
                {title : "Image files", extensions : "jpg,gif,png"}
            ]
        },
        init: {
            FilesAdded: function(up, files) {
                uploadPopup.show();
                var content = uploadPopup.find('dl');
                content.empty();
                plupload.each(files, function(file) {
                    content.append('<dd id="' + file.id + '">' + file.name + ' (' + plupload.formatSize(file.size) + ') <b>等待中</b></dd>');
                });
                uploader.start();
            },
            UploadProgress: function(up, file) {
                $('#' + file.id + ' b').text(file.percent + '%');
            },
            FileUploaded: function(up, file, result) {
                var data = $.parseJSON(result.response);
                uploadedFiles.push(data.id);
            },
            UploadComplete: function (up, files) {
                uploadPopup.hide();
                $('#activity-join-form-images-btn span').text('已上传' + uploadedFiles.length + '张');
            },
            Error: function(up, err) {
                layer.msg('上传图片错误：' + err.message);
            }
        }
    });
    uploader.init();

    var index_add_investor;

    $("#add-investor-btn").click( function () {
        index_add_investor = layer.open({
          type: 1,
          title: '添加投资人信息',
          content: $("#add-investor-temp")
        });
    });

    //监听交单
    form.on('submit(postOrder)', function(data){
        var post = data.field;
        if (investorEmpty) {
            layer.msg('请先添加一位投资人');
            return false;
        }
        if (requiredImage) {
            if (uploadedFiles.length == 0) {
                layer.msg('请上传投资截图');
                return false;
            }
            post.images = uploadedFiles.join(',');
        }
        $.post('/api/invest/order', post, function (resp) {
            $('#activity-join-area-success-detail-btn').attr('href', '/account.html?key=order&id='+resp.id);
            joinAreaSuccess.show();
            joinArea.hide();
            //百度统计追踪事件
            //window._hmt.push(['_trackEvent', 'invest', 'activity', 'submit', resp.id]);
        });
        return false;
    });

    //监听添加投资账号
    form.on('submit(postInvestor)', function(data){
        $.formPost('#add-investor-form', '/api/account/investor', data.field, function (resp) {
            if (investorEmpty) {
                $("select[name='investor']").empty();
                investorEmpty = false;
            }
            $("select[name='investor']").append("<option value='"+ resp.data.id +"' selected>"+ resp.data.investPhone + "  " +  resp.data.investName +"  (已经参与此活动0次)</option>");
            layer.close(index_add_investor);
            form.render("select");
        });
        return false;
    });

    $('#activity-get-qrcode').click(function () {
        $('#activity-get-qrcode-popup').show();
        $('#activity-get-qrcode-popup-content').html(
            '<img src="/a/65/open.png?'+(+new Date())+'" width="100%">'
        );
      return false;
    });

    // 试算
    $('#activity-calc').click(function () {
      $('#clac-popup').show();
      form.render("select");
      return false;
    });
    form.on('submit(clac)', function(data){
        var v = parseInt(data.field.deposit);//投资额
        var x = data.field.plan.split(',');
        var rebate = (v * parseFloat(x[0]) / 100).toFixed(2); // 信一返现
        var rebatePlus =  x[1]=='-' ? null : (v * parseFloat(x[1]) / 100).toFixed(2); // 奖励
        var credits = Math.floor(v * 0.001); // 积分
        var interest = (v * parseFloat(x[2]) / 100 / 365 * parseInt(x[3])).toFixed(2); // 平台利息收益
        var other = parseInt(x[4]); // 其他
        var el = $('#clac-result');
        el.find('._r b').text(rebate);
        el.find('._rp b').text(rebatePlus==null?'登陆后查看':rebatePlus);
        el.find('._c b').text(credits); // 积分
        el.find('._p b').text(interest + (other>0 ? ' + ' + other:(other<0 ? ' - ' + Math.abs(other) : '' )));
        el.find('._t b').text((parseFloat(rebate) + parseFloat(interest) + parseFloat(other)).toFixed(2));
        el.show();
        return false;
    });

    
})();
</script>

    <!-- end index home page -->
<jsp:include page="footer.jsp"></jsp:include>    