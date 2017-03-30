package com.yasinyazici.riot.request.handler;

/**
 * <p>Represents every kind of Response possible from the league of legends REST-API</p>
 *
 * @author Yasin
 */
public enum Response {

    BAD_REQUEST(400, "Bad args"),
    UNAUTHORIZED(401, "Not authorized"),
    WRONG_CALL(403, "Wrong format / Wrong call"),
    NOT_FOUND(404, "Data has not been found"),
    UNSUPPORTED_MEDIA_TYPE(415, "Unsupported param"),
    RATE_LIMIT_EXCEEDED(429, "Rate limit exceeded"),
    INTERNAL_SERVER_ERROR(500, "Internal server errors"),
    SERVICE_UNAVAILABLE(503, "Service Unavailable - Connection retries limit exceeded"),
    OK(200, "OK"),
    CHAMPION_NOT_FOUND(204, "Champ mastery not found"),
    NONE(-1, "No connection established");

    /**
     * The response code returned
     */
    private final int responseCode;

    /**
     * The response message returned
     */
    private final String message;

    /**
     * Creates a new {@link Response} enum instance
     *
     * @param responseCode the response code to set
     * @param message      the response message to set
     */
    Response(int responseCode, String message) {
        this.responseCode = responseCode;
        this.message = message;
    }

    /**
     * Gets the response code returned by the official REST-API of riot
     *
     * @return the response code
     */
    public int getResponseCode() {
        return responseCode;
    }

    public String getMessage() {
        return message;
    }

    /**
     * Verifies a response through a message
     *
     * @param response the response message to verify
     * @return a verified response ({@link Response}), or {@link Response#NONE} if the response message couldn't be verified
     */
    public static Response verifyResponse(String response) {
        for (Response value : values()) {
            if (response.equalsIgnoreCase(value.getMessage())) {
                return value;
            }
        }
        return NONE;
    }

    /**
     * Verifies a response through a message
     *
     * @param responseCode the response code to verify
     * @return a verified response ({@link Response}), or {@link Response#NONE} if the response message couldn't be verified
     */
    public static Response verifyResponse(int responseCode) {
        for (Response value : values()) {
            if (responseCode == value.getResponseCode()) {
                return value;
            }
        }
        return NONE;
    }
}
