package com.jefr.RandomRiftRoulette.common.dtos;

import com.jefr.RandomRiftRoulette.common.enums.OutcomeEnum;
import com.jefr.RandomRiftRoulette.common.enums.SummonerSpellsEnum;

import java.util.List;

public record GameStatsDTO(
        OutcomeEnum outcome,
        List<SummonerSpellsEnum> summonerSpells,
        int kills,
        int deaths,
        int assists,
        int cs,
        int level,
        String matchLength
) {}
