package com.bowen.architecture.architecture1.customerMgr.service;

import com.bowen.architecture.architecture1.common.service.BaseService;
import com.bowen.architecture.architecture1.customerMgr.dao.CustomerDAO;
import com.bowen.architecture.architecture1.customerMgr.vo.CustomerModel;
import com.bowen.architecture.architecture1.customerMgr.vo.CustomerQueryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("customerService")
@Transactional
public class CustomerService extends BaseService<CustomerModel, CustomerQueryModel> implements ICustomerService {
    private CustomerDAO dao = null;
    @Autowired
    private void setDao(CustomerDAO dao){
        this.dao = dao;
        super.setDao(dao);
    }


    @Override
    public CustomerModel getByCustomerId(String customerId) {
        return dao.getByCustomerId(customerId);
    }
}
