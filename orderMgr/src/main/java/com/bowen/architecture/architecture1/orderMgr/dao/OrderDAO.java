package com.bowen.architecture.architecture1.orderMgr.dao;

import org.springframework.stereotype.Repository;
import com.bowen.architecture.architecture1.common.dao.BaseDAO;

import com.bowen.architecture.architecture1.orderMgr.vo.OrderModel;
import com.bowen.architecture.architecture1.orderMgr.vo.OrderQueryModel;

@Repository
public interface OrderDAO extends BaseDAO<OrderModel,OrderQueryModel>{
	
}
