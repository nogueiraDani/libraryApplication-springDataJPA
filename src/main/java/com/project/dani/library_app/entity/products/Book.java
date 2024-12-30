package com.project.dani.library_app.entity.products;

import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.dani.library_app.entity.people.Writer;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "BOOKS")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_book", nullable = false)
    private Long id;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "ISBN", nullable = false, length = 20)
    private String isbn;

    @Column(name = "yearprivateation", nullable = false, length = 4)
    private Integer yearprivateation;

    @JsonIgnore
    @OneToMany(mappedBy = "book")
    // @JoinColumn(name = "id_writer")
    private List<Writer> writers;

    @JsonIgnore
    @OneToMany(mappedBy = "book")
    // @JoinColumn(name = "id_genre")
    private List<Genre> genres;

    @ManyToOne
    @JoinColumn(name = "id_loan")
    private Loan loan;

    @OneToOne
    @JoinColumn(name = "id_publisher")
    private Publisher publisher;

    @Column(name = "language", nullable = false, length = 20)
    private String language;

    @Column(name = "pages", nullable = false, length = 4)
    private Integer pages;

    @Column(name = "active", nullable = false)
    private Boolean active;

    @OneToOne
    @JoinColumn(name = "id_stock", referencedColumnName = "id_stock")
    private Stock stock;

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
