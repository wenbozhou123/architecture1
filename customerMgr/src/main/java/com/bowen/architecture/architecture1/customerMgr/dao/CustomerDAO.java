package com.bowen.architecture.architecture1.customerMgr.dao;

import com.bowen.architecture.architecture1.customerMgr.vo.CustomerModel;
import com.bowen.architecture.architecture1.customerMgr.vo.CustomerQueryModel;

import java.util.List;

public interface CustomerDAO {

    public void create(CustomerModel cm);
    public void update(CustomerModel cm);
    public void delete(int uuid);

    public CustomerModel getByUuid(int uuid);
    public List<CustomerModel> getByCondition(CustomerQueryModel cqm);

}
