package com.bowen.architecture.architecture1.orderMgr.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bowen.architecture.architecture1.common.service.BaseService;

import com.bowen.architecture.architecture1.orderMgr.dao.OrderDetailDAO;
import com.bowen.architecture.architecture1.orderMgr.vo.OrderDetailModel;
import com.bowen.architecture.architecture1.orderMgr.vo.OrderDetailQueryModel;

@Service("orderDetailService")
@Transactional
public class OrderDetailService extends BaseService<OrderDetailModel,OrderDetailQueryModel> implements IOrderDetailService{
	private OrderDetailDAO dao = null;
	@Autowired
	private void setDao(OrderDetailDAO dao){
		this.dao = dao;
		super.setDao(dao);
	}
	
}