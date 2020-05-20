package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.HunjiudianyanMapper;
import com.entity.Hunjiudianyan;
import com.server.HunjiudianyanServer;
@Service
public class HunjiudianyanServerImpi implements HunjiudianyanServer {
   @Resource
   private HunjiudianyanMapper gdao;
	@Override
	public int add(Hunjiudianyan po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Hunjiudianyan po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Hunjiudianyan> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Hunjiudianyan> getsyhunjiudianyan1(Map<String, Object> map) {
		return gdao.getsyhunjiudianyan1(map);
	}
	public List<Hunjiudianyan> getsyhunjiudianyan2(Map<String, Object> map) {
		return gdao.getsyhunjiudianyan2(map);
	}
	public List<Hunjiudianyan> getsyhunjiudianyan3(Map<String, Object> map) {
		return gdao.getsyhunjiudianyan3(map);
	}
	
	@Override
	public Hunjiudianyan quchongHunjiudianyan(Map<String, Object> account) {
		return gdao.quchongHunjiudianyan(account);
	}

	@Override
	public List<Hunjiudianyan> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Hunjiudianyan> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Hunjiudianyan getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

