package com.yasinyazici.riot.config.json.impl;

import com.yasinyazici.riot.config.json.JsonDataParser;
import com.yasinyazici.riot.data.summoner.SummonerProperties;

/**
 * Created by Yasin on 08.12.2016.
 */
public class SummonerPropertiesParser extends JsonDataParser<SummonerProperties> {

    public SummonerPropertiesParser(String json) {
        super(json);
    }

    @Override
    public SummonerProperties get() {
        System.out.print(transform());
        return null;
    }
}
