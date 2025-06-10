package com.example.eventureapp.Model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "confirmation")
public class Confirmation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "confirmationid")
    private int confirmationId;

    // One-to-One relationship with Booking entity
    @OneToOne
    @JoinColumn(name = "bookid", referencedColumnName = "bookid")
    private Booking booking;

    @Column(name = "confirmationdate")
    private Date confirmationDate;

    @Column(name = "emailsent")
    private boolean emailSent;

    public Confirmation() {}

    public Confirmation(int confirmationId, Booking booking, Date confirmationDate, boolean emailSent) {
        this.confirmationId = confirmationId;
        this.booking = booking;
        this.confirmationDate = confirmationDate;
        this.emailSent = emailSent;
    }

    public int getConfirmationId() {
        return confirmationId;
    }

    public void setConfirmationId(int confirmationId) {
        this.confirmationId = confirmationId;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Date getConfirmationDate() {
        return confirmationDate;
    }

    public void setConfirmationDate(Date confirmationDate) {
        this.confirmationDate = confirmationDate;
    }

    public boolean isEmailSent() {
        return emailSent;
    }

    public void setEmailSent(boolean emailSent) {
        this.emailSent = emailSent;
    }

    @Override
    public String toString() {
        return "Confirmation{" +
                "confirmationId=" + confirmationId +
                ", booking=" + (booking != null ? booking.getBookId() : "null") +
                ", confirmationDate=" + confirmationDate +
                ", emailSent=" + emailSent +
                '}';
    }
}