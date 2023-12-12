package com.Events.App.Schedule;

import jakarta.persistence.*;


@Entity
@Table
public class Schedule {
    @Id
    @SequenceGenerator(name="scheduler_sequence",sequenceName = "schedulerr_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="scheduler_sequence")
    private Long id;
    
    
}
