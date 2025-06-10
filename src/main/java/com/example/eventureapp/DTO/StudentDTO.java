package com.example.eventureapp.DTO;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class StudentDTO {
    private Long studentId;
    private String name;
    private String email;
    private String phonenumber;
    private String university;
    private String s_field;
    private String password;
}

