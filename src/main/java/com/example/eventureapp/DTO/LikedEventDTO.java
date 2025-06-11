package com.example.eventureapp.DTO;



public class LikedEventDTO {
    private Long studentId;
    private Long eventId;

    public LikedEventDTO() {}

    public LikedEventDTO(Long studentId, Long eventId) {
        this.studentId = studentId;
        this.eventId = eventId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }
}