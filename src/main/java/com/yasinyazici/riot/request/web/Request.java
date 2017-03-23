package com.yasinyazici.riot.request.web;

import com.yasinyazici.riot.data.exceptions.DataException;
import com.yasinyazici.riot.data.exceptions.ReplyException;
import com.yasinyazici.riot.data.exceptions.WrongRequestFormatException;
import com.yasinyazici.riot.request.handler.Response;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * <p>This class is used as an initializer for making a new {@link Request}. <!-- -->It establishes a connection with the REST-API, thus being able to return data requested.
 * Properties of each {@link Request} is declared throughout the {@link RequestLink#getModifiedLink()} procedure</p>
 *
 * @author Yasin
 * @see RequestLink
 */
public class Request {

    private RequestLink requestLink;

    /**
     * <p>Creates a new {@link Request} instance</p>
     *
     * @param requestLink the link with all data required to connect to
     */
    public Request(RequestLink requestLink) {
        if (requestLink == null) {
            return;
        }
        this.requestLink = requestLink;
    }

    /**
     * <p>Establishes a connection with the REST-API of riot by using the modified link (which is representing the request itself).</p>
     *
     * @return a new {@link RequestReply} instance representing the reply of the REST-API
     * @throws IOException                 thrown when there was an error in the procedure of establishing a connection with the REST-API
     * @throws ReplyException              thrown when the Reply is different than {@link Response#OK}
     * @throws DataException               thrown when the Data is invalid
     * @throws WrongRequestFormatException thrown when the parameters given do not equal the amount of parameters (placeholders) identified
     */
    public RequestReply makeRequest() throws IOException, ReplyException, DataException, WrongRequestFormatException {
        HttpURLConnection connection = (HttpURLConnection) new URL(requestLink.getModifiedLink()).openConnection();
        int responseCode = connection.getResponseCode();
        Response response = Response.verifyResponse(responseCode);
        if (responseCode != Response.OK.getResponseCode()) {
            throw new ReplyException(response.getMessage(), responseCode);
        } else if (responseCode == Response.CHAMPION_NOT_FOUND.getResponseCode()) {
            return new RequestReply(responseCode, "Champion mastery not found");
        }
        return new RequestReply(responseCode, new RequestContent(connection.getInputStream()).getContent());
    }

    /**
     * Gets the request link
     * @return the {@link RequestLink} instance defined while constructing this class ({@link Request})
     */
    public RequestLink getRequestLink() {
        return requestLink;
    }
}
