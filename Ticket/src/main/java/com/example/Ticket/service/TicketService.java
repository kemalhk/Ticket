package com.example.Ticket.service;

import com.example.Ticket.dto.TicketDto;
import com.example.Ticket.model.TicketCache;

import java.util.List;

public interface TicketService {

    TicketDto save (TicketDto ticketDto);

    List<TicketCache>getAllTicketCache();

    TicketCache createTicketCache(TicketCache ticketCache);

}
