package com.bowen.architecture.architecture1.customerMgr;

import com.bowen.architecture.architecture1.customerMgr.dao.CustomerDAO;
import com.bowen.architecture.architecture1.customerMgr.vo.CustomerModel;
import com.bowen.architecture.architecture1.customerMgr.vo.CustomerQueryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("client")
public class Client {

    @Autowired
    private CustomerDAO dao =null;
    public static void main(String[] args){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Client c = (Client)ctx.getBean("client");

        CustomerModel cm = new CustomerModel();
        cm.setCustomerId("c1");
        cm.setPwd("123");
        cm.setRegisterTime("111");
        cm.setShowName("c1");
        cm.setTrueName("张三");
        c.dao.create(cm);

        List<CustomerModel> list = c.dao.getByCondition(new CustomerQueryModel());

        System.out.println("list==" +list);

    }

}
