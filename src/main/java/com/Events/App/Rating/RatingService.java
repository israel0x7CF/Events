package com.Events.App.Rating;

import org.springframework.stereotype.Service;

@Service
public class RatingService {
    private final RatingRepository ratingRepository;

    public RatingService(RatingRepository ratingRepository)
    {
        this.ratingRepository = ratingRepository;
    }


    public void updateRating(Long id,Rating rating){
        Rating existing_rating = this.ratingRepository.findById(id).orElse(null);
        if(existing_rating != null){
            Long count = existing_rating.getCount();
            float currentRating = existing_rating.getRating();
            float new_rating=(currentRating + 1)/(count+1);
            existing_rating.setCount(count+1);
            existing_rating.setRating(new_rating);
            this.ratingRepository.save(existing_rating);

        }
        else{
            this.ratingRepository.save(rating);
        }


    }
}
