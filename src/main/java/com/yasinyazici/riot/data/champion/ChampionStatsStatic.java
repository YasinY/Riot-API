package com.yasinyazici.riot.data.champion;

import com.google.gson.annotations.SerializedName;
import com.yasinyazici.riot.data.champion.impl.ChampionData;

/**
 * <p>Used to display more than basic information about the champion</p>
 * @author Yasin
 */
public class ChampionStatsStatic {

    /**
     * Represents the champion id
     */
    private final int id;

    /**
     * Represents the unique title of the champion
     */
    private final String title;

    /**
     * Represents the unique name of the champion
     */
    private final String name;

    /**
     * Represents the champion key
     */
    private final String key;

    /**
     * Contains additional data about the champion
     *
     * @see ChampionData as reference
     */
    @SerializedName("info")
    private final ChampionData championData;

    /**
     * Creates a new {@link ChampionStatsStatic} instance
     *
     * @param id           the id to assign the champion to
     * @param title        the unique title to assign the champion to
     * @param name         the unique name to assign the champion to
     * @param key          the unique key to assign the champion to
     * @param championData the additional data about the champion to assign to
     */
    public ChampionStatsStatic(int id, String title, String name, String key, ChampionData championData) {
        this.id = id;
        this.title = title;
        this.name = name;
        this.key = key;
        this.championData = championData;
    }

    /**
     * Gets the champion id
     *
     * @return the id of the champion
     */
    public long getId() {
        return id;
    }

    /**
     * Gets the champion's title
     *
     * @return the unique title of the champion
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the name of the champion
     *
     * @return the name of the champion
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the key of the champion
     *
     * @return the key of the champion
     */
    public String getKey() {
        return key;
    }


    /**
     * Gets the additional champion data
     * @return the champion data for the champion
     */
    public ChampionData getChampionData() {
        return championData;
    }
}
