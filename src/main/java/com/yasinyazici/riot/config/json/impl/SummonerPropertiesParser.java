package com.yasinyazici.riot.config.json.impl;

import com.google.gson.reflect.TypeToken;
import com.yasinyazici.riot.config.json.JsonDataParser;
import com.yasinyazici.riot.data.summoner.SummonerProperties;

import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Yasin on 08.12.2016.
 * TODO: Support multiple summoners in a row
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

    @Override
    protected Type getType() {
        return new TypeToken<Map<String, SummonerProperties>>(){}.getType();
    }
}
