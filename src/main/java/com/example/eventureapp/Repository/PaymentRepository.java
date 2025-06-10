package com.example.eventureapp.Repository;

import com.example.eventureapp.Model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    List<Payment> findByBooking(Long bookId);

    boolean existsByBookId(Long bookId);
}