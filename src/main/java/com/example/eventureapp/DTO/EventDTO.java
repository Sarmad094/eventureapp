package com.example.eventureapp.DTO;
import lombok.Data;
import java.time.LocalDateTime;

public class EventDTO {
    private Long eventId;
    private String title;
    private String description;
    private Integer participants;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Double price;

    private Long organizationId;
    private Long fieldId;
    private Long locationId;
    private String locationName;

    // Constructors
    public EventDTO() {}

    public EventDTO(Long eventId, String title, String description, Integer participants,
                    LocalDateTime startDate, LocalDateTime endDate, Double price,
                    Long organizationId, Long fieldId, Long locationId, String locationName) {
        this.eventId = eventId;
        this.title = title;
        this.description = description;
        this.participants = participants;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.organizationId = organizationId;
        this.fieldId = fieldId;
        this.locationId = locationId;
        this.locationName = locationName;
    }

    // Getters and setters
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}
