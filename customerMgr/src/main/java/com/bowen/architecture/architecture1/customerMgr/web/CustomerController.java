package com.bowen.architecture.architecture1.customerMgr.web;

import com.bowen.architecture.architecture1.customerMgr.service.ICustomerService;
import com.bowen.architecture.architecture1.customerMgr.vo.CustomerModel;
import com.bowen.architecture.architecture1.customerMgr.vo.CustomerQueryModel;
import com.bowen.architecture.architecture1.pageutil.Page;
import com.bowen.architecture.architecture1.util.format.DateFormatHelper;
import com.bowen.architecture.architecture1.util.json.JsonHelper;
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
        cm.setRegisterTime(DateFormatHelper.long2str(System.currentTimeMillis()));
        customerService.create(cm);
        return "customer/success";
    }

    @RequestMapping(value = "toUpdate/{customerUuid}", method = RequestMethod.GET)
    public String toUpdate(Model model, @PathVariable("customerUuid") int customerUuid) {
        CustomerModel cm = customerService.getByUuid(customerUuid);
        model.addAttribute("cm", cm);
        return "customer/update";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
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
    public String toList(@RequestParam("queryJsonStr") String queryJsonStr, @ModelAttribute("page") Page page, Model model) {
        CustomerQueryModel cqm = null;
        if(queryJsonStr == null || queryJsonStr.trim().length() == 0){
            cqm = new CustomerQueryModel();
        }else{
            cqm = (CustomerQueryModel) JsonHelper.str2Object(queryJsonStr,CustomerQueryModel.class);
        }
        cqm.getPage().setNowPage(page.getNowPage());
        Page dbpage = customerService.getByConditionPage(cqm);

        model.addAttribute("queryJsonStr", queryJsonStr);
        model.addAttribute("page", dbpage);

        return "customer/list";
    }

}
