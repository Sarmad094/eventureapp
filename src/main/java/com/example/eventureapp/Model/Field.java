package com.example.eventureapp.Model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Field {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "field_id")
    private Long fieldId;

    @Column(name = "field_name", nullable = false)
    private String fieldName;

    @Column(name = "f_description")
    private String fDescription;

    // One-to-Many relationship with Event
    @OneToMany(mappedBy = "fieldEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Event> events;

    // Constructors
    public Field() {
    }

    public Field(String fieldName, String fDescription) {
        this.fieldName = fieldName;
        this.fDescription = fDescription;
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

    public String getFDescription() {
        return fDescription;
    }

    public void setFDescription(String fDescription) {
        this.fDescription = fDescription;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "Field{" +
                "fieldId=" + fieldId +
                ", fieldName='" + fieldName + '\'' +
                ", fDescription='" + fDescription + '\'' +
                '}';
    }
}