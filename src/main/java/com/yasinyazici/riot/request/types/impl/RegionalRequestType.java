package com.yasinyazici.riot.request.types.impl;

import com.yasinyazici.riot.request.types.RequestType;

/**
 * Created by Yasin on 17.12.2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 * REQUESTS for https://www.%region%.pvp.net/%link%
 */
public enum RegionalRequestType implements RequestType {
    START() {
        @Override
        public String getLink() {
            return "https://%region%.api.pvp.net/";
        }
    },

    GET_CURRENT_GAME() {
        @Override
        public String getLink() {
            return "observer-mode/rest/consumer/getSpectatorGameInfo/%platformId%/%summonerId%";
        }
    },
    GET_CHAMPION_MASTERY() {
        @Override
        public String getLink() { return "championmastery/location/%platformId%/player/%summonerId%/champion/%championId%";}
    };

    public String getStart() {
        return START.getLink();
    }
}
