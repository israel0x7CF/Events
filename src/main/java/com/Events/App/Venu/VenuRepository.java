package com.Events.App.Venu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface VenuRepository extends JpaRepository<Venu,Long>
{
    
}