package com.yasinyazici.riot.data.exceptions;


/**
 * Created by Yasin on 18/02/2016.
 */
public class WrongRequestFormatException extends Exception {

    private String[] neededVariables;

    public WrongRequestFormatException(String message, String ... neededVariables) {
        super(message);
        this.neededVariables = neededVariables;
    }

    public String[] getNeededVariables() {
        return neededVariables;
    }
}
