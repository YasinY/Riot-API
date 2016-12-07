package com.yasinyazici.riot.config;

/**
 * Created by Yasin on 07.12.2016.
 * Class for interacting with the API Key
 */
public class APIKey {

    private String apiKey;

    public APIKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getApiKey() {
        return apiKey;
    }

    public int getHashedApiKey() {
        return apiKey.hashCode();
    }
}
