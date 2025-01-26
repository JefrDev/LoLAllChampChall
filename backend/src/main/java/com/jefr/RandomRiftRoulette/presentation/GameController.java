package com.jefr.RandomRiftRoulette.presentation;


import com.jefr.RandomRiftRoulette.application.GameService;
import com.jefr.RandomRiftRoulette.domain.Game;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@AllArgsConstructor
@Slf4j

@RequestMapping("/game")
@RestController
public class GameController { private final GameService gameService;

    @GetMapping("")
    public ResponseEntity<List<Game>> getMyGames() {
        try{
            return ResponseEntity.ok(gameService.getMyGames());
        } catch (Exception e) {
            HttpStatus statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            log.error(String.format("error with statuscode %s occurred: %s", statusCode, e));
            throw new ResponseStatusException(statusCode, e.getMessage());
        }
    }

//    @PostMapping("")
//    public ResponseEntity<Game> addGame() {
//        try{
//
//        } catch (Exception e) {
//            HttpStatus statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
//            log.error(String.format("error with statuscode %s occurred: %s", statusCode, e));
//            throw new ResponseStatusException(statusCode, e.getMessage());
//        }
//    }
}
