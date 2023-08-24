package com.learn.microservices.hotelServices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.learn.microservices.hotelServices.entities.Hotel;

public interface HotelRepositories extends JpaRepository<Hotel,String> {

}
