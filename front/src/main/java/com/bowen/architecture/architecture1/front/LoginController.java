package com.bowen.architecture.architecture1.front;


import com.bowen.architecture.architecture1.customerMgr.service.ICustomerService;
import com.bowen.architecture.architecture1.customerMgr.vo.CustomerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/front")
public class LoginController {

    @Autowired
    private ICustomerService customerService = null;

    @RequestMapping(value = "/toLogin", method = RequestMethod.GET)
    public String toLogin() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("customerId") String customerId, @RequestParam("pwd") String pwd, HttpServletResponse response) {
        if (customerId == null || customerId.trim().length() ==0){
            return "login";
        }
        CustomerModel customerModel = customerService.getByCustomerId(customerId);
        if (customerModel == null || customerModel.getUuid() < 0){
            return "login";
        }

        Cookie c =new Cookie("myLogin", customerModel.getUuid()+","+System.currentTimeMillis());
        response.addCookie(c);
        return "index";
    }
}
