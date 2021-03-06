package com.bowen.architecture.architecture1.orderMgr.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bowen.architecture.architecture1.common.service.BaseService;

import com.bowen.architecture.architecture1.orderMgr.dao.OrderDAO;
import com.bowen.architecture.architecture1.orderMgr.vo.OrderModel;
import com.bowen.architecture.architecture1.orderMgr.vo.OrderQueryModel;

@Service("orderService")
@Transactional
public class OrderService extends BaseService<OrderModel,OrderQueryModel> implements IOrderService{
	private OrderDAO dao = null;
	@Autowired
	private void setDao(OrderDAO dao){
		this.dao = dao;
		super.setDao(dao);
	}
	
}