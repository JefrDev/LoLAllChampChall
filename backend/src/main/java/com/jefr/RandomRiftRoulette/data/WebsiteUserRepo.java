package com.jefr.RandomRiftRoulette.data;

import com.jefr.RandomRiftRoulette.domain.WebsiteUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
    public interface WebsiteUserRepo extends JpaRepository<WebsiteUser, String> {
        Optional<WebsiteUser> findByEmail(String email);
}
