package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Jiudianyuding;

public interface JiudianyudingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Jiudianyuding record);

    int insertSelective(Jiudianyuding record);

    Jiudianyuding selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Jiudianyuding record);
	
    int updateByPrimaryKey(Jiudianyuding record);
	public Jiudianyuding quchongJiudianyuding(Map<String, Object> yudingren);
	public List<Jiudianyuding> getAll(Map<String, Object> map);
	public List<Jiudianyuding> getsyjiudianyuding1(Map<String, Object> map);
	public List<Jiudianyuding> getsyjiudianyuding3(Map<String, Object> map);
	public List<Jiudianyuding> getsyjiudianyuding2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Jiudianyuding> getByPage(Map<String, Object> map);
	public List<Jiudianyuding> select(Map<String, Object> map);
//	所有List
}

