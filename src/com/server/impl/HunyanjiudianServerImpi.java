package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.HunyanjiudianMapper;
import com.entity.Hunyanjiudian;
import com.server.HunyanjiudianServer;
@Service
public class HunyanjiudianServerImpi implements HunyanjiudianServer {
   @Resource
   private HunyanjiudianMapper gdao;
	@Override
	public int add(Hunyanjiudian po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Hunyanjiudian po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Hunyanjiudian> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Hunyanjiudian> getsyhunyanjiudian1(Map<String, Object> map) {
		return gdao.getsyhunyanjiudian1(map);
	}
	public List<Hunyanjiudian> getsyhunyanjiudian2(Map<String, Object> map) {
		return gdao.getsyhunyanjiudian2(map);
	}
	public List<Hunyanjiudian> getsyhunyanjiudian3(Map<String, Object> map) {
		return gdao.getsyhunyanjiudian3(map);
	}
	
	@Override
	public Hunyanjiudian quchongHunyanjiudian(Map<String, Object> account) {
		return gdao.quchongHunyanjiudian(account);
	}

	@Override
	public List<Hunyanjiudian> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Hunyanjiudian> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Hunyanjiudian getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

