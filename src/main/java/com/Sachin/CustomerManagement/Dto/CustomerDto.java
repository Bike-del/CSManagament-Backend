package com.Sachin.CustomerManagement.Dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Data
public class CustomerDto {

    private String name;

    private double billPrice;

    private String phoneNo;

    private String city;

}
