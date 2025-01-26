package com.jefr.RandomRiftRoulette.application;

import com.jefr.RandomRiftRoulette.data.GameRepo;
import com.jefr.RandomRiftRoulette.domain.Game;
import com.jefr.RandomRiftRoulette.domain.WebsiteUser;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
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
}
