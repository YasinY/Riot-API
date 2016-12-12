package com.yasinyazici.riot.config.json.impl;

import com.yasinyazici.riot.config.json.JsonDataParser;
import com.yasinyazici.riot.data.summoner.SummonerProperties;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Yasin on 08.12.2016.
 */
public class SummonerPropertiesParser extends JsonDataParser<SummonerProperties> {

    public SummonerPropertiesParser(String json) {
        super(json);
    }

    @Override
    public SummonerProperties get() {
        Set<Map.Entry<String, SummonerProperties>> map = transform().entrySet();
        Iterator<Map.Entry<String, SummonerProperties>> iterator = map.iterator();
        return iterator.hasNext() ? iterator.next().getValue() : null;
    }
}
