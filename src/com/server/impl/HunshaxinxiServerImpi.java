package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.HunshaxinxiMapper;
import com.entity.Hunshaxinxi;
import com.server.HunshaxinxiServer;
@Service
public class HunshaxinxiServerImpi implements HunshaxinxiServer {
   @Resource
   private HunshaxinxiMapper gdao;
	@Override
	public int add(Hunshaxinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Hunshaxinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Hunshaxinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Hunshaxinxi> getsyhunshaxinxi1(Map<String, Object> map) {
		return gdao.getsyhunshaxinxi1(map);
	}
	public List<Hunshaxinxi> getsyhunshaxinxi2(Map<String, Object> map) {
		return gdao.getsyhunshaxinxi2(map);
	}
	public List<Hunshaxinxi> getsyhunshaxinxi3(Map<String, Object> map) {
		return gdao.getsyhunshaxinxi3(map);
	}
	
	@Override
	public Hunshaxinxi quchongHunshaxinxi(Map<String, Object> account) {
		return gdao.quchongHunshaxinxi(account);
	}

	@Override
	public List<Hunshaxinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Hunshaxinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Hunshaxinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

