package com.example.eventureapp.DTO;

import java.time.LocalDateTime;

public class EventDTO {
    private Long eventId;
    private String title;
    private String e_description;
    private Integer participants;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Double price;

    private Long organizationId;  // antatt Long i Organization
    private Long fieldId;         // konvertert fra int i Field
    private Long locationId;      // konvertert fra int i Location

    public EventDTO() {}

    public Long getEventId() {
        return eventId;
    }
    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getE_description() {
        return e_description;
    }
    public void setE_description(String e_description) {
        this.e_description = e_description;
    }

    public Integer getParticipants() {
        return participants;
    }
    public void setParticipants(Integer participants) {
        this.participants = participants;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getOrganizationId() {
        return organizationId;
    }
    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public Long getFieldId() {
        return fieldId;
    }
    public void setFieldId(Long fieldId) {
        this.fieldId = fieldId;
    }

    public Long getLocationId() {
        return locationId;
    }
    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }
}
