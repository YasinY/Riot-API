package com.yasinyazici.riot.data.summoner;

import com.yasinyazici.riot.LeagueAPI;
import com.yasinyazici.riot.data.exceptions.DataException;
import com.yasinyazici.riot.data.exceptions.ReplyException;
import com.yasinyazici.riot.data.exceptions.WrongRequestFormatException;
import com.yasinyazici.riot.parsers.impl.*;
import com.yasinyazici.riot.data.championmastery.ChampionMastery;
import com.yasinyazici.riot.data.game.Season;
import com.yasinyazici.riot.data.summoner.ranked.ChampionStatsRanked;
import com.yasinyazici.riot.data.summoner.ranked.league.LeagueEntry;
import com.yasinyazici.riot.data.summoner.runes.RunePages;
import com.yasinyazici.riot.request.types.impl.ApiRequestType;
import com.yasinyazici.riot.request.types.impl.RegionalRequestType;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Yasin on 08.12.2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class Summoner extends LeagueAPI {

    private String region;

    private final SummonerProperties summonerProperties;

    public Summoner(String region, SummonerProperties summonerProperties) {
        this.region = region;
        this.summonerProperties = summonerProperties;
    }

    public ChampionMastery getChampionMastery(String championId) throws Exception {
        requestCreator.getRequestProperty().setRequestType(RegionalRequestType.GET_CHAMPION_MASTERY);
        requestCreator.getRequestProperty().setParameters(region, getPlatformId(region), summonerProperties.getId(), championId);
        return new ChampionMasteryParser(requestCreator.create().getResponseMessage()).get();
    }

    public Map<String, RunePages> getRunes() throws DataException, WrongRequestFormatException, ReplyException, IOException {
        requestCreator.getRequestProperty().setRequestType(ApiRequestType.GET_SUMMONER_RUNES_BY_ID);
        requestCreator.getRequestProperty().setParameters(region, summonerProperties.getId());
        return new RunesParser(requestCreator.create().getResponseMessage()).get();
    }

    public ChampionStatsRanked getChampionStatsRanked(Season season) throws Exception {
        requestCreator.getRequestProperty().setRequestType(ApiRequestType.GET_CHAMPION_STATS_BY_SUMMONER_ID);
        requestCreator.getRequestProperty().setParameters(region, summonerProperties.getId(), season.getSeasonName());
        return new ChampionStatsRankedParser(requestCreator.create().getResponseMessage()).get();
    }
    public LeagueEntry getLeagueEntry(String queue) throws Exception {
        requestCreator.getRequestProperty().setRequestType(ApiRequestType.GET_LEAGUE_ENTRY_BY_SUMMONER_ID);
        requestCreator.getRequestProperty().setParameters(region, summonerProperties.getId());
        return new LeagueEntryParser(requestCreator.create().getResponseMessage()).getFirstLeagueEntry();
    }

    public SummonerProperties getSummonerProperties() {
        return summonerProperties;
    }

    public String getRegion() {
        return region;
    }

}
