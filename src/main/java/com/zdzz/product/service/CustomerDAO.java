package com.zdzz.product.service;

import com.zdzz.product.model.Customer;
import com.zdzz.product.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerDAO {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }

    public Customer saveCustomer(Customer customer){
        if (Objects.isNull(customer)){
            return new Customer();
        }
        return customerRepository.insert(customer);
    }

    public Customer updateCustomer(String _id, Customer customerNew){
        if (Objects.isNull(customerNew) && Objects.isNull(customerNew.getId())){
            return new Customer();
        }
        Optional<Customer> customerOld = findById(_id);
        if (Objects.nonNull(customerOld)){
            customerNew.setId(customerOld.get().getId());
            return customerRepository.save(customerNew);
        }
        return new Customer();
    }

    public String deleteCustomer(String _id){
        Optional<Customer> customer = findById(_id);
        if (Objects.nonNull(customer.get())){
            customerRepository.delete(customer.get());
        }
        return String.format("Customer with id: %s has been removed", _id);
    }

    public Optional<Customer> findById(String _id){
        return customerRepository.findById(_id);
    }
}
