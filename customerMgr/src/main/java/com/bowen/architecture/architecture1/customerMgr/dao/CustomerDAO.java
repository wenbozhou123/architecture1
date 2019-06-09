package com.bowen.architecture.architecture1.customerMgr.dao;

import com.bowen.architecture.architecture1.common.dao.BaseDAO;
import com.bowen.architecture.architecture1.customerMgr.vo.CustomerModel;
import com.bowen.architecture.architecture1.customerMgr.vo.CustomerQueryModel;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerDAO extends BaseDAO<CustomerModel, CustomerQueryModel> {

}
