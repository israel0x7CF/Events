package com.Events.App.Themes;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
@Repository
public interface ThemeRepository extends JpaRepository<Theme,Long>
{
    @Query("Select theme from Theme theme where theme.name = :theme")
    Optional<Theme> findThemeByName(@Param("theme") String theme);
}
