package com.jefr.RandomRiftRoulette.domain;

import com.jefr.RandomRiftRoulette.common.enums.OutcomeEnum;
import com.jefr.RandomRiftRoulette.common.enums.SummonerSpellsEnum;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@NoArgsConstructor
@Entity
public class GameStats {
    @Id
    private long id;
    private OutcomeEnum outcome;
    private SummonerSpellsEnum summonerSpells;
    private int kills;
    private int deaths;
    private int assists;
    private int cs;
    private int level;
    private LocalTime gameTime;
    @OneToOne
    @MapsId
    @JoinColumn(name = "game_id")
    private Game game;
}
