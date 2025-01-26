package com.jefr.RandomRiftRoulette.data;

import com.jefr.RandomRiftRoulette.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepo extends JpaRepository<Game, Long> {

    List<Game> findAllByWebsiteUserDisplayName(String displayName);
}
