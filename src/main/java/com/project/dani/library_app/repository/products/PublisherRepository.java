package com.project.dani.library_app.repository.products;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.dani.library_app.entity.products.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {

}
