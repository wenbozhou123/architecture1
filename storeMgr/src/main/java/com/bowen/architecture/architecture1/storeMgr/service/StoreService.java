package com.bowen.architecture.architecture1.storeMgr.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bowen.architecture.architecture1.common.service.BaseService;

import com.bowen.architecture.architecture1.storeMgr.dao.StoreDAO;
import com.bowen.architecture.architecture1.storeMgr.vo.StoreModel;
import com.bowen.architecture.architecture1.storeMgr.vo.StoreQueryModel;

@Service("storeService")
@Transactional
public class StoreService extends BaseService<StoreModel,StoreQueryModel> implements IStoreService{
	private StoreDAO dao = null;
	@Autowired
	private void setDao(StoreDAO dao){
		this.dao = dao;
		super.setDao(dao);
	}
	
}