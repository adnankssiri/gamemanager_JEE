package com.example.gamesmanager.gamesmanager.web;

import com.example.gamesmanager.gamesmanager.dtos.inputDtos.TicketInputDto;
import com.example.gamesmanager.gamesmanager.dtos.outputDtos1.TicketOutputDto;
import com.example.gamesmanager.gamesmanager.services.Ticket.TicketServices;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class TicketGraphqlController {
    private TicketServices ticketServices;

    @MutationMapping
    private TicketOutputDto getTicket(@Argument TicketInputDto ticketInputDto)  {
        return ticketServices.buyTicket(ticketInputDto);
    }

    @MutationMapping
    private void updateTicket(@Argument String id)  {
        ticketServices.validateTicket(id);
    }
}

