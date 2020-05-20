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

import com.entity.Hunjiudianyan;
import com.server.HunjiudianyanServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class HunjiudianyanController {
	@Resource
	private HunjiudianyanServer hunjiudianyanService;


   
	@RequestMapping("addHunjiudianyan.do")
	public String addHunjiudianyan(HttpServletRequest request,Hunjiudianyan hunjiudianyan,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		hunjiudianyan.setAddtime(time.toString().substring(0, 19));
		hunjiudianyanService.add(hunjiudianyan);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "hunjiudianyanList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:hunjiudianyanList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateHunjiudianyan.do")
	public String doUpdateHunjiudianyan(int id,ModelMap map,Hunjiudianyan hunjiudianyan){
		hunjiudianyan=hunjiudianyanService.getById(id);
		map.put("hunjiudianyan", hunjiudianyan);
		return "hunjiudianyan_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("hunjiudianyanDetail.do")
	public String hunjiudianyanDetail(int id,ModelMap map,Hunjiudianyan hunjiudianyan){
		hunjiudianyan=hunjiudianyanService.getById(id);
		map.put("hunjiudianyan", hunjiudianyan);
		return "hunjiudianyan_detail";
	}
//	前台详细
	@RequestMapping("hjdyDetail.do")
	public String hjdyDetail(int id,ModelMap map,Hunjiudianyan hunjiudianyan){
		hunjiudianyan=hunjiudianyanService.getById(id);
		map.put("hunjiudianyan", hunjiudianyan);
		return "hunjiudianyandetail";
	}
//	
	@RequestMapping("updateHunjiudianyan.do")
	public String updateHunjiudianyan(int id,ModelMap map,Hunjiudianyan hunjiudianyan,HttpServletRequest request,HttpSession session){
		hunjiudianyanService.update(hunjiudianyan);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:hunjiudianyanList.do";
	}

//	分页查询
	@RequestMapping("hunjiudianyanList.do")
	public String hunjiudianyanList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hunjiudianyan hunjiudianyan, String jiudianbianhao, String jiudianmingcheng, String tupian, String xingji, String lianxidianhua, String dizhi, String jiudianjianjie){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(jiudianbianhao==null||jiudianbianhao.equals("")){pmap.put("jiudianbianhao", null);}else{pmap.put("jiudianbianhao", jiudianbianhao);}		if(jiudianmingcheng==null||jiudianmingcheng.equals("")){pmap.put("jiudianmingcheng", null);}else{pmap.put("jiudianmingcheng", jiudianmingcheng);}		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}		if(xingji==null||xingji.equals("")){pmap.put("xingji", null);}else{pmap.put("xingji", xingji);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		if(jiudianjianjie==null||jiudianjianjie.equals("")){pmap.put("jiudianjianjie", null);}else{pmap.put("jiudianjianjie", jiudianjianjie);}		
		int total=hunjiudianyanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hunjiudianyan> list=hunjiudianyanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hunjiudianyan_list";
	}
	
	@RequestMapping("hunjiudianyan_yanben1.do")
	public String hunjiudianyan_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hunjiudianyan hunjiudianyan, String jiudianbianhao, String jiudianmingcheng, String tupian, String xingji, String lianxidianhua, String dizhi, String jiudianjianjie){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(jiudianbianhao==null||jiudianbianhao.equals("")){pmap.put("jiudianbianhao", null);}else{pmap.put("jiudianbianhao", jiudianbianhao);}		if(jiudianmingcheng==null||jiudianmingcheng.equals("")){pmap.put("jiudianmingcheng", null);}else{pmap.put("jiudianmingcheng", jiudianmingcheng);}		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}		if(xingji==null||xingji.equals("")){pmap.put("xingji", null);}else{pmap.put("xingji", xingji);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		if(jiudianjianjie==null||jiudianjianjie.equals("")){pmap.put("jiudianjianjie", null);}else{pmap.put("jiudianjianjie", jiudianjianjie);}		
		int total=hunjiudianyanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hunjiudianyan> list=hunjiudianyanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hunjiudianyan_yanben1";
	}
	@RequestMapping("hunjiudianyan_yanben2.do")
	public String hunjiudianyan_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hunjiudianyan hunjiudianyan, String jiudianbianhao, String jiudianmingcheng, String tupian, String xingji, String lianxidianhua, String dizhi, String jiudianjianjie){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(jiudianbianhao==null||jiudianbianhao.equals("")){pmap.put("jiudianbianhao", null);}else{pmap.put("jiudianbianhao", jiudianbianhao);}		if(jiudianmingcheng==null||jiudianmingcheng.equals("")){pmap.put("jiudianmingcheng", null);}else{pmap.put("jiudianmingcheng", jiudianmingcheng);}		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}		if(xingji==null||xingji.equals("")){pmap.put("xingji", null);}else{pmap.put("xingji", xingji);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		if(jiudianjianjie==null||jiudianjianjie.equals("")){pmap.put("jiudianjianjie", null);}else{pmap.put("jiudianjianjie", jiudianjianjie);}		
		int total=hunjiudianyanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hunjiudianyan> list=hunjiudianyanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hunjiudianyan_yanben2";
	}
	@RequestMapping("hunjiudianyan_yanben3.do")
	public String hunjiudianyan_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hunjiudianyan hunjiudianyan, String jiudianbianhao, String jiudianmingcheng, String tupian, String xingji, String lianxidianhua, String dizhi, String jiudianjianjie){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(jiudianbianhao==null||jiudianbianhao.equals("")){pmap.put("jiudianbianhao", null);}else{pmap.put("jiudianbianhao", jiudianbianhao);}		if(jiudianmingcheng==null||jiudianmingcheng.equals("")){pmap.put("jiudianmingcheng", null);}else{pmap.put("jiudianmingcheng", jiudianmingcheng);}		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}		if(xingji==null||xingji.equals("")){pmap.put("xingji", null);}else{pmap.put("xingji", xingji);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		if(jiudianjianjie==null||jiudianjianjie.equals("")){pmap.put("jiudianjianjie", null);}else{pmap.put("jiudianjianjie", jiudianjianjie);}		
		int total=hunjiudianyanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hunjiudianyan> list=hunjiudianyanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hunjiudianyan_yanben3";
	}
	@RequestMapping("hunjiudianyan_yanben4.do")
	public String hunjiudianyan_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hunjiudianyan hunjiudianyan, String jiudianbianhao, String jiudianmingcheng, String tupian, String xingji, String lianxidianhua, String dizhi, String jiudianjianjie){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(jiudianbianhao==null||jiudianbianhao.equals("")){pmap.put("jiudianbianhao", null);}else{pmap.put("jiudianbianhao", jiudianbianhao);}		if(jiudianmingcheng==null||jiudianmingcheng.equals("")){pmap.put("jiudianmingcheng", null);}else{pmap.put("jiudianmingcheng", jiudianmingcheng);}		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}		if(xingji==null||xingji.equals("")){pmap.put("xingji", null);}else{pmap.put("xingji", xingji);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		if(jiudianjianjie==null||jiudianjianjie.equals("")){pmap.put("jiudianjianjie", null);}else{pmap.put("jiudianjianjie", jiudianjianjie);}		
		int total=hunjiudianyanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hunjiudianyan> list=hunjiudianyanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hunjiudianyan_yanben4";
	}
	@RequestMapping("hunjiudianyan_yanben5.do")
	public String hunjiudianyan_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hunjiudianyan hunjiudianyan, String jiudianbianhao, String jiudianmingcheng, String tupian, String xingji, String lianxidianhua, String dizhi, String jiudianjianjie){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(jiudianbianhao==null||jiudianbianhao.equals("")){pmap.put("jiudianbianhao", null);}else{pmap.put("jiudianbianhao", jiudianbianhao);}		if(jiudianmingcheng==null||jiudianmingcheng.equals("")){pmap.put("jiudianmingcheng", null);}else{pmap.put("jiudianmingcheng", jiudianmingcheng);}		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}		if(xingji==null||xingji.equals("")){pmap.put("xingji", null);}else{pmap.put("xingji", xingji);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		if(jiudianjianjie==null||jiudianjianjie.equals("")){pmap.put("jiudianjianjie", null);}else{pmap.put("jiudianjianjie", jiudianjianjie);}		
		int total=hunjiudianyanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hunjiudianyan> list=hunjiudianyanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hunjiudianyan_yanben5";
	}
	
	
	
	@RequestMapping("hjdyList.do")
	public String hjdyList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hunjiudianyan hunjiudianyan, String jiudianbianhao, String jiudianmingcheng, String tupian, String xingji, String lianxidianhua, String dizhi, String jiudianjianjie){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(jiudianbianhao==null||jiudianbianhao.equals("")){pmap.put("jiudianbianhao", null);}else{pmap.put("jiudianbianhao", jiudianbianhao);}		if(jiudianmingcheng==null||jiudianmingcheng.equals("")){pmap.put("jiudianmingcheng", null);}else{pmap.put("jiudianmingcheng", jiudianmingcheng);}		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}		if(xingji==null||xingji.equals("")){pmap.put("xingji", null);}else{pmap.put("xingji", xingji);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		if(jiudianjianjie==null||jiudianjianjie.equals("")){pmap.put("jiudianjianjie", null);}else{pmap.put("jiudianjianjie", jiudianjianjie);}		
		int total=hunjiudianyanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hunjiudianyan> list=hunjiudianyanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hunjiudianyanlist";
	}
	@RequestMapping("hjdyListtp.do")
	public String hjdyListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hunjiudianyan hunjiudianyan, String jiudianbianhao, String jiudianmingcheng, String tupian, String xingji, String lianxidianhua, String dizhi, String jiudianjianjie){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(jiudianbianhao==null||jiudianbianhao.equals("")){pmap.put("jiudianbianhao", null);}else{pmap.put("jiudianbianhao", jiudianbianhao);}		if(jiudianmingcheng==null||jiudianmingcheng.equals("")){pmap.put("jiudianmingcheng", null);}else{pmap.put("jiudianmingcheng", jiudianmingcheng);}		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}		if(xingji==null||xingji.equals("")){pmap.put("xingji", null);}else{pmap.put("xingji", xingji);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		if(jiudianjianjie==null||jiudianjianjie.equals("")){pmap.put("jiudianjianjie", null);}else{pmap.put("jiudianjianjie", jiudianjianjie);}		
		int total=hunjiudianyanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hunjiudianyan> list=hunjiudianyanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hunjiudianyanlisttp";
	}
	
	@RequestMapping("deleteHunjiudianyan.do")
	public String deleteHunjiudianyan(int id,HttpServletRequest request){
		hunjiudianyanService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:hunjiudianyanList.do";
	}
	
	@RequestMapping("quchongHunjiudianyan.do")
	public void quchongHunjiudianyan(Hunjiudianyan hunjiudianyan,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("jiudianmingcheng", hunjiudianyan.getJiudianmingcheng());
		   System.out.println("jiudianmingcheng==="+hunjiudianyan.getJiudianmingcheng());
		   System.out.println("jiudianmingcheng222==="+hunjiudianyanService.quchongHunjiudianyan(map));
		   JSONObject obj=new JSONObject();
		   if(hunjiudianyanService.quchongHunjiudianyan(map)!=null){
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
