package com.Sachin.CustomerManagement.Repository;

import com.Sachin.CustomerManagement.Service.Customer.CustomerService;
import com.Sachin.CustomerManagement.VO.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    Customer findByName(String name);

    @Query(value = "select * from customer LIMIT 10 offset (:no - 1) * 10; ",nativeQuery = true)
    List<Customer> findByPage(@Param("no") long no);

    //Bill_Price column is removed
    //find  the customer which has the big amount of bill
//    @Query(value = "select * from customer where bill_price = (select max(bill_price) from customer)",nativeQuery = true)
//    List<Customer> findByBigBillPrice();

}
