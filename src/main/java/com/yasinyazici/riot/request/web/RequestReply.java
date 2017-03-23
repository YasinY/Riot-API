package com.yasinyazici.riot.request.web;

import com.yasinyazici.riot.request.handler.Response;

/**
 * <p>Represents the actual reply of the REST-API offered by riot. <!-- --> The answer usually always consists of a response code, but not always the correct response message. <!-- -->
 * see {@link Request#makeRequest()} as reference for further info</p>
 *
 * @author Yasin Yazici
 * @see Request
 */
public class RequestReply {

    private int responseCode;

    private String responseMessage;

    /**
     * Creates a new {@link RequestReply} instance
     *
     * @param responseCode    the response code returning from the connection
     * @param responseMessage the response message returning from the connection
     * @see Response
     */
    public RequestReply(int responseCode, String responseMessage) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
    }

    /**
     * <p>Gets the response code</p>
     *
     * @return responseCode the response code of the connection to return
     */
    public int getResponseCode() {
        return responseCode;
    }

    /**
     * <p>Gets the response message</p>
     *
     * @return responseMessage the response message of the connection to return
     */
    public String getResponseMessage() {
        return responseMessage;
    }
}
