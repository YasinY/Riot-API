package com.yasinyazici.riot.request.web;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by ht5-yaziya on 07.12.2016.
 */
public class RequestURL {

    private URL url;

    public RequestURL(String url) throws MalformedURLException {
        this.url = new URL(url);
    }

}
