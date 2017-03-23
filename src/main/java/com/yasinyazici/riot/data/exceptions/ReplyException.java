package com.yasinyazici.riot.data.exceptions;

import com.yasinyazici.riot.request.handler.Response;

/**
 * <p>Thrown when there is a reply other than {@link Response#OK}</p>
 *
 * @author Yasin
 */
public class ReplyException extends Exception {

    /**
     * The exception message, usually the response message of the official REST-API of Riot
     */
    private String exception;
    /**
     * The response code returned by the official REST-API of Riot
     */
    private int responseCode;

    /**
     * Creates a new {@link ReplyException}
     *
     * @param exception    the exception message to be thrown
     * @param responseCode the response code to be set
     */
    public ReplyException(String exception, int responseCode) {
        super(exception);
        this.exception = exception;
        this.responseCode = responseCode;
    }

    /**
     * Gets a verified/recognized response
     *
     * @return a verified {@link Response} instance
     */
    public Response getResponse() {
        return Response.verifyResponse(responseCode);
    }

    /**
     * Gets the response code of the reply
     *
     * @return the response code
     */
    public int getResponseCode() {
        return responseCode;
    }

    /**
     * Gets the message of the exception
     *
     * @return the message of the exception
     */
    public String getException() {
        return exception;
    }
}
