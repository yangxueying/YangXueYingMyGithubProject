package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.HunlicehuaMapper;
import com.entity.Hunlicehua;
import com.server.HunlicehuaServer;
@Service
public class HunlicehuaServerImpi implements HunlicehuaServer {
   @Resource
   private HunlicehuaMapper gdao;
	@Override
	public int add(Hunlicehua po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Hunlicehua po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Hunlicehua> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Hunlicehua> getsyhunlicehua1(Map<String, Object> map) {
		return gdao.getsyhunlicehua1(map);
	}
	public List<Hunlicehua> getsyhunlicehua2(Map<String, Object> map) {
		return gdao.getsyhunlicehua2(map);
	}
	public List<Hunlicehua> getsyhunlicehua3(Map<String, Object> map) {
		return gdao.getsyhunlicehua3(map);
	}
	
	@Override
	public Hunlicehua quchongHunlicehua(Map<String, Object> account) {
		return gdao.quchongHunlicehua(account);
	}

	@Override
	public List<Hunlicehua> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Hunlicehua> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Hunlicehua getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

