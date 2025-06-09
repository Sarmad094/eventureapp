package com.example.eventureapp.Controller;

import com.example.eventureapp.Model.Booking;
import com.example.eventureapp.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/bookinger")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }


    @GetMapping
    public List<Booking> hentAlle() {
        return bookingService.hentAlleBookinger();
    }


    @GetMapping("/{id}")
    public Booking hentEn(@PathVariable int id) {
        Optional<Booking> booking = bookingService.hentBookingVedId(id);
        return booking.orElse(null);
    }


    @PostMapping
    public int lagBooking(@RequestBody Booking booking) {
        return bookingService.lagNyBooking(booking).getBookId();
    }


    @PutMapping("/{id}")
    public boolean oppdater(@PathVariable int id, @RequestBody Booking booking) {
        booking.setBookId(id);
        return bookingService.oppdaterBooking(booking);
    }


    @DeleteMapping("/{id}")
    public boolean slett(@PathVariable int id) {
        return bookingService.slettBooking(id);
    }
}
