package com.project.dani.library_app.repository.locality;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.project.dani.library_app.entity.locality.City;

public interface CityRepository extends JpaRepository<City, Long> {

	List<City> findByNameContains(String name);

    @Query("SELECT c FROM City c ORDER BY c.name ASC")
    List<City> findAllByOrderByNameAsc();

    @Query("SELECT c FROM City c ORDER BY c.name DESC")
    List<City> findAllByOrderByNameDesc();

    @Modifying
    @Query("UPDATE City c SET c.name = ?2 WHERE c.id = ?1")
    void updateById(Long id, String name);

}
