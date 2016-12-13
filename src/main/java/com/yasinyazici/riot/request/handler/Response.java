package com.yasinyazici.riot.request.handler;

/**
 * Created by Yasin on 13/02/2016.
 */
public enum Response {

    BAD_REQUEST(400, "Bad args"),
    UNAUTHORIZED(401, "Not authorized"),
    WRONG_API_KEY(403, "Wrong API Key"),
    NOT_FOUND(404, "Data has not been found"),
    UNSUPPORTED_MEDIA_TYPE(415, "Unsupported param"),
    RATE_LIMIT_EXCEEDED(429, "Rate limit exceeded"),
    INTERNAL_SERVER_ERROR(500, "Internal server errors"),
    SERVICE_UNAVAILABLE(503, "Service unavailable"),
    OK(200, "OK"),
    NONE(-1, "No connection established");

    private final int responseCode;

    private final String message;

    Response(int responseCode, String message) {
        this.responseCode = responseCode;
        this.message = message;
    }


    public int getResponseCode() {
        return responseCode;
    }

    public String getMessage() {
        return message;
    }

    public static Response verifyResponse(String response) {
        for(Response value : values()) {
            if(response.equalsIgnoreCase(value.getMessage())) {
                return value;
            }
        }
        return NONE;
    }

    public static Response verifyResponse(int responseCode) {
        for(Response value : values()) {
            if(responseCode == value.getResponseCode()) {
                return value;
            }
        }
        return NONE;
    }
}
