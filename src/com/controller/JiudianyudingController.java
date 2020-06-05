package com.controller;

import java.io.File;
import java.io.IOException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.entity.Jiudianyuding;
import com.server.JiudianyudingServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class JiudianyudingController {
	@Resource
	private JiudianyudingServer jiudianyudingService;


   
	@RequestMapping("addJiudianyuding.do")
	public String addJiudianyuding(HttpServletRequest request,Jiudianyuding jiudianyuding,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		jiudianyuding.setAddtime(time.toString().substring(0, 19));
		jiudianyudingService.add(jiudianyuding);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "jiudianyudingList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:jiudianyudingList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateJiudianyuding.do")
	public String doUpdateJiudianyuding(int id,ModelMap map,Jiudianyuding jiudianyuding){
		jiudianyuding=jiudianyudingService.getById(id);
		map.put("jiudianyuding", jiudianyuding);
		return "jiudianyuding_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("jiudianyudingDetail.do")
	public String jiudianyudingDetail(int id,ModelMap map,Jiudianyuding jiudianyuding){
		jiudianyuding=jiudianyudingService.getById(id);
		map.put("jiudianyuding", jiudianyuding);
		return "jiudianyuding_detail";
	}
//	前台详细
	@RequestMapping("jdydDetail.do")
	public String jdydDetail(int id,ModelMap map,Jiudianyuding jiudianyuding){
		jiudianyuding=jiudianyudingService.getById(id);
		map.put("jiudianyuding", jiudianyuding);
		return "jiudianyudingdetail";
	}
//	
	@RequestMapping("updateJiudianyuding.do")
	public String updateJiudianyuding(int id,ModelMap map,Jiudianyuding jiudianyuding,HttpServletRequest request,HttpSession session){
		jiudianyudingService.update(jiudianyuding);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:jiudianyudingList.do";
	}

//	分页查询
	@RequestMapping("jiudianyudingList.do")
	public String jiudianyudingList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiudianyuding jiudianyuding, String dingdanhao, String jiudianbianhao, String jiudianmingcheng, String xingji, String jiage, String lianxidianhua, String dizhi, String yudingren, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(dingdanhao==null||dingdanhao.equals("")){pmap.put("dingdanhao", null);}else{pmap.put("dingdanhao", dingdanhao);}		if(jiudianbianhao==null||jiudianbianhao.equals("")){pmap.put("jiudianbianhao", null);}else{pmap.put("jiudianbianhao", jiudianbianhao);}		if(jiudianmingcheng==null||jiudianmingcheng.equals("")){pmap.put("jiudianmingcheng", null);}else{pmap.put("jiudianmingcheng", jiudianmingcheng);}		if(xingji==null||xingji.equals("")){pmap.put("xingji", null);}else{pmap.put("xingji", xingji);}		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		if(yudingren==null||yudingren.equals("")){pmap.put("yudingren", null);}else{pmap.put("yudingren", yudingren);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		
		int total=jiudianyudingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiudianyuding> list=jiudianyudingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiudianyuding_list";
	}
	
	@RequestMapping("jiudianyuding_yanben1.do")
	public String jiudianyuding_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiudianyuding jiudianyuding, String dingdanhao, String jiudianbianhao, String jiudianmingcheng, String xingji, String jiage, String lianxidianhua, String dizhi, String yudingren, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(dingdanhao==null||dingdanhao.equals("")){pmap.put("dingdanhao", null);}else{pmap.put("dingdanhao", dingdanhao);}		if(jiudianbianhao==null||jiudianbianhao.equals("")){pmap.put("jiudianbianhao", null);}else{pmap.put("jiudianbianhao", jiudianbianhao);}		if(jiudianmingcheng==null||jiudianmingcheng.equals("")){pmap.put("jiudianmingcheng", null);}else{pmap.put("jiudianmingcheng", jiudianmingcheng);}		if(xingji==null||xingji.equals("")){pmap.put("xingji", null);}else{pmap.put("xingji", xingji);}		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		if(yudingren==null||yudingren.equals("")){pmap.put("yudingren", null);}else{pmap.put("yudingren", yudingren);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		
		int total=jiudianyudingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiudianyuding> list=jiudianyudingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiudianyuding_yanben1";
	}
	@RequestMapping("jiudianyuding_yanben2.do")
	public String jiudianyuding_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiudianyuding jiudianyuding, String dingdanhao, String jiudianbianhao, String jiudianmingcheng, String xingji, String jiage, String lianxidianhua, String dizhi, String yudingren, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(dingdanhao==null||dingdanhao.equals("")){pmap.put("dingdanhao", null);}else{pmap.put("dingdanhao", dingdanhao);}		if(jiudianbianhao==null||jiudianbianhao.equals("")){pmap.put("jiudianbianhao", null);}else{pmap.put("jiudianbianhao", jiudianbianhao);}		if(jiudianmingcheng==null||jiudianmingcheng.equals("")){pmap.put("jiudianmingcheng", null);}else{pmap.put("jiudianmingcheng", jiudianmingcheng);}		if(xingji==null||xingji.equals("")){pmap.put("xingji", null);}else{pmap.put("xingji", xingji);}		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		if(yudingren==null||yudingren.equals("")){pmap.put("yudingren", null);}else{pmap.put("yudingren", yudingren);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		
		int total=jiudianyudingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiudianyuding> list=jiudianyudingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiudianyuding_yanben2";
	}
	@RequestMapping("jiudianyuding_yanben3.do")
	public String jiudianyuding_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiudianyuding jiudianyuding, String dingdanhao, String jiudianbianhao, String jiudianmingcheng, String xingji, String jiage, String lianxidianhua, String dizhi, String yudingren, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(dingdanhao==null||dingdanhao.equals("")){pmap.put("dingdanhao", null);}else{pmap.put("dingdanhao", dingdanhao);}		if(jiudianbianhao==null||jiudianbianhao.equals("")){pmap.put("jiudianbianhao", null);}else{pmap.put("jiudianbianhao", jiudianbianhao);}		if(jiudianmingcheng==null||jiudianmingcheng.equals("")){pmap.put("jiudianmingcheng", null);}else{pmap.put("jiudianmingcheng", jiudianmingcheng);}		if(xingji==null||xingji.equals("")){pmap.put("xingji", null);}else{pmap.put("xingji", xingji);}		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		if(yudingren==null||yudingren.equals("")){pmap.put("yudingren", null);}else{pmap.put("yudingren", yudingren);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		
		int total=jiudianyudingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiudianyuding> list=jiudianyudingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiudianyuding_yanben3";
	}
	@RequestMapping("jiudianyuding_yanben4.do")
	public String jiudianyuding_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiudianyuding jiudianyuding, String dingdanhao, String jiudianbianhao, String jiudianmingcheng, String xingji, String jiage, String lianxidianhua, String dizhi, String yudingren, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(dingdanhao==null||dingdanhao.equals("")){pmap.put("dingdanhao", null);}else{pmap.put("dingdanhao", dingdanhao);}		if(jiudianbianhao==null||jiudianbianhao.equals("")){pmap.put("jiudianbianhao", null);}else{pmap.put("jiudianbianhao", jiudianbianhao);}		if(jiudianmingcheng==null||jiudianmingcheng.equals("")){pmap.put("jiudianmingcheng", null);}else{pmap.put("jiudianmingcheng", jiudianmingcheng);}		if(xingji==null||xingji.equals("")){pmap.put("xingji", null);}else{pmap.put("xingji", xingji);}		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		if(yudingren==null||yudingren.equals("")){pmap.put("yudingren", null);}else{pmap.put("yudingren", yudingren);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		
		int total=jiudianyudingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiudianyuding> list=jiudianyudingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiudianyuding_yanben4";
	}
	@RequestMapping("jiudianyuding_yanben5.do")
	public String jiudianyuding_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiudianyuding jiudianyuding, String dingdanhao, String jiudianbianhao, String jiudianmingcheng, String xingji, String jiage, String lianxidianhua, String dizhi, String yudingren, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(dingdanhao==null||dingdanhao.equals("")){pmap.put("dingdanhao", null);}else{pmap.put("dingdanhao", dingdanhao);}		if(jiudianbianhao==null||jiudianbianhao.equals("")){pmap.put("jiudianbianhao", null);}else{pmap.put("jiudianbianhao", jiudianbianhao);}		if(jiudianmingcheng==null||jiudianmingcheng.equals("")){pmap.put("jiudianmingcheng", null);}else{pmap.put("jiudianmingcheng", jiudianmingcheng);}		if(xingji==null||xingji.equals("")){pmap.put("xingji", null);}else{pmap.put("xingji", xingji);}		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		if(yudingren==null||yudingren.equals("")){pmap.put("yudingren", null);}else{pmap.put("yudingren", yudingren);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		
		int total=jiudianyudingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiudianyuding> list=jiudianyudingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiudianyuding_yanben5";
	}
	
	@RequestMapping("jiudianyudingList2.do")
	public String jiudianyudingList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiudianyuding jiudianyuding, String dingdanhao, String jiudianbianhao, String jiudianmingcheng, String xingji, String jiage, String lianxidianhua, String dizhi, String yudingren, String beizhu,HttpServletRequest request){
		/*if(session.getAttribute("user")==null){
			return "login";
		}*/
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		pmap.put("yudingren", (String)request.getSession().getAttribute("username"));
		if(dingdanhao==null||dingdanhao.equals("")){pmap.put("dingdanhao", null);}else{pmap.put("dingdanhao", dingdanhao);}		if(jiudianbianhao==null||jiudianbianhao.equals("")){pmap.put("jiudianbianhao", null);}else{pmap.put("jiudianbianhao", jiudianbianhao);}		if(jiudianmingcheng==null||jiudianmingcheng.equals("")){pmap.put("jiudianmingcheng", null);}else{pmap.put("jiudianmingcheng", jiudianmingcheng);}		if(xingji==null||xingji.equals("")){pmap.put("xingji", null);}else{pmap.put("xingji", xingji);}		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		
		
		int total=jiudianyudingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiudianyuding> list=jiudianyudingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiudianyuding_list2";
	}	
	
	@RequestMapping("jdydList.do")
	public String jdydList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiudianyuding jiudianyuding, String dingdanhao, String jiudianbianhao, String jiudianmingcheng, String xingji, String jiage, String lianxidianhua, String dizhi, String yudingren, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(dingdanhao==null||dingdanhao.equals("")){pmap.put("dingdanhao", null);}else{pmap.put("dingdanhao", dingdanhao);}		if(jiudianbianhao==null||jiudianbianhao.equals("")){pmap.put("jiudianbianhao", null);}else{pmap.put("jiudianbianhao", jiudianbianhao);}		if(jiudianmingcheng==null||jiudianmingcheng.equals("")){pmap.put("jiudianmingcheng", null);}else{pmap.put("jiudianmingcheng", jiudianmingcheng);}		if(xingji==null||xingji.equals("")){pmap.put("xingji", null);}else{pmap.put("xingji", xingji);}		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		if(yudingren==null||yudingren.equals("")){pmap.put("yudingren", null);}else{pmap.put("yudingren", yudingren);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		
		int total=jiudianyudingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiudianyuding> list=jiudianyudingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiudianyudinglist";
	}
	@RequestMapping("jdydListtp.do")
	public String jdydListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiudianyuding jiudianyuding, String dingdanhao, String jiudianbianhao, String jiudianmingcheng, String xingji, String jiage, String lianxidianhua, String dizhi, String yudingren, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(dingdanhao==null||dingdanhao.equals("")){pmap.put("dingdanhao", null);}else{pmap.put("dingdanhao", dingdanhao);}		if(jiudianbianhao==null||jiudianbianhao.equals("")){pmap.put("jiudianbianhao", null);}else{pmap.put("jiudianbianhao", jiudianbianhao);}		if(jiudianmingcheng==null||jiudianmingcheng.equals("")){pmap.put("jiudianmingcheng", null);}else{pmap.put("jiudianmingcheng", jiudianmingcheng);}		if(xingji==null||xingji.equals("")){pmap.put("xingji", null);}else{pmap.put("xingji", xingji);}		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		if(yudingren==null||yudingren.equals("")){pmap.put("yudingren", null);}else{pmap.put("yudingren", yudingren);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		
		int total=jiudianyudingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiudianyuding> list=jiudianyudingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiudianyudinglisttp";
	}
	
	@RequestMapping("deleteJiudianyuding.do")
	public String deleteJiudianyuding(int id,HttpServletRequest request){
		jiudianyudingService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:jiudianyudingList.do";
	}
	
	
}
