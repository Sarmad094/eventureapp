package com.example.eventureapp.Service;

import com.example.eventureapp.DTO.FieldDTO;
import com.example.eventureapp.Mapper.FieldMapper;
import com.example.eventureapp.Model.Field;
import com.example.eventureapp.Repository.FieldRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FieldService {

    private final FieldRepository repository;
    private final FieldMapper mapper;

    public FieldService(FieldRepository repository, FieldMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<FieldDTO> findAll() {
        List<Field> fields = repository.findAll();
        return mapper.toDTOList(fields);
    }

    public FieldDTO findById(Long id) {
        Optional<Field> field = repository.findById(id);
        return field.map(mapper::toDTO).orElse(null);
    }

    public FieldDTO save(FieldDTO fieldDTO) {
        Field field = mapper.toEntity(fieldDTO);
        Field savedField = repository.save(field);
        return mapper.toDTO(savedField);
    }

    public FieldDTO update(Long id, FieldDTO fieldDTO) {
        Optional<Field> existingField = repository.findById(id);
        if (existingField.isPresent()) {
            Field field = existingField.get();
            field.setFieldName(fieldDTO.getFieldName());
            field.setFDescription(fieldDTO.getDescription());
            Field updatedField = repository.save(field);
            return mapper.toDTO(updatedField);
        }
        return null;
    }

    public boolean deleteById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}