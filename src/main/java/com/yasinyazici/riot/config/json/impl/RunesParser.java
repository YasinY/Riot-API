package com.yasinyazici.riot.config.json.impl;

import com.yasinyazici.riot.config.json.JsonDataParser;
import com.yasinyazici.riot.data.summoner.runes.Runes;

/**
 * Created by Yasin on 13.12.2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class RunesParser extends JsonDataParser<Runes> {

    public RunesParser(String json) {
        super(json);
    }

    @Override
    public Runes get() {
        return null;
    }
}
