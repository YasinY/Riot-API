package com.yasinyazici.riot.data.game;

/**
 * Created by Yasin on 21.12.2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public enum Season {
    SEASON_7("SEASON2017"),
    SEASON_6("SEASON2016"),
    SEASON_5("SEASON2015"),
    SEASON_4("SEASON2014"),
    SEASON_3("SEASON2013"),
    SEASON_2("SEASON2012"),
    SEASON_1("SEASON2011");

    private String seasonName;

    Season(String seasonName) {
        this.seasonName = seasonName;
    }

    public String getSeasonName() {
        return seasonName;
    }
}
