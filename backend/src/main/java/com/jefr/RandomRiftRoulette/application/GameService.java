package com.jefr.RandomRiftRoulette.application;

import com.jefr.RandomRiftRoulette.common.dtos.AddGameDTO;
import com.jefr.RandomRiftRoulette.common.dtos.GameResponseDTO;
import com.jefr.RandomRiftRoulette.data.GameRepo;
import com.jefr.RandomRiftRoulette.domain.Game;
import com.jefr.RandomRiftRoulette.domain.WebsiteUser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor

@Service
public class GameService {
    private final GameRepo gamerepo;
    private final JwtService jwtService;


    public List<GameResponseDTO> getMyGames() {
        WebsiteUser websiteUser = jwtService.getUserFromJWT();

        List<Game> games = gamerepo.findAllByWebsiteUserDisplayName(websiteUser.getDisplayName());
        return convertGameToDTO(games);
    }

    public GameResponseDTO addGame(AddGameDTO addGameDTO){
        WebsiteUser websiteUser = jwtService.getUserFromJWT();

        Game game = new Game(
                addGameDTO.playedAt(),
                addGameDTO.gameStats().outcome(),
                addGameDTO.gameStats().summonerSpells(),
                addGameDTO.gameStats().kills(),
                addGameDTO.gameStats().deaths(),
                addGameDTO.gameStats().assists(),
                addGameDTO.gameStats().cs(),
                addGameDTO.gameStats().level(),
                addGameDTO.gameStats().matchLength(),
                websiteUser,
                addGameDTO.items()
        );
        game = gamerepo.save(game);
        return convertGameToDTO(game);
    }

    public GameResponseDTO convertGameToDTO(Game game) {
        return new GameResponseDTO(
                game.getId(),
                game.getGameStats().getGame().getPlayedAt(),
                game.getGameStats().getOutcome(),
                game.getGameStats().getSummonerSpells(),
                game.getGameStats().getKills(),
                game.getGameStats().getDeaths(),
                game.getGameStats().getAssists(),
                game.getGameStats().getCs(),
                game.getGameStats().getLevel(),
                game.getGameStats().getGameTime(),
                game.getItems()
                );
    }
    public List<GameResponseDTO> convertGameToDTO(List<Game> games) {
        List<GameResponseDTO> gameDTOS = new ArrayList<>();
        for(Game game : games) {
            gameDTOS.add(new GameResponseDTO(
                    game.getId(),
                    game.getGameStats().getGame().getPlayedAt(),
                    game.getGameStats().getOutcome(),
                    game.getGameStats().getSummonerSpells(),
                    game.getGameStats().getKills(),
                    game.getGameStats().getDeaths(),
                    game.getGameStats().getAssists(),
                    game.getGameStats().getCs(),
                    game.getGameStats().getLevel(),
                    game.getGameStats().getGameTime(),
                    game.getItems()
            ));
        }
        return gameDTOS;
    }
}
