package com.example.eventureapp.Controller;

import com.example.eventureapp.Model.LikedEvent;
import com.example.eventureapp.Service.LikedEventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/likedevents")
public class LikedEventController {

    private final LikedEventService likedEventService;

    public LikedEventController(LikedEventService likedEventService) {
        this.likedEventService = likedEventService;
    }

    @GetMapping
    public ResponseEntity<List<LikedEvent>> getAllLikedEvents() {
        List<LikedEvent> likedEvents = likedEventService.getAllLikedEvents();
        return ResponseEntity.ok(likedEvents);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<List<LikedEvent>> getLikedEvents(@PathVariable Long studentId) {
        return ResponseEntity.ok(likedEventService.getLikedEventsByStudentId(studentId));
    }

    @PostMapping("/like")
    public ResponseEntity<String> likeEvent(@RequestParam Long studentId, @RequestParam Long eventId) {
        likedEventService.likeEvent(studentId, eventId);
        return ResponseEntity.ok("Event liked");
    }

    @DeleteMapping("/unlike")
    public ResponseEntity<String> unlikeEvent(@RequestParam Long studentId, @RequestParam Long eventId) {
        likedEventService.unlikeEvent(studentId, eventId);
        return ResponseEntity.ok("Event unliked");
    }

    @GetMapping("/exists")
    public ResponseEntity<Boolean> checkIfLiked(@RequestParam Long studentId, @RequestParam Long eventId) {
        return ResponseEntity.ok(likedEventService.isEventLiked(studentId, eventId));
    }
}
