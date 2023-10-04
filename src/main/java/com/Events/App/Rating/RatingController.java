package com.Events.App.Rating;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api/v1/ratings")
public class RatingController {
    private final RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService)
    {
        this.ratingService = ratingService;
    }
    @PostMapping
    public void Interaction(@RequestBody Rating rating,@RequestParam Long id){
        this.ratingService.updateRating(id,rating);
    }
}
