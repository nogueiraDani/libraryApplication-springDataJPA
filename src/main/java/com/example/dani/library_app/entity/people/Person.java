package com.example.dani.library_app.entity.people;

import java.io.Serializable;
import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class Person implements Serializable {

       
    @Column(name = "name",nullable = false, length = 50)
    private String name;

    @Column(name = "lastName", nullable = false, length = 50)
    private String lastName;

    @Column(name = "cpf",unique = true, nullable = false, length = 11)
    private String cpf;

    @Column(name = "dateBirth", nullable = false, length = 10) 
    private LocalDate dateBirth;

    @Column(name = "phone", nullable = false, length = 11)
    private String phone;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "active", nullable = false)
    private Boolean active;


    

}
