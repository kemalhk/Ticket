package com.example.Ticket.controller;

import com.example.Ticket.dto.TicketDto;
import com.example.Ticket.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ticket")
public class Controller {

    private final TicketService ticketService;

    @PostMapping
    public ResponseEntity<TicketDto> createPerson(@RequestBody TicketDto personDto){
        return ResponseEntity.ok(ticketService.save(personDto));
    }
}
