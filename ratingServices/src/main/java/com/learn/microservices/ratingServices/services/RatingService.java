package com.learn.microservices.ratingServices.services;

import com.learn.microservices.ratingServices.entities.Rating;
import com.learn.microservices.ratingServices.repository.RatingRepository;

import java.util.List;

public interface RatingService  {

    Rating create(Rating rating);

    List<Rating> getAll();

    List<Rating> getRatingByUserId(String userId);

    List<Rating> getRatingByHotelId(String hotelId);

}
