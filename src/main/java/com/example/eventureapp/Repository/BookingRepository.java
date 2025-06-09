package com.example.eventureapp.Repository;

import com.example.eventureapp.Model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
