package com.Sachin.CustomerManagement.Controller;

import com.Sachin.CustomerManagement.ApiResponse.ApiResponse;
import com.Sachin.CustomerManagement.Dto.OrderDto;
import com.Sachin.CustomerManagement.Repository.OrderRepository;
import com.Sachin.CustomerManagement.Service.Order.OrderService;
import com.Sachin.CustomerManagement.VO.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    //get
    @GetMapping("/all")
    public ResponseEntity<List<OrderDto>> getAllOrder(){

        List<Order> orders = orderService.getAllOrder();

        List<OrderDto> list = orders.stream().map(order -> {
            OrderDto orderDto = new OrderDto();
            orderDto.setOrderId(order.getOrderId());
            orderDto.setCustomerId(order.getCustomer().getCustomerId());
            orderDto.setStatus(order.getStatus());
            orderDto.setQuantity(order.getQuantity());
            orderDto.setAmount(order.getAmount());
            orderDto.setProductName(order.getProductName());
            orderDto.setCustomerName(order.getCustomer().getName());

            return orderDto;

        }).toList();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable long id){
        return new ResponseEntity<>(orderService.orderById(id), HttpStatus.OK);
    }

    //put
    @PutMapping("/update/{id}")
    public ResponseEntity<Order> updateOrder(@RequestBody Order order,@PathVariable long id){
        return new ResponseEntity<>(orderService.updateOrder(order,id), HttpStatus.OK);
    }
    //create
    @PostMapping("/create")
    public ResponseEntity<Order> createOrder(@RequestBody Order order){
        return new ResponseEntity<>(orderService.createOrder(order), HttpStatus.CREATED);
    }

    //delete
    @DeleteMapping("delete/{id}")
    public ApiResponse deleteOrder(@PathVariable long id){
        orderService.deleteOrder(id);
        return new ApiResponse("Deleted",true,null);
    }


}
