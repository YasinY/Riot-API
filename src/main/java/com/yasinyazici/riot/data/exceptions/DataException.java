package com.yasinyazici.riot.data.exceptions;

/**
 * <p>Most commonly thrown when the Data of, for instance a Summoner, is invalid or if something tries to get accessed whilst it doesn't exist. <!-- -->
 * (like bans in a blind pick game)</p>
 *
 * @author Yasin
 */
public class DataException extends Exception {

    /**
     * Creates a new {@link DataException} instance
     * @param exception the exception to be thrown
     */
    public DataException(String exception) {
        super(exception);
    }
}
