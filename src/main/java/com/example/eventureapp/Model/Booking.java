package com.example.eventureapp.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookid")
    private int bookId;

    @Column(name = "eventid")
    private int eventId;

    @Column(name = "studentid")
    private int studentId;

    @Column(name = "bookdate")
    private String bookDate;

    @Column(name = "paymentstatus")
    private boolean paymentStatus;

    public Booking() {}

    public Booking(int bookId, int eventId, int studentId, String bookDate, boolean paymentStatus) {
        this.bookId = bookId;
        this.eventId = eventId;
        this.studentId = studentId;
        this.bookDate = bookDate;
        this.paymentStatus = paymentStatus;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getBookDate() {
        return bookDate;
    }

    public void setBookDate(String bookDate) {
        this.bookDate = bookDate;
    }

    public boolean isPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookId=" + bookId +
                ", eventId=" + eventId +
                ", studentId=" + studentId +
                ", bookDate='" + bookDate + '\'' +
                ", paymentStatus=" + paymentStatus +
                '}';
    }
}
