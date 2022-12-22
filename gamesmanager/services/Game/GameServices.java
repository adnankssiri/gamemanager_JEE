package com.example.gamesmanager.gamesmanager.services.Game;

import com.example.gamesmanager.gamesmanager.dtos.inputDtos.GameInputDto;
import com.example.gamesmanager.gamesmanager.dtos.outputDtos1.GameOutputDto;


import java.util.List;

public interface GameServices {
    GameOutputDto createGame(GameInputDto gameInputDto);
    List<GameOutputDto> gamesList();
}
