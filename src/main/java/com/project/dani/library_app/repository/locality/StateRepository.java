package com.project.dani.library_app.repository.locality;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.dani.library_app.entity.locality.State;

public interface StateRepository extends JpaRepository<State, Long> {

}
