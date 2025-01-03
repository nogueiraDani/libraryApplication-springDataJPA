package com.project.dani.library_app.repository.locality;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.project.dani.library_app.entity.locality.State;

public interface StateRepository extends JpaRepository<State, Long> {

    List<State> findByNameContains(String name);

    @Query("SELECT s FROM State s ORDER BY s.name ASC")
    List<State> findAllOrderByNameAsc();

    @Query("SELECT s FROM State s ORDER BY s.name DESC")
    List<State> findAllOrderByNameDesc();

    @Modifying
    @Query("UPDATE State s SET s.name = :name WHERE s.id = :id")
    Object updateById(Long id, String name);

}
