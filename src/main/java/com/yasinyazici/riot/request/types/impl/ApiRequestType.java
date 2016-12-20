package com.yasinyazici.riot.request.types.impl;

import com.yasinyazici.riot.request.types.RequestType;
import com.yasinyazici.riot.request.web.Type;

/**
 * Created by Yasin on 10/02/2016.
 * //TODO MAKE %% TAGS DECLARE THAT MULTIPLE SUMMONERIDS/SUMMONERNAMES CAN BE GIVEN
 * REQUESTS for https://www.%region%.pvp.net/api/lol
 */
public enum ApiRequestType implements RequestType {
    START() {
        @Override
        public String getLink() { return "https://%region%.api.pvp.net/api/lol/"; }
    },
    GET_CHAMPION_LIST() {
        @Override
        public String getLink() {
            return "%region%/v1.2/champion";
        }
    },
    GET_CHAMPION_BY_ID() {
        @Override
        public String getLink() {
            return "%region%/v1.2/champion/%id%";
        }
    },
    GET_SUMMONER_DATA_BY_NAMES() {
        @Override
        public String getLink() {
            return "%region%/v1.4/summoner/by-name/%%summonerNames%";
        }
    },
    GET_SUMMONER_DATA_BY_IDS() {
        @Override
        public String getLink() {
            return "%region%/v1.4/stats/by-summoner/%%summonerIds%";
        }
    },
    GET_SUMMONER_MASTERIES_BY_IDS() {
        @Override
        public String getLink() {
            return "%region%/v1.4/summoner/%%summonerIds%/masteries";
        }
    },
    GET_SUMMONER_RUNES_BY_ID() {
        @Override
        public String getLink() {
            return "%region%/v1.4/summoner/%%summonerIds%/runes";
        }
    },
    GET_SUMMONER_NAMES_BY_ID() {
        @Override
        public String getLink() {
            return "%region%/v1.4/summoner/%%summonerIds%/name";
        }
    },
    GET_RANKED_STATS_BY_SUMMONER_ID() {
        @Override
        public String getLink() {
            return "%region%/v1.3/stats/by-summoner/%summonerId%/ranked";
        }
    },
    GET_SUMMARY_STATS_BY_SUMMONER_ID() {
        @Override
        public String getLink() {
            return "%region%/v1.3/stats/by-summoner/%summonerId%/summary";
        }
    },
    GET_MATCHLIST_BY_SUMMONER_ID() {
        @Override
        public String getLink() {
            return "%region%/v2.2/matchlist/by-summoner/%summonerId%";
        }
    },
    GET_MATCH_BY_ID() {
        @Override
        public String getLink() {
            return "%region%/v2.2/match/%matchId%";
        }
    },
    GET_RECENT_GAME_BY_SUMMONER_ID() {
        @Override
        public String getLink() {
            return "v1.3/game/by-summoner/%summonerId%/recent";
        }
    },
    GET_LEAGUE_ENTRY_BY_SUMMONER_ID() {
        @Override
        public String getLink() { return "%region%/v2.5/league/by-summoner/%summonerId%/entry";}
    },
    NONE() {
        @Override
        public String getLink() {
            return "";
        }

        @Override
        public Type getType() {
            return Type.NONE;
        }
    };

    public String getStart() {
        return START.getLink();
    }

}
