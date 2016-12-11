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
        transform().entrySet().forEach(p -> System.out.println("TEST: " + p.getValue().getName())); //DUDE IDFK THIS CODE IS TURNING ITSELF INTO A MESS
        return null;
    }
}
