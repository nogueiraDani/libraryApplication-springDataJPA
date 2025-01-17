package com.project.dani.library_app.entity.products;

import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.dani.library_app.entity.people.Writer;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "BOOKS")
@Schema(description = "Book entity")
public class Book implements Serializable {

    @Id
    @Column(name = "id_book", nullable = false)
    @Schema(hidden = true, description = "Unique identifier of the Book", example = "1")
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 0, max = 100)
    @Schema(description = "Book title", example = "Dom casmurro")
    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @NotNull
    @Size(min = 0, max = 13)
    @Schema(description = "Book ISBN-13", example = "978-8594318602")
    @Column(name = "ISBN-13", nullable = false, length = 13)
    private String isbn;

    @NotNull
    @Size(min = 0, max = 4)
    @Schema(description = "Year of publication of the book", example = "2019")
    @Column(name = "yearPublication", nullable = false, length = 4)
    private Integer yearPublication;

    @NotNull
    @Schema(description = "Writers", example = "1")
    @JsonIgnore
    @ManyToMany(mappedBy = "books")
    private List<Writer> writers;

    @NotNull
    @Schema(description = "Book genre", example = "1")
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "id_genre", nullable = false)
    private Genre genre;

    @ManyToOne
    @Schema(description = "Book loan", example = "1")
    @JoinColumn(name = "id_loan")
    private Loan loan;

    @NotNull
    @Schema(description = "Book publishier", example = "1")
    @OneToOne
    @JoinColumn(name = "id_publisher", nullable = false)
    private Publisher publisher;

    @NotNull
    @Size(min = 0, max = 20)
    @Schema(description = "Book language", example = "Português")
    @Column(name = "language", nullable = false, length = 20)
    private String language;

    @NotNull
    @Size(min = 0, max = 4)
    @Schema(description = "Number of pages in the book", example = "208")
    @Column(name = "pages", nullable = false, length = 4)
    private Integer pages;

    @NotNull
    @Schema(description = "Book status", example = "true")
    @Column(name = "active", nullable = false)
    private Boolean active;

    @NotNull
    @Size(min = 0, max = 9)
    @Schema(description = "Book stock", example = "1")
    @Column(name = "stock", nullable = false, length = 9)
    private Integer stock;

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
        Book other = (Book) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + "]";
    }


}
