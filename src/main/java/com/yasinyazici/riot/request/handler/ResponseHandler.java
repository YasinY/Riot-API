package com.yasinyazici.riot.request.handler;


/**
 * Created by Yasin on 18/02/2016.
 * @author Yasin
 * @version 1.0
 * @apiNote
 * <p>This class is used mainly for handling Responses given by the Web-server, so data can be processed to show
 * either a result for an end-user</p>
 */
public class ResponseHandler {

    private Response response;

    public ResponseHandler(Object response) {
        this.response = verifyResponse(response);
    }


    /**
     * <p>Verifies the Response by comparing the {@link Object}, which can either be an {@link Integer} or {@link String}
     * with the {@link Response#values()} through a {@code for-loop}, if one of both parameters given
     * equal the values of an {@link Enum}, the {@link Enum} is being returned</p>
     *
     * @param response The response to identify
     * @return a new {@link Response} corresponding to the response given as parameter, leading back to the answer of web-server if traced back
     */
    public Response verifyResponse(Object response) {
        for (Response element : Response.values()) {
            if (response instanceof String) {
                if (((String) response).equalsIgnoreCase(element.getMessage())) {
                    return element;
                }
            } else if (response instanceof Integer) {
                if ((int) response == element.getResponseCode()) {
                    return element;
                }
            }
        }
        return Response.NONE;
    }

    public Response getResponse() {
        return response;
    }
}
