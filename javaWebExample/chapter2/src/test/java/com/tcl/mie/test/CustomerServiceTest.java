package com.tcl.mie.test;

import com.tcl.mie.helper.DatabaseHelper;
import com.tcl.mie.model.Customer;
import com.tcl.mie.service.CustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceTest {

    private final CustomerService customerService;

    public CustomerServiceTest() {
        customerService = new CustomerService();
    }

    @BeforeAll
    public static void init() throws Exception{
        DatabaseHelper.executeSqlFile("sql/create_table.sql");
        DatabaseHelper.executeSqlFile("sql/insert.sql");
    }

    @Test
    public void getCustomerListTest() throws Exception {
        List<Customer> customerList = customerService.getCustomerList();
        Assertions.assertEquals(2, customerList.size());
    }

    @Test
    public void getCustomerTest() throws Exception{
        long id = 1;
        Customer customer = customerService.getCustomer(id);
        Assertions.assertNotNull(customer);
    }

    @Test
    public void createCustomerTest() throws Exception{
        Map<String, Object> fieldMap = new HashMap<>();
        fieldMap.put("name", "customer100");
        fieldMap.put("contact", "John");
        fieldMap.put("telephone", "13512345678");
        boolean result = customerService.createCustomer(fieldMap);
        Assertions.assertTrue(result);
    }

    @Test
    public void updateCustomerTest() throws Exception{
        long id = 1;
        Map<String, Object> fieldMap = new HashMap<String, Object>();
        fieldMap.put("contact", "Eric");
        boolean result = customerService.updateCustomer(id, fieldMap);
        Assertions.assertTrue(result);
    }

    @Test
    public void deleteCustomerTest() throws Exception{
        long id = 1;
        boolean result = customerService.deleteCustomer(id);
        Assertions.assertTrue(result);
    }

}
