package com.example.eventureapp.DTO;

import lombok.Data;

@Data
public class LikedEventDTO {
    private Long studentId;
    private Long eventId;

    public LikedEventDTO() {}

    public LikedEventDTO(Long studentId, Long eventId) {
        this.studentId = studentId;
        this.eventId = eventId;
    }
}

