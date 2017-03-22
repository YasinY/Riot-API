package com.yasinyazici.riot.parsers.impl;

import com.google.gson.reflect.TypeToken;
import com.yasinyazici.riot.data.summoner.ranked.league.QueueType;
import com.yasinyazici.riot.parsers.JsonDataParser;
import com.yasinyazici.riot.data.summoner.ranked.league.LeagueEntry;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by Yasin on 19.12.2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class LeagueEntryParser extends JsonDataParser<Map<String, List<LeagueEntry>>> {


    public LeagueEntryParser(String json) {
        super(json);
    }

    @Override
    public Map<String, List<LeagueEntry>> get() {
        return transform();
    }

    @Override
    protected Type getType() {
        return new TypeToken<Map<String, List<LeagueEntry>>>() {
        }.getType();
    }

    public LeagueEntry getFirstLeagueEntry() {
        return transform().entrySet().iterator().next().getValue().get(0);
    }

    public LeagueEntry getLeagueEntryByQueueType(QueueType queueType) {
        for(Map.Entry<String, List<LeagueEntry>> entries : transform().entrySet()) {
            for (LeagueEntry leagueEntry : entries.getValue()) {
                if(leagueEntry.getQueue().equalsIgnoreCase(queueType.name())) {
                    return leagueEntry;
                }
            }
        }
        return null;

    }
}
