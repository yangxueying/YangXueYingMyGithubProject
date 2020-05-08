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
		<TITLE>添加婚宴酒店</TITLE>
	    
 	<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">    
	</head>
<%
  String id="";
   %>

<script language="javascript">

function gows()
{
	document.location.href="hunyanjiudian_add.jsp?id=<%=id%>";
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
			<form action="addHunyanjiudian.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="30" colspan="2" background="images/table_header.gif">添加婚宴酒店</td>
						</tr>
						<tr ><td width="200">酒店编号：</td><td><input name='jiudianbianhao' type='text' id='jiudianbianhao' value='<%=connDbBean.getID()%>' onblur='' class="form-control" /></td></tr>
		
						<tr align='center'   height="22">
						    <td height="45"  align="right">&nbsp;						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();" class="btn btn-info btn-small"/>
						       <input type="reset" value="重置" name="Submit2" class="btn btn-info btn-small"/>&nbsp;
						    </td>
						</tr>
					 </table>
			</form>
   </body>
</html>




<script language=javascript >  
function hsgcheck() {
		var jiudianmingcheng = $("#jiudianmingcheng").val();
		if(jiudianmingcheng==""||(jiudianmingcheng.length<3||jiudianmingcheng.length>12)){
			 $("#clabeljiudianmingcheng").html("<font color=red>酒店名称不能为空且长度在3～12位之间！</font>");
			 $("input[id=jiudianmingcheng]").focus();
			 $("#querenzhuce").attr("disabled","disabled");
			 return false;
		} 
		else
		{
			$("#clabeljiudianmingcheng").html("");
			$.ajax({
				url : "quchongHunyanjiudian.do",
				type : "post",
				data : "jiudianmingcheng=" + jiudianmingcheng,
				dataType : "json",
				success:function(result){
				if(result.info=="ng"){
					$("#clabeljiudianmingcheng").html("<font color=red>酒店名称已存在，请更换！</font>");
					$("input[id=jiudianmingcheng]").focus();
					$("#querenzhuce").attr("disabled","disabled");
					return false;
				}
				else
				{
					$("#querenzhuce").removeAttr("disabled");
				}
				},
				error:function(){
					$("#clabeljiudianmingcheng").html("系统异常，请检查错误！");
					$("input[id=jiudianmingcheng]").focus();
					$("#querenzhuce").attr("disabled","disabled");
					return false;
				}
			});
		}
	}
</script>


<script language=javascript >  
 
 function checkform(){  
 
	var jiudianmingchengobj = document.getElementById("jiudianmingcheng"); if(jiudianmingchengobj.value==""){document.getElementById("clabeljiudianmingcheng").innerHTML="&nbsp;&nbsp;<font color=red>请输入酒店名称</font>";return false;}else{document.getElementById("clabeljiudianmingcheng").innerHTML="  "; } 


return true;   
}   
popheight=450;
</script>  
<script src="images/hsgcommon/jq.js"></script>
<script src="images/hsgcommon/common.js"></script>
<script src="images/hsgcommon/bootbox.js"></script>