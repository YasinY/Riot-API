package com.yasinyazici.riot.request.web;

import com.yasinyazici.riot.data.WrongRequestFormatException;
import com.yasinyazici.riot.utilities.ArrayUtils;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;

/**
 * Created by Yasin on 18/02/2016.
 * @author Yasin
 * @apiNote See {@link RequestFormat} as reference of how the usage of parameters corresponding to {@link RequestType} should be
 * @version 1.0
 */
public class RequestCreator {

    private RequestEntry requestEntry;
    private RequestProperty requestProperty;


    public RequestCreator(RequestEntry requestEntry) {
        this.requestEntry = requestEntry;
    }

    /**
     * This is essential, to create several different requests
     * @param requestProperty the Request property to actually set for further connection establishments
     */
    public void setRequestProperty(RequestProperty requestProperty) {
        this.requestProperty = requestProperty;
    }

    /**
     * Connects to a specific {@code URL} through the {@link Request} class
     *
     * @throws IOException
     */
    public void create() {
        try {
            String regionShortcut = requestProperty.getRequestRegion().getShortcut();
            new Request(new URL(returnReplacedData("https://" + regionShortcut + ".api.pvp.net/api/lol/" + regionShortcut + "/" + requestProperty.getRequestType().getLink() + "?api_key=" + requestEntry.getApiKey()))).connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * <p>Replaces the variables identified through {@link RequestFormat#getVariables()} with the parameters given upon creating a
     * {@link RequestCreator} instance, by looping {@code variables#length} times, using the in the loop defined variable <i>i</i>as index for each
     * array {@code variables} and {@code parameters}. Hence the {@code variables} and {@code parameters} given must equal the
     * same context and amount of values, else {@link WrongRequestFormatException} is thrown. For further details about the format, see
     * {@link RequestFormat} as reference</p>
     *
     * @param fullLink the {@link String} to undergo the procedure
     * @return the modified {@link String} after the procedure
     * @throws WrongRequestFormatException thrown if the {@code parameters#length} do not equal the {@code variablesLength} variable
     */
    private String returnReplacedData(String fullLink) throws WrongRequestFormatException {
        String[] variables = new RequestFormat(fullLink).getVariables();
        String[] parameters = requestProperty.getParameters();
        int variablesLength = variables.length;
        if (parameters.length != variablesLength) {
            throw new WrongRequestFormatException("The amount of parameters do not equal the amount needed, needed: " + Arrays.toString(variables).replace("%", "") + ", given: " + Arrays.toString(parameters));
        }
        for (int i = 0; i < variablesLength; i++) {
            fullLink = fullLink.replace(variables[i], parameters[i]);
        }
        System.out.println("Parameters: " + Arrays.toString(parameters) + ", Variables: " + Arrays.toString(variables));
        return fullLink;
    }


    public RequestProperty getRequestProperty() {
        return requestProperty;
    }

    public RequestEntry getRequestEntry() {
        return requestEntry;
    }
}
