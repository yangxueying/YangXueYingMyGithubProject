package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Hunshaxinxi;

public interface HunshaxinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Hunshaxinxi record);

    int insertSelective(Hunshaxinxi record);

    Hunshaxinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hunshaxinxi record);
	
    int updateByPrimaryKey(Hunshaxinxi record);
	public Hunshaxinxi quchongHunshaxinxi(Map<String, Object> hunshabianhao);
	public List<Hunshaxinxi> getAll(Map<String, Object> map);
	public List<Hunshaxinxi> getsyhunshaxinxi1(Map<String, Object> map);
	public List<Hunshaxinxi> getsyhunshaxinxi3(Map<String, Object> map);
	public List<Hunshaxinxi> getsyhunshaxinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Hunshaxinxi> getByPage(Map<String, Object> map);
	public List<Hunshaxinxi> select(Map<String, Object> map);
//	所有List
}

