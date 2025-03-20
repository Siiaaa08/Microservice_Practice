package com.example.movie_catalog_service.service;

import com.example.movie_catalog_service.model.Rating;
import com.example.movie_catalog_service.model.UserRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class UserRatingInfo {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackUserRating")
    public UserRating getUserRating(@PathVariable("userId") String userId) {
        return restTemplate.getForObject("http://ratings-data-service/ratingsdata/user/" +userId, UserRating.class);
    }

    public UserRating getFallbackUserRating(@PathVariable("userId") String userId) {
        UserRating userRating = new UserRating();
        userRating.setUserId(userId);
        userRating.setRatings(Arrays.asList(
                new Rating("0",0)
        ));
        return userRating;
    }

}
