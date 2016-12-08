package com.yasinyazici.riot;

import com.yasinyazici.riot.request.web.*;

/**
 * Created by Yasin on 09/02/2016.
 */
public class Main {

    public static void main(String[] args) {
        RequestProperty requestProperty = new RequestProperty(RequestType.GET_SUMMONER_DATA_BY_NAME, RequestRegion.EUROPE_WEST, "ireliaislife");
        RequestCreator requestCreator = new RequestCreator(requestProperty);
        RequestReply reply = requestCreator.create();
        System.out.println("REQUEST: " + reply.getResponseMessage());
        requestProperty.setRequestType(RequestType.GET_SUMMONER_RUNES_BY_ID);
        requestProperty.setParameters("31045241");
        requestCreator.create();
        // Summoner summoner =
    }

}
