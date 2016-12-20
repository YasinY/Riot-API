package com.yasinyazici.riot;

import com.yasinyazici.riot.config.json.impl.*;
import com.yasinyazici.riot.data.activegame.CurrentGameInfo;
import com.yasinyazici.riot.data.champion.ChampionInfo;
import com.yasinyazici.riot.data.championmastery.ChampionMastery;
import com.yasinyazici.riot.data.exceptions.PropertyNotFound;
import com.yasinyazici.riot.data.summoner.Summoner;
import com.yasinyazici.riot.data.summoner.SummonerProperties;
import com.yasinyazici.riot.data.summoner.ranked.LeagueEntry;
import com.yasinyazici.riot.request.types.impl.ApiRequestType;
import com.yasinyazici.riot.request.types.impl.GlobalRequestType;
import com.yasinyazici.riot.request.types.impl.RegionalRequestType;
import com.yasinyazici.riot.request.web.RequestCreator;
import com.yasinyazici.riot.utilities.ArrayUtils;

import java.util.Map;
import java.util.stream.Stream;

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

    synchronized String getLatestGameVersion(String region) throws Exception {
        requestCreator.getRequestProperty().setRequestType(GlobalRequestType.GET_GAME_VERSIONS);
        requestCreator.getRequestProperty().setParameters(region);
        return new GameVersionParser(requestCreator.create().getResponseMessage()).get()[0];
    }

    synchronized ChampionMastery getChampionMastery(String region, long summonerId, long championId) throws Exception {
        requestCreator.getRequestProperty().setRequestType(RegionalRequestType.GET_CHAMPION_MASTERY);
        requestCreator.getRequestProperty().setParameters(region, getPlatformId(region), summonerId, championId);
        return new ChampionMasteryParser(requestCreator.create().getResponseMessage()).get();
    }
    synchronized Summoner getSummoner(String region, String summonerName) throws Exception {
        requestCreator.getRequestProperty().setRequestType(ApiRequestType.GET_SUMMONER_DATA_BY_NAMES);
        requestCreator.getRequestProperty().setParameters(region, summonerName);
        return new Summoner(region, new SummonerPropertiesParser(requestCreator.create().getResponseMessage()).getFirstSummoner());
    }

    synchronized Stream<SummonerProperties> getSummoners(String region, String[] summonerNames) throws Exception {
        requestCreator.getRequestProperty().setRequestType(ApiRequestType.GET_SUMMONER_DATA_BY_NAMES);
        requestCreator.getRequestProperty().setParameters(region, summonerNames);
        return new SummonerPropertiesParser(requestCreator.create().getResponseMessage()).get().values().stream();
    }

    synchronized ChampionInfo getChampionInfo(String region, long championId) throws Exception {
        requestCreator.getRequestProperty().setRequestType(GlobalRequestType.GET_CHAMPION_DATA_BY_CHAMPION_ID);
        requestCreator.getRequestProperty().setParameters(region, championId);
        return new ChampionInfoParser(requestCreator.create().getResponseMessage()).get();
    }
    synchronized CurrentGameInfo getActiveGame(String region, long summonerId) throws Exception {
        requestCreator.getRequestProperty().setRequestType(RegionalRequestType.GET_CURRENT_GAME);
        requestCreator.getRequestProperty().setParameters(region, getPlatformId(region), summonerId);
        return new CurrentGameInfoParser(requestCreator.create().getResponseMessage()).get();
    }

    synchronized LeagueEntry getLeagueEntry(String region, long summonerId) throws Exception {
        requestCreator.getRequestProperty().setRequestType(ApiRequestType.GET_LEAGUE_ENTRY_BY_SUMMONER_ID);
        requestCreator.getRequestProperty().setParameters(region, summonerId);
        return new LeagueEntryParser(requestCreator.create().getResponseMessage()).getFirstLeagueEntry();
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
