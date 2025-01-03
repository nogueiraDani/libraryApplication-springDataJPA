package com.project.dani.library_app.repository.locality;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.project.dani.library_app.entity.locality.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {

    @Modifying
    @Query("UPDATE Country c SET c.name = :name WHERE c.id = :id")
    void updateById(Long id, String name);

    @Query("SELECT c FROM Country c ORDER BY c.name ASC")
    List<Country> findAllOrderByNameAsc();

    @Query("SELECT c FROM Country c ORDER BY c.name DESC")
    List<Country> findAllOrderByNameDesc();

    List<Country> findByNameContains(String name);

}
