package com.pp.rating.RatingService.services.impl;

import com.pp.rating.RatingService.entities.Rating;
import com.pp.rating.RatingService.repositories.RatingRepository;
import com.pp.rating.RatingService.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService
{
    @Autowired
    private RatingRepository ratingRepository;


    @Override
    public Rating create(Rating rating) {
        rating.setRatingId(UUID.randomUUID().toString());
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        List<Rating> byUserId = ratingRepository.findByUserId(userId);
        return byUserId;
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }
}
