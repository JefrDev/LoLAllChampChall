package com.jefr.RandomRiftRoulette.common.dtos;

import com.jefr.RandomRiftRoulette.common.enums.ItemEnum;

import java.util.Date;
import java.util.List;

public record AddGameDTO(
        Date playedAt, GameStatsDTO gameStats, List<ItemEnum> items
) {
}
