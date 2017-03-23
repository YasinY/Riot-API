package com.yasinyazici.riot.request.web;

import com.yasinyazici.riot.data.exceptions.DataException;
import com.yasinyazici.riot.data.exceptions.PropertyNotFoundException;
import com.yasinyazici.riot.data.exceptions.ReplyException;
import com.yasinyazici.riot.data.exceptions.WrongRequestFormatException;
import com.yasinyazici.riot.request.handler.Response;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Yasin on 09/02/2016.
 * <p>This class is mainly focused on establishing a connection with the Riot servers,
 * displaying the content through {@link RequestContent}</p>
 */
public class Request {

    private RequestLink requestLink;

    /**
     * <p>Creates a new {@link Request} instance</p>
     *
     * @param requestLink the url to connect to
     */
    public Request(RequestLink requestLink) {
        if (requestLink == null) {
            return;
        }
        this.requestLink = requestLink;
    }

    /**
     * Establishes a connection by using a String used as link modified by {@link RequestLink#getModifiedLink()} and reacts corresponding to the response code
     * @return a new {@link RequestReply} representing the reply of the connection
     * @throws IOException TODO here
     * @throws ReplyException
     * @throws DataException
     * @throws WrongRequestFormatException
     */
    public RequestReply makeRequest() throws IOException, ReplyException, DataException, WrongRequestFormatException, PropertyNotFoundException {
        HttpURLConnection connection = (HttpURLConnection) new URL(requestLink.getModifiedLink()).openConnection();
        int responseCode = connection.getResponseCode();
        Response response = Response.verifyResponse(responseCode);
        if(responseCode == Response.CHAMPION_NOT_FOUND.getResponseCode()) {
            throw new PropertyNotFoundException("Champion mastery not found");
        }
        if(responseCode != Response.OK.getResponseCode()) {
            throw new ReplyException(response.getMessage(), responseCode);
        }
        return new RequestReply(responseCode, new RequestContent(connection.getInputStream()).getContent());
    }

    public RequestLink getRequestLink() {
        return requestLink;
    }
}
