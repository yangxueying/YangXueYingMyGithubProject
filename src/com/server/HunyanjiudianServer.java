package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Hunyanjiudian;

public interface HunyanjiudianServer {

  public int add(Hunyanjiudian po);

  public int update(Hunyanjiudian po);
  
  
  
  public int delete(int id);

  public List<Hunyanjiudian> getAll(Map<String,Object> map);
  public List<Hunyanjiudian> getsyhunyanjiudian1(Map<String,Object> map);
  public List<Hunyanjiudian> getsyhunyanjiudian2(Map<String,Object> map);
  public List<Hunyanjiudian> getsyhunyanjiudian3(Map<String,Object> map);
  public Hunyanjiudian quchongHunyanjiudian(Map<String, Object> acount);

  public Hunyanjiudian getById( int id);

  public List<Hunyanjiudian> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Hunyanjiudian> select(Map<String, Object> map);
}
//	所有List
