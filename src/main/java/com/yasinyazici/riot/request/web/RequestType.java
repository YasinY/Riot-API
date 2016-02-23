package com.yasinyazici.riot.request.web;

/**
 * Created by Yasin on 10/02/2016.
 * //TODO EDIT SO THAT IT GIVES FULL LINK ~INSTEAD OF MERGING WHY NOT HAVE FULL
 */
public enum RequestType {
    GET_CHAMPION_LIST("v1.2/champion"),
    GET_CHAMPION_BY_ID("v1.2/champion/%id%"),
    GET_SUMMONER_DATA_BY_NAME("v1.4/summoner/by-name/%name%"),
    GET_SUMMONER_STATS_BY_ID("v1.3/stats/by-summoner/%summonerId%/summary");

    private String link;

    RequestType(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }
}
