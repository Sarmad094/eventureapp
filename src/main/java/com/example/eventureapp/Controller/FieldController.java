package com.example.eventureapp.Controller;

import com.example.eventureapp.Model.Field;
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
    public List<Field> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Field> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Field create(@RequestBody Field field) {
        return service.save(field);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Field> update(@PathVariable Long id, @RequestBody Field updated) {
        return service.findById(id)
                .map(existing -> {
                    existing.setField(updated.getField());
                    existing.setFDescription(updated.getFDescription());
                    return ResponseEntity.ok(service.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (service.findById(id).isPresent()) {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
