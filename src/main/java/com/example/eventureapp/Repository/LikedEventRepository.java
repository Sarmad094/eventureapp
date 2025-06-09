package com.example.eventureapp.Repository;

import com.example.eventureapp.Model.LikedEvent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikedEventRepository extends JpaRepository<LikedEvent, LikedEvent.LikedEventKey> {
    List<LikedEvent> findByIdStudentId(Long studentId);
    boolean existsByIdStudentIdAndIdEventId(Long studentId, Long eventId);
    void deleteByIdStudentIdAndIdEventId(Long studentId, Long eventId);
}

