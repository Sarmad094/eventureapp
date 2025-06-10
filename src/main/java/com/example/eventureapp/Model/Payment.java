package com.example.eventureapp.Model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paymentid")
    private Long paymentId;

    @Column(name = "bookid", nullable = false)
    private Long bookId;

    @Column(nullable = false)
    private Double amount;

    @Column(name = "paymentdate", nullable = false)
    private LocalDate paymentDate;

    @Column(name = "cardname")
    private String cardName;

    // Constructors
    public Payment() {}

    public Payment(Long bookId, Double amount, LocalDate paymentDate, String cardName) {
        this.bookId = bookId;
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

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
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
}
