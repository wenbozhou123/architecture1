package com.bowen.architecture.architecture1.storemgr.dao;

import org.springframework.stereotype.Repository;
import com.bowen.architecture.architecture1.common.dao.BaseDAO;

import com.bowen.architecture.architecture1.storemgr.vo.StoreModel;
import com.bowen.architecture.architecture1.storemgr.vo.StoreQueryModel;

@Repository
public interface StoreDAO extends BaseDAO<StoreModel,StoreQueryModel>{
	
}
