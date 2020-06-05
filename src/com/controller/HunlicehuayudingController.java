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

import com.entity.Hunlicehuayuding;
import com.server.HunlicehuayudingServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class HunlicehuayudingController {
	@Resource
	private HunlicehuayudingServer hunlicehuayudingService;


   
	@RequestMapping("addHunlicehuayuding.do")
	public String addHunlicehuayuding(HttpServletRequest request,Hunlicehuayuding hunlicehuayuding,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		hunlicehuayuding.setAddtime(time.toString().substring(0, 19));
		hunlicehuayudingService.add(hunlicehuayuding);
		
		session.setAttribute("backxx", "预订成功!请您在24小时内在线下和商家取得消息，否则预约将被取消");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "hunlicehuayudingList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:hunlicehuayudingList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateHunlicehuayuding.do")
	public String doUpdateHunlicehuayuding(int id,ModelMap map,Hunlicehuayuding hunlicehuayuding){
		hunlicehuayuding=hunlicehuayudingService.getById(id);
		map.put("hunlicehuayuding", hunlicehuayuding);
		return "hunlicehuayuding_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("hunlicehuayudingDetail.do")
	public String hunlicehuayudingDetail(int id,ModelMap map,Hunlicehuayuding hunlicehuayuding){
		hunlicehuayuding=hunlicehuayudingService.getById(id);
		map.put("hunlicehuayuding", hunlicehuayuding);
		return "hunlicehuayuding_detail";
	}
//	前台详细
	@RequestMapping("hlchydDetail.do")
	public String hlchydDetail(int id,ModelMap map,Hunlicehuayuding hunlicehuayuding){
		hunlicehuayuding=hunlicehuayudingService.getById(id);
		map.put("hunlicehuayuding", hunlicehuayuding);
		return "hunlicehuayudingdetail";
	}
//	
	@RequestMapping("updateHunlicehuayuding.do")
	public String updateHunlicehuayuding(int id,ModelMap map,Hunlicehuayuding hunlicehuayuding,HttpServletRequest request,HttpSession session){
		hunlicehuayudingService.update(hunlicehuayuding);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:hunlicehuayudingList.do";
	}

//	分页查询
	@RequestMapping("hunlicehuayudingList.do")
	public String hunlicehuayudingList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hunlicehuayuding hunlicehuayuding, String dingdanhao, String cehuafangan, String jiage, String lianxidianhua, String dizhi, String yudingren, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(dingdanhao==null||dingdanhao.equals("")){pmap.put("dingdanhao", null);}else{pmap.put("dingdanhao", dingdanhao);}
		if(cehuafangan==null||cehuafangan.equals("")){pmap.put("cehuafangan", null);}else{pmap.put("cehuafangan", cehuafangan);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(yudingren==null||yudingren.equals("")){pmap.put("yudingren", null);}else{pmap.put("yudingren", yudingren);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=hunlicehuayudingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hunlicehuayuding> list=hunlicehuayudingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hunlicehuayuding_list";
	}
	
	@RequestMapping("hunlicehuayuding_yanben1.do")
	public String hunlicehuayuding_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hunlicehuayuding hunlicehuayuding, String dingdanhao, String cehuafangan, String jiage, String lianxidianhua, String dizhi, String yudingren, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(dingdanhao==null||dingdanhao.equals("")){pmap.put("dingdanhao", null);}else{pmap.put("dingdanhao", dingdanhao);}
		if(cehuafangan==null||cehuafangan.equals("")){pmap.put("cehuafangan", null);}else{pmap.put("cehuafangan", cehuafangan);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(yudingren==null||yudingren.equals("")){pmap.put("yudingren", null);}else{pmap.put("yudingren", yudingren);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=hunlicehuayudingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hunlicehuayuding> list=hunlicehuayudingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hunlicehuayuding_yanben1";
	}
	@RequestMapping("hunlicehuayuding_yanben2.do")
	public String hunlicehuayuding_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hunlicehuayuding hunlicehuayuding, String dingdanhao, String cehuafangan, String jiage, String lianxidianhua, String dizhi, String yudingren, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(dingdanhao==null||dingdanhao.equals("")){pmap.put("dingdanhao", null);}else{pmap.put("dingdanhao", dingdanhao);}
		if(cehuafangan==null||cehuafangan.equals("")){pmap.put("cehuafangan", null);}else{pmap.put("cehuafangan", cehuafangan);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(yudingren==null||yudingren.equals("")){pmap.put("yudingren", null);}else{pmap.put("yudingren", yudingren);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=hunlicehuayudingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hunlicehuayuding> list=hunlicehuayudingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hunlicehuayuding_yanben2";
	}
	@RequestMapping("hunlicehuayuding_yanben3.do")
	public String hunlicehuayuding_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hunlicehuayuding hunlicehuayuding, String dingdanhao, String cehuafangan, String jiage, String lianxidianhua, String dizhi, String yudingren, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(dingdanhao==null||dingdanhao.equals("")){pmap.put("dingdanhao", null);}else{pmap.put("dingdanhao", dingdanhao);}
		if(cehuafangan==null||cehuafangan.equals("")){pmap.put("cehuafangan", null);}else{pmap.put("cehuafangan", cehuafangan);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(yudingren==null||yudingren.equals("")){pmap.put("yudingren", null);}else{pmap.put("yudingren", yudingren);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=hunlicehuayudingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hunlicehuayuding> list=hunlicehuayudingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hunlicehuayuding_yanben3";
	}
	@RequestMapping("hunlicehuayuding_yanben4.do")
	public String hunlicehuayuding_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hunlicehuayuding hunlicehuayuding, String dingdanhao, String cehuafangan, String jiage, String lianxidianhua, String dizhi, String yudingren, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(dingdanhao==null||dingdanhao.equals("")){pmap.put("dingdanhao", null);}else{pmap.put("dingdanhao", dingdanhao);}
		if(cehuafangan==null||cehuafangan.equals("")){pmap.put("cehuafangan", null);}else{pmap.put("cehuafangan", cehuafangan);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(yudingren==null||yudingren.equals("")){pmap.put("yudingren", null);}else{pmap.put("yudingren", yudingren);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=hunlicehuayudingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hunlicehuayuding> list=hunlicehuayudingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hunlicehuayuding_yanben4";
	}
	@RequestMapping("hunlicehuayuding_yanben5.do")
	public String hunlicehuayuding_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hunlicehuayuding hunlicehuayuding, String dingdanhao, String cehuafangan, String jiage, String lianxidianhua, String dizhi, String yudingren, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(dingdanhao==null||dingdanhao.equals("")){pmap.put("dingdanhao", null);}else{pmap.put("dingdanhao", dingdanhao);}
		if(cehuafangan==null||cehuafangan.equals("")){pmap.put("cehuafangan", null);}else{pmap.put("cehuafangan", cehuafangan);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(yudingren==null||yudingren.equals("")){pmap.put("yudingren", null);}else{pmap.put("yudingren", yudingren);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=hunlicehuayudingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hunlicehuayuding> list=hunlicehuayudingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hunlicehuayuding_yanben5";
	}
	
	@RequestMapping("hunlicehuayudingList2.do")
	public String hunlicehuayudingList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hunlicehuayuding hunlicehuayuding, String dingdanhao, String cehuafangan, String jiage, String lianxidianhua, String dizhi, String yudingren, String beizhu,HttpServletRequest request){
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
		if(cehuafangan==null||cehuafangan.equals("")){pmap.put("cehuafangan", null);}else{pmap.put("cehuafangan", cehuafangan);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		
		int total=hunlicehuayudingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hunlicehuayuding> list=hunlicehuayudingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hunlicehuayuding_list2";
	}
	
	
	@RequestMapping("hlchydList.do")
	public String hlchydList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hunlicehuayuding hunlicehuayuding, String dingdanhao, String cehuafangan, String jiage, String lianxidianhua, String dizhi, String yudingren, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(dingdanhao==null||dingdanhao.equals("")){pmap.put("dingdanhao", null);}else{pmap.put("dingdanhao", dingdanhao);}
		if(cehuafangan==null||cehuafangan.equals("")){pmap.put("cehuafangan", null);}else{pmap.put("cehuafangan", cehuafangan);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(yudingren==null||yudingren.equals("")){pmap.put("yudingren", null);}else{pmap.put("yudingren", yudingren);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=hunlicehuayudingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hunlicehuayuding> list=hunlicehuayudingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hunlicehuayudinglist";
	}
	@RequestMapping("hlchydListtp.do")
	public String hlchydListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hunlicehuayuding hunlicehuayuding, String dingdanhao, String cehuafangan, String jiage, String lianxidianhua, String dizhi, String yudingren, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(dingdanhao==null||dingdanhao.equals("")){pmap.put("dingdanhao", null);}else{pmap.put("dingdanhao", dingdanhao);}
		if(cehuafangan==null||cehuafangan.equals("")){pmap.put("cehuafangan", null);}else{pmap.put("cehuafangan", cehuafangan);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(yudingren==null||yudingren.equals("")){pmap.put("yudingren", null);}else{pmap.put("yudingren", yudingren);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=hunlicehuayudingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hunlicehuayuding> list=hunlicehuayudingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hunlicehuayudinglisttp";
	}
	
	@RequestMapping("deleteHunlicehuayuding.do")
	public String deleteHunlicehuayuding(int id,HttpServletRequest request){
		hunlicehuayudingService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:hunlicehuayudingList.do";
	}
	
	
}
