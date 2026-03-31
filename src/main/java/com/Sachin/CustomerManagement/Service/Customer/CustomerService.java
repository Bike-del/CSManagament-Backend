package com.Sachin.CustomerManagement.Service.Customer;

import com.Sachin.CustomerManagement.Dto.CustomerDto;
import com.Sachin.CustomerManagement.VO.Customer;
import org.springframework.stereotype.Service;

import java.util.List;



public interface CustomerService {


    public List<Customer> allCustomer();

    public Customer getByCustomerName(String name);

   // public List<Customer> getCustomerByBigBill();

    public Customer Create(Customer customer);

    public Customer update(Customer customer,Long Id);

    public void Delete(Long Id);

    public  Customer getById(Long Id);

    List<Customer> getByPageNo(long no);
}
