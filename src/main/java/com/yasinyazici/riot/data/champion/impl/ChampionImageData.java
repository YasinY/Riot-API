package com.yasinyazici.riot.data.champion.impl;

import com.google.gson.annotations.SerializedName;

/**
 * <p>Represents the image data of the champion</p>
 *
 * @author Yasin
 */
public class ChampionImageData {

    /**
     * The full name of the champion (with image type ending)
     */
    private String full;

    /**
     * The group the entity is in
     */
    private String group;

    /**
     * The the splashscreen in the loadingscreen
     */
    private String sprite;

    /**
     * The height of the champion image
     */
    @SerializedName("h")
    private int height;

    /**
     * The width of the champion image
     */
    @SerializedName("w")
    private int width;


    /**
     * The x position the image is positioned
     * //UNSURE
     */
    private int x;

    /**
     * The y position the image is positioned
     */
    private int y;

    /**
     * Creates a new {@link ChampionImageData} instance
     *
     * @param full   sets the full name of the champion
     * @param group  sets the group the entity is inherited in
     * @param sprite sets the splashscren of the champion
     * @param height sets the image height
     * @param width  sets the image width
     * @param x      sets the x-position of the image
     * @param y      sets the y-position of the image
     */
    public ChampionImageData(String full, String group, String sprite, int height, int width, int x, int y) {
        this.full = full;
        this.group = group;
        this.sprite = sprite;
        this.height = height;
        this.width = width;
        this.x = x;
        this.y = y;
    }


    /**
     * <p>Gets the full name of the champion with the corresponding image type (png, jpg etc)</p>
     *
     * @return the full name
     */
    public String getFull() {
        return full;
    }

    /**
     * <p>Gets the group of the entity</p>
     *
     * @return the group of the entity
     */
    public String getGroup() {
        return group;
    }

    /**
     * Gets the splashscreen of the champion
     * @return the splashscreen
     */
    public String getSprite() {
        return sprite;
    }

    /**
     * Gets the height of the champion image
     * @return the height of the champion image
     */
    public int getHeight() {
        return height;
    }

    /**
     * Gets the width of the champion image
     * @return the width of the champion image
     */
    public int getWidth() {
        return width;
    }

    /**
     * Gets the x-position of the image
     * @return the x-position of the image
     */
    public int getX() {
        return x;
    }

    /**
     * Gets the y-position of the image
     * @return the y-position of the image
     */
    public int getY() {
        return y;
    }
}
