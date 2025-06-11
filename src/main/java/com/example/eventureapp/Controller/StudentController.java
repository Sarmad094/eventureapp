package com.example.eventureapp.Controller;

import com.example.eventureapp.DTO.StudentDTO;
import com.example.eventureapp.Service.StudentService;
import com.example.eventureapp.Mapper.StudentMapper;
import com.example.eventureapp.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentDTO> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO dto) {
        try {
            return ResponseEntity.ok(studentService.createStudent(dto));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginStudent(@RequestBody StudentDTO loginData) {
        try {
            Optional<Student> student = studentService.getStudentByEmail(loginData.getEmail());
            if (student.isPresent() && student.get().getPassword().equals(loginData.getPassword())) {
                return ResponseEntity.ok(StudentMapper.toDTO(student.get()));
            } else {
                return ResponseEntity.status(401).body(new ErrorResponse("Invalid email or password"));
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ErrorResponse("Login failed"));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable Long id, @RequestBody StudentDTO dto) {
        try {
            return ResponseEntity.ok(studentService.updateStudent(id, dto));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        try {
            studentService.deleteStudent(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Inner classes for request/response
    public static class ErrorResponse {
        private String message;

        public ErrorResponse(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}