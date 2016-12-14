package com.yasinyazici.riot.request.web;

import com.yasinyazici.riot.utilities.ArrayUtils;

import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Yasin on 16/02/2016.
 *
 * <p>Identifies the placeholders of the {@link URL} given as parameter</p>
 */

public class RequestFormat {

    private ArrayList<String> requestFormatArray;

    private String url;

    public RequestFormat(String url) {
        this.url = url;
        this.requestFormatArray = new ArrayList<>();
    }

    /**
     * Gets the placeholders in the {@link String} <i>url</i>, filtering it by using a Pattern specified to only
     * filter out words which have a <i>%</i> in the starting position (first letter - 1) and end position (last latter + 1)
     * adding each found word by the {@link Matcher} into an {@link ArrayList<String>} which then gets
     * @return
     */
    public String[] getVariables() {
        Pattern pattern = Pattern.compile("%.+?%");
        Matcher matcher = pattern.matcher(url);
        System.out.println("Getting variables of " + url);
        while(matcher.find()) {
            if(!requestFormatArray.contains(matcher.group()))  {
                requestFormatArray.add(matcher.group());
            }
        }
        return (String[]) ArrayUtils.transformList(requestFormatArray, new String[requestFormatArray.size()]);
    }
}
