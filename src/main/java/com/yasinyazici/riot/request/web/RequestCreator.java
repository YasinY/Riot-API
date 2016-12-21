package com.yasinyazici.riot.request.web;

import com.yasinyazici.riot.config.Config;
import com.yasinyazici.riot.data.exceptions.WrongRequestFormatException;
import com.yasinyazici.riot.request.types.impl.ApiRequestType;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Yasin on 18/02/2016.
 *
 * @author Yasin
 * @version 1.0
 * @apiNote See {@link RequestFormat} as reference of how the usage of parameters corresponding to {@link ApiRequestType} should be
 */
public class RequestCreator {

    private RequestProperty requestProperty;

    public RequestCreator() {
        this.requestProperty = new RequestProperty(ApiRequestType.NONE, "");
    }

    /**
     * Connects to a specific {@code URL} through the {@link Request} class
     *
     * @throws Exception When the URL
     */
    public RequestReply create() throws Exception {
        //TODO DEBUG
        //System.out.println(replaceData(requestProperty.getRequestType().getStart() + requestProperty.getRequestType().getLink() + "?api_key=" + Config.API_KEY.getApiKey()));
        return new Request(new URL(replaceData(requestProperty.getRequestType().getStart() + requestProperty.getRequestType().getLink() + "?api_key=" + Config.API_KEY.getApiKey()))).makeRequest();
    }


    /**
     * <p>Replaces the variables identified through {@link RequestFormat#getVariables()} with the parameters given upon creating a
     * {@link RequestCreator} instance, by looping {@code variables#length} times, using the in the loop defined variable <i>i</i>as index for each
     * array {@code variables} and {@code parameters}. Hence the {@code variables} and {@code parameters} given must equal the
     * same context (order) and amount of values, else a {@link WrongRequestFormatException} is thrown. For further details about the format, see
     * {@link RequestFormat} as reference</p>
     *
     * @param fullLink the {@link String} to undergo the procedure
     * @return the modified {@link String} after the procedure
     * @throws WrongRequestFormatException thrown if the {@code parameters#length} do not equal the {@code variablesLength} variable
     */
    private String replaceData(String fullLink) throws WrongRequestFormatException {
        String[] neededVariables = new RequestFormat(fullLink).getVariables(); // The variables needed
        Object[] givenVariables = requestProperty.getParameters(); // The variables given
        int variablesLength = neededVariables.length;
        if (givenVariables.length != variablesLength) {
            throw new WrongRequestFormatException("The amount of parameters do not equal the amount needed, needed: " + formatDisplay(neededVariables) + ", given: " + Arrays.toString(givenVariables));
        }
        for (int i = 0; i < variablesLength; i++) {
            String neededVariable = neededVariables[i];
            Object givenVariable = givenVariables[i];
            fullLink = fullLink.replace(neededVariable, givenVariable instanceof String[] ? String.join(",", Arrays.asList((String[]) givenVariable)) : String.valueOf(givenVariables[i])).replace(" ", "");
        }
        return fullLink;
    }

    /**
     * TODO document
     *
     * @param prefix
     * @return
     */
    private String formatDisplay(String[] prefix) {
        return Arrays.toString(prefix).replace("%", "").replace("%%", "");
    }

    /**
     * Returns an instance of RequestProperty
     *
     * @return requestProperty The instance of RequestProperty to return
     * @link RequestProperty contains properties essential for requests to make
     */
    public RequestProperty getRequestProperty() {
        return requestProperty;
    }
}
