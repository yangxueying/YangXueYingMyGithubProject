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
		<TITLE>修改婚礼策划</TITLE>
	    
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   
       
	</head>
<%
  String id="";
 
   %>
<script language="javascript">

function gows()
{
	document.location.href="hunlicehua_add.jsp?id=<%=id%>";
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
			<form action="updateHunlicehua.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="30" colspan="2" background="images/table_header.gif">修改婚礼策划<input type="hidden" name="id" value="${hunlicehua.id}" /></td>
						</tr>
						<tr ><td width="200">策划方案：</td><td><input name='cehuafangan' type='text' id='cehuafangan' value='' onblur='hsgcheck()' class="form-control" />&nbsp;*<label id='clabelcehuafangan' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">价格：</td><td><input name='jiage' type='text' id='jiage' value='' onblur='checkform()' class="form-control" />&nbsp;<label id='clabeljiage' style='margin-top:16px;' />必需数字型</td></tr>		<tr ><td width="200">联系电话：</td><td><input name='lianxidianhua' type='text' id='lianxidianhua' value='' onblur='checkform()' class="form-control" />&nbsp;<label id='clabellianxidianhua' style='margin-top:16px;' />必需电话格式[7或8位电话，或11位手机]</td></tr>		<tr ><td width="200">地址：</td><td><input name='dizhi' type='text' id='dizhi' value='' onblur='' size='50' class="form-control" style="width:600px;" /></td></tr>		<tr ><td width="200">图片：</td><td><input name='tupian' type='text' id='tupian' size='50' value='' onblur='checkform()'  class="form-control" /><div style="margin-top:16px;">&nbsp;<input type='button' value='上传' onClick="up('tupian')"/></div>&nbsp;*<label id='clabeltupian' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">详细：</td><td><textarea name='xiangxi' cols='50' rows='5' id='xiangxi' onblur='' class="form-control" style="width:600px; height:80px;" ></textarea></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%" height="45"  align="right">&nbsp;						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();" class="btn btn-info btn-small" />
						       <input type="reset" value="重置" class="btn btn-info btn-small" />&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.cehuafangan.value='${hunlicehua.cehuafangan}';</script>	<script language="javascript">document.form1.jiage.value='${hunlicehua.jiage}';</script>	<script language="javascript">document.form1.lianxidianhua.value='${hunlicehua.lianxidianhua}';</script>	<script language="javascript">document.form1.dizhi.value='${hunlicehua.dizhi}';</script>	<script language="javascript">document.form1.tupian.value='${hunlicehua.tupian}';</script>	<script language="javascript">document.form1.xiangxi.value='${hunlicehua.xiangxi}';</script>	
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	var cehuafanganobj = document.getElementById("cehuafangan"); if(cehuafanganobj.value==""){document.getElementById("clabelcehuafangan").innerHTML="&nbsp;&nbsp;<font color=red>请输入策划方案</font>";return false;}else{document.getElementById("clabelcehuafangan").innerHTML="  "; } 	    var lianxidianhuaobj = document.getElementById("lianxidianhua"); if(lianxidianhuaobj.value!=""){ if(/^(([0\+]\d{2,3}-)?(0\d{2,3})-)?(\d{7,8})(-(\d{3,}))?$/.test(lianxidianhuaobj.value) || /^1[3|4|5|6|7|8|9][0-9]\d{8,8}$/.test(lianxidianhuaobj.value)){document.getElementById("clabellianxidianhua").innerHTML=""; }else{document.getElementById("clabellianxidianhua").innerHTML="&nbsp;&nbsp;<font color=red>必需电话格式[7或8位电话，或11位手机]</font>"; return false;}}      var tupianobj = document.getElementById("tupian"); if(tupianobj.value==""){document.getElementById("clabeltupian").innerHTML="&nbsp;&nbsp;<font color=red>请输入图片</font>";return false;}else{document.getElementById("clabeltupian").innerHTML="  "; } 	


return true;   
}   
popheight=450;
</script>  
