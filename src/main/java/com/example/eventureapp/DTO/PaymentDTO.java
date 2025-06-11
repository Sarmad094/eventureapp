// PaymentDTO.java
// Lag denne filen i: src/main/java/com/example/eventureapp/DTO/PaymentDTO.java

package com.example.eventureapp.DTO;

import java.time.LocalDate;

public class PaymentDTO {
    private Long paymentId;
    private Double amount;
    private LocalDate paymentDate;
    private String cardName;
    private Integer bookId; // Bare booking ID - bryter syklisk referanse

    // Constructors
    public PaymentDTO() {}

    public PaymentDTO(Long paymentId, Double amount, LocalDate paymentDate, String cardName) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.cardName = cardName;
    }

    // Getters and Setters
    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }
}