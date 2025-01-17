package com.project.dani.library_app.service.locality;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.project.dani.library_app.entity.locality.Address;
import com.project.dani.library_app.repository.locality.AddressRepository;


@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    // create
    @Transactional
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    // read
    // id
    @Transactional(readOnly = true)
    public Optional<Address> findById(Long id) {
        return addressRepository.findById(id);
    }

    // street
    @Transactional(readOnly = true)
    public List<Address> findByStreetContains(String name) {
        return addressRepository.findByStreetContains(name);
    }

    @Transactional(readOnly = true)
    public List<Address> findByStreetEquals(String street) {
        return this.addressRepository.findByStreetIs(street);
    }

    // neighborhood
    @Transactional(readOnly = true)
    public List<Address> findByNeighborhoodEquals(String neighborhood) {
        return this.addressRepository.findByNeighborhoodEquals(neighborhood);
    }

    @Transactional(readOnly = true)
    public List<Address> findByNeighborhoodContains(String neighborhood) {
        return this.addressRepository.findByNeighborhoodContains(neighborhood);
    }

    // zipCode
    @Transactional(readOnly = true)
    public List<Address> findByZipCodeEquals(String zipCode) {
        return this.addressRepository.findByZipCodeIs(zipCode);
    }

    @Transactional(readOnly = true)
    public List<Address> findByZipCodeContains(String zipCode) {
        return this.addressRepository.findByZipCodeContains(zipCode);
    }

    // number
    @Transactional(readOnly = true)
    public List<Address> findByNumberEquals(String number) {
        return this.addressRepository.findByNumberIs(number);
    }

    @Transactional(readOnly = true)
    public List<Address> findByNumberContains(String number) {
        return this.addressRepository.findByNumberContains(number);
    }

    // complement
    @Transactional(readOnly = true)
    public List<Address> findByComplementContains(String complement) {
        return this.addressRepository.findByComplementContains(complement);
    }

    @Transactional(readOnly = true)
    public List<Address> findByComplementEquals(String complement) {
        return this.addressRepository.findByComplementIs(complement);
    }

    // city
    @Transactional(readOnly = true)
    public List<Address> findByCityId(Long id) {
        return this.addressRepository.findByCityId(id);
    }

    @Transactional(readOnly = true)
    public List<Address> findByCityNameContains(String name) {
        return this.addressRepository.findByCityNameContains(name);
    }

    @Transactional(readOnly = true)
    public List<Address> findByCityNameEquals(String name) {
        return this.addressRepository.findByCityNameEquals(name);
    }

    // state
    @Transactional(readOnly = true)
    public List<Address> findByStateId(Long id) {
        return addressRepository.findByStateId(id);
    }

    @Transactional(readOnly = true)
    public List<Address> findByStateNameContains(String name) {
        return addressRepository.findByStateNameContains(name);
    }

    @Transactional(readOnly = true)
    public List<Address> findByStateNameEquals(String name) {
        return addressRepository.findByStateNameEquals(name);
    }

    // country
    @Transactional(readOnly = true)
    public List<Address> findByCountryId(Long id) {
        return addressRepository.findByCountryId(id);
    }

    @Transactional(readOnly = true)
    public List<Address> findByCountryNameContains(String name) {
        return addressRepository.findByCountryNameContains(name);
    }

    @Transactional(readOnly = true)
    public List<Address> findByCountryNameEquals(String name) {
        return addressRepository.findByCountryNameEquals(name);
    }


    // read all
    @Transactional(readOnly = true)
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    // order by street
    @Transactional(readOnly = true)
    public List<Address> findAllOrderByStreetAsc() {
        return addressRepository.findByOrderByStreetAsc();
    }

    @Transactional(readOnly = true)
    public List<Address> findAllOrderByStreetDesc() {
        return addressRepository.findByOrderByStreetDesc();
    }

    // order by number
    @Transactional(readOnly = true)
    public List<Address> findAllByOrderByNumberAsc() {
        return addressRepository.findByOrderByNumberAsc();
    }

    @Transactional(readOnly = true)
    public List<Address> findAllOrderByNumberDesc() {
        return addressRepository.findByOrderByNumberDesc();
    }

    // order by neighborhood
    @Transactional(readOnly = true)
    public List<Address> findAllOrderByNeighborhoodAsc() {
        return addressRepository.findByOrderByNeighborhoodAsc();
    }

    @Transactional(readOnly = true)
    public List<Address> findAllOrderByNeighborhoodDesc() {
        return addressRepository.findByOrderByNeighborhoodDesc();
    }

    // order by zip code
    @Transactional(readOnly = true)
    public List<Address> findAllOrderByZipCodeAsc() {
        return addressRepository.findByOrderByZipCodeAsc();
    }

    @Transactional(readOnly = true)
    public List<Address> findAllOrderByZipCodeDesc() {
        return addressRepository.findByOrderByZipCodeDesc();
    }


    // update
    // street
    @Transactional(readOnly = true)
    public void updateStreetById(Long id, String street) {
        this.addressRepository.updateStreetById(id, street);
    }

    // number
    @Transactional(readOnly = true)
    public void updateNumberById(Long id, String number) {
        this.addressRepository.updateNumberById(id, number);
    }

    // complement
    @Transactional(readOnly = true)
    public void updateComplementById(Long id, String complement) {
        this.addressRepository.updateComplementById(id, complement);
    }

    // neighborhood
    @Transactional(readOnly = true)
    public void updateNeighborhoodById(Long id, String neighborhood) {
        this.addressRepository.updateNeighborhoodById(id, neighborhood);
    }

    // zip code
    @Transactional(readOnly = true)
    public void updateZipCodeById(Long id, String zipCode) {
        this.addressRepository.updateZipCodeById(id, zipCode);
    }



    // delete by id
    @Transactional
    public void deleteById(Long id) {
        this.addressRepository.deleteById(id);
    }

    // delete all
    @Transactional
    public void deleteAll() {
        this.addressRepository.deleteAll();
    }



}
