package com.bowen.architecture.architecture1.cartMgr.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bowen.architecture.architecture1.common.service.BaseService;

import com.bowen.architecture.architecture1.cartMgr.dao.CartDAO;
import com.bowen.architecture.architecture1.cartMgr.vo.CartModel;
import com.bowen.architecture.architecture1.cartMgr.vo.CartQueryModel;

@Service("cartService")
@Transactional
public class CartService extends BaseService<CartModel,CartQueryModel> implements ICartService{
	private CartDAO dao = null;
	@Autowired
	private void setDao(CartDAO dao){
		this.dao = dao;
		super.setDao(dao);
	}
	
}