package com.yasinyazici.riot.request.web;

import com.yasinyazici.riot.data.exceptions.PropertyNotFound;
import com.yasinyazici.riot.data.exceptions.ReplyException;
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

    private URL url;

    private RequestContent requestContent;

    /**
     * <p>Creates a new {@link Request} instance</p>
     *
     * @param url The url to connect to
     */
    public Request(URL url) {
        if (url == null) {
            return;
        }
        this.url = url;
    }

    /**
     * Opens the connection of the {@code url} given, and creates instances to manage specifics aspects, in this case,
     * both the handling of responses and the inputStream of the URL given
     */
    public RequestReply makeRequest() throws Exception {

        System.out.println("Making request..");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        int responseCode = connection.getResponseCode();
        requestContent = new RequestContent(responseCode == 200 ? connection.getInputStream() : connection.getErrorStream());
        return new RequestReply(responseCode, requestContent.getContent()).filteredReply();
    }

    public RequestContent getRequestContent() throws PropertyNotFound {
        if (requestContent == null) {
            throw new PropertyNotFound("Requestcontent could not be grabbed");
        }
        return requestContent;
    }
}
