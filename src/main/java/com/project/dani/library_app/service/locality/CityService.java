package com.project.dani.library_app.service.locality;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.project.dani.library_app.entity.locality.City;
import com.project.dani.library_app.repository.locality.CityRepository;


@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    @Transactional
    public City save(City city) {
        return cityRepository.save(city);
    }

    @Transactional(readOnly = true)
    public Optional<City> findById(Long id) {
        return cityRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<City> findByNameContains(String name) {
        return cityRepository.findByNameContains(name);
    }

    @Transactional(readOnly = true)
    public List<City> findAll() {
        return cityRepository.findAll();
    }

    @Transactional
    public List<City> findAllOrderByNameAsc() {
        return cityRepository.findAllByOrderByNameAsc();
    }

    @Transactional(readOnly = true)
    public List<City> findAllOrderByNameDesc() {
        return cityRepository.findAllByOrderByNameDesc();
    }

    @Transactional
    public void updateById(Long id, String name) {
        cityRepository.updateById(id, name);
    }

    public void deleteById(Long id) {
        cityRepository.deleteById(id);
    }

    public void deleteAll() {
        cityRepository.deleteAll();
    }

}
