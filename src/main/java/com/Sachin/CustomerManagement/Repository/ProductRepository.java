package com.Sachin.CustomerManagement.Repository;

import com.Sachin.CustomerManagement.VO.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

}
