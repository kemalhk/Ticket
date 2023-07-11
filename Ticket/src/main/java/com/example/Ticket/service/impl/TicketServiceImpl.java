package com.example.Ticket.service.impl;

import com.example.Ticket.dto.TicketDto;
import com.example.Ticket.model.Ticket;
import com.example.Ticket.repository.TicketRepository;
import com.example.Ticket.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    @Override
    public TicketDto save (TicketDto ticketDto){
        Ticket ticket = new Ticket();
        ticket.setName(ticketDto.getName());
        ticket.setLastName(ticketDto.getLastName());
        ticket.setMail(ticketDto.getMail());
        ticket.setPrice(ticketDto.getPrice());
        ticket.setTicketNumber(ticketDto.getTicketNumber());
        ticketRepository.save(ticket);

        return ticketDto;
    }



}
