package com.example.eventureapp.Mapper;

import com.example.eventureapp.DTO.BookingDTO;
import com.example.eventureapp.Model.Booking;
import com.example.eventureapp.Model.Event;
import com.example.eventureapp.Model.Student;

public class BookingMapper {

    public static BookingDTO toDTO(Booking booking) {
        BookingDTO dto = new BookingDTO();
        dto.setBookId(Long.valueOf(booking.getBookId()));
        dto.setBookDate(booking.getBookDate());  // Direkte tildeling siden begge er String
        dto.setPaymentStatus(booking.isPaymentStatus());
        dto.setEventId(booking.getEvent() != null ? Long.valueOf(booking.getEvent().getEventId()) : null);
        dto.setStudentId(booking.getStudent() != null ? Long.valueOf(booking.getStudent().getStudentId()) : null);
        return dto;
    }

    public static Booking toEntity(BookingDTO dto, Event event, Student student) {
        Booking booking = new Booking();
        booking.setBookId(dto.getBookId() != null ? dto.getBookId().intValue() : 0);
        booking.setBookDate(dto.getBookDate());  // Direkte tildeling siden begge er String
        booking.setPaymentStatus(Boolean.TRUE.equals(dto.getPaymentStatus()));
        booking.setEvent(event);
        booking.setStudent(student);
        return booking;
    }
}