package com.example.Ticket.controller;

import com.example.Ticket.dto.TicketDto;
import com.example.Ticket.model.TicketCache;
import com.example.Ticket.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ticket")
public class Controller {

    private final TicketService ticketService;

//    @PostMapping
//    public ResponseEntity<TicketDto> createPerson(@RequestBody TicketDto personDto){
//        return ResponseEntity.ok(ticketService.save(personDto));
//    }
    @GetMapping
    public ResponseEntity<List<TicketCache>> getAllTicketCache(){
        return ResponseEntity.ok(ticketService.getAllTicketCache());
    }
    @PostMapping
    public ResponseEntity<TicketCache> createTicketCache(@RequestBody TicketCache ticketCache){
        return ResponseEntity.ok(ticketService.createTicketCache(ticketCache));
    }
}
