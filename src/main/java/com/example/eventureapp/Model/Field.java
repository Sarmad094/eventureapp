package com.example.eventureapp.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Getter
@Setter
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
    @OneToMany(mappedBy = "field", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Event> events;

    public Field() {
    }

    public Field(String fieldName, String fDescription) {
        this.fieldName = fieldName;
        this.fDescription = fDescription;
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