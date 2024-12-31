package com.project.dani.library_app.controller.locality;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.dani.library_app.entity.locality.Country;
import com.project.dani.library_app.service.locality.CountryService;



@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @PostMapping
    public Country createCountry(@RequestBody Country country) {
        countryService.save(country);
        return country;
    }

    @GetMapping("id/{id}")
    public Optional<Country> readById(@PathVariable Long id) {
        return countryService.findById(id);
    }

    @GetMapping("all")
    public List<Country> readAll() {
        return countryService.findAll();
    }

    @GetMapping("all-asc")
    public List<Country> readAllOrderByNameAsc() {
        return countryService.findAllOrderByNameAsc();
    }

    @GetMapping("all-desc")
    public List<Country> readAllOrderByNameDesc() {
        return countryService.findAllOrderByNameDesc();
    }

    @PutMapping("id/{id}")
    public Optional<Country> updateCountry(@PathVariable Long id, @RequestBody String name) {
        countryService.updateById(id, name);
        return countryService.findById(id);
    }

    @DeleteMapping("id/{id}")
    public void deleteCountryById(@PathVariable Long id) {
        countryService.deleteById(id);
    }

    @DeleteMapping("all")
    public void deleteAllCountry() {
        countryService.deleteAll();
    }



}
