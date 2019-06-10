package com.bowen.architecture.architecture1.customerMgr.web;

import com.bowen.architecture.architecture1.customerMgr.service.ICustomerService;
import com.bowen.architecture.architecture1.customerMgr.vo.CustomerModel;
import com.bowen.architecture.architecture1.customerMgr.vo.CustomerQueryModel;
import com.bowen.architecture.architecture1.pageutil.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService = null;

    @RequestMapping(value = "toAdd", method = RequestMethod.GET)
    public String toAdd(){

        return "customer/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(@ModelAttribute("cm") CustomerModel cm){
        customerService.create(cm);
        return "customer/success";
    }

    @RequestMapping(value = "toUpdate/{customerUuid}", method = RequestMethod.GET)
    public String toUpdate(Model model, @PathVariable("customerUuid") int customerUuid) {
        CustomerModel cm = customerService.getByUuid(customerUuid);
        model.addAttribute("cm", cm);
        return "customer/update";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String update(@ModelAttribute("cm") CustomerModel cm){
        customerService.create(cm);
        return "customer/success";
    }

    @RequestMapping(value = "toDelete/{customerUuid}", method = RequestMethod.GET)
    public String toDelete(Model model, @PathVariable("customerUuid") int customerUuid) {
        CustomerModel cm = customerService.getByUuid(customerUuid);
        model.addAttribute("cm", cm);
        return "customer/delete";
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String delete(@RequestParam("uuid") int custmoerUuid){
        customerService.delete(custmoerUuid);
        return "customer/success";
    }

    @RequestMapping(value = "toList", method = RequestMethod.GET)
    public String toList(@RequestParam("queryJsonStr") String queryJsonStr, @ModelAttribute("page") Page page) {
        CustomerQueryModel cqm = null;
        if(queryJsonStr == null || queryJsonStr.trim().length() == 0){
            cqm = new CustomerQueryModel();
        }else{

        }


        return "customer/list";
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String delete1(@RequestParam("uuid") int custmoerUuid){
        customerService.delete(custmoerUuid);
        return "customer/success";
    }

}
