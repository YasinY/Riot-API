package com.yasinyazici.riot.config.json.impl;

import com.yasinyazici.riot.config.json.JsonDataParser;
import com.yasinyazici.riot.data.summoner.Summoner;

/**
 * Created by Yasin on 08.12.2016.
 */
public class SummonerParser extends JsonDataParser{
    @Override
    public void readJson(String json) {
        Summoner summoner = gson.fromJson(json, Summoner.class);
        System.out.println(gson.toJson(summoner));
    }
}
