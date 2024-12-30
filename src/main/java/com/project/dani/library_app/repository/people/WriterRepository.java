package com.project.dani.library_app.repository.people;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.dani.library_app.entity.people.Writer;

public interface WriterRepository extends JpaRepository<Writer, Long> {

}
