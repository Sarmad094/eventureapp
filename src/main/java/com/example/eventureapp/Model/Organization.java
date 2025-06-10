package com.example.eventureapp.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "organization")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orgid")
    private Long orgId;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "o_field")
    private String oField;

    // Constructors
    public Organization() {}

    public Organization(String email, String password, String oField) {
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