package com.example.eventureapp.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Long eventId;

    @Column(name = "location_id")
    private Long locationId;

    @Column(name = "org_id")
    private Long orgId;

    @Column(name = "field_id")
    private Long fieldId;

    @Column(name = "title")
    private String title;

    @Column(name = "field")
    private String field;

    @Column(name = "location")
    private String location;

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
                ", location='" + location + '\'' +
                ", locationId=" + locationId +
                ", orgId=" + orgId +
                ", fieldId=" + fieldId +
                '}';
    }
}