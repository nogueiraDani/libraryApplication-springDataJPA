package com.project.dani.library_app.entity.people;

import java.time.LocalDate;
import java.util.List;
import com.project.dani.library_app.entity.locality.Address;
import com.project.dani.library_app.entity.products.Loan;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "EMPLOYEES")
public class Employee extends Person {

    @Id
    @Column(name = "id_employee", nullable = false)
    @Schema(hidden = true, description = "Unique identifier of the Employee",
            example = "1")
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 0, max = 50)
    @Schema(description = "Employee salary", example = "500,00")
    @Column(name = "salary", nullable = false, length = 50)
    private String salary;

    @NotNull
    @Size(min = 0, max = 10)
    @Schema(description = "Admission date", example = "05/05/2020")
    @Column(name = "admission_date", nullable = false, length = 10)
    private LocalDate admissionDate;

    @NotNull
    @Size(min = 0, max = 50)
    @Schema(description = "Role", example = "Atendente")
    @Column(name = "role", nullable = false, length = 50)
    private String role;

    @NotNull
    @OneToMany
    @Schema(description = "Address id", example = "1")
    private List<Address> address;

    @NotNull
    @Schema(description = "Loan id", example = "1")
    @OneToMany(mappedBy = "employee")
    private List<Loan> loans;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + "]";
    }

}
