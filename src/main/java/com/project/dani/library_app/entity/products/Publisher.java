package com.project.dani.library_app.entity.products;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "PUBLISHERS")
@Schema(description = "Publisher entity")
public class Publisher implements Serializable {

    @Id
    @Column(name = "id_publisher", nullable = false)
    @Schema(hidden = true, description = "Unique identifier of the Publisher",
            example = "1")
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 0, max = 100)
    @Schema(description = "Publishier name", example = "Principis")
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @NotNull
    @Schema(description = "Publishier status", example = "True")
    @Column(name = "active", nullable = false)
    private Boolean active;

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
        Publisher other = (Publisher) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Publisher [id=" + id + "]";
    }



}
