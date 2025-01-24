package com.project.dani.library_app.service.locality;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.project.dani.library_app.entity.locality.Country;
import com.project.dani.library_app.repository.locality.CountryRepository;
import com.project.dani.library_app.service.ValidationService;

@Service
public class CountryService {

    // melhorei o codigo eliminando o @Autowired
    private final CountryRepository countryRepository;
    private final ValidationService validationService;

    public CountryService(CountryRepository countryRepository,
            ValidationService validationService) {
        this.countryRepository = countryRepository;
        this.validationService = validationService;
    }


    // --------
    // CREATE
    // --------
    @Transactional
    public void save(Country country) {
        this.validationService.validateUniqueField(countryRepository,
                countryRepository.findByName(country.getName()),
                "-- O país " + country.getName() + " já está cadastrado");

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
        return this.validationService.validateListNotEmpty(result,
                "-- Não foi encontrado nenhum pais com " + name + ". --");
    }

    @Transactional(readOnly = true)
    public List<Country> findAll() {
        List<Country> result = this.countryRepository.findAll();
        return this.validationService.validateListNotEmpty(result,
                "-- Não há nenhum país cadastrado. --");
    }

    @Transactional(readOnly = true)
    public List<Country> findAllOrderByNameAsc() {
        List<Country> result = this.countryRepository.findAllOrderByNameAsc();
        return this.validationService.validateListNotEmpty(result,
                "-- Não há nenhum país cadastrado. --");
    }

    @Transactional(readOnly = true)
    public List<Country> findAllOrderByNameDesc() {
        List<Country> result = this.countryRepository.findAllOrderByNameDesc();
        return this.validationService.validateListNotEmpty(result,
                "-- Não há nenhum país cadastrado. --");
    }

    // --------
    // UPDATE
    // --------
    @Transactional
    public void updateCountryNameById(Long id, String name) {
        this.validationService.validateUniqueField(countryRepository,
                countryRepository.findById(id),
                "-- O país " + name + " já está cadastrado. --");

        Country country = this.validationService.validateEntityFindById(countryRepository,
                id, "-- País com o ID fornecido não foi encontrado. --");
        
        country.setName(name);

        this.countryRepository.save(country);
    }

    // --------
    // DELETE
    // --------
    @Transactional
    public void deleteById(Long id) {
        this.validationService.validateEntityExistsById(countryRepository, id,
                "-- País com o ID fornecido não foi encontrado. --");

        this.countryRepository.deleteById(id);
    }



}
