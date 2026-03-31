package com.Sachin.CustomerManagement.VO;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
@Entity
public class Customer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private long customerId;

    @Column(name = "customer_name")
    private String name;


    @Column(name = "age")
    private int age;

//    @Column(name = "bill_price")
//    private double billPrice;

    @Column(name = "phone_no")
    private String phoneNo;

//    @Column(name = "product_id", columnDefinition = "bigint default 0")
//    private long productId;

    @Column(name = "email")
    private String email;

    @Column(name = "city")
    private String city;

    @Column(name = "pincode",length = 6)
    private int pincode;


    @OneToMany(mappedBy ="customer",
    cascade = CascadeType.ALL,
    orphanRemoval = true)
    @JsonManagedReference
    private List<Order> orders = new ArrayList<>();




}
