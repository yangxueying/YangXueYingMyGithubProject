package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Hunlicehuayuding;

public interface HunlicehuayudingServer {

  public int add(Hunlicehuayuding po);

  public int update(Hunlicehuayuding po);
  
  
  
  public int delete(int id);

  public List<Hunlicehuayuding> getAll(Map<String,Object> map);
  public List<Hunlicehuayuding> getsyhunlicehuayuding1(Map<String,Object> map);
  public List<Hunlicehuayuding> getsyhunlicehuayuding2(Map<String,Object> map);
  public List<Hunlicehuayuding> getsyhunlicehuayuding3(Map<String,Object> map);
  public Hunlicehuayuding quchongHunlicehuayuding(Map<String, Object> acount);

  public Hunlicehuayuding getById( int id);

  public List<Hunlicehuayuding> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Hunlicehuayuding> select(Map<String, Object> map);
}
//	所有List
