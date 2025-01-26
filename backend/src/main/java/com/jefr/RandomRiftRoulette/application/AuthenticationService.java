package com.jefr.RandomRiftRoulette.application;

import com.jefr.RandomRiftRoulette.common.dtos.UserLoginDTO;
import com.jefr.RandomRiftRoulette.common.dtos.UserRegistrationDTO;
import com.jefr.RandomRiftRoulette.data.WebsiteUserRepo;
import com.jefr.RandomRiftRoulette.domain.WebsiteUser;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final WebsiteUserRepo userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            WebsiteUserRepo userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public WebsiteUser signup(UserRegistrationDTO input) {
        WebsiteUser user = new WebsiteUser(input.username(), input.email(), passwordEncoder.encode(input.password()));

        return userRepository.save(user);
    }

    public WebsiteUser authenticate(UserLoginDTO input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.email(),
                        input.password()
                )
        );

        return userRepository.findByEmail(input.email())
                .orElseThrow();
    }
}
