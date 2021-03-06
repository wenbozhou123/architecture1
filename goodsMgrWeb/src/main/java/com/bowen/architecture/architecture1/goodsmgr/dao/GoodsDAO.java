package com.bowen.architecture.architecture1.goodsmgr.dao;

import org.springframework.stereotype.Repository;
import com.bowen.architecture.architecture1.common.dao.BaseDAO;

import com.bowen.architecture.architecture1.goodsmgr.vo.GoodsModel;
import com.bowen.architecture.architecture1.goodsmgr.vo.GoodsQueryModel;

@Repository
public interface GoodsDAO extends BaseDAO<GoodsModel,GoodsQueryModel>{
	
}
