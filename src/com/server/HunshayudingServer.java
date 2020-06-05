package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Hunshayuding;

public interface HunshayudingServer {

  public int add(Hunshayuding po);

  public int update(Hunshayuding po);
  
  
  
  public int delete(int id);

  public List<Hunshayuding> getAll(Map<String,Object> map);
  public List<Hunshayuding> getsyhunshayuding1(Map<String,Object> map);
  public List<Hunshayuding> getsyhunshayuding2(Map<String,Object> map);
  public List<Hunshayuding> getsyhunshayuding3(Map<String,Object> map);
  public Hunshayuding quchongHunshayuding(Map<String, Object> acount);

  public Hunshayuding getById( int id);

  public List<Hunshayuding> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Hunshayuding> select(Map<String, Object> map);
}
//	所有List
