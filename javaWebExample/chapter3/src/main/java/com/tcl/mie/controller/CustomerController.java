package com.tcl.mie.controller;

import com.tcl.mie.framework.annotation.Action;
import com.tcl.mie.framework.annotation.Controller;
import com.tcl.mie.framework.annotation.Inject;
import com.tcl.mie.framework.bean.Data;
import com.tcl.mie.framework.bean.Param;
import com.tcl.mie.framework.bean.View;
import com.tcl.mie.model.Customer;
import com.tcl.mie.service.CustomerService;

import java.util.List;
import java.util.Map;

@Controller
public class CustomerController {

    @Inject
    private CustomerService customerService;

    @Action("get:/customer")
    public View index(Param param) {
        List<Customer> customerList = customerService.getCustomerList();
        return new View("customer.jsp")
                .addModel("customerList", customerList);
    }

    @Action("get:/customer_show")
    public View show(Param param){
        long id = param.getLong("id");
        Customer customer = customerService.getCustomer(id);
        return new View("customer)show.jsp")
                .addModel("customer", customer);
    }

    @Action("get:/customer_create")
    public View create(Param param){
        return new View("customer_create.jsp");
    }

    @Action("post:/customer_create")
    public Data createSubmit(Param param){
        Map<String, Object> fieldMap = param.getMap();
        boolean result = customerService.createCustomer(fieldMap);
        return new Data(result);
    }

    @Action("put:/customer_edit")
    public Data editSubmit(Param param) {
        long id = param.getLong("id");
        Map<String, Object> fieldMap = param.getMap();
        boolean result = customerService.updateCustomer(id, fieldMap);
        return new Data(result);
    }

    @Action("delete:/customer_edit")
    public Data delete(Param param){
        long id = param.getLong("id");
        boolean result = customerService.deleteCustomer(id);
        return new Data(result);
    }
}
