package com.yasinyazici.riot.data.game;

/**
 * <p>Displays all the Seasons league of legends has so far (or offers data about)</p>
 * @author Yasin
 */
public enum Season {
    SEASON_7("SEASON2017"),
    SEASON_6("SEASON2016"),
    SEASON_5("SEASON2015"),
    SEASON_4("SEASON2014"),
    SEASON_3("SEASON2013"),
    SEASON_2("SEASON2012"),
    SEASON_1("SEASON2011");

    /**
     * Represents the season parameter used for filtering for the official REST-API of Riot
     */
    private String seasonName;

    /**
     * Creates a new {@link Season} element
     * @param seasonName sets season name/parameter
     */
    Season(String seasonName) {
        this.seasonName = seasonName;
    }

    /**
     * Gets the name of the season
     * @return the season name
     */
    public String getSeasonName() {
        return seasonName;
    }
}
