package com.project.dani.library_app.service;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import com.project.dani.library_app.exception.ResourceNotFoundException;

@Component
public class ValidationService {

    public <T> List<T> validateListNotEmpty(List<T> list, String errorMessage) {
        if (list == null || list.isEmpty()) {
            throw new ResourceNotFoundException(errorMessage);
        }
        return list;
    }

    public <T> void validateUniqueField(JpaRepository<T, ?> repository,
            Optional<T> existingEntity, String errorMessage) {
        if (existingEntity.isPresent()) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public <T, ID> void validateEntityExistsById(JpaRepository<T, ID> repository, ID id,
            String errorMessage) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException(errorMessage);
        }
    }

    public <T, ID> T validateEntityFindById(JpaRepository<T, ID> repository, ID id,
            String errorMessage) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(errorMessage));
    }
}
