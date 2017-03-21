package com.yasinyazici.riot.request.web;

/**
 * Created by Yasin on 08.12.2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class RequestReply {

    private int responseCode;

    private String responseMessage;

    /**
     * Creates a new {@link RequestReply} instance
     * @param responseCode the response code returning from the connection
     * @param responseMessage the response message returning from the connection
     * @see com.yasinyazici.riot.request.handler.Response
     */
    public RequestReply(int responseCode, String responseMessage) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
    }

    /**
     * <p>Gets the response code</p>
     * @return responseCode the response code of the connection to return
     */
    public int getResponseCode() {
        return responseCode;
    }

    /**
     * <p>Gets the response message</p>
     * @return responseMessage the response message of the connection to return
     */
    public String getResponseMessage() {
        return responseMessage;
    }
}
