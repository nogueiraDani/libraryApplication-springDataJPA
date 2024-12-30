package com.project.dani.library_app.repository.products;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.dani.library_app.entity.products.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {

}
