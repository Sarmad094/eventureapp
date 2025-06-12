package com.example.eventureapp.Controller;

import com.example.eventureapp.DTO.EventDTO;
import com.example.eventureapp.Mapper.EventMapper;
import com.example.eventureapp.Model.Event;
import com.example.eventureapp.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("http://localhost:3000")  // Fixed: removed duplicate "http://"
@RequestMapping("/api/events")
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }


    @GetMapping
    public List<EventDTO> getAllEvents() {
        return eventService.findAll().stream()
                .map(EventMapper::toDTO)
                .collect(Collectors.toList());
    }
    @GetMapping("/{id}/remaining-slots")
    public ResponseEntity<Integer> getRemainingSlots(@PathVariable Long id) {
        try {
            Optional<Event> event = eventService.findById(id);
            if (event.isPresent()) {
                int remainingSlots = eventService.calculateRemainingSlots(id);
                return ResponseEntity.ok(remainingSlots);
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<EventDTO> getEventById(@PathVariable Long id) {
        Optional<Event> event = eventService.findById(id);
        return event.map(e -> ResponseEntity.ok(EventMapper.toDTO(e)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Long> createEvent(@RequestBody EventDTO eventDTO) {
        try {
            Event event = EventMapper.toEntity(eventDTO);
            Event savedEvent = eventService.save(event);
            return ResponseEntity.ok(savedEvent.getEventId());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateEvent(@PathVariable Long id, @RequestBody EventDTO eventDTO) {
        try {
            Event event = EventMapper.toEntity(eventDTO);
            event.setEventId(id);
            eventService.save(event);
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(false);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteEvent(@PathVariable Long id) {
        try {
            eventService.deleteById(id);
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(false);
        }
    }
}