package com.project.dani.library_app.repository.locality;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.project.dani.library_app.entity.locality.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

    // read
    // street
    List<Address> findByStreetContains(String name);

    List<Address> findByStreetIs(String street);


    // neighborhood
    List<Address> findByNeighborhoodEquals(String neighborhood);

    List<Address> findByNeighborhoodContains(String neighborhood);


    // zip code
    List<Address> findByZipCodeIs(String zipCode);

    List<Address> findByZipCodeContains(String zipCode);


    // number
    List<Address> findByNumberIs(String number);

    List<Address> findByNumberContains(String number);


    // complement
    List<Address> findByComplementContains(String complement);

    List<Address> findByComplementIs(String complement);


    // city
    List<Address> findByCityId(Long id);

    List<Address> findByCityNameContains(String name);

    List<Address> findByCityNameEquals(String name);


    // state
    List<Address> findByStateId(Long id);

    List<Address> findByStateNameContains(String name);

    List<Address> findByStateNameEquals(String name);


    // country
    List<Address> findByCountryId(Long id);

    List<Address> findByCountryNameContains(String name);

    List<Address> findByCountryNameEquals(String name);


    // read all
    // order by street
    List<Address> findByOrderByStreetAsc();

    List<Address> findByOrderByStreetDesc();

    // order by number
    List<Address> findByOrderByNumberAsc();

    List<Address> findByOrderByNumberDesc();

    // order by neighborhood
    List<Address> findByOrderByNeighborhoodAsc();

    List<Address> findByOrderByNeighborhoodDesc();

    // order by zipCode
    List<Address> findByOrderByZipCodeAsc();

    List<Address> findByOrderByZipCodeDesc();


    // update
    // street
    @Query("UPDATE Address a SET a.street = ?2 WHERE a.id = ?1")
    void updateStreetById(Long id, String street);

    // number
    @Modifying
    @Query("UPDATE Address a SET a.number = ?2 WHERE a.id = ?1")
    void updateNumberById(Long id, String number);

    // complement
    @Modifying
    @Query("UPDATE Address a SET a.complement = ?2 WHERE a.id = ?1")
    void updateComplementById(Long id, String complement);

    // neighborhood
    @Modifying
    @Query("UPDATE Address a SET a.neighborhood = ?2 WHERE a.id = ?1")
    void updateNeighborhoodById(Long id, String neighborhood);

    // zipCode
    @Modifying
    @Query("UPDATE Address a SET a.zipCode = ?2 WHERE a.id = ?1")
    void updateZipCodeById(Long id, String zipCode);



}
