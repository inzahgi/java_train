package com.tcl.mie.service;

import com.tcl.mie.helper.DatabaseHelper;
import com.tcl.mie.model.Customer;
import com.tcl.mie.util.PropsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class CustomerService {

    private final static Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);




    public List<Customer> getCustomerList(){
        Connection conn = DatabaseHelper.getConnection();
        try{
            String sql="SELECT * FROM customer";
            return DatabaseHelper.queryEntityList(Customer.class, conn, sql);
        }finally {
            DatabaseHelper.closeConnection(conn);
        }
    }

    public Customer getCustomer(long id){
        // TODO
        return null;
    }

    public boolean createCustomer(Map<String, Object> fieldMap){
        // TODO
        return false;
    }

    public boolean updateCustomer(long id, Map<String, Object> foeldMap){
        // TODO
        return false;
    }

    public boolean deleteCustomer(long id){
        // TODO
        return false;
    }
}
