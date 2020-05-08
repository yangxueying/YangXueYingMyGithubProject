<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
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
  <title>在线论坛</title>
  <link rel="stylesheet" href="qtimages/common.css"> 
  <link rel="stylesheet" href="qtimages/jquery-ui.min.css">
  <link rel="stylesheet" type="text/css" href="qtimages/swiper.min.css">   
  <link rel="stylesheet" type="text/css" href="qtimages/index.css">   

</head>
<% String bk=request.getParameter("bk"); %>
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
    <h1>在线论坛</h1>
    <h2>优质的服务，高速高质，只为您的一个点赞....</h2>
    <div class="swiper-container-banner swiper-container-horizontal">
     
	 
	<table width="100%" border="0" align="center" cellpadding="3" cellspacing="1" bordercolor="#00FFFF" class="newsline" style="border-collapse:collapse">
                          <tr>
                            <td height="104" valign="top"><table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#00FFFF" style="border-collapse:collapse">
                                <tr>
                                  <td width="30" bgcolor="#EBE2FE">序号</td>
                                  <td width="352" bgcolor='#EBE2FE'>标题</td>
                                  <td width="48" bgcolor='#EBE2FE'>类型</td>
                                  <td width="60" bgcolor='#EBE2FE'>发帖人</td>
                                  <td width="130" align="center" bgcolor="#EBE2FE">发布时间</td>
                                  <td width="65" align="center" bgcolor="#EBE2FE">已有回帖</td>
                                </tr>
                                 <% 

  	
    String sqlbbs =  "select * from tiezi where bankuai='"+bk+"' and fid='0' order by issh desc, id desc";
	int bbsi=0;
	 ResultSet RS_resultbbs=connDbBean.executeQuery(sqlbbs);
	while(RS_resultbbs.next()){
	bbsi++;

     %>
                                <tr>
                                  <td width="30"><%=bbsi%></td>
                                  <td><a href="tiezidetail.jsp?id=<%=RS_resultbbs.getString("id") %>"><%
								  if(RS_resultbbs.getString("issh").equals("是"))
								  {
								  %>
								  <img src="bbs/zhiding.png" width="15" height="15" style="padding-top:5px;">
								  <%
								  }
								  %><%=RS_resultbbs.getString("biaoti") %> </a></td>
                                  <td><img src="bbs/<%=RS_resultbbs.getString("leixing") %>.gif" width="18" height="18"></td>
                                  <td><%=RS_resultbbs.getString("faburen") %></td>
                                  <td width="130" align="center"><%=RS_resultbbs.getString("addtime") %></td>
                                  <td width="65" align="center"><%=connDbBean.gettzs((String)RS_resultbbs.getString("id")) %></td>
                                </tr>
	<%
  }
   %>
                            </table></td>
                          </tr>
                          <tr>
                            <td align="right"><a href="tieziadd.jsp?bk=<%=bk%>">我要发帖</a> <a href="bbs.jsp" onClick="javascript:history.back();">返回</a></td>
                          </tr>
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
</body></html>