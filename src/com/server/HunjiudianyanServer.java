package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Hunjiudianyan;

public interface HunjiudianyanServer {

  public int add(Hunjiudianyan po);

  public int update(Hunjiudianyan po);
  
  
  
  public int delete(int id);

  public List<Hunjiudianyan> getAll(Map<String,Object> map);
  public List<Hunjiudianyan> getsyhunjiudianyan1(Map<String,Object> map);
  public List<Hunjiudianyan> getsyhunjiudianyan2(Map<String,Object> map);
  public List<Hunjiudianyan> getsyhunjiudianyan3(Map<String,Object> map);
  public Hunjiudianyan quchongHunjiudianyan(Map<String, Object> acount);

  public Hunjiudianyan getById( int id);

  public List<Hunjiudianyan> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Hunjiudianyan> select(Map<String, Object> map);
}
//	所有List
