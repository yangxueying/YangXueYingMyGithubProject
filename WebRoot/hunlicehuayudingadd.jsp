<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>

<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta name="viewport" content="width=device-width,minimum-scale=1.0,initial-scale=1,maximum-scale=1.0,user-scalable=no">
  <meta content="telephone=no" name="formatdetection">
  <meta content="email=no" name="formatdetection">
  <meta http-equiv="Pragma" content="no-cache">
  <meta http-equiv="Cache-Control" content="no-cache">
  <meta http-equiv="Expires" content="0">
  <meta name="format-detection" content="telephone=no">
<title>婚礼策划预订</title>

  <link rel="stylesheet" href="qtimages/common.css"> 
  <link rel="stylesheet" href="qtimages/jquery-ui.min.css">
  <link rel="stylesheet" type="text/css" href="qtimages/swiper.min.css">   
  <link rel="stylesheet" type="text/css" href="qtimages/index.css">   

</head>
<%
if(request.getSession().getAttribute("username")==null)
{
	out.print("<script>alert('对不起,请您先登陆!');location.href='index.do';</script>");
	return;
}
  String id="";


 



   %>


	
	<script language="javascript">
function checkform()
{
	
}
function gow()
{
	document.location.href="hunlicehuayudingadd.jsp?id=<%=id%>";
}
</script>


<body>
<jsp:include page="qttop.jsp"></jsp:include>
  <div class="swiper-container-top">
    <div class="swiper-wrapper">
        <div class="swiper-slide">
          <img src="qtimages/bb2.jpg">
        </div>
    </div>
  </div>
 
  <div class="bj-gary"></div>
  <aside>
    <h1>享受你的生活</h1>
    <br>
    <h2>爱，始于家的感觉，让每一次服务有爱之旅</h2>
    <h2>让我们摆脱担忧，让你的世界像在自己家一样的生活</h2>
  </aside>


  <div class="family">
    <h1>婚礼策划预订</h1>
    <h2>优质的服务，高速高质，只为您的一个点赞....</h2>
    <div class="swiper-container-banner swiper-container-horizontal">
     
	 
	 <link rel="stylesheet" href="images/hsgcommon/divqt.css" type="text/css">
<% 




%>

  

				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CCCCCC" style="border-collapse:collapse" class="newsline">
						<form action="addHunlicehuayuding.do" name="form1" method="post">
						<tr ><td width="200">订单号：</td><td><input name='dingdanhao' type='text' id='dingdanhao' value='<%=connDbBean.getID()%>' onblur='' class="form-control" /></td></tr>		<tr ><td width="200">策划方案：</td><td><input name='cehuafangan' type='text' id='cehuafangan' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr><script language="javascript">document.form1.cehuafangan.value='<%=connDbBean.readzd("hunlicehua","cehuafangan","id",request.getParameter("id"))%>';document.form1.cehuafangan.setAttribute("readOnly",'true');</script>		<tr ><td width="200">价格：</td><td><input name='jiage' type='text' id='jiage' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr><script language="javascript">document.form1.jiage.value='<%=connDbBean.readzd("hunlicehua","jiage","id",request.getParameter("id"))%>';document.form1.jiage.setAttribute("readOnly",'true');</script>		<tr ><td width="200">联系电话：</td><td><input name='lianxidianhua' type='text' id='lianxidianhua' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr><script language="javascript">document.form1.lianxidianhua.value='<%=connDbBean.readzd("hunlicehua","lianxidianhua","id",request.getParameter("id"))%>';document.form1.lianxidianhua.setAttribute("readOnly",'true');</script>		<tr ><td width="200">地址：</td><td><input name='dizhi' type='text' id='dizhi' value='' onblur='' class="form-control" /></td></tr>		<tr ><td width="200">预订人：</td><td><input name='yudingren' type='text' id='yudingren' onblur='' class="form-control" value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly" /></td></tr>		<tr ><td width="200">备注：</td><td><textarea name='beizhu' cols='50' rows='5' id='beizhu' onblur='' class="form-control" style="width:600px; height:80px;" ></textarea></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						      <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
						</form>
					 </table>
			
			<script language="javascript">popheight = 450;</script>
						
					  
    
    </div>
  </div>
  <div class="ensure">
    <h1>用心做好每一次服务</h1>
    <div>
      <img src="qtimages/home_icon_baozhang.png">
      <h2>保障</h2>
      <h3>解决安全、畅通等问题<br>线上订单，全程享受保障服务</h3>
    </div>
    <div>
      <img src="qtimages/home_icon_longyang.png">
      <h2>拒绝线下</h2>
      <h3>拥有在家一样自由的空间、无限的陪伴</h3>
    </div>
    <div>
      <img src="qtimages/home_icon_zijin.png">
      <h2>担保安全</h2>
      <h3>在线支付<br>满意后，才会收到付款</h3>
    </div>
    <div>
      <img src="qtimages/home_icon_renzheng.png">
      <h2>实名视频认证</h2>
      <h3>对身份和环境严格认证<br>平台监管、追踪每一笔线上订单</h3>
    </div>
  </div>
  <jsp:include page="qtdown.jsp"></jsp:include>
  <script src="qtimages/jweixin-1.0.0.js"></script>
  <script src="qtimages/jquery-1.11.3.min.js"></script>
  <script src="qtimages/wx.js"></script>
  <script src="qtimages/swiper.min.js"></script>
  <script src="qtimages/jquery-ui.min.js"></script>
  <script src="qtimages/index.js"></script>
  
</body> 
</html>
