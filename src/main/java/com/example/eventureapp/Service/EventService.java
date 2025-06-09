package com.example.eventureapp.Service;

import com.example.eventureapp.Model.Event;
import com.example.eventureapp.Repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    private final EventRepository repo;

    public EventService(EventRepository repo) {
        this.repo = repo;
    }

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
}
