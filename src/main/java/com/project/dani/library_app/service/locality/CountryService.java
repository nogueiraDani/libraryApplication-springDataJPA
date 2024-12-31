package com.project.dani.library_app.service.locality;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.project.dani.library_app.entity.locality.Country;
import com.project.dani.library_app.repository.locality.CountryRepository;

@Service

public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    public void save(Country country) {
        this.countryRepository.save(country);
    }

    @Transactional(readOnly = true)
    public Optional<Country> findById(Long id) {
        return this.countryRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Country> findAll() {
        return this.countryRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Country> findAllOrderByNameAsc() {
        return this.countryRepository.findAllOrderByNameAsc();
    }

    @Transactional(readOnly = true)
    public List<Country> findAllOrderByNameDesc() {
        return this.countryRepository.findAllOrderByNameDesc();
    }

    @Transactional
    public void updateById(Long id, String name) {
        this.countryRepository.updateById(id, name);
    }

    @Transactional
    public void deleteById(Long id) {
        this.countryRepository.deleteById(id);
    }

    @Transactional
    public void deleteAll() {
        this.countryRepository.deleteAll();
    }



}
