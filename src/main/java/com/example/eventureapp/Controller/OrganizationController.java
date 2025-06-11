package com.example.eventureapp.Controller;

import com.example.eventureapp.Model.Organization;
import com.example.eventureapp.DTO.OrganizationDTO;
import com.example.eventureapp.Service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organizations")
@CrossOrigin(origins = "*")
public class OrganizationController {

    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping
    public List<OrganizationDTO> getAllOrganizations() {
        return organizationService.getAllOrganizationsDTO();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrganizationDTO> getOrganizationById(@PathVariable Long id) {
        return organizationService.getOrganizationByIdDTO(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ✅ OPPDATERT: Tar imot DTO og konverterer til Organization
    @PostMapping("/register")
    public ResponseEntity<OrganizationDTO> registerOrganization(@RequestBody OrganizationDTO dto) {
        try {
            Organization org = new Organization();
            org.setOrgId(dto.getOrgId());
            org.setOrgName(dto.getOrgName());
            org.setEmail(dto.getEmail());
            org.setOField(dto.getOField());
            // Passord bør håndteres her om det legges til

            OrganizationDTO created = organizationService.createOrganizationDTO(org);
            return ResponseEntity.ok(created);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrganizationDTO> updateOrganization(@PathVariable Long id, @RequestBody Organization organization) {
        try {
            return ResponseEntity.ok(organizationService.updateOrganizationDTO(id, organization));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrganization(@PathVariable Long id) {
        try {
            organizationService.deleteOrganization(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
