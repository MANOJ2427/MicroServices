package com.learn.microservices.hotelServices.services;
import com.learn.microservices.hotelServices.entities.Hotel;

import java.util.List;

public interface HotelServices {

    Hotel create(Hotel hotel);

    List<Hotel> getAll();

    Hotel get(String id);

}
