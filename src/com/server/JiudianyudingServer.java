package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Jiudianyuding;

public interface JiudianyudingServer {

  public int add(Jiudianyuding po);

  public int update(Jiudianyuding po);
  
  
  
  public int delete(int id);

  public List<Jiudianyuding> getAll(Map<String,Object> map);
  public List<Jiudianyuding> getsyjiudianyuding1(Map<String,Object> map);
  public List<Jiudianyuding> getsyjiudianyuding2(Map<String,Object> map);
  public List<Jiudianyuding> getsyjiudianyuding3(Map<String,Object> map);
  public Jiudianyuding quchongJiudianyuding(Map<String, Object> acount);

  public Jiudianyuding getById( int id);

  public List<Jiudianyuding> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Jiudianyuding> select(Map<String, Object> map);
}
//	所有List
