package com.project.dani.library_app.entity.people;

import java.util.List;
import com.project.dani.library_app.entity.locality.Address;
import com.project.dani.library_app.entity.products.Book;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "WRITERS")
public class Writer extends Person {

    @Id
    @Column(name = "id_writer", nullable = false)
    @Schema(hidden = true, description = "Unique identifier of the Writer", example = "1")
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Schema(description = "Book id", example = "1")
    @ManyToMany
    @JoinTable(name = "writer_books", joinColumns = @JoinColumn(name = "writer_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Book> books;

    @NotNull
    @OneToMany
    @Schema(description = "Book id", example = "1")
    @JoinColumn(name = "id_address", nullable = false)
    private List<Address> address;

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
        Writer other = (Writer) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Writer [id=" + id + "]";
    }



}
