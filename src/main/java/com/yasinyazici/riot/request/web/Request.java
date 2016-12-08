package com.yasinyazici.riot.request.web;

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

    private Response response;

    /**
     * <p>Creates a new {@link Request} instance</p>
     *
     * @param url The url to connect to
     */
    public Request(URL url) {
        if(url == null) {
            return;
        }
        this.url = url;
    }

    /**
     * Opens the connection of the {@code url} given, and creates instances to manage specifics aspects, in this case,
     * both the handling of responses and the inputStream of the URL given
     */
    public RequestReply makeRequest() {
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            response = Response.verifyResponse(connection.getResponseCode());
            requestContent = new RequestContent(response.getResponseCode() <= 400 ? connection.getInputStream() : connection.getErrorStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new RequestReply(response.getResponseCode(), requestContent.getContent());
    }

    public URL getUrl() {
        return url;
    }

    public RequestContent getRequestContent() {
        if(requestContent == null) {
            throw new IllegalStateException("RequestContent could not be grabbed");
        }
        return requestContent;
    }

    public Response getResponse() {
        return response;
    }
}
