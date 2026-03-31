package com.Sachin.CustomerManagement.Dto;


import com.Sachin.CustomerManagement.VO.orderStatus;
import lombok.Data;

@Data
public class OrderDto {
    private long orderId;
    private String productName;
    private int quantity;
    private double amount;
    private orderStatus status;
    private long customerId;
    private String customerName;

    // Optional, include only needed fields
}

