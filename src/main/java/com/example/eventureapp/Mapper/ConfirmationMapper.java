package com.example.eventureapp.Mapper;

import com.example.eventureapp.DTO.ConfirmationDTO;
import com.example.eventureapp.Model.Booking;
import com.example.eventureapp.Model.Confirmation;
import com.example.eventureapp.Repository.BookingRepository;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

public class ConfirmationMapper {

    public static ConfirmationDTO toDTO(Confirmation confirmation) {
        ConfirmationDTO dto = new ConfirmationDTO();
        dto.setConfirmationId(confirmation.getConfirmationId());
        dto.setBookId(confirmation.getBooking() != null ? confirmation.getBooking().getBookId() : null);

        // Convert Date to LocalDate
        if (confirmation.getConfirmationDate() != null) {
            dto.setConfirmationDate(confirmation.getConfirmationDate()
                    .toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate());
        }

        dto.setEmailSent(confirmation.isEmailSent());
        return dto;
    }

    public static Confirmation toEntity(ConfirmationDTO dto, BookingRepository bookingRepository) {
        Confirmation confirmation = new Confirmation();
        confirmation.setConfirmationId(dto.getConfirmationId());

        if (dto.getBookId() != null) {
            Optional<Booking> booking = bookingRepository.findById(dto.getBookId());
            booking.ifPresent(confirmation::setBooking);
        }

        // Convert LocalDate to Date
        if (dto.getConfirmationDate() != null) {
            Date date = Date.from(dto.getConfirmationDate()
                    .atStartOfDay(ZoneId.systemDefault())
                    .toInstant());
            confirmation.setConfirmationDate(date);
        }

        confirmation.setEmailSent(Boolean.TRUE.equals(dto.getEmailSent()));
        return confirmation;
    }
}