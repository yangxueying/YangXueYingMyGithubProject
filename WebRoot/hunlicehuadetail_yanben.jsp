<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>

<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta name="viewport" content="width=device-width,minimum-scale=1.0,initial-scale=1,maximum-scale=1.0,user-scalable=no">
  <meta content="telephone=no" name="formatdetection">
  <meta content="email=no" name="formatdetection">
  <meta http-equiv="Pragma" content="no-cache">
  <meta http-equiv="Cache-Control" content="no-cache">
  <meta http-equiv="Expires" content="0">
  <meta name="format-detection" content="telephone=no">
<title>婚礼策划</title>

  <link rel="stylesheet" href="qtimages/common.css"> 
  <link rel="stylesheet" href="qtimages/jquery-ui.min.css">
  <link rel="stylesheet" type="text/css" href="qtimages/swiper.min.css">   
  <link rel="stylesheet" type="text/css" href="qtimages/index.css">   

</head>
<script language=javascript src='js/popup.js'></script>
<script language=javascript> 
function hsgpinglun(nbiao,nid){ 
popheight=450;
pop('hsgpinglun.jsp?biao='+nbiao+'&id='+nid,'在线评论',550,250) ;
}
</script> 
<%
	String id=request.getParameter("id");
	
     %>
<body>
<jsp:include page="qttop.jsp"></jsp:include>
  <div class="swiper-container-top">
    <div class="swiper-wrapper">
        <div class="swiper-slide">
          <img src="qtimages/bb2.jpg">
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


  <div class="family">
    <h1>婚礼策划</h1>
    <h2>优质的服务，高速高质，只为您的一个点赞....</h2>
    <div class="swiper-container-banner swiper-container-horizontal">
     
	 
	 
   <table width="100%" border="0" align="center" cellpadding="3" cellspacing="1" bordercolor="#00FFFF" style="border-collapse:collapse"  class="newsline">  
      <tr>
		 <td width='11%' height=44>策划方案：</td><td width='39%'>${hunlicehua.cehuafangan}</td><td  rowspan=4 align=center><a href=${hunlicehua.tupian} target=_blank><img src=${hunlicehua.tupian}  width=228 height=215 border=0></a></td></tr><tr>         <td width='11%' height=44>价格：</td><td width='39%'>${hunlicehua.jiage}</td></tr><tr>         <td width='11%' height=44>联系电话：</td><td width='39%'>${hunlicehua.lianxidianhua}</td></tr><tr>         <td width='11%' height=44>地址：</td><td width='39%'>${hunlicehua.dizhi}</td></tr><tr>                           <td width='11%' height=100  >详细：</td><td width='39%' colspan=2 height=100 >${hunlicehua.xiangxi}</td></tr><tr><td colspan=3 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" /><input type=button name=Submit52 value=打印 onClick="javascript:window.print()" /> <!--jixaaxnnxiu--></td></tr>
    
  </table>
						
					  
    
    </div>
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
  <jsp:include page="qtdown.jsp"></jsp:include>
  <script src="qtimages/jweixin-1.0.0.js"></script>
  <script src="qtimages/jquery-1.11.3.min.js"></script>
  <script src="qtimages/wx.js"></script>
  <script src="qtimages/swiper.min.js"></script>
  <script src="qtimages/jquery-ui.min.js"></script>
  <script src="qtimages/index.js"></script>
  
</body> 
</html>

