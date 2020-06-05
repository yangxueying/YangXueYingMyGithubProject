package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Hunlicehua;

public interface HunlicehuaServer {

  public int add(Hunlicehua po);

  public int update(Hunlicehua po);
  
  
  
  public int delete(int id);

  public List<Hunlicehua> getAll(Map<String,Object> map);
  public List<Hunlicehua> getsyhunlicehua1(Map<String,Object> map);
  public List<Hunlicehua> getsyhunlicehua2(Map<String,Object> map);
  public List<Hunlicehua> getsyhunlicehua3(Map<String,Object> map);
  public Hunlicehua quchongHunlicehua(Map<String, Object> acount);

  public Hunlicehua getById( int id);

  public List<Hunlicehua> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Hunlicehua> select(Map<String, Object> map);
}
//	所有List
