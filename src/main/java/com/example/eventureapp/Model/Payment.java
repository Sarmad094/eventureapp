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

    @Column(nullable = false)
    private Double amount;

    @Column(name = "paymentdate", nullable = false)
    private LocalDate paymentDate;

    @Column(name = "cardname")
    private String cardName;

    // One-to-One relationship with Booking
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookid", referencedColumnName = "bookid")
    private Booking booking;

    // Constructors
    public Payment() {}

    public Payment(Double amount, LocalDate paymentDate, String cardName, Booking booking) {
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.cardName = cardName;
        this.booking = booking;
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

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", amount=" + amount +
                ", paymentDate=" + paymentDate +
                ", cardName='" + cardName + '\'' +
                ", bookingId=" + (booking != null ? booking.getBookId() : null) +
                '}';
    }
}