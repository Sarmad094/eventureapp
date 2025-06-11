
package com.example.eventureapp.Service;

import com.example.eventureapp.Model.Organization;
import com.example.eventureapp.DTO.OrganizationDTO;
import com.example.eventureapp.Mapper.OrganizationMapper;
import com.example.eventureapp.Repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizationService {

    private final OrganizationRepository organizationRepository;
    private final OrganizationMapper organizationMapper;

    @Autowired
    public OrganizationService(OrganizationRepository organizationRepository, OrganizationMapper organizationMapper) {
        this.organizationRepository = organizationRepository;
        this.organizationMapper = organizationMapper;
    }

    // DTO METODER - Bruker mapper for konvertering
    public List<OrganizationDTO> getAllOrganizationsDTO() {
        List<Organization> organizations = organizationRepository.findAll();
        return organizationMapper.toDTOList(organizations);
    }

    public Optional<OrganizationDTO> getOrganizationByIdDTO(Long orgId) {
        Optional<Organization> organization = organizationRepository.findById(orgId);
        return organization.map(organizationMapper::toDTO);
    }

    public OrganizationDTO createOrganizationDTO(Organization organization) {
        if (organizationRepository.existsByEmail(organization.getEmail())) {
            throw new IllegalArgumentException("Organization with this email already exists");
        }
        Organization savedOrg = organizationRepository.save(organization);
        return organizationMapper.toDTO(savedOrg);
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
            return organizationMapper.toDTO(savedOrg);
        } else {
            throw new IllegalArgumentException("Organization not found with id: " + orgId);
        }
    }

    // ORIGINALE METODER - Uendret for andre som bruker dem
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
}