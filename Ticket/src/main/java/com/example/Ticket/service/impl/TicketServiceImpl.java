package com.example.Ticket.service.impl;

import com.example.Ticket.dto.TicketDto;
import com.example.Ticket.entity.Ticket;
import com.example.Ticket.repository.TicketPerository;
import com.example.Ticket.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketPerository ticketPerository;

    @Override
    public TicketDto save (TicketDto ticketDto){
        Ticket ticket = new Ticket();
        ticket.setName(ticketDto.getName());
        ticket.setLastName(ticketDto.getLastName());
        ticket.setMail(ticketDto.getMail());
        ticket.setPrice(ticketDto.getPrice());
        ticket.setTicketNumber(ticketDto.getTicketNumber());
        ticketPerository.save(ticket);


        return ticketDto;
    }



}
