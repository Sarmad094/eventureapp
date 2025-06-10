package com.example.eventureapp.DTO;

import lombok.Data;

@Data
public class BookingDTO {
    private Long bookId;
    private String bookDate;
    private Boolean paymentStatus;
    private Long eventId; // Bare ID, ikke hele event-objektet
}
