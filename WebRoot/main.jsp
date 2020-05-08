<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%request.setCharacterEncoding("utf-8");%>
<!doctype html>
<html lang="en">
<head>
	<title>婚礼私人订制系统</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="images/css/font.css">
	<link rel="stylesheet" href="images/css/xadmin.css">
    <link rel="stylesheet" href="images/hsg3.css">
    <script type="text/javascript" src="images/hsg1.js"></script>
    <script type="text/javascript" src="images/hsg2.js"></script>
    <script src="images/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="images/js/xadmin.js"></script>

</head>
<body>
    <div class="container">
        <div class="logo">婚礼私人订制系统</div>
        <div class="open-nav"><i class="iconfont"></i></div>
        <ul class="layui-nav right" lay-filter="">
		 <li class="layui-nav-item">当前用户：${sessionScope.username} [${sessionScope.cx}]</li>
          <li class="layui-nav-item">
            <a href="javascript:;">返回</a>
            <dl class="layui-nav-child">
              <dd><a href="index.jsp">前台</a></dd>
              
              <dd><a href="logout.jsp">退出</a></dd>
            </dl>
          </li>
        </ul>
    </div>
    <div class="wrapper">
        <div class="left-nav">
          <div id="side-nav">
            <ul id="nav">
               
	  <%
if (request.getSession().getAttribute("cx").equals("超级管理员") || request.getSession().getAttribute("cx").equals("普通管理员")){%><jsp:include page="left_guanliyuan.jsp"></jsp:include><%}
if (request.getSession().getAttribute("cx").equals("注册用户")){%><jsp:include page="left_zhuceyonghu.jsp"></jsp:include><%}


%>

               
				
            </ul>
          </div>
        </div>
        <div class="page-content">
         <iframe  frameborder="0" id="hsgmain" name="hsgmain" scrolling="yes" src="sy.jsp" height="100%" style="  visibility:inherit; width:100%;z-index:1;" ></iframe>
        </div>
    </div>
    <div class="footer">
        <div class="copyright">Copyright @2020 婚礼私人订制系统 v2.3 All Rights Reserved. 本后台系统由xxxxxxx技术支持</div>  
    </div>
	<div class="bg-changer">
        <div class="swiper-container changer-list">
            <div class="swiper-wrapper">
                <div class="swiper-slide"><img class="item" src="./images/a.jpg" alt=""></div>
                <div class="swiper-slide"><img class="item" src="./images/b.jpg" alt=""></div>
                <div class="swiper-slide"><img class="item" src="./images/c.jpg" alt=""></div>
                <div class="swiper-slide"><img class="item" src="./images/d.jpg" alt=""></div>
                <div class="swiper-slide"><img class="item" src="./images/e.jpg" alt=""></div>
                <div class="swiper-slide"><img class="item" src="./images/f.jpg" alt=""></div>
                <div class="swiper-slide"><img class="item" src="./images/g.jpg" alt=""></div>
                <div class="swiper-slide"><img class="item" src="./images/h.jpg" alt=""></div>
                <div class="swiper-slide"><img class="item" src="./images/i.jpg" alt=""></div>
                <div class="swiper-slide"><img class="item" src="./images/j.jpg" alt=""></div>
                <div class="swiper-slide"><img class="item" src="./images/k.jpg" alt=""></div>
                <div class="swiper-slide"><span class="reset">初始化</span></div>
            </div>
        </div>
        <div class="bg-out"></div>
        <div id="changer-set"><i class="iconfont">&#xe696;</i></div>   
    </div>
</body>
</html>