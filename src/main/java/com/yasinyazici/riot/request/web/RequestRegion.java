package com.yasinyazici.riot.request.web;

/**
 * Created by Yasin on 10/02/2016.
 */
public enum RequestRegion {

    BRASIL("br"),
    EUROPE_NORTH_EAST("eune"),
    EUROPE_WEST("euw"),
    KOREA("kr"),
    LATIN_AMERICA_NORTH("lan"),
    LATIN_AMERICA_SOUTH("las"),
    NORTH_AMERICA("na"),
    OCEANIA("oce"),
    RUSSIA("ru"),
    TURKEY("tr");

    private String shortcut;

    RequestRegion(String shortcut) {
        this.shortcut = shortcut;
    }

    public String getShortcut() {
        return shortcut;
    }

    public void setShortcut(String shortcut) {
        this.shortcut = shortcut;
    }
}
