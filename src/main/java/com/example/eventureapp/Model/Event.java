package com.example.eventureapp.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Long eventId;

    // Many-to-One relationship with Organization
    @ManyToOne
    @JoinColumn(name = "org_id", referencedColumnName = "org_id")
    private Organization organization;

    // Many-to-One relationship with Field
    @ManyToOne
    @JoinColumn(name = "field_id", referencedColumnName = "field_id")
    private Field fieldEntity;

    // Many-to-One relationship with Location
    @ManyToOne
    @JoinColumn(name = "location_id", referencedColumnName = "location_id")
    private Location location;

    // One-to-Many relationship with Booking
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Booking> bookings;

    // One-to-One relationship with LikedEvent
    @OneToOne(mappedBy = "event", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private LikedEvent likedEvent;

    @Column(name = "title")
    private String title;

    @Column(name = "e_description")
    private String e_description;

    @Column(name = "participants")
    private Integer participants;

    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDateTime endDate;

    @Column(name = "price")
    private Double price;

    // Constructors
    public Event() {
    }

    public Event(String title, LocalDateTime startDate, LocalDateTime endDate) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getters and Setters
    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Field getFieldEntity() {
        return fieldEntity;
    }

    public void setFieldEntity(Field fieldEntity) {
        this.fieldEntity = fieldEntity;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public LikedEvent getLikedEvent() {
        return likedEvent;
    }

    public void setLikedEvent(LikedEvent likedEvent) {
        this.likedEvent = likedEvent;
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

    @Override
    public String toString() {
        return "Event{" +
                "eventId=" + eventId +
                ", title='" + title + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", organization=" + (organization != null ? organization.getOrgId() : "null") +
                ", field=" + (fieldEntity != null ? fieldEntity.getFieldId() : "null") +
                ", location=" + (location != null ? location.getLocationName() : "null") +
                '}';
    }
}