<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.util.db"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <meta name="viewport" content="width=device-width,minimum-scale=1.0,initial-scale=1,maximum-scale=1.0,user-scalable=no">
  <meta content="telephone=no" name="formatdetection">
  <meta content="email=no" name="formatdetection">
  <meta http-equiv="Pragma" content="no-cache">
  <meta http-equiv="Cache-Control" content="no-cache">
  <meta http-equiv="Expires" content="0">
  <meta name="format-detection" content="telephone=no">
  <title>婚礼私人订制系统</title>
  <link rel="stylesheet" href="qtimages/common.css"> 
  <link rel="stylesheet" href="qtimages/jquery-ui.min.css">
  <link rel="stylesheet" type="text/css" href="qtimages/swiper.min.css">   
  <link rel="stylesheet" type="text/css" href="qtimages/index.css">   

</head>
<body>
<jsp:include page="qttop.jsp"></jsp:include>
 
  <div class="swiper-container-top">
    <div class="swiper-wrapper">
        <div class="swiper-slide">
          <img src="qtimages/bb.jpg">
        </div>
    </div>
  </div>
  <div class="cform">
    <div class="coverform">
      <div class="formbottom">
        <div class="form-phone">
		<form name="formsearch" id="formsearch" action="news.jsp" method="post">
          <span class="pc">站内搜索：</span>
          <input id="phone" type="text" maxlength="11" style="border:0px;" placeholder="请填写关键词">
        </div>
		<button type="submit"  class="btn-submit">站内搜索</button>
       
		</form>
      </div>
    </div>
  </div>
  <div class="bj-gary"></div>
  <aside>
    <h1>享受你的生活</h1>
    <br>
    <h2>爱，始于家的感觉，让每一次服务有爱之旅</h2>
    <h2>让我们摆脱担忧，让你的世界像在自己家一样的生活</h2>
  </aside>
  <div class='family'>
    <h1>婚宴酒店推荐</h1>
    <h2>优质的服务，高速高质，只为您的一个点赞....</h2>
    <div class='swiper-container-banner swiper-container-horizontal'>
      <div class='swiper-wrapper' style='transform: translate3d(-2440px, 0px, 0px); transition-duration: 0ms;'>
	 
     <%
		 int spi=0;
		 %>
		 <c:forEach items="${syhunyanjiudian}" var="a">
		 <%
		 	spi++;
			if(spi<=10)
			{
		 %>
        <div class='swiper-slide' data-swiper-slide-index='6' style='width: 386.667px; margin-right: 20px;'>
       <img onclick="javascript:location.href='hyjdDetail.do?id=${a.id}';" src='${a.tupian}' class='family-image' style='widht:380px; height:300px; border-radius: 18px; cursor:pointer'><div class='fmilyright'><span class='fname'></span><img src='qtimages/home_icon_dingwei.png' class='location-icon'> 
          <span class='cityname'>${a.jiudianmingcheng}</span><strong></strong></div>
        </div>
        <%
			}
			%>
		</c:forEach>
	    
		
        </div>
      <div class='swiper-button-prev' hidden=''></div>
      <div class='swiper-button-next' hidden=''></div>
    </div>
   
    <img src='qtimages/home_riji_left.png' class='banner-button-left'>
    <img src='qtimages/home_riji_right.png' class='banner-button-right'>
  </div>

  <div class="ensure">
    <h1>用心做好每一次服务</h1>
    <div>
      <img src="qtimages/home_icon_baozhang.png">
      <h2>保障</h2>
      <h3>解决安全、畅通等问题<br>线上订单，全程享受保障服务</h3>
    </div>
    <div>
      <img src="qtimages/home_icon_longyang.png">
      <h2>拒绝线下</h2>
      <h3>拥有在家一样自由的空间、无限的陪伴</h3>
    </div>
    <div>
      <img src="qtimages/home_icon_zijin.png">
      <h2>担保安全</h2>
      <h3>在线支付<br>满意后，才会收到付款</h3>
    </div>
    <div>
      <img src="qtimages/home_icon_renzheng.png">
      <h2>实名视频认证</h2>
      <h3>对身份和环境严格认证<br>平台监管、追踪每一笔线上订单</h3>
    </div>
  </div>
 
  
  <div class="comefamily"><img src="qtimages/pic_chengweijiating.png"></div>
  <div class="community">
    <h1>关于我们</h1>
    <div class="community-all">
      <div class="community-top">
        <a  href="dx_detail.php?lb=关于我们">
        <img src="qtimages/home_pic_faxian.png" class="community-left">
        <span><h2>婚礼私人订制系统</h2><%=connDbBean.ensubStr(connDbBean.readzd("dx","content","leibie","关于我们"),185)%></span>
        </a>
      </div>
      
  </div>
  
 <div class='community'>
    <h1>婚礼策划</h1>
    <div class='community-all'>
      <div class='swiper-container-community swiper-container-horizontal'>
        <div class='swiper-wrapper' style='transform: translate3d(0px, 0px, 0px); transition-duration: 0ms;'>
       <%
		 int txi=0;
		 %>
       <c:forEach items="${syhunlicehua}" var="b">
	   <%
		 	txi++;
			if(txi<=10)
			{
		 %>
        <img onClick="javascript:location.href='hlchDetail.do?id=${b.id}';" src='${b.tupian}' class='swiper-slide background-img' style='width: 240.5px; margin-right: 20px; border-radius: 18px; cursor:pointer' title='${b.cehuafangan}'>
       	<%
			}
			%>
		</c:forEach>
        </div>
        <div class='swiper-button-prev swiper-button-disabled' hidden=''></div>
        <div class='swiper-button-next' hidden=''></div>
      </div>
      <img src='qtimages/home_faxian_left.png' class='community-btn-left'>
      <img src='qtimages/home_faxian_right.png' class='community-btn-right'>
    </div>
  </div>
 
  <jsp:include page="qtdown.jsp"></jsp:include>
  <script src="qtimages/jweixin-1.0.0.js"></script>
  <script src="qtimages/jquery-1.11.3.min.js"></script>
  <script src="qtimages/wx.js"></script>
  <script src="qtimages/swiper.min.js"></script>
  <script src="qtimages/jquery-ui.min.js"></script>
  <script src="qtimages/index.js"></script>
</body></html>