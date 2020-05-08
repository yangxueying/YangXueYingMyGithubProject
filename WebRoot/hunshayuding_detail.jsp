<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>婚纱预订详细</title>
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   

  </head>

  <body >

  婚纱预订详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>订单号：</td><td width='39%'>${hunshayuding.dingdanhao}</td>     <td width='11%'>婚纱编号：</td><td width='39%'>${hunshayuding.hunshabianhao}</td></tr><tr>     <td width='11%'>婚纱名称：</td><td width='39%'>${hunshayuding.hunshamingcheng}</td>     <td width='11%'>婚纱类型：</td><td width='39%'>${hunshayuding.hunshaleixing}</td></tr><tr>     <td width='11%'>联系电话：</td><td width='39%'>${hunshayuding.lianxidianhua}</td>     <td width='11%'>价格：</td><td width='39%'>${hunshayuding.jiage}</td></tr><tr>     <td width='11%'>预订人：</td><td width='39%'>${hunshayuding.yudingren}</td>     <td width='11%'>备注：</td><td width='39%'>${hunshayuding.beizhu}</td>     </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

