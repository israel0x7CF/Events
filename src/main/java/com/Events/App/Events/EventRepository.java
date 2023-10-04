package com.Events.App.Events;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Events,Long>
{
    @Query("SELECT event FROM Events event WHERE event.name = :name")
    Optional<Events> findEventByName(@Param("name") String Name);   
}
