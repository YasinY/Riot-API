package com.yasinyazici.riot.data.champion;

import com.google.gson.annotations.SerializedName;
import com.yasinyazici.riot.LeagueAPI;
import com.yasinyazici.riot.data.champion.impl.ChampionImageData;

/**
 * <p>Represents champion data including </p>
 *
 * @author Yasin
 */
public class ChampionImage {

    /**
     * Represents the champion id
     */
    private final long id;

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
     * Contains the image data additional to the regular champion data
     */
    @SerializedName("image")
    private final ChampionImageData championImageData;

    /**
     * Creates a new {@link ChampionImage} instance
     * @param id the champion id to assign the champion to
     * @param title the unique champion title to assign the champion to
     * @param name the unique name of the champion
     * @param key the representation of the champion key
     * @param championImageData the additional image data
     */
    public ChampionImage(long id, String title, String name, String key, ChampionImageData championImageData) {
        this.id = id;
        this.title = title;
        this.name = name;
        this.key = key;
        this.championImageData = championImageData;
    }

    /**
     * Gets the champion id
     * @return the id of the champion
     */
    public long getId() {
        return id;
    }

    /**
     * Gets the champion's title
     * @return the unique title of the champion
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the name of the champion
     * @return the name of the champion
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the key of the champion
     * @return the key of the champion
     */
    public String getKey() {
        return key;
    }

    /**
     * Gets the additional image data for the champion (ie. used to generate the image link {@link LeagueAPI#getImageUrl(long)}
     * @return the {@link ChampionImageData} instance which got defined within the construction of the class
     */
    public ChampionImageData getChampionImageData() {
        return championImageData;
    }
}
