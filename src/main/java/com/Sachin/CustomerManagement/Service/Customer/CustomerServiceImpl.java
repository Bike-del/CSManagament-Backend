package com.Sachin.CustomerManagement.Service.Customer;

import com.Sachin.CustomerManagement.Dto.CustomerDto;
import com.Sachin.CustomerManagement.VO.Customer;
import com.Sachin.CustomerManagement.Repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    //get
    public List<Customer> allCustomer(){
        return customerRepository.findAll();
    }

    @Override
    public Customer getByCustomerName(String name) {
        return customerRepository.findByName(name);
    }



    //post
    public Customer Create(Customer customer){

        return customerRepository.save(customer);
    }


    //put
    public Customer update(Customer customer,Long Id){
        Customer oldCustomer = customerRepository.findById(Id).
                orElseThrow(()-> new RuntimeException("Customer not found for this id:"+Id));

        oldCustomer.setAge(customer.getAge());
        oldCustomer.setName(customer.getName());
        oldCustomer.setEmail(customer.getEmail());
        oldCustomer.setPhoneNo(customer.getPhoneNo());
     //   oldCustomer.setBillPrice(customer.getBillPrice());
        oldCustomer.setPincode(customer.getPincode());
        oldCustomer.setCity(customer.getCity());

        customerRepository.save(oldCustomer);

        return oldCustomer;

    }

    //delete
    @Override
    public void Delete(Long Id) {
        customerRepository.deleteById(Id);

    }

    @Override
    public Customer getById(Long Id) {
        return customerRepository.findById(Id).orElseThrow(()-> new RuntimeException("Customer not found for this id:"+Id));
    }

    @Override
    public List<Customer> getByPageNo(long no) {
        return customerRepository.findByPage(no);
    }

}
