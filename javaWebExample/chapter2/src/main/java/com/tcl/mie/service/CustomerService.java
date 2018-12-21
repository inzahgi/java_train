package com.tcl.mie.service;

import com.tcl.mie.helper.DatabaseHelper;
import com.tcl.mie.model.Customer;
import com.tcl.mie.util.PropsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.activation.DataHandler;
import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class CustomerService {

    private final static Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);




    public List<Customer> getCustomerList(){
        String sql = "SELECT * FROM customer";
        return DatabaseHelper.queryEntityList(Customer.class, sql);
    }

    public Customer getCustomer(long id){
        String sql = "SELECT * FROM customer WHERE id = ?";
        return DatabaseHelper.queryEntity(Customer.class, sql, id);
    }

    public boolean createCustomer(Map<String, Object> fieldMap){
        return DatabaseHelper.insertEntity(Customer.class, fieldMap);
    }

    public boolean updateCustomer(long id, Map<String, Object> fieldMap){
        return DatabaseHelper.updateEntity(Customer.class, id, fieldMap);
    }

    public boolean deleteCustomer(long id){
        return DatabaseHelper.deleteEntity(Customer.class, id);
    }
}
