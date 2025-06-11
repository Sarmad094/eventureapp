// StudentService.java
package com.example.eventureapp.Service;

import com.example.eventureapp.DTO.StudentDTO;
import com.example.eventureapp.Mapper.StudentMapper;
import com.example.eventureapp.Model.Student;
import com.example.eventureapp.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(StudentMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<StudentDTO> getStudentById(Long id) {
        return studentRepository.findById(id).map(StudentMapper::toDTO);
    }

    public Optional<Student> getStudentByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    public StudentDTO createStudent(StudentDTO dto) {
        if (studentRepository.existsByEmail(dto.getEmail())) {
            throw new IllegalArgumentException("Student with this email already exists");
        }
        Student saved = studentRepository.save(StudentMapper.toEntity(dto));
        return StudentMapper.toDTO(saved);
    }

    public StudentDTO updateStudent(Long id, StudentDTO dto) {
        return studentRepository.findById(id).map(existing -> {
            existing.setName(dto.getName());
            existing.setEmail(dto.getEmail());
            existing.setPhonenumber(dto.getPhonenumber());
            existing.setUniversity(dto.getUniversity());
            existing.setField(dto.getS_field());
            existing.setPassword(dto.getPassword());
            return StudentMapper.toDTO(studentRepository.save(existing));
        }).orElseThrow(() -> new IllegalArgumentException("Student not found"));
    }

    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new IllegalArgumentException("Student not found");
        }
        studentRepository.deleteById(id);
    }
}