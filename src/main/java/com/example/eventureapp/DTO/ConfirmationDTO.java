package com.example.eventureapp.DTO;

import lombok.Data;

@Data
public class ConfirmationDTO {
    private int confirmationID;
    private String confirmationDate;
    private Boolean EmailSent;
    private int bookid;
}
