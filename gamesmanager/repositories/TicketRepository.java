package com.example.gamesmanager.gamesmanager.repositories;

import com.example.gamesmanager.gamesmanager.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, String> {
}