$.ajaxSetup({
    cache: !1,
    dataType: "json"
}),
$.ajaxPrefilter(function(e, t, n) {
    if (!e.crossDomain) {
        n.setRequestHeader("App-Version", "web");
        var o = $.cookie("loginToken");
        o && n.setRequestHeader("X-Login-Token", o)
    }
}),
$(document).ajaxError(function(e, t, n, o) {
    500 <= t.status && t.status < 600 ? layer.msg("500: 服务器程序错误") : 403 == t.status ? layer.msg("403: 禁止访问") : 404 == t.status && layer.msg("404: 请求的资源不存在")
}),
$.formErrorsRender = function(e, t) {
    if (t)
        for (var n in t)
            "__all__" == t[n].field ? layer.msg("错误：" + t[n].message) : layer.tips(t[n].message, e + " [name=" + t[n].field + "]", {
                tipsMore: !0
            })
}
,
$.formPost = function(t, e, n, o) {
    $.post(e, n, function(e) {
        -2 != e.statusCode ? 0 == e.statusCode ? "function" == typeof o && o(e) : layer.msg("错误：" + e.message) : $.formErrorsRender(t, e.message)
    })
}
,
$.form = function(e, t, n) {
    $(e).submit(function() {
        return $.formPost(e, t, $(this).serializeArray(), n),
        !1
    })
}
,
$.sendMobilePopup = null,
$.sendMobileLoadCaptcha = function() {
    $.get("/api/captcha/new.json", function(e) {
        $("#send-mobile-code-popup-img img").attr("src", e.image),
        $("input[name=captcha_data]", $.sendMobilePopup).val(e.key),
        $("input[name=captcha]", $.sendMobilePopup).val("")
    })
}
,
$.sendMobile = function(e, t) {
    var n = $(e)
      , o = n.val();
    return o && 11 == o.length ? (null == $.sendMobilePopup && ($.sendMobilePopup = $("#send-mobile-code-popup"),
    $("#send-mobile-code-popup-img").click(function() {
        return $.sendMobileLoadCaptcha(),
        !1
    }),
    $.form("#send-mobile-code-popup form", "/api/mobile/send_code", function(e) {
        layer.msg("已经发送验证码到:" + e.mobile),
        $.sendMobilePopup.hide()
    })),
    $("h1", $.sendMobilePopup).text("发送验证码到:" + o),
    $("input[name=mobile]", $.sendMobilePopup).val(o),
    $("input[name=type]", $.sendMobilePopup).val(t),
    $.sendMobileLoadCaptcha(),
    $.sendMobilePopup.show()) : (layer.msg("请填写正确的手机号"),
    n.focus()),
    !1
}
,
$(function() {
    var e;
    !function() {
        var t = $("#headerWrap")
          , n = t.height();
        if (0 != t.length) {
            t.offset().top;
            var e = $("#stop_homeNav");
            if (0 != e.length)
                var o = e.offset().top;
            $(window).scroll(function() {
                var e = $(this).scrollTop();
                44 < e ? ($("body").css("padding-top", n),
                t.addClass("Topheader"),
                o <= e && (t.removeClass("Topheader"),
                $("body").css("padding-top", 0))) : ($("body").css("padding-top", 0),
                t.removeClass("Topheader"))
            })
        }
        var r = $("#homeNav");
        "function" == typeof $.fn.onePageNav && r.onePageNav()
    }(),
    $(".qq_box").hover(function() {
        $(this).children(".sec_qq").stop().fadeIn()
    }, function() {
        $(this).children(".sec_qq").stop().fadeOut()
    }),
    (e = $("#ftoolTop")).click(function(e) {
        e.preventDefault(),
        $("html,body").animate({
            scrollTop: 0
        }, 500)
    }),
    $(window).on("DOMContentLoaded scroll resize", function() {
        0 == $(this).scrollTop() ? e.hide() : e.show()
    }),
    $(".ftool_item").mouseenter(function() {
        $(this).addClass("ftool_hover"),
        $(this).find(".ftool_code").css({
            display: "block"
        }).stop(!0, !0).animate({
            opacity: 1,
            right: "50px"
        }, 500)
    }).mouseleave(function() {
        $(this).removeClass("ftool_hover"),
        $(this).find(".ftool_code").css({
            display: "none"
        }).animate({
            opacity: 0,
            right: "100px"
        }, 500)
    }),
    $(".tip2").tipso({
        useTitle: !1,
        position: "top",
        width: 240,
        background: "#666"
    })
});