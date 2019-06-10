package com.bowen.architecture.architecture1.customerMgr;

import com.bowen.architecture.architecture1.customerMgr.dao.CustomerDAO;
import com.bowen.architecture.architecture1.customerMgr.service.ICustomerService;
import com.bowen.architecture.architecture1.customerMgr.vo.CustomerModel;
import com.bowen.architecture.architecture1.customerMgr.vo.CustomerQueryModel;
import com.bowen.architecture.architecture1.pageutil.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("client")
@Transactional
public class Client {

    @Autowired
    private ICustomerService customerService = null;

    public ICustomerService getS(){
        return customerService;
    }

    public static void main(String[] args){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Client c = (Client)ctx.getBean("client");

        CustomerModel cm = new CustomerModel();
        cm.setCustomerId("c1");
        cm.setPwd("123");
        cm.setRegisterTime("111");
        cm.setShowName("c1");
        cm.setTrueName("张三");
        //c.dao.create(cm);

        CustomerQueryModel cqm = new CustomerQueryModel();

        cqm.getPage().setNowPage(5);

        Page<CustomerModel> p = c.getS().getByConditionPage(cqm);

        System.out.println("list==" +p);

    }

}
