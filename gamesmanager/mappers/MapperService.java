package com.example.gamesmanager.gamesmanager.mappers;

import com.example.gamesmanager.gamesmanager.dtos.outputDtos1.GameOutputDto;
import com.example.gamesmanager.gamesmanager.dtos.outputDtos1.TicketOutputDto;
import com.example.gamesmanager.gamesmanager.entities.Game;
import com.example.gamesmanager.gamesmanager.entities.Ticket;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class MapperService {
    public GameOutputDto fromGame(Game game){
        GameOutputDto gameOutputDto = new GameOutputDto();
        BeanUtils.copyProperties(game, gameOutputDto);
        return  gameOutputDto;
    }

    public TicketOutputDto fromTicket(Ticket ticket){
        TicketOutputDto ticketOutputDto = new TicketOutputDto();
        BeanUtils.copyProperties(ticket, ticketOutputDto);
        ticketOutputDto.setGameOutputDto(this.fromGame(ticket.getGame()));
        return ticketOutputDto;
    }
}
