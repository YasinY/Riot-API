package com.yasinyazici.riot;

import com.yasinyazici.riot.config.json.impl.SummonerParser;
import com.yasinyazici.riot.request.handler.Response;
import com.yasinyazici.riot.request.web.*;

/**
 * Created by Yasin on 09/02/2016.
 */
public class Main {

    public static void main(String[] args) {
        RequestProperty requestProperty = new RequestProperty(RequestType.GET_SUMMONER_DATA_BY_NAME, RequestRegion.EUROPE_WEST, "ireliaislife");
        RequestCreator requestCreator = new RequestCreator(requestProperty);
        RequestReply reply = requestCreator.create();
        new SummonerParser().readJson(reply.getResponseMessage());
        //System.out.println(Response.verifyResponse(reply.getResponseCode()));
        // Summoner summoner =
    }

}
