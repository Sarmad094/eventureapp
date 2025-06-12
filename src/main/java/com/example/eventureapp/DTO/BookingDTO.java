package com.example.eventureapp.DTO;

public class BookingDTO {
    private Long bookId;
    private String bookDate;        // Endret fra LocalDate til String
    private Boolean paymentStatus;
    private Long eventId;
    private Long studentId;

    // Constructors
    public BookingDTO() {}

    public BookingDTO(Long bookId, String bookDate, Boolean paymentStatus, Long eventId, Long studentId) {
        this.bookId = bookId;
        this.bookDate = bookDate;
        this.paymentStatus = paymentStatus;
        this.eventId = eventId;
        this.studentId = studentId;
    }

    // Getters and Setters
    public Long getBookId() { return bookId; }
    public void setBookId(Long bookId) { this.bookId = bookId; }

    public String getBookDate() { return bookDate; }          // Endret return type
    public void setBookDate(String bookDate) { this.bookDate = bookDate; }  // Endret parameter type

    public Boolean getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(Boolean paymentStatus) { this.paymentStatus = paymentStatus; }

    public Long getEventId() { return eventId; }
    public void setEventId(Long eventId) { this.eventId = eventId; }

    public Long getStudentId() { return studentId; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }
}