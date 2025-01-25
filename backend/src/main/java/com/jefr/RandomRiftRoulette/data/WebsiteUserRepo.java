package com.jefr.RandomRiftRoulette.data;

import com.jefr.RandomRiftRoulette.domain.WebsiteUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface WebsiteUserRepo extends JpaRepository<WebsiteUser, String> {
}
