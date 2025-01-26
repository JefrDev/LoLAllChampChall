package com.jefr.RandomRiftRoulette.application;

import com.jefr.RandomRiftRoulette.common.dtos.AddGameDTO;
import com.jefr.RandomRiftRoulette.data.GameRepo;
import com.jefr.RandomRiftRoulette.domain.Game;
import com.jefr.RandomRiftRoulette.domain.WebsiteUser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor

@Service
public class GameService {
    private final GameRepo gamerepo;
    private final JwtService jwtService;


    public List<Game> getMyGames() {
        WebsiteUser websiteUser = jwtService.getUserFromJWT();

        return gamerepo.findAllByWebsiteUserDisplayName(websiteUser.getDisplayName());
    }

    public Game addGame(AddGameDTO addGameDTO){
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
        return gamerepo.save(game);
    }
}
