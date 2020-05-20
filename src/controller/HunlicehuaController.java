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

import com.entity.Hunlicehua;
import com.server.HunlicehuaServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class HunlicehuaController {
	@Resource
	private HunlicehuaServer hunlicehuaService;


   
	@RequestMapping("addHunlicehua.do")
	public String addHunlicehua(HttpServletRequest request,Hunlicehua hunlicehua,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		hunlicehua.setAddtime(time.toString().substring(0, 19));
		hunlicehuaService.add(hunlicehua);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "hunlicehuaList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:hunlicehuaList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateHunlicehua.do")
	public String doUpdateHunlicehua(int id,ModelMap map,Hunlicehua hunlicehua){
		hunlicehua=hunlicehuaService.getById(id);
		map.put("hunlicehua", hunlicehua);
		return "hunlicehua_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("hunlicehuaDetail.do")
	public String hunlicehuaDetail(int id,ModelMap map,Hunlicehua hunlicehua){
		hunlicehua=hunlicehuaService.getById(id);
		map.put("hunlicehua", hunlicehua);
		return "hunlicehua_detail";
	}
//	前台详细
	@RequestMapping("hlchDetail.do")
	public String hlchDetail(int id,ModelMap map,Hunlicehua hunlicehua){
		hunlicehua=hunlicehuaService.getById(id);
		map.put("hunlicehua", hunlicehua);
		return "hunlicehuadetail";
	}
//	
	@RequestMapping("updateHunlicehua.do")
	public String updateHunlicehua(int id,ModelMap map,Hunlicehua hunlicehua,HttpServletRequest request,HttpSession session){
		hunlicehuaService.update(hunlicehua);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:hunlicehuaList.do";
	}

//	分页查询
	@RequestMapping("hunlicehuaList.do")
	public String hunlicehuaList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hunlicehua hunlicehua, String cehuafangan, String jiage1,String jiage2, String lianxidianhua, String dizhi, String tupian, String xiangxi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(cehuafangan==null||cehuafangan.equals("")){pmap.put("cehuafangan", null);}else{pmap.put("cehuafangan", cehuafangan);}		if(jiage1==null||jiage1.equals("")){pmap.put("jiage1", null);}else{pmap.put("jiage1", jiage1);}		if(jiage2==null||jiage2.equals("")){pmap.put("jiage2", null);}else{pmap.put("jiage2", jiage2);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}		if(xiangxi==null||xiangxi.equals("")){pmap.put("xiangxi", null);}else{pmap.put("xiangxi", xiangxi);}		
		int total=hunlicehuaService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hunlicehua> list=hunlicehuaService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hunlicehua_list";
	}
	
	@RequestMapping("hunlicehua_yanben1.do")
	public String hunlicehua_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hunlicehua hunlicehua, String cehuafangan, String jiage1,String jiage2, String lianxidianhua, String dizhi, String tupian, String xiangxi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(cehuafangan==null||cehuafangan.equals("")){pmap.put("cehuafangan", null);}else{pmap.put("cehuafangan", cehuafangan);}		if(jiage1==null||jiage1.equals("")){pmap.put("jiage1", null);}else{pmap.put("jiage1", jiage1);}		if(jiage2==null||jiage2.equals("")){pmap.put("jiage2", null);}else{pmap.put("jiage2", jiage2);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}		if(xiangxi==null||xiangxi.equals("")){pmap.put("xiangxi", null);}else{pmap.put("xiangxi", xiangxi);}		
		int total=hunlicehuaService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hunlicehua> list=hunlicehuaService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hunlicehua_yanben1";
	}
	@RequestMapping("hunlicehua_yanben2.do")
	public String hunlicehua_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hunlicehua hunlicehua, String cehuafangan, String jiage1,String jiage2, String lianxidianhua, String dizhi, String tupian, String xiangxi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(cehuafangan==null||cehuafangan.equals("")){pmap.put("cehuafangan", null);}else{pmap.put("cehuafangan", cehuafangan);}		if(jiage1==null||jiage1.equals("")){pmap.put("jiage1", null);}else{pmap.put("jiage1", jiage1);}		if(jiage2==null||jiage2.equals("")){pmap.put("jiage2", null);}else{pmap.put("jiage2", jiage2);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}		if(xiangxi==null||xiangxi.equals("")){pmap.put("xiangxi", null);}else{pmap.put("xiangxi", xiangxi);}		
		int total=hunlicehuaService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hunlicehua> list=hunlicehuaService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hunlicehua_yanben2";
	}
	@RequestMapping("hunlicehua_yanben3.do")
	public String hunlicehua_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hunlicehua hunlicehua, String cehuafangan, String jiage1,String jiage2, String lianxidianhua, String dizhi, String tupian, String xiangxi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(cehuafangan==null||cehuafangan.equals("")){pmap.put("cehuafangan", null);}else{pmap.put("cehuafangan", cehuafangan);}		if(jiage1==null||jiage1.equals("")){pmap.put("jiage1", null);}else{pmap.put("jiage1", jiage1);}		if(jiage2==null||jiage2.equals("")){pmap.put("jiage2", null);}else{pmap.put("jiage2", jiage2);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}		if(xiangxi==null||xiangxi.equals("")){pmap.put("xiangxi", null);}else{pmap.put("xiangxi", xiangxi);}		
		int total=hunlicehuaService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hunlicehua> list=hunlicehuaService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hunlicehua_yanben3";
	}
	@RequestMapping("hunlicehua_yanben4.do")
	public String hunlicehua_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hunlicehua hunlicehua, String cehuafangan, String jiage1,String jiage2, String lianxidianhua, String dizhi, String tupian, String xiangxi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(cehuafangan==null||cehuafangan.equals("")){pmap.put("cehuafangan", null);}else{pmap.put("cehuafangan", cehuafangan);}		if(jiage1==null||jiage1.equals("")){pmap.put("jiage1", null);}else{pmap.put("jiage1", jiage1);}		if(jiage2==null||jiage2.equals("")){pmap.put("jiage2", null);}else{pmap.put("jiage2", jiage2);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}		if(xiangxi==null||xiangxi.equals("")){pmap.put("xiangxi", null);}else{pmap.put("xiangxi", xiangxi);}		
		int total=hunlicehuaService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hunlicehua> list=hunlicehuaService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hunlicehua_yanben4";
	}
	@RequestMapping("hunlicehua_yanben5.do")
	public String hunlicehua_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hunlicehua hunlicehua, String cehuafangan, String jiage1,String jiage2, String lianxidianhua, String dizhi, String tupian, String xiangxi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(cehuafangan==null||cehuafangan.equals("")){pmap.put("cehuafangan", null);}else{pmap.put("cehuafangan", cehuafangan);}		if(jiage1==null||jiage1.equals("")){pmap.put("jiage1", null);}else{pmap.put("jiage1", jiage1);}		if(jiage2==null||jiage2.equals("")){pmap.put("jiage2", null);}else{pmap.put("jiage2", jiage2);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}		if(xiangxi==null||xiangxi.equals("")){pmap.put("xiangxi", null);}else{pmap.put("xiangxi", xiangxi);}		
		int total=hunlicehuaService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hunlicehua> list=hunlicehuaService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hunlicehua_yanben5";
	}
	
	
	
	@RequestMapping("hlchList.do")
	public String hlchList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hunlicehua hunlicehua, String cehuafangan, String jiage1,String jiage2, String lianxidianhua, String dizhi, String tupian, String xiangxi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(cehuafangan==null||cehuafangan.equals("")){pmap.put("cehuafangan", null);}else{pmap.put("cehuafangan", cehuafangan);}		if(jiage1==null||jiage1.equals("")){pmap.put("jiage1", null);}else{pmap.put("jiage1", jiage1);}		if(jiage2==null||jiage2.equals("")){pmap.put("jiage2", null);}else{pmap.put("jiage2", jiage2);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}		if(xiangxi==null||xiangxi.equals("")){pmap.put("xiangxi", null);}else{pmap.put("xiangxi", xiangxi);}		
		int total=hunlicehuaService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hunlicehua> list=hunlicehuaService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hunlicehualist";
	}
	@RequestMapping("hlchListtp.do")
	public String hlchListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hunlicehua hunlicehua, String cehuafangan, String jiage1,String jiage2, String lianxidianhua, String dizhi, String tupian, String xiangxi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(cehuafangan==null||cehuafangan.equals("")){pmap.put("cehuafangan", null);}else{pmap.put("cehuafangan", cehuafangan);}		if(jiage1==null||jiage1.equals("")){pmap.put("jiage1", null);}else{pmap.put("jiage1", jiage1);}		if(jiage2==null||jiage2.equals("")){pmap.put("jiage2", null);}else{pmap.put("jiage2", jiage2);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		if(tupian==null||tupian.equals("")){pmap.put("tupian", null);}else{pmap.put("tupian", tupian);}		if(xiangxi==null||xiangxi.equals("")){pmap.put("xiangxi", null);}else{pmap.put("xiangxi", xiangxi);}		
		int total=hunlicehuaService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hunlicehua> list=hunlicehuaService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hunlicehualisttp";
	}
	
	@RequestMapping("deleteHunlicehua.do")
	public String deleteHunlicehua(int id,HttpServletRequest request){
		hunlicehuaService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:hunlicehuaList.do";
	}
	
	@RequestMapping("quchongHunlicehua.do")
	public void quchongHunlicehua(Hunlicehua hunlicehua,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("cehuafangan", hunlicehua.getCehuafangan());
		   System.out.println("cehuafangan==="+hunlicehua.getCehuafangan());
		   System.out.println("cehuafangan222==="+hunlicehuaService.quchongHunlicehua(map));
		   JSONObject obj=new JSONObject();
		   if(hunlicehuaService.quchongHunlicehua(map)!=null){
				 obj.put("info", "ng");
			   }else{
				   obj.put("info", "策划方案可以用！");
				  
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
