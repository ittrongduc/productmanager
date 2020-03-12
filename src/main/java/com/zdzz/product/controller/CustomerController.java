package com.zdzz.product.controller;

import com.zdzz.product.model.Customer;
import com.zdzz.product.service.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    private CustomerDAO customerDAO;

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public List<Customer> getAllCustomers(){
        return customerDAO.getAllCustomer();
    }

    @RequestMapping(value = "/customer/{_id}", method = RequestMethod.GET)
    public Optional<Customer> getCustomerById(@PathVariable("_id") String _id){
        return customerDAO.findById(_id);
    }

    @RequestMapping(value = "/customer/insert", method = RequestMethod.POST)
    public Customer insertCustomer(@RequestBody Customer customer){
        return customerDAO.saveCustomer(customer);
    }

    @RequestMapping(value = "/customer/delete/{_id}", method = RequestMethod.GET)
    public String removeCustomer(@PathVariable("_id") String _id){
        return customerDAO.deleteCustomer(_id);
    }

    @RequestMapping(value = "/customer/update/{_id}", method = RequestMethod.POST)
    public Customer updateCustomer(@PathVariable("_id") String _id, @RequestBody Customer customer){
        return customerDAO.updateCustomer(_id, customer);
    }

}
