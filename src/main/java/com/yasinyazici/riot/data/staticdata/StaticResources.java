package com.yasinyazici.riot.data.staticdata;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yasinyazici.riot.config.Config;
import com.yasinyazici.riot.data.champion.ChampionImage;
import com.yasinyazici.riot.data.masteries.MasteryData;
import com.yasinyazici.riot.data.runes.RuneData;

import java.io.InputStreamReader;
import java.util.Map;

/**
 * <p>Offers static resources to the api (mainly to avoid redundant calls to the official REST-API of Riot</p>
 *
 * @author Yasin
 */
public class StaticResources {

    /**
     * A map loaded up with mastery data upon construction of {@link StaticResources}
     */
    private Map<Integer, MasteryData> masteryDataMap;

    /**
     * A map loaded with rune data upon construction of {@link StaticResources}
     */
    private Map<Integer, RuneData> runeDataMap;

    /**
     * A map loaded with champion data upon construction of {@link StaticResources}
     */
    private Map<String, ChampionImage> championDataMap;

    /**
     * Creates a new {@link StaticResources} instance
     */
    public StaticResources() {
        Gson gson = new Gson();
        try {
            masteryDataMap = gson.fromJson(new InputStreamReader(Config.MASTERIES), new TypeToken<Map<Integer, MasteryData>>() {
            }.getType());
            runeDataMap = gson.fromJson(new InputStreamReader(Config.RUNES), new TypeToken<Map<Integer, RuneData>>() {
            }.getType());
            championDataMap = gson.fromJson(new InputStreamReader(Config.CHAMPION_DATA), new TypeToken<Map<String, ChampionImage>>() {
            }.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * <p>Gets mastery data filtered by mastery id</p>
     *
     * @param masteryId the mastery id to retrieve locally
     * @return a {@link MasteryData} element representing the mastery if found, otherwise returns null
     */
    public MasteryData getMasteryData(int masteryId) {
        return masteryDataMap.values().stream().filter(p -> p.getId() == masteryId).findFirst().orElse(null);
    }

    /**
     * <p>Gets rune data filtered by rune id</p>
     *
     * @param runeId the rune id to retrieve locally
     * @return a {@link RuneData} element representing the mastery if found, otherwise returns null
     */
    public RuneData getRuneData(int runeId) {
        return runeDataMap.values().stream().filter(p -> p.getId() == runeId).findFirst().orElse(null);
    }

    /**
     * <p>Gets champion data filtered by champion id</p>
     *
     * @param championId the champion id to retrieve locally
     * @return a {@link ChampionImage} element representing a Champion if found, otherwise returns null
     */
    public ChampionImage getChampionData(long championId) {
        return championDataMap.values().stream().filter(p -> p.getId() == championId).findFirst().orElse(null);
    }

}
