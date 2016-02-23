package com.yasinyazici.riot.request.web;

/**
 * Created by Yasin on 10/02/2016.
 * //TODO MAKE %% TAGS DECLARE THAT MULTIPLE SUMMONERIDS/SUMMONERNAMES CAN BE GIVEN
 */
public enum RequestType {
    GET_CHAMPION_LIST("v1.2/champion"),
    GET_CHAMPION_BY_ID("v1.2/champion/%id%"),
    GET_SUMMONER_DATA_BY_NAME("v1.4/summoner/by-name/%name%"),
    GET_SUMMONER_STATS_BY_ID("v1.3/stats/by-summoner/%summonerId%/summary"),
    GET_SUMMONER_MASTERIES_BY_ID("v1.4/summoner/%summonerId%/masteries"),
    GET_SUMMONER_RUNES_BY_ID("v1.4/summoner/%summonerIds%/runes"),
    GET_SUMMONER_NAMES_BY_ID("v1.4/summoner/%summonerIds%/name"),
    GET_RANKED_STATS_BY_SUMMONER_ID("v1.3/stats/by-summoner/%summonerId%/ranked"),
    GET_SUMMARY_STATS_BY_SUMMONER_ID("v1.3/stats/by-summoner/%summonerId%/summary"),
    GET_MATCHLIST_BY_SUMMONER_ID("v2.2/matchlist/by-summoner/%summonerId%"),
    GET_MATCH_BY_ID("v2.2/match/%matchId%"),
    GET_RECENT_GAME_BY_SUMMONER_ID("v1.3/game/by-summoner/%summonerId%/recent");

    private String link;

    RequestType(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }
}
