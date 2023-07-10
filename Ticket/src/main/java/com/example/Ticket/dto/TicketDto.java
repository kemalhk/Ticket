package com.example.Ticket.dto;

import lombok.Data;

@Data
public class TicketDto {

    private String name;
    private String lastName;
    private String mail;
    private Double price;
    private Integer ticketNumber;
}
