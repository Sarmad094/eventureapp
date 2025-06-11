package com.example.eventureapp.Mapper;

import com.example.eventureapp.DTO.StudentDTO;
import com.example.eventureapp.Model.Student;

public class StudentMapper {

    public static StudentDTO toDTO(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setStudentId(student.getStudentId());
        dto.setName(student.getName());
        dto.setEmail(student.getEmail());
        dto.setPhonenumber(student.getPhonenumber());
        dto.setUniversity(student.getUniversity());
        dto.setS_field(student.getField());
        dto.setPassword(student.getPassword());
        return dto;
    }

    public static Student toEntity(StudentDTO dto) {
        Student student = new Student();
        student.setStudentId(dto.getStudentId());
        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setPhonenumber(dto.getPhonenumber());
        student.setUniversity(dto.getUniversity());
        student.setField(dto.getS_field());
        student.setPassword(dto.getPassword());
        return student;
    }
}