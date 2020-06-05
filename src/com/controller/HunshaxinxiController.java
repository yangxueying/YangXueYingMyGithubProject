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

import com.entity.Hunshaxinxi;
import com.server.HunshaxinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class HunshaxinxiController {
	@Resource
	private HunshaxinxiServer hunshaxinxiService;


   
	@RequestMapping("addHunshaxinxi.do")
	public String addHunshaxinxi(HttpServletRequest request,Hunshaxinxi hunshaxinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		hunshaxinxi.setAddtime(time.toString().substring(0, 19));
		hunshaxinxiService.add(hunshaxinxi);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "hunshaxinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:hunshaxinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateHunshaxinxi.do")
	public String doUpdateHunshaxinxi(int id,ModelMap map,Hunshaxinxi hunshaxinxi){
		hunshaxinxi=hunshaxinxiService.getById(id);
		map.put("hunshaxinxi", hunshaxinxi);
		return "hunshaxinxi_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("hunshaxinxiDetail.do")
	public String hunshaxinxiDetail(int id,ModelMap map,Hunshaxinxi hunshaxinxi){
		hunshaxinxi=hunshaxinxiService.getById(id);
		map.put("hunshaxinxi", hunshaxinxi);
		return "hunshaxinxi_detail";
	}
//	前台详细
	@RequestMapping("hsxxDetail.do")
	public String hsxxDetail(int id,ModelMap map,Hunshaxinxi hunshaxinxi){
		hunshaxinxi=hunshaxinxiService.getById(id);
		map.put("hunshaxinxi", hunshaxinxi);
		return "hunshaxinxidetail";
	}
//	
	@RequestMapping("updateHunshaxinxi.do")
	public String updateHunshaxinxi(int id,ModelMap map,Hunshaxinxi hunshaxinxi,HttpServletRequest request,HttpSession session){
		hunshaxinxiService.update(hunshaxinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:hunshaxinxiList.do";
	}

//	分页查询
	@RequestMapping("hunshaxinxiList.do")
	public String hunshaxinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hunshaxinxi hunshaxinxi, String hunshabianhao, String hunshamingcheng, String hunshaleixing, String tupian, String lianxidianhua, String jiage1,String jiage2, String xiangxi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(hunshabianhao==null||hunshabianhao.equals("")){pmap.put("hunshabianhao", null);}else{pmap.put("hunshabianhao", hunshabianhao);}		if(hunshamingcheng==null||hunshamingcheng.equals("")){pmap.put("hunshamingcheng", null);}else{pmap.put("hunshamingcheng", hunshamingcheng);}		if(hunshaleixing==null||hunshaleixing.equals("")){pmap.put("hunshaleixing", null);}else{pmap.put("hunshaleixing", hunshaleixing);}		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(jiage1==null||jiage1.equals("")){pmap.put("jiage1", null);}else{pmap.put("jiage1", jiage1);}		if(jiage2==null||jiage2.equals("")){pmap.put("jiage2", null);}else{pmap.put("jiage2", jiage2);}		if(xiangxi==null||xiangxi.equals("")){pmap.put("xiangxi", null);}else{pmap.put("xiangxi", xiangxi);}		
		int total=hunshaxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hunshaxinxi> list=hunshaxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hunshaxinxi_list";
	}
	
	@RequestMapping("hunshaxinxi_yanben1.do")
	public String hunshaxinxi_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hunshaxinxi hunshaxinxi, String hunshabianhao, String hunshamingcheng, String hunshaleixing, String tupian, String lianxidianhua, String jiage1,String jiage2, String xiangxi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(hunshabianhao==null||hunshabianhao.equals("")){pmap.put("hunshabianhao", null);}else{pmap.put("hunshabianhao", hunshabianhao);}		if(hunshamingcheng==null||hunshamingcheng.equals("")){pmap.put("hunshamingcheng", null);}else{pmap.put("hunshamingcheng", hunshamingcheng);}		if(hunshaleixing==null||hunshaleixing.equals("")){pmap.put("hunshaleixing", null);}else{pmap.put("hunshaleixing", hunshaleixing);}		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(jiage1==null||jiage1.equals("")){pmap.put("jiage1", null);}else{pmap.put("jiage1", jiage1);}		if(jiage2==null||jiage2.equals("")){pmap.put("jiage2", null);}else{pmap.put("jiage2", jiage2);}		if(xiangxi==null||xiangxi.equals("")){pmap.put("xiangxi", null);}else{pmap.put("xiangxi", xiangxi);}		
		int total=hunshaxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hunshaxinxi> list=hunshaxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hunshaxinxi_yanben1";
	}
	@RequestMapping("hunshaxinxi_yanben2.do")
	public String hunshaxinxi_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hunshaxinxi hunshaxinxi, String hunshabianhao, String hunshamingcheng, String hunshaleixing, String tupian, String lianxidianhua, String jiage1,String jiage2, String xiangxi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(hunshabianhao==null||hunshabianhao.equals("")){pmap.put("hunshabianhao", null);}else{pmap.put("hunshabianhao", hunshabianhao);}		if(hunshamingcheng==null||hunshamingcheng.equals("")){pmap.put("hunshamingcheng", null);}else{pmap.put("hunshamingcheng", hunshamingcheng);}		if(hunshaleixing==null||hunshaleixing.equals("")){pmap.put("hunshaleixing", null);}else{pmap.put("hunshaleixing", hunshaleixing);}		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(jiage1==null||jiage1.equals("")){pmap.put("jiage1", null);}else{pmap.put("jiage1", jiage1);}		if(jiage2==null||jiage2.equals("")){pmap.put("jiage2", null);}else{pmap.put("jiage2", jiage2);}		if(xiangxi==null||xiangxi.equals("")){pmap.put("xiangxi", null);}else{pmap.put("xiangxi", xiangxi);}		
		int total=hunshaxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hunshaxinxi> list=hunshaxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hunshaxinxi_yanben2";
	}
	@RequestMapping("hunshaxinxi_yanben3.do")
	public String hunshaxinxi_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hunshaxinxi hunshaxinxi, String hunshabianhao, String hunshamingcheng, String hunshaleixing, String tupian, String lianxidianhua, String jiage1,String jiage2, String xiangxi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(hunshabianhao==null||hunshabianhao.equals("")){pmap.put("hunshabianhao", null);}else{pmap.put("hunshabianhao", hunshabianhao);}		if(hunshamingcheng==null||hunshamingcheng.equals("")){pmap.put("hunshamingcheng", null);}else{pmap.put("hunshamingcheng", hunshamingcheng);}		if(hunshaleixing==null||hunshaleixing.equals("")){pmap.put("hunshaleixing", null);}else{pmap.put("hunshaleixing", hunshaleixing);}		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(jiage1==null||jiage1.equals("")){pmap.put("jiage1", null);}else{pmap.put("jiage1", jiage1);}		if(jiage2==null||jiage2.equals("")){pmap.put("jiage2", null);}else{pmap.put("jiage2", jiage2);}		if(xiangxi==null||xiangxi.equals("")){pmap.put("xiangxi", null);}else{pmap.put("xiangxi", xiangxi);}		
		int total=hunshaxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hunshaxinxi> list=hunshaxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hunshaxinxi_yanben3";
	}
	@RequestMapping("hunshaxinxi_yanben4.do")
	public String hunshaxinxi_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hunshaxinxi hunshaxinxi, String hunshabianhao, String hunshamingcheng, String hunshaleixing, String tupian, String lianxidianhua, String jiage1,String jiage2, String xiangxi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(hunshabianhao==null||hunshabianhao.equals("")){pmap.put("hunshabianhao", null);}else{pmap.put("hunshabianhao", hunshabianhao);}		if(hunshamingcheng==null||hunshamingcheng.equals("")){pmap.put("hunshamingcheng", null);}else{pmap.put("hunshamingcheng", hunshamingcheng);}		if(hunshaleixing==null||hunshaleixing.equals("")){pmap.put("hunshaleixing", null);}else{pmap.put("hunshaleixing", hunshaleixing);}		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(jiage1==null||jiage1.equals("")){pmap.put("jiage1", null);}else{pmap.put("jiage1", jiage1);}		if(jiage2==null||jiage2.equals("")){pmap.put("jiage2", null);}else{pmap.put("jiage2", jiage2);}		if(xiangxi==null||xiangxi.equals("")){pmap.put("xiangxi", null);}else{pmap.put("xiangxi", xiangxi);}		
		int total=hunshaxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hunshaxinxi> list=hunshaxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hunshaxinxi_yanben4";
	}
	@RequestMapping("hunshaxinxi_yanben5.do")
	public String hunshaxinxi_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hunshaxinxi hunshaxinxi, String hunshabianhao, String hunshamingcheng, String hunshaleixing, String tupian, String lianxidianhua, String jiage1,String jiage2, String xiangxi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(hunshabianhao==null||hunshabianhao.equals("")){pmap.put("hunshabianhao", null);}else{pmap.put("hunshabianhao", hunshabianhao);}		if(hunshamingcheng==null||hunshamingcheng.equals("")){pmap.put("hunshamingcheng", null);}else{pmap.put("hunshamingcheng", hunshamingcheng);}		if(hunshaleixing==null||hunshaleixing.equals("")){pmap.put("hunshaleixing", null);}else{pmap.put("hunshaleixing", hunshaleixing);}		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(jiage1==null||jiage1.equals("")){pmap.put("jiage1", null);}else{pmap.put("jiage1", jiage1);}		if(jiage2==null||jiage2.equals("")){pmap.put("jiage2", null);}else{pmap.put("jiage2", jiage2);}		if(xiangxi==null||xiangxi.equals("")){pmap.put("xiangxi", null);}else{pmap.put("xiangxi", xiangxi);}		
		int total=hunshaxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hunshaxinxi> list=hunshaxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hunshaxinxi_yanben5";
	}
	
	
	
	@RequestMapping("hsxxList.do")
	public String hsxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hunshaxinxi hunshaxinxi, String hunshabianhao, String hunshamingcheng, String hunshaleixing, String tupian, String lianxidianhua, String jiage1,String jiage2, String xiangxi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(hunshabianhao==null||hunshabianhao.equals("")){pmap.put("hunshabianhao", null);}else{pmap.put("hunshabianhao", hunshabianhao);}		if(hunshamingcheng==null||hunshamingcheng.equals("")){pmap.put("hunshamingcheng", null);}else{pmap.put("hunshamingcheng", hunshamingcheng);}		if(hunshaleixing==null||hunshaleixing.equals("")){pmap.put("hunshaleixing", null);}else{pmap.put("hunshaleixing", hunshaleixing);}		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(jiage1==null||jiage1.equals("")){pmap.put("jiage1", null);}else{pmap.put("jiage1", jiage1);}		if(jiage2==null||jiage2.equals("")){pmap.put("jiage2", null);}else{pmap.put("jiage2", jiage2);}		if(xiangxi==null||xiangxi.equals("")){pmap.put("xiangxi", null);}else{pmap.put("xiangxi", xiangxi);}		
		int total=hunshaxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hunshaxinxi> list=hunshaxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hunshaxinxilist";
	}
	@RequestMapping("hsxxListtp.do")
	public String hsxxListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hunshaxinxi hunshaxinxi, String hunshabianhao, String hunshamingcheng, String hunshaleixing, String tupian, String lianxidianhua, String jiage1,String jiage2, String xiangxi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(hunshabianhao==null||hunshabianhao.equals("")){pmap.put("hunshabianhao", null);}else{pmap.put("hunshabianhao", hunshabianhao);}		if(hunshamingcheng==null||hunshamingcheng.equals("")){pmap.put("hunshamingcheng", null);}else{pmap.put("hunshamingcheng", hunshamingcheng);}		if(hunshaleixing==null||hunshaleixing.equals("")){pmap.put("hunshaleixing", null);}else{pmap.put("hunshaleixing", hunshaleixing);}		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(jiage1==null||jiage1.equals("")){pmap.put("jiage1", null);}else{pmap.put("jiage1", jiage1);}		if(jiage2==null||jiage2.equals("")){pmap.put("jiage2", null);}else{pmap.put("jiage2", jiage2);}		if(xiangxi==null||xiangxi.equals("")){pmap.put("xiangxi", null);}else{pmap.put("xiangxi", xiangxi);}		
		int total=hunshaxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hunshaxinxi> list=hunshaxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hunshaxinxilisttp";
	}
	
	@RequestMapping("deleteHunshaxinxi.do")
	public String deleteHunshaxinxi(int id,HttpServletRequest request){
		hunshaxinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:hunshaxinxiList.do";
	}
	
	@RequestMapping("quchongHunshaxinxi.do")
	public void quchongHunshaxinxi(Hunshaxinxi hunshaxinxi,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("hunshamingcheng", hunshaxinxi.getHunshamingcheng());
		   System.out.println("hunshamingcheng==="+hunshaxinxi.getHunshamingcheng());
		   System.out.println("hunshamingcheng222==="+hunshaxinxiService.quchongHunshaxinxi(map));
		   JSONObject obj=new JSONObject();
		   if(hunshaxinxiService.quchongHunshaxinxi(map)!=null){
				 obj.put("info", "ng");
			   }else{
				   obj.put("info", "婚纱名称可以用！");
				  
			   }
		   response.setContentType("text/html;charset=utf-8");
		   PrintWriter out=null;
		   try {
			out=response.getWriter();
			out.print(obj);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			out.close();
		}
	}
}
