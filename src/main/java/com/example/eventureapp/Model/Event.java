package com.example.eventureapp.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
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

    // One-to-Many relationship with LikedEvent
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LikedEvent> likedEvents;

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

    public Event() {
    }

    public Event(String title, LocalDateTime startDate, LocalDateTime endDate) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventId=" + eventId +
                ", title='" + title + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", organization=" + (organization != null ? organization.getOrgId() : "null") +
                ", field=" + (fieldEntity != null ? fieldEntity.getField() : "null") +
                ", location=" + (location != null ? location.getLocationName() : "null") +
                '}';
    }
}