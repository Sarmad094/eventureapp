package com.example.eventureapp.Controller;

import com.example.eventureapp.DTO.BookingDTO;
import com.example.eventureapp.Mapper.BookingMapper;
import com.example.eventureapp.Model.Booking;
import com.example.eventureapp.Model.Event;
import com.example.eventureapp.Model.Student;
import com.example.eventureapp.Service.BookingService;
import com.example.eventureapp.Service.EventService;
import com.example.eventureapp.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;
    private final EventService eventService;
    private final StudentService studentService;

    @Autowired
    public BookingController(BookingService bookingService, EventService eventService, StudentService studentService) {
        this.bookingService = bookingService;
        this.eventService = eventService;
        this.studentService = studentService;
    }

    @GetMapping
    public List<BookingDTO> hentAlle() {
        return bookingService.hentAlleBookinger().stream()
                .map(BookingMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public BookingDTO hentEn(@PathVariable int id) {
        Optional<Booking> booking = bookingService.hentBookingVedId(id);
        return booking.map(BookingMapper::toDTO).orElse(null);
    }

    @PostMapping
    public Long lagBooking(@RequestBody BookingDTO bookingDTO) {
        Event event = eventService.findById(bookingDTO.getEventId()).orElse(null);
        Student student = studentService.getStudentById(bookingDTO.getStudentId()).orElse(null);
        Booking booking = BookingMapper.toEntity(bookingDTO, event, student);
        return Long.valueOf(bookingService.lagNyBooking(booking).getBookId());
    }

    @PutMapping("/{id}")
    public boolean oppdater(@PathVariable int id, @RequestBody BookingDTO bookingDTO) {
        Event event = eventService.findById(bookingDTO.getEventId()).orElse(null);
        Student student = studentService.getStudentById(bookingDTO.getStudentId()).orElse(null);
        Booking booking = BookingMapper.toEntity(bookingDTO, event, student);
        booking.setBookId(id);
        return bookingService.oppdaterBooking(booking);
    }

    @DeleteMapping("/{id}")
    public boolean slett(@PathVariable int id) {
        return bookingService.slettBooking(id);
    }
}