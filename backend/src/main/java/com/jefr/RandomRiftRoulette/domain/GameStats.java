package com.jefr.RandomRiftRoulette.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jefr.RandomRiftRoulette.common.enums.OutcomeEnum;
import com.jefr.RandomRiftRoulette.common.enums.SummonerSpellsEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.List;

@NoArgsConstructor
@Entity

@Getter
@Setter
@AllArgsConstructor
public class GameStats {
    @Id
    private Long id;
    private OutcomeEnum outcome;
    @Enumerated
    private List<SummonerSpellsEnum> summonerSpells;
    private int kills;
    private int deaths;
    private int assists;
    private int cs;
    private int level;
    private String gameTime;
    @OneToOne
    @MapsId
    @JoinColumn(name = "game_id")
    @JsonIgnore
    private Game game;

    public GameStats(OutcomeEnum outcome, List<SummonerSpellsEnum> summonerSpells, int kills, int deaths, int assists, int cs, int level, String gameTime, Game game) {
        this.outcome = outcome;
        this.summonerSpells = summonerSpells;
        this.kills = kills;
        this.deaths = deaths;
        this.assists = assists;
        this.cs = cs;
        this.level = level;
        this.gameTime = gameTime;
        this.game = game;
    }

    @Override
    public String toString() {
        return "GameStats{" +
                "id=" + id +
                ", outcome=" + outcome +
                ", summonerSpells=" + summonerSpells +
                ", kills=" + kills +
                ", deaths=" + deaths +
                ", assists=" + assists +
                ", cs=" + cs +
                ", level=" + level +
                ", gameTime='" + gameTime + '\'' +
                ", game=" + game +
                '}';
    }
}
