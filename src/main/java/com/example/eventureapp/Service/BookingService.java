package com.example.eventureapp.Service;

import com.example.eventureapp.Model.Booking;
import com.example.eventureapp.Repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public List<Booking> hentAlleBookinger() {
        return bookingRepository.findAll();
    }

    public Optional<Booking> hentBookingVedId(int id) {
        return bookingRepository.findById(id);
    }

    public Booking lagNyBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public boolean oppdaterBooking(Booking booking) {
        if (!bookingRepository.existsById(booking.getBookId())) {
            return false;
        }
        bookingRepository.save(booking);
        return true;
    }

    public boolean slettBooking(int id) {
        if (!bookingRepository.existsById(id)) {
            return false;
        }
        bookingRepository.deleteById(id);
        return true;
    }
}
