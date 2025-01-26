package com.jefr.RandomRiftRoulette.data;

import com.jefr.RandomRiftRoulette.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepo extends JpaRepository<Game, Long> {

    List<Game> findAllByWebsiteUserDisplayName(String displayName);
}
