package com.example.gamesmanager.gamesmanager.services.Ticket;

import com.example.gamesmanager.gamesmanager.dtos.inputDtos.TicketInputDto;
import com.example.gamesmanager.gamesmanager.dtos.outputDtos1.TicketOutputDto;
import com.example.gamesmanager.gamesmanager.entities.Game;
import com.example.gamesmanager.gamesmanager.entities.Ticket;
import com.example.gamesmanager.gamesmanager.enums.TicketState;
import com.example.gamesmanager.gamesmanager.mappers.MapperService;
import com.example.gamesmanager.gamesmanager.repositories.GameRepository;
import com.example.gamesmanager.gamesmanager.repositories.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class TicketServicesImpl implements TicketServices {
    private TicketRepository ticketRepository;
    private MapperService mapperService;
    private GameRepository gameRepository;

    @Override
    public TicketOutputDto buyTicket(TicketInputDto ticketInputDto)  {
        if (ticketInputDto.getGameId() == null || ticketInputDto.getGameId().isEmpty()
                || ticketInputDto.getPrice().isNaN() || ticketInputDto.getPrice() <= 0)
            throw new RuntimeException("champs invalide");
        Game game = gameRepository.findById(ticketInputDto.getGameId())
                .orElseThrow(
                        () -> new RuntimeException("champ invalide")
                );
        if (game.getAvailableTicketNumber() == 0)
            throw new RuntimeException("plus de tickets!");
        Ticket ticket = new Ticket();
        ticket.setId(UUID.randomUUID().toString());
        ticket.setPrice(ticketInputDto.getPrice());
        ticket.setState(TicketState.ENABLED);
        ticket.setRef(UUID.randomUUID().toString().substring(0,16));
        ticket.setGame(game);

        game.setAvailableTicketNumber(game.getAvailableTicketNumber() - 1);
        gameRepository.save(game);
        return mapperService.fromTicket(ticketRepository.save(ticket));
    }

    @Override
    public void validateTicket(String id){
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("oui"));
        if (ticket.getState() == TicketState.DISABLED)
            throw new RuntimeException("non");
        //Do not validate ticket until the day of the game
        ticket.setState(TicketState.DISABLED);
        ticketRepository.save(ticket);
    }
}
