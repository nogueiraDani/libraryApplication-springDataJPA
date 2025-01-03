package com.project.dani.library_app.controller.locality;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.dani.library_app.entity.locality.Country;
import com.project.dani.library_app.entity.locality.State;
import com.project.dani.library_app.service.locality.StateService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/state")
public class StateController {

    @Autowired
    private StateService stateService;

    @PostMapping
    public State createState(@RequestBody State state) {
        return stateService.save(state);   
    }

    @GetMapping("id/{id}")
    public Optional<State> readById(@PathVariable Long id) {
        return stateService.findById(id);
    }

    @GetMapping("name/{name}")
    public List<State> readByName(@PathVariable String name) {
        return stateService.findByNameContains(name);
    }
    
    @GetMapping("all")
    public List<State> readAll() {
        return stateService.findAll();
    }

    @GetMapping("all-asc")
    public List<State> readAllOrderByNameAsc() {
        return stateService.findAllOrderByNameAsc();
    }

    @GetMapping("all-desc")
    public List<State> readAllOrderByNameDesc() {
        return stateService.findAllOrderByNameDesc();
    }

    @PutMapping("id/{id}")
    public Optional<State> updateCountry(@PathVariable Long id, @RequestBody String name) {
        stateService.updateById(id, name);
        return stateService.findById(id);
    }

    @DeleteMapping("id/{id}")
    public void deleteStateById(@PathVariable Long id) {
        stateService.deleteById(id);
    }

    @DeleteMapping("all")
    public void deleteAllState() {
        stateService.deleteAll();
    }

}
