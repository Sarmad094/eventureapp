
package com.example.eventureapp.Service;

import com.example.eventureapp.Model.Payment;
import com.example.eventureapp.DTO.PaymentDTO;
import com.example.eventureapp.Mapper.PaymentMapper;
import com.example.eventureapp.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository, PaymentMapper paymentMapper) {
        this.paymentRepository = paymentRepository;
        this.paymentMapper = paymentMapper;
    }

    // DTO METODER - Bruker mapper for konvertering
    public List<PaymentDTO> getAllPaymentsDTO() {
        List<Payment> payments = paymentRepository.findAll();
        return paymentMapper.toDTOList(payments);
    }

    public Optional<PaymentDTO> getPaymentByIdDTO(Long paymentId) {
        Optional<Payment> payment = paymentRepository.findById(paymentId);
        return payment.map(paymentMapper::toDTO);
    }

    public PaymentDTO createPaymentDTO(Payment payment) {
        if (payment.getAmount() == null || payment.getAmount() <= 0) {
            throw new IllegalArgumentException("Payment amount must be greater than 0");
        }
        if (payment.getBooking() == null) {
            throw new IllegalArgumentException("BookID is required");
        }
        Payment savedPayment = paymentRepository.save(payment);
        return paymentMapper.toDTO(savedPayment);
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
            return paymentMapper.toDTO(savedPayment);
        } else {
            throw new IllegalArgumentException("Payment not found with id: " + paymentId);
        }
    }

    public Optional<PaymentDTO> getPaymentsByBookIdDTO(int bookId) {
        Optional<Payment> payment = paymentRepository.findByBookingBookId(bookId);
        return payment.map(paymentMapper::toDTO);
    }

    // ORIGINALE METODER - Uendret for andre som bruker dem
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
}