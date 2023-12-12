package com.Events.App.Rating;
import org.springframework.data.annotation.Transient;

import com.Events.App.Organizers.Organizers;

import jakarta.persistence.*;
@Entity
@Table
public class Rating {
    @Id
    @SequenceGenerator(
        name="rating_sequence",sequenceName="rating_sequence"
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "rating_sequence"
    )
    
    private Long Id;
    // private Organizers org;
    private Long count;
    private float rating;

    public Rating (){

    }
    // public Rating(float rating){
    //     this.rating = rating;
    // }
    public float getRating() {
        return rating;
    }
    public void setRating(float rating) {
        this.rating = rating;
        
    }
    public Long getCount() {
        return count;
    }
    public void setCount(Long count) {
        this.count = count;
    }
    
}
