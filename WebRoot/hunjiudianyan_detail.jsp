<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>婚酒店宴详细</title>
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   

  </head>

  <body >

  婚酒店宴详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%' height=44>酒店编号：</td><td width='39%'>${hunjiudianyan.jiudianbianhao}</td><td  rowspan=5 align=center><a href=${hunjiudianyan.tupian} target=_blank><img src=${hunjiudianyan.tupian} width=228 height=215 border=0></a></td></tr><tr><td width='11%' height=44>酒店名称：</td><td width='39%'>${hunjiudianyan.jiudianmingcheng}</td></tr><tr><td width='11%' height=44>星级：</td><td width='39%'>${hunjiudianyan.xingji}</td></tr><tr><td width='11%' height=44>联系电话：</td><td width='39%'>${hunjiudianyan.lianxidianhua}</td></tr><tr><td width='11%' height=44>地址：</td><td width='39%'>${hunjiudianyan.dizhi}</td></tr><tr><td width='11%' height=100  >酒店简介：</td><td width='39%' colspan=2 height=100 >${hunjiudianyan.jiudianjianjie}</td></tr><tr><td colspan=3 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

