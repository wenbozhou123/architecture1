package com.bowen.architecture.architecture1.customerMgr.dao;

import com.bowen.architecture.architecture1.customerMgr.vo.CustomerModel;
import com.bowen.architecture.architecture1.customerMgr.vo.CustomerQueryModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDAO {

    public void create(CustomerModel cm);
    public void update(CustomerModel cm);
    public void delete(int uuid);

    public CustomerModel getByUuid(int uuid);
    public List<CustomerModel> getByConditionPage(CustomerQueryModel cqm);

}
