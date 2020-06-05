package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.HunshayudingMapper;
import com.entity.Hunshayuding;
import com.server.HunshayudingServer;
@Service
public class HunshayudingServerImpi implements HunshayudingServer {
   @Resource
   private HunshayudingMapper gdao;
	@Override
	public int add(Hunshayuding po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Hunshayuding po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Hunshayuding> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Hunshayuding> getsyhunshayuding1(Map<String, Object> map) {
		return gdao.getsyhunshayuding1(map);
	}
	public List<Hunshayuding> getsyhunshayuding2(Map<String, Object> map) {
		return gdao.getsyhunshayuding2(map);
	}
	public List<Hunshayuding> getsyhunshayuding3(Map<String, Object> map) {
		return gdao.getsyhunshayuding3(map);
	}
	
	@Override
	public Hunshayuding quchongHunshayuding(Map<String, Object> account) {
		return gdao.quchongHunshayuding(account);
	}

	@Override
	public List<Hunshayuding> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Hunshayuding> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Hunshayuding getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

