package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Hunyanjiudian;

public interface HunyanjiudianMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Hunyanjiudian record);

    int insertSelective(Hunyanjiudian record);

    Hunyanjiudian selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hunyanjiudian record);
	
    int updateByPrimaryKey(Hunyanjiudian record);
	public Hunyanjiudian quchongHunyanjiudian(Map<String, Object> jiudianbianhao);
	public List<Hunyanjiudian> getAll(Map<String, Object> map);
	public List<Hunyanjiudian> getsyhunyanjiudian1(Map<String, Object> map);
	public List<Hunyanjiudian> getsyhunyanjiudian3(Map<String, Object> map);
	public List<Hunyanjiudian> getsyhunyanjiudian2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Hunyanjiudian> getByPage(Map<String, Object> map);
	public List<Hunyanjiudian> select(Map<String, Object> map);
//	所有List
}

