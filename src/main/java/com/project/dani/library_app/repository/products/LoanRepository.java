package com.project.dani.library_app.repository.products;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.dani.library_app.entity.products.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {

}