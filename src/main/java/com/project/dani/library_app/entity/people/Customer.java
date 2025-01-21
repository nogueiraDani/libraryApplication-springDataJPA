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

@Getter
@Setter
@Entity
@Table(name = "CUSTOMERS")
public class Customer extends Person {

    @Id
    @Column(name = "id_customer", nullable = false)
    @Schema(hidden = true, description = "Unique identifier of the Customer",
            example = "1")
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 0, max = 10)
    @Schema(description = "Registration date", example = "01/01/2024")
    @Column(name = "registrationDate", nullable = false, length = 10)
    private LocalDate registrationDate;

    @NotNull
    @Schema(description = "Address id", example = "1")
    @OneToMany
    private List<Address> address;

    @NotNull
    @Schema(description = "Loan id", example = "1")
    @OneToMany(mappedBy = "customer")
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
        Customer other = (Customer) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Customer [id=" + id + "]";
    }



}
