package com.learn.microservices.userServices.external.services;

import com.learn.microservices.userServices.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Map;

@FeignClient("RATING-SERVICE")
public interface RatingSevice {

    @PostMapping("/ratings")
    public Rating createRating(Rating values);

    @PutMapping("/ratings/{ratingId}")
    public Rating updateRating(@PathVariable String ratingId, Rating values);

    @DeleteMapping("/ratings/{ratingId}")
    public Rating deletRating(@PathVariable String ratingId);


}
