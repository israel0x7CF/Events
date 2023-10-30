package com.Events.App.Events;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

import com.Events.App.Organizers.Organizers;
import com.Events.App.Themes.Theme;
import com.Events.App.Venu.Venu;



//import com.Events.App.Themes.Theme;
@Entity
@Table
public class Events {
    // add a reference to the theme class, one to one type 
    public enum Schedule {
        recurring,
        onestime 
    }
    @Id
    @SequenceGenerator(name="event_sequence",sequenceName = "event_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "event_sequence")
    private Long id;
    private String name;
    private Integer estimatedArrival;
    private Integer actualArrivals;
    private Float Rating;
    private LocalDate eventDate;
    private String description;
    // @Enumerated(EnumType.STRING)
    // private Schedule schedule;

    @OneToMany
    Set<Theme>themes;

    @ManyToMany
    @JoinTable(
        name="EventVenuMapping",
        joinColumns= @JoinColumn(name="event_id"),
        inverseJoinColumns=@JoinColumn(name="venu_id")
        )
    Set<Venu> venus;
    @ManyToMany(mappedBy = "event")
    private Set<Organizers> organizers;
    
  
    public Events(){

    }
    public Events(String name,Integer estimatedArrival,Integer actualArrivals,Float Rating,LocalDate date,String description,Schedule schedule)
    {
        this.name = name;
        this.description = description;
        this.estimatedArrival = estimatedArrival;
        this.actualArrivals = actualArrivals;
        this.eventDate = date;
        this.description = description;
        // this.schedule = schedule;
        
    }
    public Set<Organizers> getOrganizers() {
        return this.organizers;
    }
    public String getDescription() {
        return description;
    }
    public Integer getActualArrivals() {
        return actualArrivals;
    }
    public Integer getEstimatedArrival() {
        return estimatedArrival;
    }
    public String getName() {
        return name;
    }
    public Long getId() {
        return id;
    }
    public Float getRating() {
        return Rating;
    }
    public LocalDate getDate() {
        return eventDate;
    }
    public Set<Venu> getVenus() {
        return venus;
    }
    public void setActualArrivals(Integer actualArrivals) {
        this.actualArrivals = actualArrivals;
    }
    public void setEstimatedArrival(Integer estimatedArrival) {
        this.estimatedArrival = estimatedArrival;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDate(LocalDate date) {
        this.eventDate = date;
    }
    public void setRating(Float rating) {
        Rating = rating;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setVenus(Set<Venu> venus) {
        this.venus = venus;
    }
    public void setOrganizers(Set<Organizers> organizers){
        this.organizers = organizers;
    }
}
