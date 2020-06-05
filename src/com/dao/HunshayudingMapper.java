package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Hunshayuding;

public interface HunshayudingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Hunshayuding record);

    int insertSelective(Hunshayuding record);

    Hunshayuding selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hunshayuding record);
	
    int updateByPrimaryKey(Hunshayuding record);
	public Hunshayuding quchongHunshayuding(Map<String, Object> yudingren);
	public List<Hunshayuding> getAll(Map<String, Object> map);
	public List<Hunshayuding> getsyhunshayuding1(Map<String, Object> map);
	public List<Hunshayuding> getsyhunshayuding3(Map<String, Object> map);
	public List<Hunshayuding> getsyhunshayuding2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Hunshayuding> getByPage(Map<String, Object> map);
	public List<Hunshayuding> select(Map<String, Object> map);
//	所有List
}

