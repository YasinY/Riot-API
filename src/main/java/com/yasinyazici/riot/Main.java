package com.yasinyazici.riot;

import com.yasinyazici.riot.config.json.impl.CurrentGameInfoParser;
import com.yasinyazici.riot.config.json.impl.RunesParser;
import com.yasinyazici.riot.config.json.impl.SummonerPropertiesParser;
import com.yasinyazici.riot.data.activegame.CurrentGameInfo;
import com.yasinyazici.riot.data.summoner.SummonerProperties;
import com.yasinyazici.riot.data.summoner.runes.Rune;
import com.yasinyazici.riot.data.summoner.runes.RunePage;
import com.yasinyazici.riot.data.summoner.runes.Runes;
import com.yasinyazici.riot.request.web.RequestCreator;
import com.yasinyazici.riot.request.web.RequestProperty;
import com.yasinyazici.riot.request.web.RequestReply;
import com.yasinyazici.riot.request.web.RequestType;

/**
 * Created by Yasin on 09/02/2016.
 */
public class Main {

    public static void main(String[] args) {
        RequestCreator requestCreator = new RequestCreator(new RequestProperty(RequestType.GET_SUMMONER_DATA_BY_NAME, "euw", "VitamZ"));
        RequestReply reply = requestCreator.create();
        SummonerProperties summonerProperties = new SummonerPropertiesParser(reply.getResponseMessage()).get();
        requestCreator.getRequestProperty().setRequestType(RequestType.GET_SUMMONER_RUNES_BY_ID);
        requestCreator.getRequestProperty().setParameters("euw", String.valueOf(summonerProperties.getId()));
        Runes runes = new RunesParser(requestCreator.create().getResponseMessage()).get();
        for(RunePage runePage : runes.getPages()) {
            System.out.println("runepage name: " + runePage.getName());
            System.out.println("runepage id: " + runePage.getId());
            for(Rune rune : runePage.getSlots()) {
                System.out.println("Runeid: " + rune.getRuneId());
                System.out.println("Rune slot id: " + rune.getRuneSlotId());
            }
        }
        requestCreator.getRequestProperty().setRequestType(RequestType.GET_CURRENT_GAME);
        requestCreator.getRequestProperty().setParameters("euw", "EUW1", String.valueOf(summonerProperties.getId()));
        CurrentGameInfo currentGameInfo = new CurrentGameInfoParser(requestCreator.create().getResponseMessage()).get();
    }

}
