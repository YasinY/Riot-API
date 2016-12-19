package com.yasinyazici.riot;

import com.yasinyazici.riot.config.Config;
import com.yasinyazici.riot.config.json.impl.*;
import com.yasinyazici.riot.data.activegame.CurrentGameInfo;
import com.yasinyazici.riot.data.champion.ChampionInfo;
import com.yasinyazici.riot.data.championmastery.ChampionMastery;
import com.yasinyazici.riot.data.exceptions.PropertyNotFound;
import com.yasinyazici.riot.data.summoner.Summoner;
import com.yasinyazici.riot.data.summoner.runes.Runes;
import com.yasinyazici.riot.request.types.ApiRequestType;
import com.yasinyazici.riot.request.types.GlobalRequestType;
import com.yasinyazici.riot.request.types.RegionalRequestType;
import com.yasinyazici.riot.request.web.RequestCreator;

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
    synchronized Summoner getSummoner(String region, String summonerName) throws Exception {
        requestCreator.getRequestProperty().setRequestType(ApiRequestType.GET_SUMMONER_DATA_BY_NAME);
        requestCreator.getRequestProperty().setParameters(region, summonerName);
        return new Summoner(region, new SummonerParser(requestCreator.create().getResponseMessage()).get());
    }

    synchronized ChampionInfo getChampionInfo(String region, long championId) throws Exception {
        requestCreator.getRequestProperty().setRequestType(GlobalRequestType.GET_CHAMPION_DATA_BY_CHAMPION_ID);
        requestCreator.getRequestProperty().setParameters(region, championId);
        return new ChampionInfoParser(requestCreator.create().getResponseMessage()).get();
    }
    synchronized CurrentGameInfo getActiveGame(String region, long summonerId) throws Exception {
        requestCreator.getRequestProperty().setRequestType(RegionalRequestType.GET_CURRENT_GAME);
        requestCreator.getRequestProperty().setParameters(region, Config.getPlatformId(region), summonerId);
        return new CurrentGameInfoParser(requestCreator.create().getResponseMessage()).get();
    }

}
