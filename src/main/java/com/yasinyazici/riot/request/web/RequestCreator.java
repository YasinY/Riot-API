package com.yasinyazici.riot.request.web;

import com.yasinyazici.riot.config.Config;
import com.yasinyazici.riot.data.exceptions.WrongRequestFormatException;

import java.net.URL;
import java.util.Arrays;

/**
 * Created by Yasin on 18/02/2016.
 *
 * @author Yasin
 * @version 1.0
 * @apiNote See {@link RequestFormat} as reference of how the usage of parameters corresponding to {@link RequestType} should be
 */
public class RequestCreator {

    private RequestProperty requestProperty;

    public RequestCreator(RequestProperty requestProperty) {
        this.requestProperty = requestProperty;
    }
    /**
     * Connects to a specific {@code URL} through the {@link Request} class
     * @throws Exception When the URL
     */
    public RequestReply create() {
        RequestReply requestReply = null;
        try {
            System.out.println("Creating new request..");
            String regionShortcut = requestProperty.getRequestRegion().getShortcut();
            String url = replaceData("https://" + regionShortcut + ".api.pvp.net/api/lol/" + regionShortcut + "/" + requestProperty.getRequestType().getLink() + "?api_key=" + Config.API_KEY.getApiKey());
            requestReply = new Request(new URL(url)).makeRequest();
            System.out.println("Request Reply: " + requestReply.getResponseMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return requestReply;
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
    private String replaceData(String fullLink) throws WrongRequestFormatException {
        String[] variables = new RequestFormat(fullLink).getVariables(); // The variables given
        String[] parameters = requestProperty.getParameters(); // The variables given
        int variablesLength = variables.length;
        if (parameters.length != variablesLength) {
            throw new WrongRequestFormatException("The amount of parameters do not equal the amount needed, needed: " + formatDisplay(variables) + ", given: " + Arrays.toString(parameters));
        }
        for (int i = 0; i < variablesLength; i++) {
            fullLink = fullLink.replace(variables[i], parameters[i]);
        }
        System.out.println("Parameters given: " + formatDisplay(parameters) + ", Variables given: " + formatDisplay(variables));
        return fullLink;
    }

    private String formatDisplay(String[] prefix) {
        return Arrays.toString(prefix).replace("%%", "").replace("%", "");
    }

    /**
     * Returns an instance of RequestProperty
     * @link RequestProperty contains properties essential for requests to make
     * @return requestProperty The instance of RequestProperty to return
     */
    public RequestProperty getRequestProperty() {
        return requestProperty;
    }
}
