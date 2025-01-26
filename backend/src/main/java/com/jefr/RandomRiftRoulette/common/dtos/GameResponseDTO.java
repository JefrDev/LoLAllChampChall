package com.jefr.RandomRiftRoulette.common.dtos;

import com.jefr.RandomRiftRoulette.common.enums.ItemEnum;
import com.jefr.RandomRiftRoulette.common.enums.OutcomeEnum;
import com.jefr.RandomRiftRoulette.common.enums.SummonerSpellsEnum;

import java.time.LocalDate;
import java.util.List;

public record GameResponseDTO(
        Long id,
        LocalDate playedAt,
        OutcomeEnum outcome,
        List<SummonerSpellsEnum> summonerSpells,
        int kills,
        int deaths,
        int assists,
        int cs,
        int level,
        String gameTime,
        List<ItemEnum> items
) {}
