<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
 <header>
    <img src="qtimages/icon_logo.png" width="65" class="logo"><span style="font-family:宋体; color:#FFFFFF;  WIDTH: 300; FONT-WEIGHT: bold; FONT-SIZE: 19pt; margin-top:5pt; ">婚礼私人订制系统</span>
    <div class="top-right">
     		<span><a href='index.do'>首页</a></span>
		<span><a href='hsxxListtp.do'>婚纱信息</a></span>
<span><a href='hlchListtp.do'>婚礼策划</a></span>
<span><a href='hyjdListtp.do'>婚宴酒店</a></span>

	  <span class="clo2">
          <a  href="javascript::void(0);" onClick="return false;" class="apd">新闻信息</a>
          <div class="pull-down" style="display: none;"><div class="pd-top"><a href="xwtzList.do?lb=婚礼知识">婚礼知识</a></div> </div>
      </span><!--yoxulixuyaxn-->
      <span><a href='bbs.jsp'>在线发帖</a></span>
	  <span><a href='login.jsp'>后台管理</a></span>
	  
	 <%
    if((String)request.getSession().getAttribute("username")==null || (String)request.getSession().getAttribute("username")==""){
     %>
      <strong><a href="userreg.jsp">注册</a> | <a href="userlog.jsp">登陆</a></strong>
	    <%}else{ %>
				 <strong><%=request.getSession().getAttribute("username")%>[<%=request.getSession().getAttribute("cx")%>] <a href="logout.jsp">退出</a>|<a href="main.jsp">个人后台</a></strong>
				     <%} %>
      <br>
    </div>
  </header>