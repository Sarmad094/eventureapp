package com.example.eventureapp.Mapper;

import com.example.eventureapp.DTO.BookingDTO;
import com.example.eventureapp.Model.Booking;
import com.example.eventureapp.Model.Event;
import com.example.eventureapp.Model.Student;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BookingMapper {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static BookingDTO toDTO(Booking booking) {
        BookingDTO dto = new BookingDTO();
        dto.setBookId(Long.valueOf(booking.getBookId()));

        if (booking.getBookDate() != null && !booking.getBookDate().isEmpty()) {
            dto.setBookDate(LocalDate.parse(booking.getBookDate(), DATE_FORMATTER));
        }

        dto.setPaymentStatus(booking.isPaymentStatus());
        dto.setEventId(booking.getEvent() != null ? Long.valueOf(booking.getEvent().getEventId()) : null);
        dto.setStudentId(booking.getStudent() != null ? Long.valueOf(booking.getStudent().getStudentId()) : null);

        return dto;
    }

    public static Booking toEntity(BookingDTO dto, Event event, Student student) {
        Booking booking = new Booking();
        booking.setBookId(dto.getBookId() != null ? dto.getBookId().intValue() : 0);

        if (dto.getBookDate() != null) {
            booking.setBookDate(dto.getBookDate().format(DATE_FORMATTER));
        }

        booking.setPaymentStatus(Boolean.TRUE.equals(dto.getPaymentStatus()));
        booking.setEvent(event);
        booking.setStudent(student);

        return booking;
    }
}
