package com.jefr.RandomRiftRoulette.domain;

import com.jefr.RandomRiftRoulette.common.enums.ItemEnum;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private ItemEnum itemEnum;
    @ManyToOne
    private Game game;
}
