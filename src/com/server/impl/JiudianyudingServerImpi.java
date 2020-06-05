package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.JiudianyudingMapper;
import com.entity.Jiudianyuding;
import com.server.JiudianyudingServer;
@Service
public class JiudianyudingServerImpi implements JiudianyudingServer {
   @Resource
   private JiudianyudingMapper gdao;
	@Override
	public int add(Jiudianyuding po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Jiudianyuding po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Jiudianyuding> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Jiudianyuding> getsyjiudianyuding1(Map<String, Object> map) {
		return gdao.getsyjiudianyuding1(map);
	}
	public List<Jiudianyuding> getsyjiudianyuding2(Map<String, Object> map) {
		return gdao.getsyjiudianyuding2(map);
	}
	public List<Jiudianyuding> getsyjiudianyuding3(Map<String, Object> map) {
		return gdao.getsyjiudianyuding3(map);
	}
	
	@Override
	public Jiudianyuding quchongJiudianyuding(Map<String, Object> account) {
		return gdao.quchongJiudianyuding(account);
	}

	@Override
	public List<Jiudianyuding> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Jiudianyuding> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Jiudianyuding getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

