package com.Events.App.Organizers;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizersRepository extends JpaRepository<Organizers,Long>
{

    @Query("select organizer from Organizers organizer where organizer.name = :name")
    Optional<Organizers> findOrganizerByName(@Param("name") String name);
    
}