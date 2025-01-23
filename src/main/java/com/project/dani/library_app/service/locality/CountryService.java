package com.project.dani.library_app.service.locality;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.project.dani.library_app.entity.locality.Country;
import com.project.dani.library_app.exception.ResourceNotFoundException;
import com.project.dani.library_app.repository.locality.CountryRepository;

@Service
public class CountryService {

    // melhorei o codigo eliminando o @Autowired
    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }


    // --------
    // CREATE
    // --------
    @Transactional
    public void save(Country country) {
        if (this.countryRepository.findByName(country.getName()).isPresent()) {
            throw new IllegalArgumentException(
                    "-- O país " + country.getName() + " já está cadastrado.--");
        }

        this.countryRepository.save(country);

    }


    // --------
    // READ
    // --------
    @Transactional(readOnly = true)
    public Country findById(Long id) {
        return this.countryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "-- País com o ID fornecido não foi encontrado. --"));
    }

    @Transactional(readOnly = true)
    public List<Country> findByNameContains(String name) {
        List<Country> result = this.countryRepository.findByNameContains(name);
        return validateListNotEmpty(result,
                "-- Não foi encontrado nenhum pais com" + name + ". --");
    }

    @Transactional(readOnly = true)
    public List<Country> findAll() {
        List<Country> result = this.countryRepository.findAll();
        return validateListNotEmpty(result, "-- Não há nenhum país cadastrado. --");
    }

    @Transactional(readOnly = true)
    public List<Country> findAllOrderByNameAsc() {
        List<Country> result = this.countryRepository.findAllOrderByNameAsc();
        return validateListNotEmpty(result, "-- Não há nenhum país cadastrado. --");
    }

    @Transactional(readOnly = true)
    public List<Country> findAllOrderByNameDesc() {
        List<Country> result = this.countryRepository.findAllOrderByNameDesc();
        return validateListNotEmpty(result, "-- Não há nenhum país cadastrado. --");
    }

    // --------
    // UPDATE
    // --------
    @Transactional
    public void updateCountryNameById(Long id, String name) {
        if (this.countryRepository.findByName(name).isPresent()) {
            throw new IllegalArgumentException(
                    "-- O país " + name + " já está cadastrado. --");
        }

        Country country = this.countryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "-- País com o ID fornecido não foi encontrado. --"));
        country.setName(name);

        this.countryRepository.save(country);
    }

    // --------
    // DELETE
    // --------
    @Transactional
    public void deleteById(Long id) {
        if (!this.countryRepository.existsById(id)) {
            throw new ResourceNotFoundException(
                    "-- Country com o ID fornecido não foi encontrado. --");
        }

        this.countryRepository.deleteById(id);
    }



    private <T> List<T> validateListNotEmpty(List<T> list, String errorMessage) {
        if (list.isEmpty()) {
            throw new ResourceNotFoundException(errorMessage);
        }

        return list;
    }


}
