
package com.example.eventureapp.Service;

import com.example.eventureapp.Model.Organization;
import com.example.eventureapp.DTO.OrganizationDTO;
import com.example.eventureapp.Repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrganizationService {

    private final OrganizationRepository organizationRepository;

    @Autowired
    public OrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }


    public List<OrganizationDTO> getAllOrganizationsDTO() {
        List<Organization> organizations = organizationRepository.findAll();
        return organizations.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<OrganizationDTO> getOrganizationByIdDTO(Long orgId) {
        Optional<Organization> organization = organizationRepository.findById(orgId);
        return organization.map(this::convertToDTO);
    }

    public OrganizationDTO createOrganizationDTO(Organization organization) {
        if (organizationRepository.existsByEmail(organization.getEmail())) {
            throw new IllegalArgumentException("Organization with this email already exists");
        }
        Organization savedOrg = organizationRepository.save(organization);
        return convertToDTO(savedOrg);
    }

    public OrganizationDTO updateOrganizationDTO(Long orgId, Organization organization) {
        Optional<Organization> existingOrg = organizationRepository.findById(orgId);
        if (existingOrg.isPresent()) {
            Organization org = existingOrg.get();
            org.setOrgName(organization.getOrgName());
            org.setEmail(organization.getEmail());
            org.setPassword(organization.getPassword());
            org.setOField(organization.getOField());
            Organization savedOrg = organizationRepository.save(org);
            return convertToDTO(savedOrg);
        } else {
            throw new IllegalArgumentException("Organization not found with id: " + orgId);
        }
    }

    public List<Organization> getAllOrganizations() {
        return organizationRepository.findAll();
    }

    public Optional<Organization> getOrganizationById(Long orgId) {
        return organizationRepository.findById(orgId);
    }

    public Organization createOrganization(Organization organization) {
        if (organizationRepository.existsByEmail(organization.getEmail())) {
            throw new IllegalArgumentException("Organization with this email already exists");
        }
        return organizationRepository.save(organization);
    }

    public Organization updateOrganization(Long orgId, Organization organization) {
        Optional<Organization> existingOrg = organizationRepository.findById(orgId);
        if (existingOrg.isPresent()) {
            Organization org = existingOrg.get();
            org.setOrgName(organization.getOrgName());
            org.setEmail(organization.getEmail());
            org.setPassword(organization.getPassword());
            org.setOField(organization.getOField());
            return organizationRepository.save(org);
        } else {
            throw new IllegalArgumentException("Organization not found with id: " + orgId);
        }
    }

    public void deleteOrganization(Long orgId) {
        if (organizationRepository.existsById(orgId)) {
            organizationRepository.deleteById(orgId);
        } else {
            throw new IllegalArgumentException("Organization not found with id: " + orgId);
        }
    }


    private OrganizationDTO convertToDTO(Organization organization) {
        if (organization == null) {
            return null;
        }

        return new OrganizationDTO(
                organization.getOrgId(),
                organization.getOrgName(),
                organization.getEmail(),
                organization.getOField()
        );

    }
}