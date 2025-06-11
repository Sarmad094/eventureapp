package com.example.eventureapp.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrganizationDTO {
    private Long orgId;
    private String orgName;
    private String email;
    private String password; // ✅ LAGT TIL for login og registrering
    @JsonProperty("oField")
    private String oField;

    // Constructors
    public OrganizationDTO() {}

    public OrganizationDTO(Long orgId, String orgName, String email, String password, String oField) {
        this.orgId = orgId;
        this.orgName = orgName;
        this.email = email;
        this.password = password;
        this.oField = oField;
    }

    // Getters and Setters
    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOField() {
        return oField;
    }

    public void setOField(String oField) {
        this.oField = oField;
    }
}