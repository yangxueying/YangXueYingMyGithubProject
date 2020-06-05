package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Hunlicehuayuding;

public interface HunlicehuayudingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Hunlicehuayuding record);

    int insertSelective(Hunlicehuayuding record);

    Hunlicehuayuding selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hunlicehuayuding record);
	
    int updateByPrimaryKey(Hunlicehuayuding record);
	public Hunlicehuayuding quchongHunlicehuayuding(Map<String, Object> yudingren);
	public List<Hunlicehuayuding> getAll(Map<String, Object> map);
	public List<Hunlicehuayuding> getsyhunlicehuayuding1(Map<String, Object> map);
	public List<Hunlicehuayuding> getsyhunlicehuayuding3(Map<String, Object> map);
	public List<Hunlicehuayuding> getsyhunlicehuayuding2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Hunlicehuayuding> getByPage(Map<String, Object> map);
	public List<Hunlicehuayuding> select(Map<String, Object> map);
//	所有List
}

