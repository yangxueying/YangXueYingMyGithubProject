package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.HunlicehuayudingMapper;
import com.entity.Hunlicehuayuding;
import com.server.HunlicehuayudingServer;
@Service
public class HunlicehuayudingServerImpi implements HunlicehuayudingServer {
   @Resource
   private HunlicehuayudingMapper gdao;
	@Override
	public int add(Hunlicehuayuding po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Hunlicehuayuding po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Hunlicehuayuding> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Hunlicehuayuding> getsyhunlicehuayuding1(Map<String, Object> map) {
		return gdao.getsyhunlicehuayuding1(map);
	}
	public List<Hunlicehuayuding> getsyhunlicehuayuding2(Map<String, Object> map) {
		return gdao.getsyhunlicehuayuding2(map);
	}
	public List<Hunlicehuayuding> getsyhunlicehuayuding3(Map<String, Object> map) {
		return gdao.getsyhunlicehuayuding3(map);
	}
	
	@Override
	public Hunlicehuayuding quchongHunlicehuayuding(Map<String, Object> account) {
		return gdao.quchongHunlicehuayuding(account);
	}

	@Override
	public List<Hunlicehuayuding> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Hunlicehuayuding> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Hunlicehuayuding getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

