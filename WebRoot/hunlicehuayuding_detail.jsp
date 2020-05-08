<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>婚礼策划预订详细</title>
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   

  </head>

  <body >

  婚礼策划预订详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>订单号：</td><td width='39%'>${hunlicehuayuding.dingdanhao}</td>     <td width='11%'>策划方案：</td><td width='39%'>${hunlicehuayuding.cehuafangan}</td></tr><tr>     <td width='11%'>价格：</td><td width='39%'>${hunlicehuayuding.jiage}</td>     <td width='11%'>联系电话：</td><td width='39%'>${hunlicehuayuding.lianxidianhua}</td></tr><tr>     <td width='11%'>地址：</td><td width='39%'>${hunlicehuayuding.dizhi}</td>     <td width='11%'>预订人：</td><td width='39%'>${hunlicehuayuding.yudingren}</td></tr><tr>     <td width='11%'>备注：</td><td width='39%'>${hunlicehuayuding.beizhu}</td>     <td>&nbsp;</td><td>&nbsp;</td></tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

