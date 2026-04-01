package com.Sachin.CustomerManagement.Service.Order;

import com.Sachin.CustomerManagement.Dto.OrderDto;
import com.Sachin.CustomerManagement.VO.Order;

import java.util.List;

public interface OrderService {

    //get
    public List<Order> getAllOrder();

    //post
    public Order createOrder(OrderDto order);

    //put
    public Order updateOrder(OrderDto order,long Id);

    //delete
    public void deleteOrder(long Id);

    OrderDto orderById(long id);
}
