package com.learn.microservices.ratingServices.services;

import com.learn.microservices.ratingServices.entities.Rating;
import com.learn.microservices.ratingServices.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServicesimpl implements RatingService{

    @Autowired
    RatingRepository ratingRepository;

    @Override
    public Rating create(Rating rating) {
        String Id = UUID.randomUUID().toString();
        rating.setRatingId(Id);
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAll() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }
}
