package com.project.dani.library_app.entity.locality;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ADDRESSES")
@Schema(description = "Address entity")
public class Address implements Serializable {

    @Id
    @Column(name = "id_address", nullable = false, insertable = false, updatable = false)
    @Schema(hidden = true, description = "Unique identifier of the Address",
            example = "1")
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 0, max = 50)
    @Schema(description = "Address street", example = "Rua das flores")
    @Column(name = "street", length = 50, nullable = false)
    private String street;

    @NotNull
    @Size(min = 0, max = 10)
    @Schema(description = "Address number", example = "150")
    @Column(name = "number", length = 10, nullable = false)
    private String number;

    @Size(min = 0, max = 100)
    @Schema(description = "Address complement", example = "Próximo ao hospital")
    @Column(name = "complement", length = 100, nullable = false)
    private String complement;

    @NotNull
    @Size(min = 0, max = 50)
    @Schema(description = "Address neighborhood", example = "Centro")
    @Column(name = "neighborhood", length = 50, nullable = false)
    private String neighborhood;

    @NotNull
    @Size(min = 0, max = 9)
    @Schema(description = "Address zip code", example = "11111-111")
    @Column(name = "zipCode", length = 9, nullable = false)
    private String zipCode;

    @NotNull
    @OneToOne
    @Schema(description = "City id", example = "1")
    @JoinColumn(name = "id_city", nullable = false)
    private City city;

    @NotNull
    @OneToOne
    @Schema(description = "State id", example = "1")
    @JoinColumn(name = "id_state", nullable = false)
    private State state;

    @NotNull
    @OneToOne
    @Schema(description = "Country id", example = "1")
    @JoinColumn(name = "id_country", nullable = false)
    private Country country;



}
