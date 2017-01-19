package com.yasinyazici.riot.parsers.impl;

import com.google.gson.reflect.TypeToken;
import com.yasinyazici.riot.data.masteries.MasteryData;
import com.yasinyazici.riot.parsers.JsonDataParser;

import java.lang.reflect.Type;

/**
 * Created by Yasin on 19.01.2017.
 */
public class MasteryDataParser extends JsonDataParser<MasteryData> {

    public MasteryDataParser(String json) {
        super(json);
        System.out.println("Parsing data: " + json);
    }

    @Override
    public MasteryData get() {
        return transform();
    }

    @Override
    protected Type getType() {
        return new TypeToken<MasteryData>(){}.getType();
    }
}
