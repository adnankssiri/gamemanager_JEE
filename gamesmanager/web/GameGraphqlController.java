package com.example.gamesmanager.gamesmanager.web;

import com.example.gamesmanager.gamesmanager.dtos.inputDtos.GameInputDto;
import com.example.gamesmanager.gamesmanager.dtos.outputDtos1.GameOutputDto;
import com.example.gamesmanager.gamesmanager.services.Game.GameServices;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class GameGraphqlController {
    private GameServices gameServices;

    @MutationMapping
    private GameOutputDto addGame(@Argument GameInputDto gameInputDto) {
        return gameServices.createGame(gameInputDto);
    }

    @QueryMapping
    private List<GameOutputDto> getGames(){
        return gameServices.gamesList();
    }
}
