package com.example.gamesmanager.gamesmanager.repositories;

import com.example.gamesmanager.gamesmanager.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, String> {
}
