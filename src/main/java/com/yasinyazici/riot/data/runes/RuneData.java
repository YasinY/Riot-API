package com.yasinyazici.riot.data.runes;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Yasin on 17.01.2017
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class RuneData {


    private String name;
    @SerializedName("plaintext")
    private String plainText;

    private String description;

    private int id;

    private int stacks;

    public RuneData(String name, String plainText, String description, int id, int stacks) {
        this.name = name;
        this.plainText = plainText;
        this.description = description;
        this.id = id;
        this.stacks = stacks;
    }

    public String getName() { return name;}

    public String getPlainText() {
        return plainText;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public int getStacks() {
        return stacks;
    }
}
