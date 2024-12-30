package com.project.dani.library_app.entity.products;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.dani.library_app.entity.people.Customer;
import com.project.dani.library_app.entity.people.Employee;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name = "LOANS")
public class Loan implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_loan", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_customer")
    private Customer customer;

    @JsonIgnore
    @OneToMany(mappedBy = "loan")
    //@JoinColumn(name = "id_book")
    private List<Book> books;

    @OneToOne
    @JoinColumn(name = "id_employee")
    private Employee employee;

    @Column(name = "loanDate", nullable = false)
    private LocalDate loanDate;

    @Column(name = "returnDate", nullable = false)
    private LocalDate returnDate;

}
