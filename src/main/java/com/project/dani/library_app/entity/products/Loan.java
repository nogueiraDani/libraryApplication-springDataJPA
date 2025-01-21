package com.project.dani.library_app.entity.products;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.dani.library_app.entity.people.Customer;
import com.project.dani.library_app.entity.people.Employee;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name = "LOANS")
@Schema(description = "Loan entity")
public class Loan implements Serializable{

    @Id
    @Column(name = "id_loan", nullable = false)
    @Schema(hidden = true, description = "Unique identifier of the Loan",
            example = "1")
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @JsonIgnore
    @Schema(description = "Book id", example = "1")
    @OneToMany(mappedBy = "loan")
    private List<Book> books;

    @NotNull
    @ManyToOne
    @Schema(description = "Customer id", example = "1")
    @JoinColumn(name = "id_customer") 
    private Customer customer;

    @NotNull
    @ManyToOne
    @Schema(description = "Employee id", example = "1")
    @JoinColumn(name = "id_employee")
    private Employee employee;

    @NotNull
    @Size(min = 0, max = 10)
    @Schema(description = "Loan Date", example = "05/05/2010")
    @Column(name = "loanDate", nullable = false, length = 10)
    private LocalDate loanDate;

    @NotNull
    @Size(min = 0, max = 10)
    @Schema(description = "Return Date", example = "05/15/2010")
    @Column(name = "returnDate", nullable = false, length = 10)
    private LocalDate returnDate;

}
