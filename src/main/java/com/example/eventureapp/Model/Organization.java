package com.example.eventureapp.Model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;


@Entity
@Table(name = "organization")
public class Organization {

    @Id
    @Column(name = "org_id")
    private Long orgId; // ✅ FJERNET @GeneratedValue - nå manuell

    @Column(nullable = false)
    private String orgName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "o_field")
    @JsonProperty("oField")
    private String oField;

    // One-to-Many relasjon til Event
    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Event> events;

    // Constructors
    public Organization() {}

    public Organization(Long orgId, String orgName, String email, String password, String oField) {
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

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}