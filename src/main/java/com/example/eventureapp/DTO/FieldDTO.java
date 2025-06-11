package com.example.eventureapp.DTO;
import lombok.Data;
public class FieldDTO {
    private Long fieldId;
    private String fieldName;
    private String description;

    // Constructors
    public FieldDTO() {
    }

    public FieldDTO(Long fieldId, String fieldName, String description) {
        this.fieldId = fieldId;
        this.fieldName = fieldName;
        this.description = description;
    }

    // Getters and Setters
    public Long getFieldId() {
        return fieldId;
    }

    public void setFieldId(Long fieldId) {
        this.fieldId = fieldId;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
