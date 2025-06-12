package com.example.eventureapp.Service;

import com.example.eventureapp.DTO.EventDTO;
import com.example.eventureapp.Mapper.EventMapper;
import com.example.eventureapp.Model.Event;
import com.example.eventureapp.Repository.BookingRepository;
import com.example.eventureapp.Repository.eventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventService {
    private final eventRepository repo;

    public EventService(eventRepository repo) {
        this.repo = repo;
    }

    // === ENTITY-LEVEL METHODS (for intern bruk eller andre servicer) ===
    public List<Event> findAll() {
        return repo.findAll();
    }

    public Optional<Event> findById(Long id) {
        return repo.findById(id);
    }

    public Event save(Event event) {
        return repo.save(event);
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    // === DTO-LEVEL METHODS (for controller-bruk) ===
    public List<EventDTO> getAllEventDTOs() {
        return findAll().stream()
                .map(EventMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<EventDTO> getEventDTOById(Long id) {
        return findById(id).map(EventMapper::toDTO);
    }

    public Long createEventFromDTO(EventDTO dto) {
        Event event = EventMapper.toEntity(dto);
        return (long) save(event).getEventId();
    }

    public boolean updateEventFromDTO(Long id, EventDTO dto) {
        Event event = EventMapper.toEntity(dto);
        event.setEventId(id.intValue());
        save(event);
        return true;
    }
    @Autowired
    private BookingRepository bookingRepository; // Legg til denne dependency

    public int calculateRemainingSlots(Long eventId) {
        Optional<Event> event = findById(eventId);
        if (event.isPresent()) {
            int maxParticipants = event.get().getParticipants();
            int currentBookings = bookingRepository.countByEvent_EventId(eventId);
            return Math.max(0, maxParticipants - currentBookings);
        }
        return 0;
    }

    public boolean canBookEvent(Long eventId, Long studentId) {
        // Sjekk om det er ledige plasser
        if (calculateRemainingSlots(eventId) <= 0) {
            return false;
        }

        // Sjekk om student allerede har booket
        if (bookingRepository.existsByStudent_StudentIdAndEvent_EventId(studentId, eventId)) {
            return false;
        }

        return true;
    }

}
