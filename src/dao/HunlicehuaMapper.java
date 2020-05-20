package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Hunlicehua;

public interface HunlicehuaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Hunlicehua record);

    int insertSelective(Hunlicehua record);

    Hunlicehua selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hunlicehua record);
	
    int updateByPrimaryKey(Hunlicehua record);
	public Hunlicehua quchongHunlicehua(Map<String, Object> cehuafangan);
	public List<Hunlicehua> getAll(Map<String, Object> map);
	public List<Hunlicehua> getsyhunlicehua1(Map<String, Object> map);
	public List<Hunlicehua> getsyhunlicehua3(Map<String, Object> map);
	public List<Hunlicehua> getsyhunlicehua2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Hunlicehua> getByPage(Map<String, Object> map);
	public List<Hunlicehua> select(Map<String, Object> map);
//	所有List
}

