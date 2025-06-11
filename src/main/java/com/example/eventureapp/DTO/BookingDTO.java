package com.example.eventureapp.DTO;

import java.time.LocalDate;

public class BookingDTO {
    private Long bookId;
    private LocalDate bookDate;
    private Boolean paymentStatus;
    private Long eventId;   // referanse til Event - bryter syklisk referanse
    private Long studentId; // referanse til Student - bryter syklisk referanse

    // Constructors
    public BookingDTO() {}

    public BookingDTO(Long bookId, LocalDate bookDate, Boolean paymentStatus, Long eventId, Long studentId) {
        this.bookId = bookId;
        this.bookDate = bookDate;
        this.paymentStatus = paymentStatus;
        this.eventId = eventId;
        this.studentId = studentId;
    }

    // Getters and Setters
    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public LocalDate getBookDate() {
        return bookDate;
    }

    public void setBookDate(LocalDate bookDate) {
        this.bookDate = bookDate;
    }

    public Boolean getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
}