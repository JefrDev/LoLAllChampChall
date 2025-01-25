package com.jefr.RandomRiftRoulette.presentation;

import com.jefr.RandomRiftRoulette.application.UserService;
import com.jefr.RandomRiftRoulette.dtos.UserOutputDTO;
import com.jefr.RandomRiftRoulette.dtos.UserRegistrationDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


@Slf4j
@RequestMapping("/user")
@RestController
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public UserOutputDTO registerUser(@RequestBody UserRegistrationDTO userRegistrationDTO) {
        try{
            System.out.println(userRegistrationDTO);
            return userService.registerUser(userRegistrationDTO);
        } catch (Exception e) {
            HttpStatus errorCode = HttpStatus.INTERNAL_SERVER_ERROR;
            log.error(String.format("error occured with errorcode %s. :%s", errorCode, e));
            throw new ResponseStatusException(errorCode, e.getMessage());
        }
    }
}
