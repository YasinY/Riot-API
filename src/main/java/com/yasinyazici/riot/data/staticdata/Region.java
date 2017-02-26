package com.yasinyazici.riot.data.staticdata;

/**
 * Created by Yasin on 08.02.2017
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
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
    BR("BR1");

    private String platformId;

    Region(String platformId) {
        this.platformId = platformId;
    }

    public String getShortCode() {
        return this.name().toLowerCase();
    }

    public String getPlatformId() {
        return platformId;
    }

}
