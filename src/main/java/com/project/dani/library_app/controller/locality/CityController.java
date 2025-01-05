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
import com.project.dani.library_app.entity.locality.City;
import com.project.dani.library_app.service.locality.CityService;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @PostMapping
    public City createCity(@RequestBody City city) {
        return cityService.save(city);
    }

    @GetMapping("id/{id}")
    public Optional<City> readById(@PathVariable Long id) {
        return cityService.findById(id);
    }
    
    @GetMapping("name/{name}")
    public List<City> readByName(@PathVariable String name) {
        return cityService.findByNameContains(name);
    }
    
    @GetMapping("all")
    public List<City> readAll() {
        return cityService.findAll();
    }

    @GetMapping("all-asc")
    public List<City> readAllOrderByNameAsc() {
        return cityService.findAllOrderByNameAsc();
    }

    @GetMapping("all-desc")
    public List<City> readAllOrderByNameDesc() {
        return cityService.findAllOrderByNameDesc();
    }

    @PutMapping("id/{id}")
    public Optional<City> updateCity(@PathVariable Long id, @RequestBody String name) {
        cityService.updateById(id, name);
        return cityService.findById(id);
    }

    @DeleteMapping("id/{id}")
    public void deleteCityById(@PathVariable Long id) {
        cityService.deleteById(id);
    }

    @DeleteMapping("all")
    public void deleteAllCity() {
        cityService.deleteAll();
    }

}
