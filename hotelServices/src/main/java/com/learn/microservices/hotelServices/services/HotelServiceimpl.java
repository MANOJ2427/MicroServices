package com.learn.microservices.hotelServices.services;

import com.learn.microservices.hotelServices.entities.Hotel;
import com.learn.microservices.hotelServices.repositories.HotelRepositories;
import com.learn.microservices.hotelServices.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceimpl implements HotelServices{

    @Autowired
    HotelRepositories hotelRepositories;

    @Override
    public Hotel create(Hotel hotel) {
        String ID = UUID.randomUUID().toString();
        hotel.setId(ID);
        return hotelRepositories.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepositories.findAll();
    }

    @Override
    public Hotel get(String id) {
        return hotelRepositories.findById(id)
                .orElseThrow(
                        ()-> new ResourceNotFoundException("Hotel with Give Id is not found !!!")
                );
    }
}
