package com.example.eventureapp.Service;

import com.example.eventureapp.Model.Field;
import com.example.eventureapp.Repository.FieldRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FieldService {

    private final FieldRepository repository;

    public FieldService(FieldRepository repository) {
        this.repository = repository;
    }

    public List<Field> findAll() {
        return repository.findAll();
    }

    public Optional<Field> findById(Long id) {
        return repository.findById(id);
    }

    public Field save(Field field) {
        return repository.save(field);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
