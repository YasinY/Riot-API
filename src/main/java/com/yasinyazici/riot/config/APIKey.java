package com.yasinyazici.riot.config;

/**
 * <p>Used to manage the API-Key which is essential to create requests</p>
 *
 * @author Yasin
 */
public class APIKey {

    /**
     * The api key used as identification
     */
    private String apiKey;

    /**
     * Creates a new {@link APIKey} instance
     *
     * @param apiKey the API-Key to assign
     */
    public APIKey(String apiKey) {
        this.apiKey = apiKey;
    }

    /**
     * Gets the API-Key
     *
     * @return a {@link String}
     */
    public String getApiKey() {
        return apiKey;
    }

    /**
     * Gets the hash code for the API-Key
     *
     * @return the hash code for the api-key
     */
    public int getHashCode() {
        return apiKey.hashCode();
    }
}
