package com.yasinyazici.riot;

import com.yasinyazici.riot.config.json.impl.SummonerParser;
import com.yasinyazici.riot.data.summoner.Summoner;
import com.yasinyazici.riot.request.web.RequestCreator;
import com.yasinyazici.riot.request.web.RequestType;

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

    public Summoner getSummoner(String region, String summonerName) {
        requestCreator.getRequestProperty().setRequestType(RequestType.GET_SUMMONER_DATA_BY_NAME);
        requestCreator.getRequestProperty().setParameters(region, summonerName);
        return new Summoner(region, new SummonerParser(requestCreator.create().getResponseMessage()).get());
    }
}
