package com.example.eventureapp.Controller;

import com.example.eventureapp.DTO.EventDTO;
import com.example.eventureapp.Mapper.EventMapper;
import com.example.eventureapp.Model.Event;
import com.example.eventureapp.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("http://http://localhost:3000")
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

    @GetMapping("/{id}")
    public EventDTO getEventById(@PathVariable Long id) {
        Optional<Event> event = eventService.findById(id);
        return event.map(EventMapper::toDTO).orElse(null);
    }

    @PostMapping
    public Long createEvent(@RequestBody EventDTO eventDTO) {
        Event event = EventMapper.toEntity(eventDTO);
        return (long) eventService.save(event).getEventId();
    }

    @PutMapping("/{id}")
    public boolean updateEvent(@PathVariable Long id, @RequestBody EventDTO eventDTO) {
        Event event = EventMapper.toEntity(eventDTO);
        event.setEventId(id.intValue());
        eventService.save(event);
        return true;
    }

    @DeleteMapping("/{id}")
    public boolean deleteEvent(@PathVariable Long id) {
        eventService.deleteById(id);
        return true;
    }
}
