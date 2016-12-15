package com.yasinyazici.riot.request.web;

/**
 * Created by ht5-yaziya on 15.12.2016.
 */
public enum GlobalRequestType implements RequestType {
    GET_VERSIONS("/api/lol/static-data/%region%/v1.2/versions"),
    GET_CHAMPION_DATA_IMAGE("api/lol/static-data/euw/v1.2/champion?champData=image");

    private String url;

    GlobalRequestType(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
