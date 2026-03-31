package com.Sachin.CustomerManagement.Repository;

import com.Sachin.CustomerManagement.VO.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

}
