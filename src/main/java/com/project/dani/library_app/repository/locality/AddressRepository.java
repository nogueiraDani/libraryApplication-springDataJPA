package com.project.dani.library_app.repository.locality;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.dani.library_app.entity.locality.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
