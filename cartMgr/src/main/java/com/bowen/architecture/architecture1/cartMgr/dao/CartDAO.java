package com.bowen.architecture.architecture1.cartMgr.dao;

import org.springframework.stereotype.Repository;
import com.bowen.architecture.architecture1.common.dao.BaseDAO;

import com.bowen.architecture.architecture1.cartMgr.vo.CartModel;
import com.bowen.architecture.architecture1.cartMgr.vo.CartQueryModel;

@Repository
public interface CartDAO extends BaseDAO<CartModel,CartQueryModel>{
	
}
