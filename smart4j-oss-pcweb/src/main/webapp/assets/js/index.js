!function(pe) {
    pe.fn.slide = function(fe) {
        return pe.fn.slide.defaults = {
            type: "slide",
            effect: "fade",
            autoPlay: !1,
            delayTime: 500,
            interTime: 2500,
            triggerTime: 150,
            defaultIndex: 0,
            titCell: ".hd li",
            mainCell: ".bd",
            targetCell: null,
            trigger: "mouseover",
            scroll: 1,
            vis: 1,
            titOnClassName: "on",
            autoPage: !1,
            prevCell: ".prev",
            nextCell: ".next",
            pageStateCell: ".pageState",
            opp: !1,
            pnLoop: !0,
            easing: "swing",
            startFun: null,
            endFun: null,
            switchLoad: null,
            playStateCell: ".playState",
            mouseOverStop: !0,
            defaultPlay: !0,
            returnDefault: !1
        },
        this.each(function() {
            var i, t = pe.extend({}, pe.fn.slide.defaults, fe), e = pe(this), o = t.effect, s = pe(t.prevCell, e), r = pe(t.nextCell, e), l = pe(t.pageStateCell, e), n = pe(t.playStateCell, e), u = (X = pe(t.titCell, e)).length, c = pe(t.mainCell, e), f = c.children().length, p = t.switchLoad, d = pe(t.targetCell, e), h = parseInt(t.defaultIndex), v = parseInt(t.delayTime), a = parseInt(t.interTime), m = (parseInt(t.triggerTime),
            parseInt(t.scroll)), g = "false" != t.autoPlay && 0 != t.autoPlay, w = "false" != t.opp && 0 != t.opp, C = "false" != t.autoPage && 0 != t.autoPage, I = "false" != t.pnLoop && 0 != t.pnLoop, M = "false" != t.mouseOverStop && 0 != t.mouseOverStop, y = "false" != t.defaultPlay && 0 != t.defaultPlay, b = "false" != t.returnDefault && 0 != t.returnDefault, x = isNaN(t.vis) ? 1 : parseInt(t.vis), O = !-[1] && !window.XMLHttpRequest, q = 0, P = 0, T = 0, k = 0, S = t.easing, Q = null, L = null, j = null, B = t.titOnClassName, D = X.index(e.find("." + B)), F = h = -1 == D ? h : D, E = h, W = h, N = x <= f ? f % m != 0 ? f % m : m : 0, A = "leftMarquee" == o || "topMarquee" == o, H = function() {
                pe.isFunction(t.startFun) && t.startFun(h, u, e, pe(t.titCell, e), c, d, s, r)
            }, U = function() {
                pe.isFunction(t.endFun) && t.endFun(h, u, e, pe(t.titCell, e), c, d, s, r)
            }, $ = function() {
                X.removeClass(B),
                y && X.eq(E).addClass(B)
            };
            if ("menu" == t.type)
                return y && X.removeClass(B).eq(h).addClass(B),
                X.hover(function() {
                    i = pe(this).find(t.targetCell);
                    var e = X.index(pe(this));
                    L = setTimeout(function() {
                        switch (h = e,
                        X.removeClass(B).eq(h).addClass(B),
                        H(),
                        o) {
                        case "fade":
                            i.stop(!0, !0).animate({
                                opacity: "show"
                            }, v, S, U);
                            break;
                        case "slideDown":
                            i.stop(!0, !0).animate({
                                height: "show"
                            }, v, S, U)
                        }
                    }, t.triggerTime)
                }, function() {
                    switch (clearTimeout(L),
                    o) {
                    case "fade":
                        i.animate({
                            opacity: "hide"
                        }, v, S);
                        break;
                    case "slideDown":
                        i.animate({
                            height: "hide"
                        }, v, S)
                    }
                }),
                void (b && e.hover(function() {
                    clearTimeout(j)
                }, function() {
                    j = setTimeout($, v)
                }));
            if (0 == u && (u = f),
            A && (u = 2),
            C) {
                if (x <= f)
                    if ("leftLoop" == o || "topLoop" == o)
                        u = f % m != 0 ? 1 + (f / m ^ 0) : f / m;
                    else {
                        var _ = f - x;
                        (u = 1 + parseInt(_ % m != 0 ? _ / m + 1 : _ / m)) <= 0 && (u = 1)
                    }
                else
                    u = 1;
                X.html("");
                var z = "";
                if (1 == t.autoPage || "true" == t.autoPage)
                    for (var R = 0; R < u; R++)
                        z += "<li>" + (R + 1) + "</li>";
                else
                    for (R = 0; R < u; R++)
                        z += t.autoPage.replace("$", R + 1);
                X.html(z);
                var X = X.children()
            }
            if (x <= f) {
                c.children().each(function() {
                    pe(this).width() > T && (T = pe(this).width(),
                    P = pe(this).outerWidth(!0)),
                    pe(this).height() > k && (k = pe(this).height(),
                    q = pe(this).outerHeight(!0))
                });
                var G = c.children()
                  , J = function() {
                    for (var e = 0; e < x; e++)
                        G.eq(e).clone().addClass("clone").appendTo(c);
                    for (e = 0; e < N; e++)
                        G.eq(f - e - 1).clone().addClass("clone").prependTo(c)
                };
                switch (o) {
                case "fold":
                    c.css({
                        position: "relative",
                        width: P,
                        height: q
                    }).children().css({
                        position: "absolute",
                        width: T,
                        left: 0,
                        top: 0,
                        display: "none"
                    });
                    break;
                case "top":
                    c.wrap('<div class="tempWrap" style="overflow:hidden; position:relative; height:' + x * q + 'px"></div>').css({
                        top: -h * m * q,
                        position: "relative",
                        padding: "0",
                        margin: "0"
                    }).children().css({
                        height: k
                    });
                    break;
                case "left":
                    c.wrap('<div class="tempWrap" style="overflow:hidden; position:relative; width:' + x * P + 'px"></div>').css({
                        width: f * P,
                        left: -h * m * P,
                        position: "relative",
                        overflow: "hidden",
                        padding: "0",
                        margin: "0"
                    }).children().css({
                        float: "left",
                        width: T
                    });
                    break;
                case "leftLoop":
                case "leftMarquee":
                    J(),
                    c.wrap('<div class="tempWrap" style="overflow:hidden; position:relative; width:' + x * P + 'px"></div>').css({
                        width: (f + x + N) * P,
                        position: "relative",
                        overflow: "hidden",
                        padding: "0",
                        margin: "0",
                        left: -(N + h * m) * P
                    }).children().css({
                        float: "left",
                        width: T
                    });
                    break;
                case "topLoop":
                case "topMarquee":
                    J(),
                    c.wrap('<div class="tempWrap" style="overflow:hidden; position:relative; height:' + x * q + 'px"></div>').css({
                        height: (f + x + N) * q,
                        position: "relative",
                        padding: "0",
                        margin: "0",
                        top: -(N + h * m) * q
                    }).children().css({
                        height: k
                    })
                }
            }
            var K = function(e) {
                var t = e * m;
                return e == u ? t = f : -1 == e && f % m != 0 && (t = -f % m),
                t
            }
              , V = function(n) {
                var e = function(e) {
                    for (var t = e; t < x + e; t++)
                        n.eq(t).find("img[" + p + "]").each(function() {
                            var e = pe(this);
                            if (e.attr("src", e.attr(p)).removeAttr(p),
                            c.find(".clone")[0])
                                for (var t = c.children(), n = 0; n < t.length; n++)
                                    t.eq(n).find("img[" + p + "]").each(function() {
                                        pe(this).attr(p) == e.attr("src") && pe(this).attr("src", pe(this).attr(p)).removeAttr(p)
                                    })
                        })
                };
                switch (o) {
                case "fade":
                case "fold":
                case "top":
                case "left":
                case "slideDown":
                    e(h * m);
                    break;
                case "leftLoop":
                case "topLoop":
                    e(N + K(W));
                    break;
                case "leftMarquee":
                case "topMarquee":
                    var t = "leftMarquee" == o ? c.css("left").replace("px", "") : c.css("top").replace("px", "")
                      , a = "leftMarquee" == o ? P : q
                      , i = N;
                    if (t % a != 0) {
                        var s = Math.abs(t / a ^ 0);
                        i = 1 == h ? N + s : N + s - 1
                    }
                    e(i)
                }
            }
              , Y = function(e) {
                if (!y || F != h || e || A) {
                    if (A ? 1 <= h ? h = 1 : h <= 0 && (h = 0) : u <= (W = h) ? h = 0 : h < 0 && (h = u - 1),
                    H(),
                    null != p && V(c.children()),
                    d[0] && (i = d.eq(h),
                    null != p && V(d),
                    "slideDown" == o ? (d.not(i).stop(!0, !0).slideUp(v),
                    i.slideDown(v, S, function() {
                        c[0] || U()
                    })) : (d.not(i).stop(!0, !0).hide(),
                    i.animate({
                        opacity: "show"
                    }, v, function() {
                        c[0] || U()
                    }))),
                    x <= f)
                        switch (o) {
                        case "fade":
                            c.children().stop(!0, !0).eq(h).animate({
                                opacity: "show"
                            }, v, S, function() {
                                U()
                            }).siblings().hide();
                            break;
                        case "fold":
                            c.children().stop(!0, !0).eq(h).animate({
                                opacity: "show"
                            }, v, S, function() {
                                U()
                            }).siblings().animate({
                                opacity: "hide"
                            }, v, S);
                            break;
                        case "top":
                            c.stop(!0, !1).animate({
                                top: -h * m * q
                            }, v, S, function() {
                                U()
                            });
                            break;
                        case "left":
                            c.stop(!0, !1).animate({
                                left: -h * m * P
                            }, v, S, function() {
                                U()
                            });
                            break;
                        case "leftLoop":
                            var t = W;
                            c.stop(!0, !0).animate({
                                left: -(K(W) + N) * P
                            }, v, S, function() {
                                t <= -1 ? c.css("left", -(N + (u - 1) * m) * P) : u <= t && c.css("left", -N * P),
                                U()
                            });
                            break;
                        case "topLoop":
                            t = W;
                            c.stop(!0, !0).animate({
                                top: -(K(W) + N) * q
                            }, v, S, function() {
                                t <= -1 ? c.css("top", -(N + (u - 1) * m) * q) : u <= t && c.css("top", -N * q),
                                U()
                            });
                            break;
                        case "leftMarquee":
                            var n = c.css("left").replace("px", "");
                            0 == h ? c.animate({
                                left: ++n
                            }, 0, function() {
                                0 <= c.css("left").replace("px", "") && c.css("left", -f * P)
                            }) : c.animate({
                                left: --n
                            }, 0, function() {
                                c.css("left").replace("px", "") <= -(f + N) * P && c.css("left", -N * P)
                            });
                            break;
                        case "topMarquee":
                            var a = c.css("top").replace("px", "");
                            0 == h ? c.animate({
                                top: ++a
                            }, 0, function() {
                                0 <= c.css("top").replace("px", "") && c.css("top", -f * q)
                            }) : c.animate({
                                top: --a
                            }, 0, function() {
                                c.css("top").replace("px", "") <= -(f + N) * q && c.css("top", -N * q)
                            })
                        }
                    X.removeClass(B).eq(h).addClass(B),
                    F = h,
                    I || (r.removeClass("nextStop"),
                    s.removeClass("prevStop"),
                    0 == h && s.addClass("prevStop"),
                    h == u - 1 && r.addClass("nextStop")),
                    l.html("<span>" + (h + 1) + "</span>/" + u)
                }
            };
            y && Y(!0),
            b && e.hover(function() {
                clearTimeout(j)
            }, function() {
                j = setTimeout(function() {
                    h = E,
                    y ? Y() : "slideDown" == o ? i.slideUp(v, $) : i.animate({
                        opacity: "hide"
                    }, v, $),
                    F = h
                }, 300)
            });
            var Z = function(e) {
                Q = setInterval(function() {
                    w ? h-- : h++,
                    Y()
                }, e || a)
            }
              , ee = function(e) {
                Q = setInterval(Y, e || a)
            }
              , te = function() {
                M || !g || n.hasClass("pauseState") || (clearInterval(Q),
                Z())
            }
              , ne = function() {
                (I || h != u - 1) && (h++,
                Y(),
                A || te())
            }
              , ae = function() {
                (I || 0 != h) && (h--,
                Y(),
                A || te())
            }
              , ie = function() {
                clearInterval(Q),
                A ? ee() : Z(),
                n.removeClass("pauseState")
            }
              , se = function() {
                clearInterval(Q),
                n.addClass("pauseState")
            };
            if (g ? A ? (w ? h-- : h++,
            ee(),
            M && c.hover(se, ie)) : (Z(),
            M && e.hover(se, ie)) : (A && (w ? h-- : h++),
            n.addClass("pauseState")),
            n.click(function() {
                n.hasClass("pauseState") ? ie() : se()
            }),
            "mouseover" == t.trigger ? X.hover(function() {
                var e = X.index(this);
                L = setTimeout(function() {
                    h = e,
                    Y(),
                    te()
                }, t.triggerTime)
            }, function() {
                clearTimeout(L)
            }) : X.click(function() {
                h = X.index(this),
                Y(),
                te()
            }),
            A) {
                if (r.mousedown(ne),
                s.mousedown(ae),
                I) {
                    var oe, re = function() {
                        oe = setTimeout(function() {
                            clearInterval(Q),
                            ee(a / 10 ^ 0)
                        }, 150)
                    }, le = function() {
                        clearTimeout(oe),
                        clearInterval(Q),
                        ee()
                    };
                    r.mousedown(re),
                    r.mouseup(le),
                    s.mousedown(re),
                    s.mouseup(le)
                }
                "mouseover" == t.trigger && (r.hover(ne, function() {}),
                s.hover(ae, function() {}))
            } else
                r.click(ne),
                s.click(ae);
            if ("auto" == t.vis && 1 == m && ("left" == o || "leftLoop" == o)) {
                var ue, ce = function() {
                    O && (c.width("auto"),
                    c.children().width("auto")),
                    c.parent().width("auto"),
                    P = c.parent().width(),
                    O && c.parent().width(P),
                    c.children().width(P),
                    "left" == o ? (c.width(P * f),
                    c.stop(!0, !1).animate({
                        left: -h * P
                    }, 0)) : (c.width(P * (f + 2)),
                    c.stop(!0, !1).animate({
                        left: -(h + 1) * P
                    }, 0)),
                    O || P == c.parent().width() || ce()
                };
                pe(window).resize(function() {
                    clearTimeout(ue),
                    ue = setTimeout(ce, 100)
                }),
                ce()
            }
        })
    }
}(jQuery),
$(".banner").slide({
    mainCell: ".bd",
    titCell: ".hd",
    prevCell: ".btn_l",
    nextCell: ".btn_r",
    effect: "leftLoop",
    vis: "auto",
    autoPage: !0,
    autoPlay: !0,
    pnLoop: !0,
    delayTime: 500,
    interTime: 5e3
});
