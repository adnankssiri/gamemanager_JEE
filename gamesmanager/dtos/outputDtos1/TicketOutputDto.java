package com.example.gamesmanager.gamesmanager.dtos.outputDtos1;

import com.example.gamesmanager.gamesmanager.enums.TicketState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketOutputDto {
    private String id;
    private Double price;
    private TicketState state;
    private String ref;
    private com.example.gamesmanager.gamesmanager.dtos.outputDtos1.GameOutputDto gameOutputDto;
}
