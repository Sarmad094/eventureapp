

package com.example.eventureapp.Mapper;

import com.example.eventureapp.Model.Payment;
import com.example.eventureapp.DTO.PaymentDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PaymentMapper {

    // Konverter Payment Entity til PaymentDTO
    public PaymentDTO toDTO(Payment payment) {
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

    // Konverter liste av Payments til DTOs
    public List<PaymentDTO> toDTOList(List<Payment> payments) {
        return payments.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}