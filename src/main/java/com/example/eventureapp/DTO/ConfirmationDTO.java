package com.example.eventureapp.DTO;

import java.time.LocalDate;

public class ConfirmationDTO {
    private Integer confirmationId;
    private LocalDate confirmationDate;
    private Boolean emailSent;
    private Integer bookId; // Bare booking ID - bryter syklisk referanse

    // Constructors
    public ConfirmationDTO() {}

    public ConfirmationDTO(Integer confirmationId, LocalDate confirmationDate, Boolean emailSent, Integer bookId) {
        this.confirmationId = confirmationId;
        this.confirmationDate = confirmationDate;
        this.emailSent = emailSent;
        this.bookId = bookId;
    }

    // Getters and Setters
    public Integer getConfirmationId() {
        return confirmationId;
    }

    public void setConfirmationId(Integer confirmationId) {
        this.confirmationId = confirmationId;
    }

    public LocalDate getConfirmationDate() {
        return confirmationDate;
    }

    public void setConfirmationDate(LocalDate confirmationDate) {
        this.confirmationDate = confirmationDate;
    }

    public Boolean getEmailSent() {
        return emailSent;
    }

    public void setEmailSent(Boolean emailSent) {
        this.emailSent = emailSent;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }
}