package com.project.dani.library_app.service.locality;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.project.dani.library_app.entity.locality.State;
import com.project.dani.library_app.repository.locality.StateRepository;
import com.project.dani.library_app.service.ValidationService;

@Service
public class StateService {

    private final StateRepository stateRepository;
    private final ValidationService validationService;


    public StateService(StateRepository stateRepository,
            ValidationService validationService) {
        this.stateRepository = stateRepository;
        this.validationService = validationService;
    }

    // --------
    // CREATE
    // --------
    @Transactional
    public void save(State state) {
        this.validationService.validateUniqueField(stateRepository,
                stateRepository.findByName(state.getName()),
                "-- O estado " + state.getName() + " já está cadastrado. --");

        this.stateRepository.save(state);
    }

    // --------
    // READ
    // --------
    @Transactional(readOnly = true)
    public State findById(Long id) {
        return this.stateRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "-- Estado com ID fornecido não foi encontrado.--"));
    }

    @Transactional(readOnly = true)
    public List<State> findByNameContains(String name) {
        List<State> result = this.stateRepository.findByNameContains(name);
        return this.validationService.validateListNotEmpty(result,
                "-- Não foi encontrado nenhum estado com " + name + ". --");
    }

    @Transactional(readOnly = true)
    public List<State> findAll() {
        List<State> result = this.stateRepository.findAll();
        return this.validationService.validateListNotEmpty(result,
                "-- Não há nenhum estado cadastrado. --");
    }

    @Transactional(readOnly = true)
    public List<State> findAllOrderByNameAsc() {
        List<State> result = this.stateRepository.findAllOrderByNameAsc();
        return this.validationService.validateListNotEmpty(result,
                "-- Não há nenhum estado cadastrado. --");
    }

    @Transactional(readOnly = true)
    public List<State> findAllOrderByNameDesc() {
        List<State> result = this.stateRepository.findAllOrderByNameDesc();
        return this.validationService.validateListNotEmpty(result,
                "-- Não há nenhum estado cadastrado. --");
    }

    // --------
    // UPDATE
    // --------
    @Transactional
    public void updateById(Long id, String name) {
        this.validationService.validateUniqueField(stateRepository,
                stateRepository.findById(id),
                "-- País com o ID fornecido não foi encontrado. --");

        State state = this.validationService.validateEntityFindById(stateRepository, id,
                "-- Estado com o ID fornecido não foi encontrado. --");

        state.setName(name);

        this.stateRepository.save(state);
    }

    // --------
    // DELETE
    // --------
    @Transactional
    public void deleteById(Long id) {
        this.validationService.validateEntityExistsById(stateRepository, id,
                "-- Estado com o ID fornecido não foi encontrado. --");

        this.stateRepository.deleteById(id);
    }

}
