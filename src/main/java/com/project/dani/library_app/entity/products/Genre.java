package com.project.dani.library_app.entity.products;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "GENRES")
@Schema(description = "Genre entity")
public class Genre implements Serializable {
    
    @Id
    @Column(name = "id_genre", nullable = false)
    @Schema(hidden = true, description = "Unique identifier of the Genre",
            example = "1")
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 0, max = 100)
    @Schema(description = "Genre name", example = "Ficção")
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Size(min = 0, max = 255)
    @Schema(description = "Genre name", example = "Ficção literária")
    @Column(name = "description", length = 255)
    private String description;

    @ManyToOne
    @Schema(description = "Book id", example = "1")
    @JoinColumn(name = "id_book", nullable = false)
    private Book book;

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
        Genre other = (Genre) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Genre [id=" + id + "]";
    }

    
}
