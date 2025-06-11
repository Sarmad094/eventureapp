package com.example.eventureapp.Mapper;

import com.example.eventureapp.DTO.LikedEventDTO;
import com.example.eventureapp.Model.LikedEvent;

public class LikedEventMapper {
    public static LikedEventDTO toDTO(LikedEvent likedEvent) {
        return new LikedEventDTO(
                likedEvent.getStudentId(),
                likedEvent.getEventId()
        );
    }

    public static LikedEvent toEntity(LikedEventDTO dto) {
        return new LikedEvent(dto.getStudentId(), dto.getEventId());
    }
}
