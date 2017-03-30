package com.yasinyazici.riot.request.types.impl;

import com.yasinyazici.riot.request.types.RequestType;

/**
 * <p>Represents a RequestType used to navigate a Request to <i>https://www.%region%.pvp.net/%link%</i></p>
 * @author Yasin
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
        public String getLink() {
            return "championmastery/location/%platformId%/player/%summonerId%/champion/%championId%";
        }
    },
    GET_ALL_CHAMPION_MASTERIES() {
        @Override
        public String getLink() {
            return "championmastery/location/%platformId%/player/%summonerId%/champions";
        }
    };

    public String getStart() {
        return START.getLink();
    }
}
