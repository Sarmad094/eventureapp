package com.example.eventureapp.Controller;

import com.example.eventureapp.Model.Organization;
import com.example.eventureapp.DTO.OrganizationDTO;
import com.example.eventureapp.Service.OrganizationService;
import com.example.eventureapp.Mapper.OrganizationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organizations")
@CrossOrigin(origins = "*")
public class OrganizationController {

    private final OrganizationService organizationService;
    private final OrganizationMapper organizationMapper;

    @Autowired
    public OrganizationController(OrganizationService organizationService, OrganizationMapper organizationMapper) {
        this.organizationService = organizationService;
        this.organizationMapper = organizationMapper;
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

    // ✅ FIKSET: Registrer organisasjon med manuell ID
    @PostMapping("/register")
    public ResponseEntity<OrganizationDTO> registerOrganization(@RequestBody OrganizationDTO dto) {
        try {
            // Sjekk at alle påkrevde felter er fylt ut
            if (dto.getOrgId() == null || dto.getOrgName() == null || dto.getEmail() == null || dto.getPassword() == null) {
                return ResponseEntity.badRequest().body(null);
            }

            Organization org = organizationMapper.toEntity(dto);
            OrganizationDTO created = organizationService.createOrganizationDTO(org);
            return ResponseEntity.ok(created);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // ✅ NYTT: Login endpoint
    @PostMapping("/login")
    public ResponseEntity<OrganizationDTO> loginOrganization(@RequestBody OrganizationDTO loginDto) {
        try {
            // Kun email og password trengs for login
            if (loginDto.getEmail() == null || loginDto.getPassword() == null) {
                return ResponseEntity.badRequest().body(null);
            }

            OrganizationDTO authenticatedOrg = organizationService.authenticateOrganization(
                    loginDto.getEmail(),
                    loginDto.getPassword()
            );

            if (authenticatedOrg != null) {
                return ResponseEntity.ok(authenticatedOrg);
            } else {
                return ResponseEntity.status(401).body(null); // Unauthorized
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrganizationDTO> updateOrganization(@PathVariable Long id, @RequestBody OrganizationDTO dto) {
        try {
            Organization org = organizationMapper.toEntity(dto);
            return ResponseEntity.ok(organizationService.updateOrganizationDTO(id, org));
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