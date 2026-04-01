package com.Sachin.CustomerManagement.Repository;

import com.Sachin.CustomerManagement.VO.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByUserName(String userName);
}
