package com.yasinyazici.riot.request.web;

/**
 * Created by Yasin on 08.12.2016.
 */
public class RequestReply {

    private int responseCode;

    private String responseMessage;

    public RequestReply(int responseCode, String responseMessage) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }
}
