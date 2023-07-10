package com.example.Ticket.repository;

import com.example.Ticket.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketPerository extends JpaRepository<Ticket,Integer>{
}
