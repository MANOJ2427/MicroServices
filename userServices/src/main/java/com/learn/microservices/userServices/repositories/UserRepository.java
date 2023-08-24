package com.learn.microservices.userServices.repositories;

import com.learn.microservices.userServices.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,String> {
    // Add Any custom method
}
