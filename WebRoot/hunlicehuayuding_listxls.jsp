<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="hunlicehuayudinghsgb" scope="page" class="com.bean.HunlicehuayudingBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=hunlicehuayuding.xls");
%>
<html>
  <head>
    <title>婚礼策划预订</title>
  </head>

  <body >
 <%
			String sql="select * from hunlicehuayuding  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center' bgcolor='#ebf0f7'>订单号</td>    <td align='center' bgcolor='#ebf0f7'>策划方案</td>    <td align='center' bgcolor='#ebf0f7'>价格</td>    <td align='center' bgcolor='#ebf0f7'>联系电话</td>    <td align='center' bgcolor='#ebf0f7'>地址</td>    <td align='center' bgcolor='#ebf0f7'>预订人</td>        <td  width='80' align='center' bgcolor='#ebf0f7'>是否支付</td>    
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=hunlicehuayudinghsgb.getAllHunlicehuayuding(10);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.dingdanhao}</td>    <td>${u.cehuafangan}</td>    <td>${u.jiage}</td>    <td>${u.lianxidianhua}</td>    <td>${u.dizhi}</td>    <td>${u.yudingren}</td>        <td align='center' bgcolor='#ebf0f7'>${u.iszf} </td>    
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

