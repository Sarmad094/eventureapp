package com.example.eventureapp.Repository;

import com.example.eventureapp.Model.Booking;
import com.example.eventureapp.Model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    <findByBooking> Optional<Payment> findByBooking(findByBooking booking);

    boolean existsByBooking(Booking booking);
}