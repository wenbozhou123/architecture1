package com.bowen.architecture.architecture1.orderMgr.dao;

import org.springframework.stereotype.Repository;
import com.bowen.architecture.architecture1.common.dao.BaseDAO;

import com.bowen.architecture.architecture1.orderMgr.vo.OrderDetailModel;
import com.bowen.architecture.architecture1.orderMgr.vo.OrderDetailQueryModel;

@Repository
public interface OrderDetailDAO extends BaseDAO<OrderDetailModel,OrderDetailQueryModel>{
	
}
