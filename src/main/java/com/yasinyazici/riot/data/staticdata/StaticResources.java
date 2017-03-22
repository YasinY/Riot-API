package com.yasinyazici.riot.data.staticdata;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yasinyazici.riot.config.Config;
import com.yasinyazici.riot.data.champion.ChampionImage;
import com.yasinyazici.riot.data.masteries.MasteryData;
import com.yasinyazici.riot.data.runes.RuneData;
import com.yasinyazici.riot.data.summoner.runes.Rune;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * Created by Yasin on 07.02.2017
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class StaticResources {

    private Map<Integer, MasteryData> masteryDataMap;

    private Map<Integer, RuneData> runeDataMap;

    private Map<String, ChampionImage> championDataMap;

   public StaticResources() {
       Gson gson = new Gson();
       try {
           masteryDataMap = gson.fromJson(new InputStreamReader(Config.MASTERIES), new TypeToken<Map<Integer, MasteryData>>() {}.getType());
           runeDataMap = gson.fromJson(new InputStreamReader(Config.RUNES), new TypeToken<Map<Integer, RuneData>>(){}.getType());
           championDataMap = gson.fromJson(new InputStreamReader(Config.CHAMPION_DATA), new TypeToken<Map<String, ChampionImage>>(){}.getType());
       } catch(Exception e) {
           e.printStackTrace();
       }
   }

    public MasteryData getMasteryData(int masteryId) {
        return masteryDataMap.values().stream().filter(p -> p.getId() == masteryId).findFirst().orElse(null);
    }
    public RuneData getRuneData(int runeId) {
        return runeDataMap.values().stream().filter(p -> p.getId() == runeId).findFirst().orElse(null);
    }

    public ChampionImage getChampionData(long championId) {
        return championDataMap.values().stream().filter(p -> p.getId() == championId).findFirst().orElse(null);
    }

    public Map<String, ChampionImage> getChampionDataMap() {
        return championDataMap;
    }
}
