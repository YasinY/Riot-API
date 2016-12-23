package com.yasinyazici.riot;

import com.yasinyazici.riot.data.champion.impl.ChampionImage;
import com.yasinyazici.riot.parsers.impl.*;
import com.yasinyazici.riot.data.activegame.CurrentGameInfo;
import com.yasinyazici.riot.data.champion.ChampionStats;
import com.yasinyazici.riot.data.championmastery.ChampionMastery;
import com.yasinyazici.riot.data.exceptions.PropertyNotFound;
import com.yasinyazici.riot.data.game.Season;
import com.yasinyazici.riot.data.summoner.Summoner;
import com.yasinyazici.riot.data.summoner.masteries.Masteries;
import com.yasinyazici.riot.data.summoner.ranked.ChampionStatsRanked;
import com.yasinyazici.riot.data.summoner.ranked.league.LeagueEntry;
import com.yasinyazici.riot.data.summoner.runes.Runes;
import com.yasinyazici.riot.request.types.impl.ApiRequestType;
import com.yasinyazici.riot.request.types.impl.GlobalRequestType;
import com.yasinyazici.riot.request.types.impl.RegionalRequestType;
import com.yasinyazici.riot.request.web.RequestCreator;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Yasin on 17.12.2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class LeagueAPI {

    protected RequestCreator requestCreator;


    public LeagueAPI() {
        requestCreator = new RequestCreator();
    }

    public synchronized String[] getGameVersions(String region) throws Exception {
        requestCreator.getRequestProperty().setRequestType(GlobalRequestType.GET_GAME_VERSIONS);
        requestCreator.getRequestProperty().setParameters(region);
        return new GameVersionParser(requestCreator.create().getResponseMessage()).get();
    }
    public synchronized String getLatestGameVersion(String region) throws Exception {
        requestCreator.getRequestProperty().setRequestType(GlobalRequestType.GET_GAME_VERSIONS);
        requestCreator.getRequestProperty().setParameters(region);
        return new GameVersionParser(requestCreator.create().getResponseMessage()).get()[0];
    }

    public synchronized ChampionMastery getChampionMastery(String region, long summonerId, long championId) throws Exception {
        requestCreator.getRequestProperty().setRequestType(RegionalRequestType.GET_CHAMPION_MASTERY);
        requestCreator.getRequestProperty().setParameters(region, getPlatformId(region), summonerId, championId);
        return new ChampionMasteryParser(requestCreator.create().getResponseMessage()).get();
    }

    public synchronized List<ChampionMastery> getChampionMasteries(String region, long summonerId) throws Exception {
        requestCreator.getRequestProperty().setRequestType(RegionalRequestType.GET_ALL_CHAMPION_MASTERIES);
        requestCreator.getRequestProperty().setParameters(region, getPlatformId(region), summonerId);
        return new ChampionMasteriesParser(requestCreator.create().getResponseMessage()).get();
    }
    public synchronized Summoner getSummoner(String region, String summonerName) throws Exception {
        requestCreator.getRequestProperty().setRequestType(ApiRequestType.GET_SUMMONER_DATA_BY_NAMES);
        requestCreator.getRequestProperty().setParameters(region, summonerName);
        return new Summoner(region, new SummonerPropertiesParser(requestCreator.create().getResponseMessage()).getFirstSummoner());
    }

    public synchronized List<Summoner> getSummoners(String region, String... summonerNames) throws Exception {
        requestCreator.getRequestProperty().setRequestType(ApiRequestType.GET_SUMMONER_DATA_BY_NAMES);
        requestCreator.getRequestProperty().setParameters(region, summonerNames);
        return new SummonerPropertiesParser(requestCreator.create().getResponseMessage()).get().entrySet().stream().map(p -> new Summoner(region, p.getValue())).collect(Collectors.toList());
    }

    public synchronized ChampionStats getChampionInfo(String region, long championId) throws Exception {
        requestCreator.getRequestProperty().setRequestType(GlobalRequestType.GET_CHAMPION_INFO_BY_CHAMPION_ID);
        requestCreator.getRequestProperty().setParameters(region, championId);
        return new ChampionInfoParser(requestCreator.create().getResponseMessage()).get();
    }

    public synchronized ChampionImage getChampionImage(String region, long championId) throws Exception {
        requestCreator.getRequestProperty().setRequestType(GlobalRequestType.GET_CHAMPION_IMAGE_BY_CHAMPION_ID);
        requestCreator.getRequestProperty().setParameters(region, championId);
        return new ChampionImageParser(requestCreator.create().getResponseMessage()).get();
    }

    public synchronized CurrentGameInfo getActiveGame(String region, long summonerId) throws Exception {
        requestCreator.getRequestProperty().setRequestType(RegionalRequestType.GET_CURRENT_GAME);
        requestCreator.getRequestProperty().setParameters(region, getPlatformId(region), summonerId);
        return new CurrentGameInfoParser(requestCreator.create().getResponseMessage()).get();
    }

    public synchronized ChampionStatsRanked getChampionStatsRanked(String region, long summonerId, Season season) throws Exception {
        requestCreator.getRequestProperty().setRequestType(ApiRequestType.GET_CHAMPION_STATS_BY_SUMMONER_ID);
        requestCreator.getRequestProperty().setParameters(region, summonerId, season.getSeasonName());
        return new ChampionStatsRankedParser(requestCreator.create().getResponseMessage()).get();
    }
    public synchronized Map<String, List<LeagueEntry>> getLeagueEntries(String region, long  summonerId) throws Exception {
        requestCreator.getRequestProperty().setRequestType(ApiRequestType.GET_LEAGUE_ENTRY_BY_SUMMONER_ID);
        requestCreator.getRequestProperty().setParameters(region, summonerId);
        return new LeagueEntryParser(requestCreator.create().getResponseMessage()).get();
    }
    public synchronized LeagueEntry getLeagueEntry(String region, long summonerId) throws Exception {
        requestCreator.getRequestProperty().setRequestType(ApiRequestType.GET_LEAGUE_ENTRY_BY_SUMMONER_ID);
        requestCreator.getRequestProperty().setParameters(region, summonerId);
        return new LeagueEntryParser(requestCreator.create().getResponseMessage()).getFirstLeagueEntry();
    }
    public synchronized Masteries getMasteries(String region, long summonerId) throws Exception {
        requestCreator.getRequestProperty().setRequestType(ApiRequestType.GET_SUMMONER_MASTERIES_BY_IDS);
        requestCreator.getRequestProperty().setParameters(region, summonerId);
        return new MasteriesParser(requestCreator.create().getResponseMessage()).get();
    }
    public synchronized Runes getRunes(String region, long summonerId) throws Exception {
        requestCreator.getRequestProperty().setRequestType(ApiRequestType.GET_SUMMONER_RUNES_BY_ID);
        requestCreator.getRequestProperty().setParameters(region, summonerId);
        return new RunesParser(requestCreator.create().getResponseMessage()).get();
    }


    public synchronized String getPlatformId(String region) throws PropertyNotFound {
        switch (region) {
            case "na":
                return "NA1";
            case "euw":
                return "EUW1";
            case "eune":
                return "EUN1";
            case "jp":
                return "JP1";
            case "kr":
                return "KR";
            case "oce":
                return "OC1";
            case "br":
                return "BR1";
            case "lan":
                return "LA1";
            case "las":
                return "LA2";
            case "ru":
                return "RU";
            case "tr":
                return "TR1";
            default:
                throw new PropertyNotFound("Property not found");
        }
    }
}
