package com.example.eventureapp.Mapper;

import com.example.eventureapp.Model.Field;
import com.example.eventureapp.DTO.FieldDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FieldMapper {

    /**
     * Convert Field entity to FieldDTO
     */
    public FieldDTO toDTO(Field field) {
        if (field == null) {
            return null;
        }

        FieldDTO dto = new FieldDTO();
        dto.setFieldId(field.getFieldId());
        dto.setFieldName(field.getFieldName());
        dto.setDescription(field.getFDescription());

        return dto;
    }

    /**
     * Convert FieldDTO to Field entity
     */
    public Field toEntity(FieldDTO dto) {
        if (dto == null) {
            return null;
        }

        Field field = new Field();
        field.setFieldId(dto.getFieldId());
        field.setFieldName(dto.getFieldName());
        field.setFDescription(dto.getDescription());

        return field;
    }

    /**
     * Convert list of Field entities to list of FieldDTOs
     */
    public List<FieldDTO> toDTOList(List<Field> fields) {
        if (fields == null) {
            return null;
        }

        return fields.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Convert list of FieldDTOs to list of Field entities
     */
    public List<Field> toEntityList(List<FieldDTO> dtos) {
        if (dtos == null) {
            return null;
        }

        return dtos.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}