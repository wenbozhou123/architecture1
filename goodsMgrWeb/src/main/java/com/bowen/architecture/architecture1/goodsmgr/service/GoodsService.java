package com.bowen.architecture.architecture1.goodsmgr.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bowen.architecture.architecture1.common.service.BaseService;

import com.bowen.architecture.architecture1.goodsmgr.dao.GoodsDAO;
import com.bowen.architecture.architecture1.goodsmgr.vo.GoodsModel;
import com.bowen.architecture.architecture1.goodsmgr.vo.GoodsQueryModel;

@Service("goodsService")
@Transactional
public class GoodsService extends BaseService<GoodsModel,GoodsQueryModel> implements IGoodsService{
	private GoodsDAO dao = null;
	@Autowired
	private void setDao(GoodsDAO dao){
		this.dao = dao;
		super.setDao(dao);
	}
	
}