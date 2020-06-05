package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Hunshaxinxi;

public interface HunshaxinxiServer {

  public int add(Hunshaxinxi po);

  public int update(Hunshaxinxi po);
  
  
  
  public int delete(int id);

  public List<Hunshaxinxi> getAll(Map<String,Object> map);
  public List<Hunshaxinxi> getsyhunshaxinxi1(Map<String,Object> map);
  public List<Hunshaxinxi> getsyhunshaxinxi2(Map<String,Object> map);
  public List<Hunshaxinxi> getsyhunshaxinxi3(Map<String,Object> map);
  public Hunshaxinxi quchongHunshaxinxi(Map<String, Object> acount);

  public Hunshaxinxi getById( int id);

  public List<Hunshaxinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Hunshaxinxi> select(Map<String, Object> map);
}
//	所有List
