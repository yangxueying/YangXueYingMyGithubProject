package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Hunjiudianyan;

public interface HunjiudianyanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Hunjiudianyan record);

    int insertSelective(Hunjiudianyan record);

    Hunjiudianyan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hunjiudianyan record);
	
    int updateByPrimaryKey(Hunjiudianyan record);
	public Hunjiudianyan quchongHunjiudianyan(Map<String, Object> jiudianbianhao);
	public List<Hunjiudianyan> getAll(Map<String, Object> map);
	public List<Hunjiudianyan> getsyhunjiudianyan1(Map<String, Object> map);
	public List<Hunjiudianyan> getsyhunjiudianyan3(Map<String, Object> map);
	public List<Hunjiudianyan> getsyhunjiudianyan2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Hunjiudianyan> getByPage(Map<String, Object> map);
	public List<Hunjiudianyan> select(Map<String, Object> map);
//	所有List
}

