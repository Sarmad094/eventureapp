package com.example.eventureapp.Service;

import com.example.eventureapp.Model.LikedEvent;
import com.example.eventureapp.Repository.LikedEventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikedEventService {

    private final LikedEventRepository likedEventRepository;

    public LikedEventService(LikedEventRepository likedEventRepository) {
        this.likedEventRepository = likedEventRepository;
    }

    public List<LikedEvent> getLikedEventsByStudentId(Long studentId) {
        return likedEventRepository.findByIdStudentId(studentId);
    }

    public List<LikedEvent> getAllLikedEvents() {
        return likedEventRepository.findAll();
    }

    public boolean isEventLiked(Long studentId, Long eventId) {
        return likedEventRepository.existsByIdStudentIdAndIdEventId(studentId, eventId);
    }

    public void likeEvent(Long studentId, Long eventId) {
        if (!isEventLiked(studentId, eventId)) {
            likedEventRepository.save(new LikedEvent(studentId, eventId));
        }
    }

    public void unlikeEvent(Long studentId, Long eventId) {
        likedEventRepository.deleteByIdStudentIdAndIdEventId(studentId, eventId);
    }
}
