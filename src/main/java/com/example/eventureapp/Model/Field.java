package com.example.eventureapp.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Field {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fieldId;

    @Column(nullable = false)
    private String field;

    @Column(name = "f_description")
    private String fDescription;

    public Field() {
    }

    public Field(String field, String fDescription) {
        this.field = field;
        this.fDescription = fDescription;
    }
}
