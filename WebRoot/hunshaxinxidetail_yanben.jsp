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
<title>��ɴ��Ϣ</title>

  <link rel="stylesheet" href="qtimages/common.css"> 
  <link rel="stylesheet" href="qtimages/jquery-ui.min.css">
  <link rel="stylesheet" type="text/css" href="qtimages/swiper.min.css">   
  <link rel="stylesheet" type="text/css" href="qtimages/index.css">   

</head>
<script language=javascript src='js/popup.js'></script>
<script language=javascript> 
function hsgpinglun(nbiao,nid){ 
popheight=450;
pop('hsgpinglun.jsp?biao='+nbiao+'&id='+nid,'��������',550,250) ;
}
</script> 
<%
	String id=request.getParameter("id");
	
     %>
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
    <h1>�����������</h1>
    <br>
    <h2>����ʼ�ڼҵĸо�����ÿһ�η����а�֮��</h2>
    <h2>�����ǰ��ѵ��ǣ���������������Լ���һ��������</h2>
  </aside>


  <div class="family">
    <h1>��ɴ��Ϣ</h1>
    <h2>���ʵķ��񣬸��ٸ��ʣ�ֻΪ����һ������....</h2>
    <div class="swiper-container-banner swiper-container-horizontal">
     
	 
	 
   <table width="100%" border="0" align="center" cellpadding="3" cellspacing="1" bordercolor="#00FFFF" style="border-collapse:collapse"  class="newsline">  
      <tr>
		 <td width='11%' height=44>��ɴ��ţ�</td><td width='39%'>${hunshaxinxi.hunshabianhao}</td><td  rowspan=5 align=center><a href=${hunshaxinxi.tupian} target=_blank><img src=${hunshaxinxi.tupian}  width=228 height=215 border=0></a></td></tr><tr>         <td width='11%' height=44>��ɴ���ƣ�</td><td width='39%'>${hunshaxinxi.hunshamingcheng}</td></tr><tr>         <td width='11%' height=44>��ɴ���ͣ�</td><td width='39%'>${hunshaxinxi.hunshaleixing}</td></tr><tr>                  <td width='11%' height=44>��ϵ�绰��</td><td width='39%'>${hunshaxinxi.lianxidianhua}</td></tr><tr>         <td width='11%' height=44>�۸�</td><td width='39%'>${hunshaxinxi.jiage}</td></tr><tr>                  <td width='11%' height=100  >��ϸ��</td><td width='39%' colspan=2 height=100 >${hunshaxinxi.xiangxi}</td></tr><tr>							 
                                <td colspan="3"><table width="100%" border="0" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse" class="newsline">
                                  <tr>
                                    <td width="30" align="center" bgcolor="CCFFFF">���</td>
                                    <td width="471" bgcolor='#CCFFFF'>��������</td>
                                    <td width="88" bgcolor='#CCFFFF'>����</td>
                                    <td width="88" bgcolor='#CCFFFF'>������</td>
                                    <td width="138" align="center" bgcolor="CCFFFF">����ʱ��</td>
                                  </tr>
								  <%@page import="com.util.db"%>
                                   <%
								   int pli=0;
    for(HashMap map:new db().getpinglun("hunshaxinxi",id)){
	pli=pli+1;
     %>
                                   <tr>
                                    <td width="30" align="center" bgcolor='#CCFF99'><%=pli%></td>
                                    <td width="471" bgcolor='#CCFF99'><%=map.get("pinglunneirong") %></td>
                                    <td width="88" bgcolor='#CCFF99'><%=map.get("pingfen") %></td>
                                    <td width="88" bgcolor='#CCFF99'><%=map.get("pinglunren") %></td>
                                    <td width="138" align="center" bgcolor="CCFF99"><%=map.get("addtime") %></td>
                                  </tr>
                                  <%
								 
								  }
								   %>
                                </table></td>
                                </tr><tr><td colspan=3 align=center><input type=button name=Submit5 value=���� onClick="javascript:history.back()" /><input type=button name=Submit52 value=��ӡ onClick="javascript:window.print()" /> <!--jixaaxnnxiu--><input type=button name=Submit53 value=���� onClick="javascript:hsgpinglun('hunshaxinxi','<%=id%>')"/></td></tr>
    
  </table>
						
					  
    
    </div>
  </div>
  <div class="ensure">
    <h1>��������ÿһ�η���</h1>
    <div>
      <img src="qtimages/home_icon_baozhang.png">
      <h2>����</h2>
      <h3>�����ȫ����ͨ������<br>���϶�����ȫ�����ܱ��Ϸ���</h3>
    </div>
    <div>
      <img src="qtimages/home_icon_longyang.png">
      <h2>�ܾ�����</h2>
      <h3>ӵ���ڼ�һ�����ɵĿռ䡢���޵����</h3>
    </div>
    <div>
      <img src="qtimages/home_icon_zijin.png">
      <h2>������ȫ</h2>
      <h3>����֧��<br>����󣬲Ż��յ�����</h3>
    </div>
    <div>
      <img src="qtimages/home_icon_renzheng.png">
      <h2>ʵ����Ƶ��֤</h2>
      <h3>����ݺͻ����ϸ���֤<br>ƽ̨��ܡ�׷��ÿһ�����϶���</h3>
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

