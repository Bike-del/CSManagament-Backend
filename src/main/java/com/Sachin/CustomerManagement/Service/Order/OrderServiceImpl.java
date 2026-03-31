package com.Sachin.CustomerManagement.Service.Order;

import com.Sachin.CustomerManagement.Dto.OrderDto;
import com.Sachin.CustomerManagement.Repository.OrderRepository;
import com.Sachin.CustomerManagement.VO.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public Order createOrder(Order order) {
        int qty = order.getQuantity();
        Double price = order.getAmount();
        Double total = qty*price;
        order.setBillPrice(total);
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(Order order, long Id) {
        Order oldOrder = orderRepository.findById(Id).orElseThrow(
                ()-> new RuntimeException("Order not found for this id"));
        oldOrder.setAmount(order.getAmount());
        oldOrder.setCustomer(order.getCustomer());
        oldOrder.setStatus(order.getStatus());
        oldOrder.setProductName(order.getProductName());
        oldOrder.setQuantity(order.getQuantity());

        return  orderRepository.save(oldOrder);

    }



    @Override
    public void deleteOrder(long Id) {
            orderRepository.deleteById(Id);
    }

    @Override
    public OrderDto orderById(long id) {
        Order order =  orderRepository.findById(id).orElseThrow(()-> new RuntimeException("order not found"));
        OrderDto orderDto = convertToDto(order);
        return orderDto;
    }

    //TODO : conver into objectMapper
    private OrderDto convertToDto(Order order) {

//        OrderDto orderDto = new OrderDto();
//        orderDto.setOrderId(order.getOrderId());
//        orderDto.setStatus(order.getStatus());
//        orderDto.setQuantity(order.getQuantity());
//        orderDto.setAmount(order.getAmount());
//        orderDto.setProductName(order.getProductName());
//        orderDto.setCustomerId(order.getCustomer().getCustomerId());

        OrderDto orderDto = objectMapper.convertValue(order, OrderDto.class);

        orderDto.setCustomerId(order.getCustomer().getCustomerId());
        return orderDto;
    }


}
