package com.yasinyazici.riot.request.types.impl;

import com.yasinyazici.riot.request.types.RequestType;

/**
 * Created by Yasin on 17.12.2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 * REQUESTS FOR https://www.global.api.pvp.net/
 */
public enum GlobalRequestType implements RequestType {
    START() {
        @Override
        public String getLink() { return "https://global.api.pvp.net/api/lol/"; }
    },
    GET_GAME_VERSIONS() {
        @Override
        public String getLink() { return "static-data/%region%/v1.2/versions"; }
    },
    GET_CHAMPION_INFO_BY_CHAMPION_ID() {
        @Override
        public String getLink() { return "static-data/%region%/v1.2/champion/%champId%";}
        @Override
        public String getQueryParameter() {return "champData=info";}
    },
    GET_CHAMPION_IMAGE_BY_CHAMPION_ID() {
        @Override
        public String getLink() { return "static-data/%region%/v1.2/champion/%champId%";}

        @Override
        public String getQueryParameter() { return "champData=image";}
    };

    public String getStart() {
        return START.getLink();
    }
}
