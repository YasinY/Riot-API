package com.yasinyazici.riot.data.exceptions;

import com.yasinyazici.riot.request.handler.Response;

/**
 * Created by Yasin on 18.12.2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class ReplyException extends Exception {

    private int responseCode;

    public ReplyException(String exception, int responseCode) {
        super(exception);
        this.responseCode = responseCode;
    }

    public Response getResponse() {
        return Response.verifyResponse(responseCode);
    }

    public int getResponseCode() {
        return responseCode;
    }
}
