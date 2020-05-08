var ctime,xtime;
$(".clo2").mouseover(function(){
  $(this).find(".pull-down").css("display","inline-block");


});
$(".clo2").mouseout(function() {
 
  $(this).find(".pull-down").css("display","none");


 
});

$(".pull-down").mouseover(function(){
 

  // $(".pull-down").css("display","inline-block");

});
$(".pull-down").mouseout(function(){

  $(".pull-down").css("display","none");

});

$(".wechat-hover").mouseover(function(){
  $("footer .footer-center .wechat-img").css("display","inline-block");
});
$(".wechat-hover").mouseout(function(){
  $("footer .footer-center .wechat-img").css("display","none");
});
$(".li-news a").mouseover(function(){
  $("footer .news").css("display","inline-block");
});
$(".li-news a").mouseout(function(){
  xtime = setTimeout(function(){
    $("footer .news").css("display","none");
  },2000);
});
$("footer .news").mouseover(function(){
  clearTimeout(xtime);
  $("footer .news").css("display","inline-block");
});
$("footer .news").mouseout(function(){
  $("footer .news").css("display","none");
});
var UA = navigator.userAgent;
//移动端地址跳转
// if(UA.match(/Android/i)||(UA.indexOf('iPhone') != -1) || (UA.indexOf('iPod') != -1) || (UA.indexOf('iPad') != -1)) {
//     window.location = location.hostname+'webapp.html';
// }

if(UA.match(/Android/i)||(UA.indexOf('iPhone') != -1) || (UA.indexOf('iPod') != -1) || (UA.indexOf('iPad') != -1)) {
  $(".icon-left").attr("src","http://viptail.image.alimmdn.com/files/official_web/img/mob_btn_expand.png");
  $(".phoneshow").attr("src","http://viptail.image.alimmdn.com/files/official_web/img/mob_btn_expand.png");
  $('.ios').on("click",function(){
    location.href="http://a.app.qq.com/o/simple.jsp?pkgname=com.viptail.xiaogouzaijia";
  });
  $('.android').on("click",function(){
    location.href="http://a.app.qq.com/o/simple.jsp?pkgname=com.viptail.xiaogouzaijia";
  });
  
$(".fixedbottom").css("display","block");
$("body").css("padding-bottom","12%");
}
// var ua = navigator.userAgent.toLowerCase();
// if (ua.indexOf("viptail") == -1) {
// }
$(".fixedbottom .right").on("click",function(){
    location.href="http://a.app.qq.com/o/simple.jsp?pkgname=com.viptail.xiaogouzaijia";
});
$(".fixedbottom .close").on("click",function(){
    $(this).parent().css("display","none");
    $("body").css("padding-bottom","0");
    $("footer").css("margin-bottom","0");
});
/**
 * 是否为微信
 * @returns {boolean}
 */
function isWechat() {
    var ua = navigator.userAgent.toLowerCase();
    if (ua.match(/MicroMessenger/i) == "micromessenger") {
        return true;
    } else {
        return false;
    }
}
// 微信
if (isWechat()) {
    var wxData = {
        'url': location.href
    };
    $.ajax({
        url: "/viptail/api/wxActivity/bind",
        data: wxData,
        type: "POST",
        dataType: "json",
        async: false,
        success: function(data) {
            if (data.respCode == '0') {
                wx.config({
                    debug: false,
                    appId: data.appId,
                    timestamp: data.timestamp,
                    nonceStr: data.nonceStr,
                    signature: data.signature,
                    jsApiList: ['onMenuShareTimeline', 'onMenuShareAppMessage', 'hideAllNonBaseMenuItem', 'showMenuItems', 'onMenuShareQQ', 'onMenuShareQZone']
                });
            }
        }
    });
    wx.ready(function() {
        wx.hideAllNonBaseMenuItem();
        wx.showMenuItems({
            menuList: ['menuItem:share:appMessage', 'menuItem:share:timeline', 'menuItem:favorite', 'menuItem:openWithSafari', "menuItem:share:qq", "menuItem:share:QZone"] // 要显示的菜单项
        });
        wx.onMenuShareTimeline({ //分享到朋友圈的API  
            title: '小狗在家宠物家庭寄养平台',
            // 分享标题
            link: location.href,
            // 分享链接
            desc: '全国200多个城市已开通服务，随时随地寻找身边的爱宠家庭。－爱你的宠物，享受你的生活。',
            // 分享描述
            imgUrl: 'http://viptail.image.alimmdn.com/app_icon/default_icon.png',
            // 分享图标
            success: function() {
                // 用户确认分享后执行的回调函数
            },
            cancel: function() {
                // 用户取消分享后执行的回调函数
            }
        });
        wx.onMenuShareAppMessage({ //分享到朋友的API
            title: '小狗在家宠物家庭寄养平台',
            // 分享标题
            desc: '全国200多个城市已开通服务，随时随地寻找身边的爱宠家庭。－爱你的宠物，享受你的生活。',
            // 分享描述
            link: location.href,
            // 分享链接
            imgUrl: 'http://viptail.image.alimmdn.com/app_icon/default_icon.png',
            // 分享图标
            success: function() {
                // 用户确认分享后执行的回调函数
            },
            cancel: function() {
                // 用户取消分享后执行的回调函数
            }
        });
        wx.onMenuShareQQ({ //分享到QQ的API
            title: '小狗在家宠物家庭寄养平台',
            // 分享标题
            desc: '全国200多个城市已开通服务，随时随地寻找身边的爱宠家庭。－爱你的宠物，享受你的生活。',
            // 分享描述
            link: location.href,
            // 分享链接
            imgUrl: 'http://viptail.image.alimmdn.com/app_icon/default_icon.png',
            // 分享图标
            success: function() {
                // 用户确认分享后执行的回调函数
            },
            cancel: function() {
                // 用户取消分享后执行的回调函数
            }
        });
        wx.onMenuShareQZone({ //分享到qq空间的API
            title: '小狗在家宠物家庭寄养平台',
            // 分享标题
            desc: '全国200多个城市已开通服务，随时随地寻找身边的爱宠家庭。－爱你的宠物，享受你的生活。',
            // 分享描述
            link: location.href,
            // 分享链接
            imgUrl: 'http://viptail.image.alimmdn.com/app_icon/default_icon.png',
            // 分享图标
            success: function() {
                // 用户确认分享后执行的回调函数
            },
            cancel: function() {
                // 用户取消分享后执行的回调函数
            }
        });
        wx.error(function(res) {
            console.log(res.errMsg);
        });

    });
} else {
    console.log("not wechat");
}