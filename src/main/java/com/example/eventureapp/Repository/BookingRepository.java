package com.example.eventureapp.Repository;

import com.example.eventureapp.Model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

    // Legg til denne metoden for å telle bookinger per event
    int countByEvent_EventId(Long eventId);

    // Legg til denne for å sjekke om student allerede har booket
    boolean existsByStudent_StudentIdAndEvent_EventId(Long studentId, Long eventId);

    @Repository
    public interface bookingRepository extends JpaRepository<Booking, Integer> {

    }
}


