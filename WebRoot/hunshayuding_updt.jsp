﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>


<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<TITLE>修改婚纱预订</TITLE>
	    
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   
       
	</head>
<%
  String id="";
 
   %>
<script language="javascript">

function gows()
{
	document.location.href="hunshayuding_add.jsp?id=<%=id%>";
}
function hsgxia2shxurxu(nstr,nwbk)
{
	if (eval("form1."+nwbk).value.indexOf(nstr)>=0)
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value.replace(nstr+"；", "");
	}
	else
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value+nstr+"；";
	}
}
</script>
	<body>
			<form action="updateHunshayuding.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="30" colspan="2" background="images/table_header.gif">修改婚纱预订<input type="hidden" name="id" value="${hunshayuding.id}" /></td>
						</tr>
						<tr ><td width="200">订单号：</td><td><input name='dingdanhao' type='text' id='dingdanhao' value='<%=connDbBean.getID()%>' onblur='' class="form-control" /></td></tr>		<tr ><td width="200">婚纱编号：</td><td><input name='hunshabianhao' type='text' id='hunshabianhao' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>		<tr ><td width="200">婚纱名称：</td><td><input name='hunshamingcheng' type='text' id='hunshamingcheng' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>		<tr ><td width="200">婚纱类型：</td><td><input name='hunshaleixing' type='text' id='hunshaleixing' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>		<tr ><td width="200">联系电话：</td><td><input name='lianxidianhua' type='text' id='lianxidianhua' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>		<tr ><td width="200">价格：</td><td><input name='jiage' type='text' id='jiage' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>		<tr ><td width="200">预订人：</td><td><input name='yudingren' type='text' id='yudingren' onblur='' class="form-control" value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly" /></td></tr>		<tr ><td width="200">备注：</td><td><textarea name='beizhu' cols='50' rows='5' id='beizhu' onblur='' class="form-control" style="width:600px; height:80px;" ></textarea></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%" height="45"  align="right">&nbsp;						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();" class="btn btn-info btn-small" />
						       <input type="reset" value="重置" class="btn btn-info btn-small" />&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.dingdanhao.value='${hunshayuding.dingdanhao}';</script>	<script language="javascript">document.form1.hunshabianhao.value='${hunshayuding.hunshabianhao}';</script>	<script language="javascript">document.form1.hunshamingcheng.value='${hunshayuding.hunshamingcheng}';</script>	<script language="javascript">document.form1.hunshaleixing.value='${hunshayuding.hunshaleixing}';</script>	<script language="javascript">document.form1.lianxidianhua.value='${hunshayuding.lianxidianhua}';</script>	<script language="javascript">document.form1.jiage.value='${hunshayuding.jiage}';</script>	<script language="javascript">document.form1.yudingren.value='${hunshayuding.yudingren}';</script>	<script language="javascript">document.form1.beizhu.value='${hunshayuding.beizhu}';</script>	
					 </table>
			</form>
   </body>
</html>






