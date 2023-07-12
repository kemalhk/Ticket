package com.example.Ticket.repository;

import com.example.Ticket.model.Ticket;
import com.example.Ticket.model.TicketCache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TicketCacheRepository extends CrudRepository<TicketCache,Integer> {
}
