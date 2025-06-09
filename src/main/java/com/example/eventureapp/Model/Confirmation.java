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

    @Column(name = "bookingid")
    private int bookingId;

    @Column(name = "confirmationdate")
    private Date confirmationDate;

    @Column(name = "emailsent")
    private boolean emailSent;

    public Confirmation() {}

    public Confirmation(int confirmationId, int bookingId, Date confirmationDate, boolean emailSent) {
        this.confirmationId = confirmationId;
        this.bookingId = bookingId;
        this.confirmationDate = confirmationDate;
        this.emailSent = emailSent;
    }

    public int getConfirmationId() {
        return confirmationId;
    }

    public void setConfirmationId(int confirmationId) {
        this.confirmationId = confirmationId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
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
                ", bookingId=" + bookingId +
                ", confirmationDate=" + confirmationDate +
                ", emailSent=" + emailSent +
                '}';
    }
}
