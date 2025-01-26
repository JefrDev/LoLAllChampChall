package com.jefr.RandomRiftRoulette.presentation;

import com.jefr.RandomRiftRoulette.domain.WebsiteUser;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@NoArgsConstructor
@RequestMapping("/user")
public class WebsiteUserController {

    @GetMapping("/me")
    public ResponseEntity<WebsiteUser> getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        WebsiteUser user = (WebsiteUser) authentication.getPrincipal();

        return ResponseEntity.ok(user);
    }
}
