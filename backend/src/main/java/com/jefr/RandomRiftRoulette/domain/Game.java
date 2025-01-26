package com.jefr.RandomRiftRoulette.domain;

import com.jefr.RandomRiftRoulette.common.enums.ItemEnum;
import com.jefr.RandomRiftRoulette.common.enums.OutcomeEnum;
import com.jefr.RandomRiftRoulette.common.enums.SummonerSpellsEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Entity
@Table(name = "game")
@Getter
@Setter
@AllArgsConstructor
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private LocalDate playedAt;
    @OneToOne(mappedBy = "game", cascade = CascadeType.ALL)
    private GameStats gameStats;
    @ManyToOne
    private WebsiteUser websiteUser;
    @Enumerated
    private List<ItemEnum> items = new ArrayList<>();

    public Game(LocalDate playedAt, OutcomeEnum outcomeEnum, List<SummonerSpellsEnum> summonerSpells, int kills, int deaths, int assists, int cs, int level, String gameLength, WebsiteUser websiteUser, List<ItemEnum> items) {
        this.playedAt = playedAt;
        this.gameStats = new GameStats(outcomeEnum, summonerSpells, kills, deaths, assists, cs, level, gameLength, this);
        this.websiteUser = websiteUser;
        this.items = items;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", playedAt=" + playedAt +
                ", gameStats=" + gameStats +
                ", websiteUser=" + websiteUser +
                ", items=" + items +
                '}';
    }
}
