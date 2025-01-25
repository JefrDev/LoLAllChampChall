package com.jefr.RandomRiftRoulette.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Entity
@Table(name = "game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private Date playedAt;
    @OneToOne(mappedBy = "game", cascade = CascadeType.ALL)
    private GameStats gameStats;
    @ManyToOne
    @JsonIgnore
    private WebsiteUser websiteUser;
    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
    private List<Item> items = new ArrayList<>();
}
