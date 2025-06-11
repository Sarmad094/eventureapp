

package com.example.eventureapp.Service;

import com.example.eventureapp.Model.Payment;
import com.example.eventureapp.DTO.PaymentDTO;
import com.example.eventureapp.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    // DTO METODER - Disse returnerer DTOs (ingen sykliske referanser)
    public List<PaymentDTO> getAllPaymentsDTO() {
        List<Payment> payments = paymentRepository.findAll();
        return payments.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<PaymentDTO> getPaymentByIdDTO(Long paymentId) {
        Optional<Payment> payment = paymentRepository.findById(paymentId);
        return payment.map(this::convertToDTO);
    }

    public PaymentDTO createPaymentDTO(Payment payment) {
        if (payment.getAmount() == null || payment.getAmount() <= 0) {
            throw new IllegalArgumentException("Payment amount must be greater than 0");
        }
        if (payment.getBooking() == null) {
            throw new IllegalArgumentException("BookID is required");
        }
        Payment savedPayment = paymentRepository.save(payment);
        return convertToDTO(savedPayment);
    }

    public PaymentDTO updatePaymentDTO(Long paymentId, Payment payment) {
        Optional<Payment> existingPayment = paymentRepository.findById(paymentId);
        if (existingPayment.isPresent()) {
            Payment p = existingPayment.get();
            p.setBooking(payment.getBooking());
            p.setAmount(payment.getAmount());
            p.setPaymentDate(payment.getPaymentDate());
            p.setCardName(payment.getCardName());
            Payment savedPayment = paymentRepository.save(p);
            return convertToDTO(savedPayment);
        } else {
            throw new IllegalArgumentException("Payment not found with id: " + paymentId);
        }
    }

    public Optional<PaymentDTO> getPaymentsByBookIdDTO(int bookId) {
        Optional<Payment> payment = paymentRepository.findByBookingBookId(bookId);
        return payment.map(this::convertToDTO);
    }

    // ORIGINALE METODER - Behold disse hvis andre deler av koden bruker dem
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Optional<Payment> getPaymentById(Long paymentId) {
        return paymentRepository.findById(paymentId);
    }

    public Payment createPayment(Payment payment) {
        if (payment.getAmount() == null || payment.getAmount() <= 0) {
            throw new IllegalArgumentException("Payment amount must be greater than 0");
        }
        if (payment.getBooking() == null) {
            throw new IllegalArgumentException("BookID is required");
        }
        return paymentRepository.save(payment);
    }

    public Payment updatePayment(Long paymentId, Payment payment) {
        Optional<Payment> existingPayment = paymentRepository.findById(paymentId);
        if (existingPayment.isPresent()) {
            Payment p = existingPayment.get();
            p.setBooking(payment.getBooking());
            p.setAmount(payment.getAmount());
            p.setPaymentDate(payment.getPaymentDate());
            p.setCardName(payment.getCardName());
            return paymentRepository.save(p);
        } else {
            throw new IllegalArgumentException("Payment not found with id: " + paymentId);
        }
    }

    public void deletePayment(Long paymentId) {
        if (paymentRepository.existsById(paymentId)) {
            paymentRepository.deleteById(paymentId);
        } else {
            throw new IllegalArgumentException("Payment not found with id: " + paymentId);
        }
    }

    public Optional<Payment> getPaymentsByBookId(int bookId) {
        return paymentRepository.findByBookingBookId(bookId);
    }

    // PRIVATE HELPER METODE - Konverterer Entity til DTO
    private PaymentDTO convertToDTO(Payment payment) {
        if (payment == null) {
            return null;
        }

        PaymentDTO dto = new PaymentDTO(
                payment.getPaymentId(),
                payment.getAmount(),
                payment.getPaymentDate(),
                payment.getCardName()
        );

        // Legg til booking ID (bryter syklisk referanse)
        if (payment.getBooking() != null) {
            dto.setBookId(payment.getBooking().getBookId());
        }

        return dto;
    }
}