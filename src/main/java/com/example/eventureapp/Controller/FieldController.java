package com.example.eventureapp.Controller;

import com.example.eventureapp.DTO.FieldDTO;
import com.example.eventureapp.Service.FieldService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fields")
public class FieldController {

    private final FieldService service;

    public FieldController(FieldService service) {
        this.service = service;
    }

    @GetMapping
    public List<FieldDTO> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FieldDTO> getById(@PathVariable Long id) {
        FieldDTO fieldDTO = service.findById(id);
        if (fieldDTO != null) {
            return ResponseEntity.ok(fieldDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public FieldDTO create(@RequestBody FieldDTO fieldDTO) {
        return service.save(fieldDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FieldDTO> update(@PathVariable Long id, @RequestBody FieldDTO fieldDTO) {
        fieldDTO.setFieldId(id); // Ensure the ID is set
        FieldDTO updatedField = service.update(id, fieldDTO);
        if (updatedField != null) {
            return ResponseEntity.ok(updatedField);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = service.deleteById(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}