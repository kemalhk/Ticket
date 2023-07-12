package com.example.Ticket.service.impl;

import com.example.Ticket.dto.TicketDto;
import com.example.Ticket.model.Ticket;
import com.example.Ticket.model.TicketCache;
import com.example.Ticket.repository.TicketCacheRepository;
import com.example.Ticket.repository.TicketRepository;
import com.example.Ticket.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final TicketCacheRepository ticketCacheRepository;

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

    @Override
    public List<TicketCache> getAllTicketCache() {
        return new ArrayList<TicketCache>((Collection<? extends TicketCache>) ticketCacheRepository.findAll());
    }

    @Override
    public TicketCache createTicketCache(TicketCache ticketCache){
        return ticketCacheRepository.save(ticketCache);
    }




}
