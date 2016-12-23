package com.yasinyazici.riot.request.web;

import com.yasinyazici.riot.config.Config;
import com.yasinyazici.riot.data.exceptions.WrongRequestFormatException;
import com.yasinyazici.riot.request.web.RequestCreator;
import com.yasinyazici.riot.request.web.RequestFormat;
import com.yasinyazici.riot.request.web.RequestProperty;

import java.net.MalformedURLException;
import java.util.Arrays;

/**
 * Created by Yasin on 23.12.2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class RequestLink {

    private RequestProperty requestProperty;

    private String baseLink;
    private final String link;
    private final String[] neededVariables;

    public RequestLink(RequestProperty requestProperty) throws WrongRequestFormatException, MalformedURLException {
        this.requestProperty = requestProperty;
        this.baseLink = generateLink();
        this.neededVariables = new RequestFormat(baseLink).getVariables(); //Generate link is the original url
        this.link = replaceData();
    }

    private String generateLink() {
        return requestProperty.getRequestType().getStart() + requestProperty.getRequestType().getLink() + (requestProperty.getRequestType().optionalParameters() ? "&" : "?") +"api_key=" + Config.API_KEY.getApiKey();
    }

    private String replaceData() throws WrongRequestFormatException {
        String modifiedLink = this.baseLink;
        String[] neededVariables = new RequestFormat(modifiedLink).getVariables(); // The variables needed
        Object[] givenVariables = requestProperty.getParameters();
        int variablesLength = neededVariables.length;
        if (givenVariables.length != variablesLength) {
            throw new WrongRequestFormatException("The amount of parameters do not equal the amount needed, needed: " + formatDisplay(neededVariables) + ", given: " + Arrays.toString(givenVariables));
        }
        //System.out.println("To be replaced : " + fullLink);
        for (int i = 0; i < variablesLength; i++) {
            String neededVariable = neededVariables[i];
            Object givenVariable = givenVariables[i];
            modifiedLink = modifiedLink.replace(neededVariable, givenVariable instanceof String[] ? String.join(",", Arrays.asList((String[]) givenVariable)) : String.valueOf(givenVariables[i])).replace(" ", "");
        }
        //System.out.println("Replace data: " + fullLink);
        return modifiedLink;
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

    public final String getLink() {
        return link;
    }
    public String[] getNeededVariables() {
        return neededVariables;
    }


    public RequestProperty getRequestProperty() {
        return requestProperty;
    }
}
