package com.yasinyazici.riot.data.staticdata;

import java.util.stream.Stream;

/**
 * <p>This class is responsible for the identification of the location in which requests are being made</p>
 * @author Yasin
 */
public enum Region {
    EUW("EUW1"),
    EUNE("EUN1"),
    NA( "NA1"),
    TR("TR1"),
    KR("KR"),
    JP("JP1"),
    RU("RU"),
    OCE("OC1"),
    LAS("LA2"),
    LAN("LA1"),
    BR("BR1"),
    NONE("NONE");

    /**
     * Represents the platform id used to identify regions for specific requests
     */
    private String platformId;

    /**
     * Creates a new {@link Region} instance
     * @param platformId the platform id to assign a region to
     */
    Region(String platformId) {
        this.platformId = platformId;
    }

    /**
     * Gets the name of the enum as it equals the region shortcode which also is liable for all kind of requests
     * @return the name of the enum in lowercase as shortcode
     */
    public String getShortCode() {
        return this.name().toLowerCase();
    }

    /**
     * Gets the platform id corresponding to the region for requests like spectator mode
     * @return platformId the platformId corresponding to a region
     */
    public String getPlatformId() {
        return platformId;
    }

    /**
     * Parses the given String to identify the corresponding region
     * @param regionCode the region code to identify and return an object on
     * @return the identified region or {@link Region#NONE} if the string could not get identified
     */
    public static Region parseRegion(String regionCode) {
        return Stream.of(values()).filter(region -> region.getShortCode().equalsIgnoreCase(regionCode)).findFirst().orElse(NONE);
    }

}
