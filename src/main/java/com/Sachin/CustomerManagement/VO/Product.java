package com.Sachin.CustomerManagement.VO;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;

    private String productName;


    private String description;

    private double qty;

    private String image;






    private double landingCost; //purchase price + gst

    private double sellingPrice;  //purchase Price + gst + profit margin

    private double purchasePrice;

    private LocalDateTime createdOn;
    private LocalDateTime modifiedOn;

}
