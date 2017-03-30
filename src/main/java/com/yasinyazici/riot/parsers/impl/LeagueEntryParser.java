package com.yasinyazici.riot.parsers.impl;

import com.google.gson.reflect.TypeToken;
import com.yasinyazici.riot.data.championmastery.ChampionMastery;
import com.yasinyazici.riot.data.summoner.ranked.league.QueueType;
import com.yasinyazici.riot.parsers.JsonDataParser;
import com.yasinyazici.riot.data.summoner.ranked.league.LeagueEntry;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * <p>Used to parse a multiple {@link LeagueEntry}'s, see {@link LeagueEntry} as reference about what statistics are being displayed</p>
 *
 * @author Yasin
 */
public class LeagueEntryParser extends JsonDataParser<Map<String, List<LeagueEntry>>> {


    public LeagueEntryParser(String json) {
        super(json);
    }

    @Override
    public Map<String, List<LeagueEntry>> get() {
        return parse();
    }

    @Override
    protected Type getType() {
        return new TypeToken<Map<String, List<LeagueEntry>>>() {
        }.getType();
    }

    public LeagueEntry getFirstLeagueEntry() {
        return parse().entrySet().iterator().next().getValue().get(0);
    }

    public LeagueEntry getLeagueEntryByQueueType(QueueType queueType) {
        for(Map.Entry<String, List<LeagueEntry>> entries : parse().entrySet()) {
            for (LeagueEntry leagueEntry : entries.getValue()) {
                if(leagueEntry.getQueue().equalsIgnoreCase(queueType.name())) {
                    return leagueEntry;
                }
            }
        }
        return null;

    }
}
