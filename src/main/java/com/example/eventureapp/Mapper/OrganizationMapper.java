
package com.example.eventureapp.Mapper;

import com.example.eventureapp.Model.Organization;
import com.example.eventureapp.DTO.OrganizationDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrganizationMapper {

    // Konverter Organization Entity til OrganizationDTO
    public OrganizationDTO toDTO(Organization organization) {
        if (organization == null) {
            return null;
        }

        return new OrganizationDTO(
                organization.getOrgId(),
                organization.getOrgName(),
                organization.getEmail(),
                organization.getOField()
        );
        // Ingen events - unngår sykliske referanser
    }

    // Konverter liste av Organizations til DTOs
    public List<OrganizationDTO> toDTOList(List<Organization> organizations) {
        return organizations.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}