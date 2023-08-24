package com.learn.microservices.userServices.services;

import com.learn.microservices.userServices.entities.Hotel;
import com.learn.microservices.userServices.entities.Rating;
import com.learn.microservices.userServices.entities.Users;
import com.learn.microservices.userServices.exception.UserNotFound;
import com.learn.microservices.userServices.external.services.HotelService;
import com.learn.microservices.userServices.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserServices{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;
    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


    @Override
    public Users saveUser(Users users) {
        String userId = UUID.randomUUID().toString();
        users.setUserID(userId);
        return userRepository.save(users);
    }

    @Override
    public List<Users> getAllUser() {
        return userRepository.findAll();
    }

//    @Override
//    public Users getUser(String userId) {
//        Users user = userRepository.findById(userId).orElseThrow(()-> new UserNotFound("User With Give Id Not Found, ID :"+userId));
//       //http://localhost:8083/ratings/users/aeafd868-425b-406c-8014-0ab5424e0c8c
//        Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+userId, Rating[].class);
//        logger.info("{} ",ratingsOfUser);
//        List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();
//        List<Rating> usersRating= ratings.stream().map(
//                rating->{
//                    //http://localhost:8082/hotels/8d3abc28-9918-42c5-a3c2-860c74cb03e0
//                  Hotel hotel =  restTemplate.getForObject("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
//                  logger.info("{} ",hotel);
//                  rating.setHotel(hotel);
//                  return rating;
//                }).collect(Collectors.toList());
//        user.setRatings(usersRating);
//        return user;
//    }

    @Override
    public Users getUser(String userId) {
        Users user = userRepository.findById(userId).orElseThrow(()-> new UserNotFound("User With Give Id Not Found, ID :"+userId));
        //http://localhost:8083/ratings/users/aeafd868-425b-406c-8014-0ab5424e0c8c
        Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+userId, Rating[].class);
        logger.info("{} ",ratingsOfUser);
        List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();
        List<Rating> usersRating= ratings.stream().map(
                rating->{
                    Hotel hotel = hotelService.getHotel(rating.getHotelId());
                    logger.info("{} ",hotel);
                    rating.setHotel(hotel);
                    return rating;
                }).collect(Collectors.toList());
        user.setRatings(usersRating);
        return user;
    }
    @Override
    public Users deleteUser(String userId) {
        return null;
    }
}
