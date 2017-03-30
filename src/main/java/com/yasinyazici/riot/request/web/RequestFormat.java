package com.yasinyazici.riot.request.web;

import com.yasinyazici.riot.utilities.ArrayUtils;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>Identifies the placeholders of the {@link URL} given as parameter</p>
 * @author Yasin
 */

public class RequestFormat {

    /**
     * The array containing all identified placeholders
     */
    private ArrayList<String> requestFormatArray;

    /**
     * The url which will be fit to the format
     */
    private String url;

    /**
     * Creates a new {@link RequestFormat} instance
     *
     * @param url the url to identify the format/placeholders of
     */
    public RequestFormat(String url) {
        this.url = url;
        this.requestFormatArray = new ArrayList<>();
    }

    /**
     * Gets the placeholders in the {@link String} <i>url</i>, filtering it by using a Pattern specified to only
     * filter out words which has a <i>%</i> in the starting position (first letter - 1) and end position (last latter + 1)
     * adding each found word by the {@link Matcher} into an {@link ArrayList}, transforming the {@link ArrayList} to a {@link String[]} array
     *
     * @return a new 2d {@link String} transformed from A {@link List}
     */
    public String[] getVariables() {
        Pattern pattern = Pattern.compile("%.+?%");
        Matcher matcher = pattern.matcher(url);
        while (matcher.find()) {
            if (!requestFormatArray.contains(matcher.group())) {
                requestFormatArray.add(matcher.group());
            }
        }
        return (String[]) ArrayUtils.transformList(requestFormatArray, new String[requestFormatArray.size()]);
    }
}
