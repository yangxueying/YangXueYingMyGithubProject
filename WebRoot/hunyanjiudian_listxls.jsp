<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="hunyanjiudianhsgb" scope="page" class="com.bean.HunyanjiudianBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=hunyanjiudian.xls");
%>
<html>
  <head>
    <title>����Ƶ�</title>
  </head>

  <body >
 <%
			String sql="select * from hunyanjiudian  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">���</td>
    <td align='center' bgcolor='#ebf0f7'>�Ƶ���</td>    <td align='center' bgcolor='#ebf0f7'>�Ƶ�����</td>    <td  width='90' align='center' bgcolor='#ebf0f7'>ͼƬ</td>    <td align='center' bgcolor='#ebf0f7'>�Ǽ�</td>    <td align='center' bgcolor='#ebf0f7'>�۸�</td>    <td align='center' bgcolor='#ebf0f7'>��ϵ�绰</td>    <td align='center' bgcolor='#ebf0f7'>��ַ</td>        
	
    <td width="120" align="center" bgcolor="CCFFFF">���ʱ��</td>
    
  </tr>
   <%		
				List pagelist3=hunyanjiudianhsgb.getAllHunyanjiudian(10);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.jiudianbianhao}</td>    <td>${u.jiudianmingcheng}</td>    <td width='90' align='center' bgcolor='#ebf0f7'><a href='${u.tupian}' target='_blank'><img src='${u.tupian}' width=88 height=99 border=0 /></a></td>    <td>${u.xingji}</td>    <td>${u.jiage}</td>    <td>${u.lianxidianhua}</td>    <td>${u.dizhi}</td>        
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

