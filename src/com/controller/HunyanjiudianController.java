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

import com.entity.Hunyanjiudian;
import com.server.HunyanjiudianServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class HunyanjiudianController {
	@Resource
	private HunyanjiudianServer hunyanjiudianService;


   
	@RequestMapping("addHunyanjiudian.do")
	public String addHunyanjiudian(HttpServletRequest request,Hunyanjiudian hunyanjiudian,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		hunyanjiudian.setAddtime(time.toString().substring(0, 19));
		hunyanjiudianService.add(hunyanjiudian);
		
		session.setAttribute("backxx", "预订成功!请您在24小时内在线下和商家取得消息，否则预约将被取消");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "hunyanjiudianList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:hunyanjiudianList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateHunyanjiudian.do")
	public String doUpdateHunyanjiudian(int id,ModelMap map,Hunyanjiudian hunyanjiudian){
		hunyanjiudian=hunyanjiudianService.getById(id);
		map.put("hunyanjiudian", hunyanjiudian);
		return "hunyanjiudian_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("hunyanjiudianDetail.do")
	public String hunyanjiudianDetail(int id,ModelMap map,Hunyanjiudian hunyanjiudian){
		hunyanjiudian=hunyanjiudianService.getById(id);
		map.put("hunyanjiudian", hunyanjiudian);
		return "hunyanjiudian_detail";
	}
//	前台详细
	@RequestMapping("hyjdDetail.do")
	public String hyjdDetail(int id,ModelMap map,Hunyanjiudian hunyanjiudian){
		hunyanjiudian=hunyanjiudianService.getById(id);
		map.put("hunyanjiudian", hunyanjiudian);
		return "hunyanjiudiandetail";
	}
//	
	@RequestMapping("updateHunyanjiudian.do")
	public String updateHunyanjiudian(int id,ModelMap map,Hunyanjiudian hunyanjiudian,HttpServletRequest request,HttpSession session){
		hunyanjiudianService.update(hunyanjiudian);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:hunyanjiudianList.do";
	}

//	分页查询
	@RequestMapping("hunyanjiudianList.do")
	public String hunyanjiudianList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hunyanjiudian hunyanjiudian, String jiudianbianhao, String jiudianmingcheng, String tupian, String xingji, String jiage1,String jiage2, String lianxidianhua, String dizhi, String jiudianjianjie){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(jiudianbianhao==null||jiudianbianhao.equals("")){pmap.put("jiudianbianhao", null);}else{pmap.put("jiudianbianhao", jiudianbianhao);}
		if(jiudianmingcheng==null||jiudianmingcheng.equals("")){pmap.put("jiudianmingcheng", null);}else{pmap.put("jiudianmingcheng", jiudianmingcheng);}
		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}
		if(xingji==null||xingji.equals("")){pmap.put("xingji", null);}else{pmap.put("xingji", xingji);}
		if(jiage1==null||jiage1.equals("")){pmap.put("jiage1", null);}else{pmap.put("jiage1", jiage1);}
		if(jiage2==null||jiage2.equals("")){pmap.put("jiage2", null);}else{pmap.put("jiage2", jiage2);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(jiudianjianjie==null||jiudianjianjie.equals("")){pmap.put("jiudianjianjie", null);}else{pmap.put("jiudianjianjie", jiudianjianjie);}
		
		int total=hunyanjiudianService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hunyanjiudian> list=hunyanjiudianService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hunyanjiudian_list";
	}
	
	@RequestMapping("hunyanjiudian_yanben1.do")
	public String hunyanjiudian_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hunyanjiudian hunyanjiudian, String jiudianbianhao, String jiudianmingcheng, String tupian, String xingji, String jiage1,String jiage2, String lianxidianhua, String dizhi, String jiudianjianjie){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(jiudianbianhao==null||jiudianbianhao.equals("")){pmap.put("jiudianbianhao", null);}else{pmap.put("jiudianbianhao", jiudianbianhao);}
		if(jiudianmingcheng==null||jiudianmingcheng.equals("")){pmap.put("jiudianmingcheng", null);}else{pmap.put("jiudianmingcheng", jiudianmingcheng);}
		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}
		if(xingji==null||xingji.equals("")){pmap.put("xingji", null);}else{pmap.put("xingji", xingji);}
		if(jiage1==null||jiage1.equals("")){pmap.put("jiage1", null);}else{pmap.put("jiage1", jiage1);}
		if(jiage2==null||jiage2.equals("")){pmap.put("jiage2", null);}else{pmap.put("jiage2", jiage2);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(jiudianjianjie==null||jiudianjianjie.equals("")){pmap.put("jiudianjianjie", null);}else{pmap.put("jiudianjianjie", jiudianjianjie);}
		
		int total=hunyanjiudianService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hunyanjiudian> list=hunyanjiudianService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hunyanjiudian_yanben1";
	}
	@RequestMapping("hunyanjiudian_yanben2.do")
	public String hunyanjiudian_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hunyanjiudian hunyanjiudian, String jiudianbianhao, String jiudianmingcheng, String tupian, String xingji, String jiage1,String jiage2, String lianxidianhua, String dizhi, String jiudianjianjie){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(jiudianbianhao==null||jiudianbianhao.equals("")){pmap.put("jiudianbianhao", null);}else{pmap.put("jiudianbianhao", jiudianbianhao);}
		if(jiudianmingcheng==null||jiudianmingcheng.equals("")){pmap.put("jiudianmingcheng", null);}else{pmap.put("jiudianmingcheng", jiudianmingcheng);}
		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}
		if(xingji==null||xingji.equals("")){pmap.put("xingji", null);}else{pmap.put("xingji", xingji);}
		if(jiage1==null||jiage1.equals("")){pmap.put("jiage1", null);}else{pmap.put("jiage1", jiage1);}
		if(jiage2==null||jiage2.equals("")){pmap.put("jiage2", null);}else{pmap.put("jiage2", jiage2);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(jiudianjianjie==null||jiudianjianjie.equals("")){pmap.put("jiudianjianjie", null);}else{pmap.put("jiudianjianjie", jiudianjianjie);}
		
		int total=hunyanjiudianService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hunyanjiudian> list=hunyanjiudianService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hunyanjiudian_yanben2";
	}
	@RequestMapping("hunyanjiudian_yanben3.do")
	public String hunyanjiudian_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hunyanjiudian hunyanjiudian, String jiudianbianhao, String jiudianmingcheng, String tupian, String xingji, String jiage1,String jiage2, String lianxidianhua, String dizhi, String jiudianjianjie){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(jiudianbianhao==null||jiudianbianhao.equals("")){pmap.put("jiudianbianhao", null);}else{pmap.put("jiudianbianhao", jiudianbianhao);}
		if(jiudianmingcheng==null||jiudianmingcheng.equals("")){pmap.put("jiudianmingcheng", null);}else{pmap.put("jiudianmingcheng", jiudianmingcheng);}
		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}
		if(xingji==null||xingji.equals("")){pmap.put("xingji", null);}else{pmap.put("xingji", xingji);}
		if(jiage1==null||jiage1.equals("")){pmap.put("jiage1", null);}else{pmap.put("jiage1", jiage1);}
		if(jiage2==null||jiage2.equals("")){pmap.put("jiage2", null);}else{pmap.put("jiage2", jiage2);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(jiudianjianjie==null||jiudianjianjie.equals("")){pmap.put("jiudianjianjie", null);}else{pmap.put("jiudianjianjie", jiudianjianjie);}
		
		int total=hunyanjiudianService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hunyanjiudian> list=hunyanjiudianService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hunyanjiudian_yanben3";
	}
	@RequestMapping("hunyanjiudian_yanben4.do")
	public String hunyanjiudian_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hunyanjiudian hunyanjiudian, String jiudianbianhao, String jiudianmingcheng, String tupian, String xingji, String jiage1,String jiage2, String lianxidianhua, String dizhi, String jiudianjianjie){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(jiudianbianhao==null||jiudianbianhao.equals("")){pmap.put("jiudianbianhao", null);}else{pmap.put("jiudianbianhao", jiudianbianhao);}
		if(jiudianmingcheng==null||jiudianmingcheng.equals("")){pmap.put("jiudianmingcheng", null);}else{pmap.put("jiudianmingcheng", jiudianmingcheng);}
		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}
		if(xingji==null||xingji.equals("")){pmap.put("xingji", null);}else{pmap.put("xingji", xingji);}
		if(jiage1==null||jiage1.equals("")){pmap.put("jiage1", null);}else{pmap.put("jiage1", jiage1);}
		if(jiage2==null||jiage2.equals("")){pmap.put("jiage2", null);}else{pmap.put("jiage2", jiage2);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(jiudianjianjie==null||jiudianjianjie.equals("")){pmap.put("jiudianjianjie", null);}else{pmap.put("jiudianjianjie", jiudianjianjie);}
		
		int total=hunyanjiudianService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hunyanjiudian> list=hunyanjiudianService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hunyanjiudian_yanben4";
	}
	@RequestMapping("hunyanjiudian_yanben5.do")
	public String hunyanjiudian_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hunyanjiudian hunyanjiudian, String jiudianbianhao, String jiudianmingcheng, String tupian, String xingji, String jiage1,String jiage2, String lianxidianhua, String dizhi, String jiudianjianjie){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(jiudianbianhao==null||jiudianbianhao.equals("")){pmap.put("jiudianbianhao", null);}else{pmap.put("jiudianbianhao", jiudianbianhao);}
		if(jiudianmingcheng==null||jiudianmingcheng.equals("")){pmap.put("jiudianmingcheng", null);}else{pmap.put("jiudianmingcheng", jiudianmingcheng);}
		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}
		if(xingji==null||xingji.equals("")){pmap.put("xingji", null);}else{pmap.put("xingji", xingji);}
		if(jiage1==null||jiage1.equals("")){pmap.put("jiage1", null);}else{pmap.put("jiage1", jiage1);}
		if(jiage2==null||jiage2.equals("")){pmap.put("jiage2", null);}else{pmap.put("jiage2", jiage2);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(jiudianjianjie==null||jiudianjianjie.equals("")){pmap.put("jiudianjianjie", null);}else{pmap.put("jiudianjianjie", jiudianjianjie);}
		
		int total=hunyanjiudianService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hunyanjiudian> list=hunyanjiudianService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hunyanjiudian_yanben5";
	}
	
	
	
	@RequestMapping("hyjdList.do")
	public String hyjdList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hunyanjiudian hunyanjiudian, String jiudianbianhao, String jiudianmingcheng, String tupian, String xingji, String jiage1,String jiage2, String lianxidianhua, String dizhi, String jiudianjianjie){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(jiudianbianhao==null||jiudianbianhao.equals("")){pmap.put("jiudianbianhao", null);}else{pmap.put("jiudianbianhao", jiudianbianhao);}
		if(jiudianmingcheng==null||jiudianmingcheng.equals("")){pmap.put("jiudianmingcheng", null);}else{pmap.put("jiudianmingcheng", jiudianmingcheng);}
		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}
		if(xingji==null||xingji.equals("")){pmap.put("xingji", null);}else{pmap.put("xingji", xingji);}
		if(jiage1==null||jiage1.equals("")){pmap.put("jiage1", null);}else{pmap.put("jiage1", jiage1);}
		if(jiage2==null||jiage2.equals("")){pmap.put("jiage2", null);}else{pmap.put("jiage2", jiage2);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(jiudianjianjie==null||jiudianjianjie.equals("")){pmap.put("jiudianjianjie", null);}else{pmap.put("jiudianjianjie", jiudianjianjie);}
		
		int total=hunyanjiudianService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hunyanjiudian> list=hunyanjiudianService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hunyanjiudianlist";
	}
	@RequestMapping("hyjdListtp.do")
	public String hyjdListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hunyanjiudian hunyanjiudian, String jiudianbianhao, String jiudianmingcheng, String tupian, String xingji, String jiage1,String jiage2, String lianxidianhua, String dizhi, String jiudianjianjie){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(jiudianbianhao==null||jiudianbianhao.equals("")){pmap.put("jiudianbianhao", null);}else{pmap.put("jiudianbianhao", jiudianbianhao);}
		if(jiudianmingcheng==null||jiudianmingcheng.equals("")){pmap.put("jiudianmingcheng", null);}else{pmap.put("jiudianmingcheng", jiudianmingcheng);}
		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}
		if(xingji==null||xingji.equals("")){pmap.put("xingji", null);}else{pmap.put("xingji", xingji);}
		if(jiage1==null||jiage1.equals("")){pmap.put("jiage1", null);}else{pmap.put("jiage1", jiage1);}
		if(jiage2==null||jiage2.equals("")){pmap.put("jiage2", null);}else{pmap.put("jiage2", jiage2);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(jiudianjianjie==null||jiudianjianjie.equals("")){pmap.put("jiudianjianjie", null);}else{pmap.put("jiudianjianjie", jiudianjianjie);}
		
		int total=hunyanjiudianService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hunyanjiudian> list=hunyanjiudianService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hunyanjiudianlisttp";
	}
	
	@RequestMapping("deleteHunyanjiudian.do")
	public String deleteHunyanjiudian(int id,HttpServletRequest request){
		hunyanjiudianService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:hunyanjiudianList.do";
	}
	
	@RequestMapping("quchongHunyanjiudian.do")
	public void quchongHunyanjiudian(Hunyanjiudian hunyanjiudian,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("jiudianmingcheng", hunyanjiudian.getJiudianmingcheng());
		   System.out.println("jiudianmingcheng==="+hunyanjiudian.getJiudianmingcheng());
		   System.out.println("jiudianmingcheng222==="+hunyanjiudianService.quchongHunyanjiudian(map));
		   JSONObject obj=new JSONObject();
		   if(hunyanjiudianService.quchongHunyanjiudian(map)!=null){
				 obj.put("info", "ng");
			   }else{
				   obj.put("info", "酒店名称可以用！");
				  
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
