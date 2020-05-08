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
 <% 
 if((String)request.getSession().getAttribute("username")==null || (String)request.getSession().getAttribute("username")=="")
{
	out.print("<script>alert('对不起,请您先登陆!');location.href='index.jsp';</script>");
	return;
}
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
    <h1>在线论坛</h1>
    <h2>优质的服务，高速高质，只为您的一个点赞....</h2>
    <div class="swiper-container-banner swiper-container-horizontal">
     
	 
	<table width="96%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#EEE8A4" style="border-collapse:collapse">
                      <tr>
                        <td height="104" valign="top">
						
						
						
					
                            <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#EEE8A4" style="border-collapse:collapse">
                              <tr>
                                <td width="13%">标题：</td>
                                <td width="87%"><%=connDbBean.readzd("tiezi","biaoti","id",id)%> &nbsp;<img src="bbs/<%=connDbBean.readzd("tiezi","leixing","id",id)%>.gif" width="18" height="18"> 发帖人：<%=connDbBean.readzd("tiezi","faburen","id",id)%> ：<%=connDbBean.readzd("tiezi","addtime","id",id)%> <%
								if(connDbBean.readzd("tiezi","fujian","id",id).equals(""))
								{}
								else
								{
									out.print("<a href='"+connDbBean.readzd("tiezi","fujian","id",id)+"'>附件下载</a>");
								}
								%></td>
                              </tr>
                              <tr>
                                <td>内容：</td>
                                <td height="100"><%=connDbBean.readzd("tiezi","neirong","id",id)%></td>
                              </tr>
                              <tr>
                                <td>&nbsp;</td>
                                <td>&nbsp;</td>
                              </tr>
                            </table>
                        
                        </td>
                      </tr>
                      <tr>
                        <td align="right"><table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#EEE8A4" style="border-collapse:collapse">
                            <tr>
                              <td colspan="2">已有回帖如下：</td>
                            </tr>
							 <%
							int bbsi=0;
							  String sqlbbs =  "select * from tiezi where fid='"+id+"' order by id desc";
							  ResultSet RS_resultbbs=connDbBean.executeQuery(sqlbbs);
								while(RS_resultbbs.next()){
								bbsi++;
								%>
								 <tr>
                              <td width="19%"><p>回复人:<%=RS_resultbbs.getString("faburen") %></p>
                                <p><%=RS_resultbbs.getString("addtime") %></p></td>
                              <td width="81%" height="100"><%=RS_resultbbs.getString("neirong") %></td>
                            </tr>
								<%
								}
							 %>
                            <tr>
                              <td colspan="2">我也来回一个：</td>
                            </tr>
                            <tr>
                              <td colspan="2"><form action="addTiezi.do" name="form1" method="post">
                                  <textarea name="neirong" cols="70" rows="5" id="neirong"></textarea>
                                  <input type="submit" name="Submit" value="回复">
                                  
								  <input name="bankuai" type="hidden" id="bankuai" value="<%=connDbBean.readzd("tiezi","bankuai","id",id)%>"> <input name="faburen" type="hidden" id="faburen" value="<%=request.getSession().getAttribute("username")%>"> <input name="fid" type="hidden" id="fid" value="<%=id%>"> <input name="addtime" type="hidden" id="addtime" value="<%=connDbBean.gettime()%>" />
                              </form></td>
                            </tr>
                        </table></td>
                      </tr>
                      <tr>
                        <td align="right"><a href="bbs.jsp" >返回</a></td>
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