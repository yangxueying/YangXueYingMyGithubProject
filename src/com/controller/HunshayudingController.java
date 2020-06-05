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

import com.entity.Hunshayuding;
import com.server.HunshayudingServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class HunshayudingController {
	@Resource
	private HunshayudingServer hunshayudingService;


   
	@RequestMapping("addHunshayuding.do")
	public String addHunshayuding(HttpServletRequest request,Hunshayuding hunshayuding,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		hunshayuding.setAddtime(time.toString().substring(0, 19));
		hunshayudingService.add(hunshayuding);
		
		session.setAttribute("backxx", "预订成功!请您在24小时内在线下和商家取得消息，否则预约将被取消");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "hunshayudingList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:hunshayudingList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateHunshayuding.do")
	public String doUpdateHunshayuding(int id,ModelMap map,Hunshayuding hunshayuding){
		hunshayuding=hunshayudingService.getById(id);
		map.put("hunshayuding", hunshayuding);
		return "hunshayuding_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("hunshayudingDetail.do")
	public String hunshayudingDetail(int id,ModelMap map,Hunshayuding hunshayuding){
		hunshayuding=hunshayudingService.getById(id);
		map.put("hunshayuding", hunshayuding);
		return "hunshayuding_detail";
	}
//	前台详细
	@RequestMapping("hsydDetail.do")
	public String hsydDetail(int id,ModelMap map,Hunshayuding hunshayuding){
		hunshayuding=hunshayudingService.getById(id);
		map.put("hunshayuding", hunshayuding);
		return "hunshayudingdetail";
	}
//	
	@RequestMapping("updateHunshayuding.do")
	public String updateHunshayuding(int id,ModelMap map,Hunshayuding hunshayuding,HttpServletRequest request,HttpSession session){
		hunshayudingService.update(hunshayuding);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:hunshayudingList.do";
	}

//	分页查询
	@RequestMapping("hunshayudingList.do")
	public String hunshayudingList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hunshayuding hunshayuding, String dingdanhao, String hunshabianhao, String hunshamingcheng, String hunshaleixing, String lianxidianhua, String jiage, String yudingren, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(dingdanhao==null||dingdanhao.equals("")){pmap.put("dingdanhao", null);}else{pmap.put("dingdanhao", dingdanhao);}
		if(hunshabianhao==null||hunshabianhao.equals("")){pmap.put("hunshabianhao", null);}else{pmap.put("hunshabianhao", hunshabianhao);}
		if(hunshamingcheng==null||hunshamingcheng.equals("")){pmap.put("hunshamingcheng", null);}else{pmap.put("hunshamingcheng", hunshamingcheng);}
		if(hunshaleixing==null||hunshaleixing.equals("")){pmap.put("hunshaleixing", null);}else{pmap.put("hunshaleixing", hunshaleixing);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(yudingren==null||yudingren.equals("")){pmap.put("yudingren", null);}else{pmap.put("yudingren", yudingren);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=hunshayudingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hunshayuding> list=hunshayudingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hunshayuding_list";
	}
	
	@RequestMapping("hunshayuding_yanben1.do")
	public String hunshayuding_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hunshayuding hunshayuding, String dingdanhao, String hunshabianhao, String hunshamingcheng, String hunshaleixing, String lianxidianhua, String jiage, String yudingren, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(dingdanhao==null||dingdanhao.equals("")){pmap.put("dingdanhao", null);}else{pmap.put("dingdanhao", dingdanhao);}
		if(hunshabianhao==null||hunshabianhao.equals("")){pmap.put("hunshabianhao", null);}else{pmap.put("hunshabianhao", hunshabianhao);}
		if(hunshamingcheng==null||hunshamingcheng.equals("")){pmap.put("hunshamingcheng", null);}else{pmap.put("hunshamingcheng", hunshamingcheng);}
		if(hunshaleixing==null||hunshaleixing.equals("")){pmap.put("hunshaleixing", null);}else{pmap.put("hunshaleixing", hunshaleixing);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(yudingren==null||yudingren.equals("")){pmap.put("yudingren", null);}else{pmap.put("yudingren", yudingren);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=hunshayudingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hunshayuding> list=hunshayudingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hunshayuding_yanben1";
	}
	@RequestMapping("hunshayuding_yanben2.do")
	public String hunshayuding_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hunshayuding hunshayuding, String dingdanhao, String hunshabianhao, String hunshamingcheng, String hunshaleixing, String lianxidianhua, String jiage, String yudingren, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(dingdanhao==null||dingdanhao.equals("")){pmap.put("dingdanhao", null);}else{pmap.put("dingdanhao", dingdanhao);}
		if(hunshabianhao==null||hunshabianhao.equals("")){pmap.put("hunshabianhao", null);}else{pmap.put("hunshabianhao", hunshabianhao);}
		if(hunshamingcheng==null||hunshamingcheng.equals("")){pmap.put("hunshamingcheng", null);}else{pmap.put("hunshamingcheng", hunshamingcheng);}
		if(hunshaleixing==null||hunshaleixing.equals("")){pmap.put("hunshaleixing", null);}else{pmap.put("hunshaleixing", hunshaleixing);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(yudingren==null||yudingren.equals("")){pmap.put("yudingren", null);}else{pmap.put("yudingren", yudingren);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=hunshayudingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hunshayuding> list=hunshayudingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hunshayuding_yanben2";
	}
	@RequestMapping("hunshayuding_yanben3.do")
	public String hunshayuding_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hunshayuding hunshayuding, String dingdanhao, String hunshabianhao, String hunshamingcheng, String hunshaleixing, String lianxidianhua, String jiage, String yudingren, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(dingdanhao==null||dingdanhao.equals("")){pmap.put("dingdanhao", null);}else{pmap.put("dingdanhao", dingdanhao);}
		if(hunshabianhao==null||hunshabianhao.equals("")){pmap.put("hunshabianhao", null);}else{pmap.put("hunshabianhao", hunshabianhao);}
		if(hunshamingcheng==null||hunshamingcheng.equals("")){pmap.put("hunshamingcheng", null);}else{pmap.put("hunshamingcheng", hunshamingcheng);}
		if(hunshaleixing==null||hunshaleixing.equals("")){pmap.put("hunshaleixing", null);}else{pmap.put("hunshaleixing", hunshaleixing);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(yudingren==null||yudingren.equals("")){pmap.put("yudingren", null);}else{pmap.put("yudingren", yudingren);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=hunshayudingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hunshayuding> list=hunshayudingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hunshayuding_yanben3";
	}
	@RequestMapping("hunshayuding_yanben4.do")
	public String hunshayuding_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hunshayuding hunshayuding, String dingdanhao, String hunshabianhao, String hunshamingcheng, String hunshaleixing, String lianxidianhua, String jiage, String yudingren, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(dingdanhao==null||dingdanhao.equals("")){pmap.put("dingdanhao", null);}else{pmap.put("dingdanhao", dingdanhao);}
		if(hunshabianhao==null||hunshabianhao.equals("")){pmap.put("hunshabianhao", null);}else{pmap.put("hunshabianhao", hunshabianhao);}
		if(hunshamingcheng==null||hunshamingcheng.equals("")){pmap.put("hunshamingcheng", null);}else{pmap.put("hunshamingcheng", hunshamingcheng);}
		if(hunshaleixing==null||hunshaleixing.equals("")){pmap.put("hunshaleixing", null);}else{pmap.put("hunshaleixing", hunshaleixing);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(yudingren==null||yudingren.equals("")){pmap.put("yudingren", null);}else{pmap.put("yudingren", yudingren);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=hunshayudingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hunshayuding> list=hunshayudingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hunshayuding_yanben4";
	}
	@RequestMapping("hunshayuding_yanben5.do")
	public String hunshayuding_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hunshayuding hunshayuding, String dingdanhao, String hunshabianhao, String hunshamingcheng, String hunshaleixing, String lianxidianhua, String jiage, String yudingren, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(dingdanhao==null||dingdanhao.equals("")){pmap.put("dingdanhao", null);}else{pmap.put("dingdanhao", dingdanhao);}
		if(hunshabianhao==null||hunshabianhao.equals("")){pmap.put("hunshabianhao", null);}else{pmap.put("hunshabianhao", hunshabianhao);}
		if(hunshamingcheng==null||hunshamingcheng.equals("")){pmap.put("hunshamingcheng", null);}else{pmap.put("hunshamingcheng", hunshamingcheng);}
		if(hunshaleixing==null||hunshaleixing.equals("")){pmap.put("hunshaleixing", null);}else{pmap.put("hunshaleixing", hunshaleixing);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(yudingren==null||yudingren.equals("")){pmap.put("yudingren", null);}else{pmap.put("yudingren", yudingren);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=hunshayudingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hunshayuding> list=hunshayudingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hunshayuding_yanben5";
	}
	
	@RequestMapping("hunshayudingList2.do")
	public String hunshayudingList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hunshayuding hunshayuding, String dingdanhao, String hunshabianhao, String hunshamingcheng, String hunshaleixing, String lianxidianhua, String jiage, String yudingren, String beizhu,HttpServletRequest request){
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
		if(dingdanhao==null||dingdanhao.equals("")){pmap.put("dingdanhao", null);}else{pmap.put("dingdanhao", dingdanhao);}
		if(hunshabianhao==null||hunshabianhao.equals("")){pmap.put("hunshabianhao", null);}else{pmap.put("hunshabianhao", hunshabianhao);}
		if(hunshamingcheng==null||hunshamingcheng.equals("")){pmap.put("hunshamingcheng", null);}else{pmap.put("hunshamingcheng", hunshamingcheng);}
		if(hunshaleixing==null||hunshaleixing.equals("")){pmap.put("hunshaleixing", null);}else{pmap.put("hunshaleixing", hunshaleixing);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		
		int total=hunshayudingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hunshayuding> list=hunshayudingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hunshayuding_list2";
	}
	
	
	@RequestMapping("hsydList.do")
	public String hsydList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hunshayuding hunshayuding, String dingdanhao, String hunshabianhao, String hunshamingcheng, String hunshaleixing, String lianxidianhua, String jiage, String yudingren, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(dingdanhao==null||dingdanhao.equals("")){pmap.put("dingdanhao", null);}else{pmap.put("dingdanhao", dingdanhao);}
		if(hunshabianhao==null||hunshabianhao.equals("")){pmap.put("hunshabianhao", null);}else{pmap.put("hunshabianhao", hunshabianhao);}
		if(hunshamingcheng==null||hunshamingcheng.equals("")){pmap.put("hunshamingcheng", null);}else{pmap.put("hunshamingcheng", hunshamingcheng);}
		if(hunshaleixing==null||hunshaleixing.equals("")){pmap.put("hunshaleixing", null);}else{pmap.put("hunshaleixing", hunshaleixing);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(yudingren==null||yudingren.equals("")){pmap.put("yudingren", null);}else{pmap.put("yudingren", yudingren);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=hunshayudingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hunshayuding> list=hunshayudingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hunshayudinglist";
	}
	@RequestMapping("hsydListtp.do")
	public String hsydListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hunshayuding hunshayuding, String dingdanhao, String hunshabianhao, String hunshamingcheng, String hunshaleixing, String lianxidianhua, String jiage, String yudingren, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(dingdanhao==null||dingdanhao.equals("")){pmap.put("dingdanhao", null);}else{pmap.put("dingdanhao", dingdanhao);}
		if(hunshabianhao==null||hunshabianhao.equals("")){pmap.put("hunshabianhao", null);}else{pmap.put("hunshabianhao", hunshabianhao);}
		if(hunshamingcheng==null||hunshamingcheng.equals("")){pmap.put("hunshamingcheng", null);}else{pmap.put("hunshamingcheng", hunshamingcheng);}
		if(hunshaleixing==null||hunshaleixing.equals("")){pmap.put("hunshaleixing", null);}else{pmap.put("hunshaleixing", hunshaleixing);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(yudingren==null||yudingren.equals("")){pmap.put("yudingren", null);}else{pmap.put("yudingren", yudingren);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=hunshayudingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hunshayuding> list=hunshayudingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hunshayudinglisttp";
	}
	
	@RequestMapping("deleteHunshayuding.do")
	public String deleteHunshayuding(int id,HttpServletRequest request){
		hunshayudingService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:hunshayudingList.do";
	}
	
	
}
