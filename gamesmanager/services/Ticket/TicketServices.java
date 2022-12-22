package com.example.gamesmanager.gamesmanager.services.Ticket;

import com.example.gamesmanager.gamesmanager.dtos.inputDtos.TicketInputDto;
import com.example.gamesmanager.gamesmanager.dtos.outputDtos1.TicketOutputDto;


public interface TicketServices {
    TicketOutputDto buyTicket(TicketInputDto ticketInputDto) ;

    void validateTicket(String id) ;
}
