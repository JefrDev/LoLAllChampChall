package com.jefr.RandomRiftRoulette.application;

import com.jefr.RandomRiftRoulette.data.WebsiteUserRepo;
import com.jefr.RandomRiftRoulette.domain.WebsiteUser;
import com.jefr.RandomRiftRoulette.dtos.UserOutputDTO;
import com.jefr.RandomRiftRoulette.dtos.UserRegistrationDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final WebsiteUserRepo userRepo;

    public UserOutputDTO registerUser(UserRegistrationDTO userRegistrationDTO) {
        WebsiteUser user = new WebsiteUser(userRegistrationDTO.username(), userRegistrationDTO.email(), userRegistrationDTO.password());
        user = userRepo.save(user);

        return userToUserOutputDTO(user);
    }

    public UserOutputDTO userToUserOutputDTO(WebsiteUser user) {
        return new UserOutputDTO(user.getUserName(), user.getEmail());
    }
}
