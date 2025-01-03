package com.project.dani.library_app.service.locality;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.project.dani.library_app.entity.locality.State;
import com.project.dani.library_app.repository.locality.StateRepository;

@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;

    @Transactional
    public State save(State state) {
        return this.stateRepository.save(state);
    }

    @Transactional(readOnly = true)
    public Optional<State> findById(Long id) {
        return this.stateRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<State> findByNameContains(String name) {
        return this.stateRepository.findByNameContains(name);
    }

    @Transactional(readOnly = true)
    public List<State> findAll() {
        return this.stateRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<State> findAllOrderByNameAsc() {
        return this.stateRepository.findAllOrderByNameAsc();
    }

    @Transactional(readOnly = true)
    public List<State> findAllOrderByNameDesc() {
        return this.stateRepository.findAllOrderByNameDesc();
    }

    @Transactional
    public void updateById(Long id, String name) {
        this.stateRepository.updateById(id, name);
    }

    @Transactional
    public void deleteById(Long id) {
        this.stateRepository.deleteById(id);
    }

    @Transactional
    public void deleteAll() {
        this.stateRepository.deleteAll();
    }

}