package com.yasinyazici.riot.data.summoner;

import com.yasinyazici.riot.LeagueAPI;
import com.yasinyazici.riot.config.Config;
import com.yasinyazici.riot.config.json.impl.ChampionMasteryParser;
import com.yasinyazici.riot.config.json.impl.MasteriesParser;
import com.yasinyazici.riot.config.json.impl.RunesParser;
import com.yasinyazici.riot.data.championmastery.ChampionMastery;
import com.yasinyazici.riot.data.summoner.masteries.Masteries;
import com.yasinyazici.riot.data.summoner.runes.Runes;
import com.yasinyazici.riot.request.types.ApiRequestType;
import com.yasinyazici.riot.request.types.RegionalRequestType;

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

    public Masteries getMasteries() throws Exception {
        requestCreator.getRequestProperty().setRequestType(ApiRequestType.GET_SUMMONER_MASTERIES_BY_ID);
        requestCreator.getRequestProperty().setParameters(region, summonerProperties.getId());
        return new MasteriesParser(requestCreator.create().getResponseMessage()).get();
    }
    public Runes getRunes() throws Exception {
        requestCreator.getRequestProperty().setRequestType(ApiRequestType.GET_SUMMONER_RUNES_BY_ID);
        requestCreator.getRequestProperty().setParameters(region, summonerProperties.getId());
        return new RunesParser(requestCreator.create().getResponseMessage()).get();
    }

    public SummonerProperties getSummonerProperties() {
        return summonerProperties;
    }

    public String getRegion() {
        return region;
    }

}
