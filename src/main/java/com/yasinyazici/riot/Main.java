package com.yasinyazici.riot;

import com.yasinyazici.riot.config.json.impl.SummonerPropertiesParser;
import com.yasinyazici.riot.data.summoner.SummonerProperties;
import com.yasinyazici.riot.data.summoner.runes.Runes;
import com.yasinyazici.riot.request.web.*;

/**
 * Created by Yasin on 09/02/2016.
 */
public class Main {

    public static void main(String[] args) {
        RequestCreator requestCreator = new RequestCreator(new RequestProperty(RequestType.GET_SUMMONER_DATA_BY_NAME, RequestRegion.EUROPE_WEST, "jungle ís life"));
        RequestReply reply = requestCreator.create();
        SummonerProperties summonerProperties = new SummonerPropertiesParser(reply.getResponseMessage()).get();
        //System.out.println(summonerProperties.getName());
        //System.out.println(Response.verifyResponse(reply.getResponseCode()));
        // Summoner summoner =
    }

}
