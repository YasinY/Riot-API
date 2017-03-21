package com.yasinyazici.riot.request.web;

import com.yasinyazici.riot.data.exceptions.DataException;
import com.yasinyazici.riot.data.exceptions.PropertyNotFound;
import com.yasinyazici.riot.data.exceptions.ReplyException;
import com.yasinyazici.riot.data.exceptions.WrongRequestFormatException;
import com.yasinyazici.riot.request.handler.Response;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
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
    public RequestReply makeRequest() throws IOException, ReplyException, DataException, WrongRequestFormatException {
        HttpURLConnection connection = (HttpURLConnection) new URL(requestLink.getModifiedLink()).openConnection();
        int responseCode = connection.getResponseCode();
        if(responseCode != 200) {
            Response response = Response.verifyResponse(responseCode);
            throw new ReplyException(response.getMessage(), responseCode);
        }
        String content = new RequestContent(connection.getInputStream()).getContent();
        return new RequestReply(responseCode, content);
    }

    public RequestLink getRequestLink() {
        return requestLink;
    }
}
