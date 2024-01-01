package com.Events.App.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<Users,Long>
{
    Optional<Users> findByUsername(String username);
    Optional<Users> findByEmail(String email);
}
