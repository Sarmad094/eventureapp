package com.example.eventureapp.Service;

import com.example.eventureapp.DTO.LikedEventDTO;
import com.example.eventureapp.Mapper.LikedEventMapper;
import com.example.eventureapp.Model.LikedEvent;
import com.example.eventureapp.Model.Student;
import com.example.eventureapp.Model.Event;
import com.example.eventureapp.Repository.LikedEventRepository;
import com.example.eventureapp.Repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LikedEventService {

    private final LikedEventRepository likedEventRepository;
    private final StudentRepository studentRepository;
    private final com.example.eventureapp.Repository.eventRepository eventRepository;

    public LikedEventService(LikedEventRepository likedEventRepository,
                             StudentRepository studentRepository,
                             com.example.eventureapp.Repository.eventRepository eventRepository) {
        this.likedEventRepository = likedEventRepository;
        this.studentRepository = studentRepository;
        this.eventRepository = eventRepository;
    }

    public List<LikedEventDTO> getLikedEventsByStudentId(Long studentId) {
        return likedEventRepository.findByIdStudentId(studentId)
                .stream()
                .map(LikedEventMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<LikedEventDTO> getAllLikedEvents() {
        return likedEventRepository.findAll()
                .stream()
                .map(LikedEventMapper::toDTO)
                .collect(Collectors.toList());
    }

    public boolean isEventLiked(Long studentId, Long eventId) {
        return likedEventRepository.existsByIdStudentIdAndIdEventId(studentId, eventId);
    }

    @Transactional
    public void likeEvent(Long studentId, Long eventId) {
        // Sjekk om student og event eksisterer
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + studentId));

        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found with id: " + eventId));

        // Sjekk om like allerede eksisterer
        if (!isEventLiked(studentId, eventId)) {
            LikedEvent likedEvent = new LikedEvent(studentId, eventId);
            likedEvent.setStudent(student);
            likedEvent.setEvent(event);
            likedEventRepository.save(likedEvent);
        }
    }

    @Transactional
    public void unlikeEvent(Long studentId, Long eventId) {
        likedEventRepository.deleteByIdStudentIdAndIdEventId(studentId, eventId);
    }
}