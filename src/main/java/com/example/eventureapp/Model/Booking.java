package com.example.eventureapp.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookid")
    private int bookId;

    @Column(name = "bookdate")
    private String bookDate;

    @Column(name = "paymentstatus")
    private boolean paymentStatus;

    // Many-to-One relationship with Event
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "eventid", referencedColumnName = "eventid")
    private Event event;

    // Many-to-One relationship with Student
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studentid", referencedColumnName = "studentid")
    private Student student;

    // One-to-One relationship with Confirmation
    @OneToOne(mappedBy = "booking", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Confirmation confirmation;

    // One-to-One relationship with Payment
    @OneToOne(mappedBy = "booking", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Payment payment;

    public Booking() {}

    public Booking(String bookDate, boolean paymentStatus, Event event, Student student) {
        this.bookDate = bookDate;
        this.paymentStatus = paymentStatus;
        this.event = event;
        this.student = student;
    }

    // Getters and Setters
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
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

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Confirmation getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(Confirmation confirmation) {
        this.confirmation = confirmation;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookId=" + bookId +
                ", bookDate='" + bookDate + '\'' +
                ", paymentStatus=" + paymentStatus +
                ", eventId=" + (event != null ? event.getEventId() : null) +
                ", studentId=" + (student != null ? student.getStudentId() : null) +
                '}';
    }
}

