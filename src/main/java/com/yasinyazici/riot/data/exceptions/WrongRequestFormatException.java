package com.yasinyazici.riot.data.exceptions;


import com.yasinyazici.riot.request.web.Request;
import com.yasinyazici.riot.request.web.RequestLink;

/**
 * <p>Thrown when the parameters given do not equal the amount identified by the {@link RequestLink#getModifiedLink()}</p>
 * @author Yasin
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
