package com.yasinyazici.riot.config.json.impl;

import com.google.gson.reflect.TypeToken;
import com.yasinyazici.riot.config.json.JsonDataParser;
import com.yasinyazici.riot.data.summoner.ranked.LeagueEntry;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * Created by Yasin on 19.12.2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class LeagueEntryParser extends JsonDataParser<Map<String,List<LeagueEntry>>> {


    public LeagueEntryParser(String json) {
        super(json);
    }

    @Override
    public Map<String, List<LeagueEntry>> get() {
        return transform();
    }

    @Override
    protected Type getType() {
        return new TypeToken<Map<String,List<LeagueEntry>>>(){}.getType();
    }

    public LeagueEntry getFirstLeagueEntry() {
        return transform().entrySet().iterator().next().getValue().get(0);
    }
}
