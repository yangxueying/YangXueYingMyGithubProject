<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="hunshayudinghsgb" scope="page" class="com.bean.HunshayudingBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=hunshayuding.xls");
%>
<html>
  <head>
    <title>��ɴԤ��</title>
  </head>

  <body >
 <%
			String sql="select * from hunshayuding  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">���</td>
    <td align='center' bgcolor='#ebf0f7'>������</td>    <td align='center' bgcolor='#ebf0f7'>��ɴ���</td>    <td align='center' bgcolor='#ebf0f7'>��ɴ����</td>    <td align='center' bgcolor='#ebf0f7'>��ɴ����</td>    <td align='center' bgcolor='#ebf0f7'>��ϵ�绰</td>    <td align='center' bgcolor='#ebf0f7'>�۸�</td>    <td align='center' bgcolor='#ebf0f7'>Ԥ����</td>        <td  width='80' align='center' bgcolor='#ebf0f7'>�Ƿ�֧��</td>    
	
    <td width="120" align="center" bgcolor="CCFFFF">���ʱ��</td>
    
  </tr>
   <%		
				List pagelist3=hunshayudinghsgb.getAllHunshayuding(11);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.dingdanhao}</td>    <td>${u.hunshabianhao}</td>    <td>${u.hunshamingcheng}</td>    <td>${u.hunshaleixing}</td>    <td>${u.lianxidianhua}</td>    <td>${u.jiage}</td>    <td>${u.yudingren}</td>        <td align='center' bgcolor='#ebf0f7'>${u.iszf} </td>    
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

