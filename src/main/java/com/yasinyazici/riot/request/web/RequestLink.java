package com.yasinyazici.riot.request.web;

import com.yasinyazici.riot.config.Config;
import com.yasinyazici.riot.data.exceptions.WrongRequestFormatException;
import com.yasinyazici.riot.request.types.RequestType;
import com.yasinyazici.riot.request.web.RequestCreator;
import com.yasinyazici.riot.request.web.RequestFormat;
import com.yasinyazici.riot.request.web.RequestProperty;

import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by Yasin on 23.12.2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class RequestLink {

    private RequestProperty requestProperty;


    /**
     * <p>Creates a new {@link RequestLink} instance</p>
     * @param requestProperty the request property to assign the request to
     * @throws WrongRequestFormatException TODO
     * @throws MalformedURLException
     */
    public RequestLink(RequestProperty requestProperty) throws WrongRequestFormatException, MalformedURLException {
        this.requestProperty = requestProperty;
    }

    /**
     * <p>Puts together the link so it's ready to get modified by the method {@link RequestLink#getModifiedLink()}</p>
     *
     * @return the link to modify
     */
    private String generateLink() {
        RequestType requestType = requestProperty.getRequestType();
        return requestType.getStart() + requestType.getLink() + "?api_key=" + Config.API_KEY.getApiKey() + "&" + requestType.getQueryParameter();
    }

    /**
     * <p>Modifies the link so it's ready to get used as request</p>
     *
     * @return a modified version of {@link #RequestLink(RequestProperty)#getModifiedLink()}
     * @throws WrongRequestFormatException thrown when the parameters given do not equal the amount of placeholders identified
     */
    public String getModifiedLink() throws WrongRequestFormatException {
        String modifiedLink = generateLink();
        String[] neededVariables = new RequestFormat(modifiedLink).getVariables(); // The variables needed
        Object[] givenVariables = requestProperty.getParameters();
        int variablesLength = neededVariables.length;
        if (givenVariables.length != variablesLength) {
            throw new WrongRequestFormatException("The amount of parameters do not equal the amount needed.", neededVariables);
        }
        for (int i = 0; i < variablesLength; i++) {
            String neededVariable = neededVariables[i];
            Object givenVariable = givenVariables[i];
            modifiedLink = modifiedLink.replace(neededVariable, givenVariable instanceof String[] ? String.join(",", Arrays.asList((String[]) givenVariable)) : String.valueOf(givenVariables[i])).replace(" ", "");
        }
        return modifiedLink;
    }

}
