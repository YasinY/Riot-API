package com.yasinyazici.riot.request.web;

import com.yasinyazici.riot.data.exceptions.ReplyException;
import com.yasinyazici.riot.request.handler.Response;

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

    public RequestReply filteredReply() throws ReplyException {
        if(responseCode != 200) {
            Response response = Response.verifyResponse(responseCode);
            throw new ReplyException(response.getMessage() + ", (" + responseCode + ") ");
        }
        return this;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }
}
