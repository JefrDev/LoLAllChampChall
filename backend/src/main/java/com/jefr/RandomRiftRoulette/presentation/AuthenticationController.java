package com.jefr.RandomRiftRoulette.presentation;

import com.jefr.RandomRiftRoulette.application.AuthenticationService;
import com.jefr.RandomRiftRoulette.application.JwtService;
import com.jefr.RandomRiftRoulette.common.dtos.UserJwtResponseDTO;
import com.jefr.RandomRiftRoulette.common.dtos.UserLoginDTO;
import com.jefr.RandomRiftRoulette.common.dtos.UserRegistrationDTO;
import com.jefr.RandomRiftRoulette.domain.WebsiteUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<WebsiteUser> register(@RequestBody UserRegistrationDTO userRegistrationDTO) {
        WebsiteUser registeredUser = authenticationService.signup(userRegistrationDTO);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<UserJwtResponseDTO> authenticate(@RequestBody UserLoginDTO loginUserDto) {
        WebsiteUser authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        UserJwtResponseDTO jwtResponse = new UserJwtResponseDTO(jwtToken);

        return ResponseEntity.ok(jwtResponse);
    }
}
