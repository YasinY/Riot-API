package com.yasinyazici.riot.request.web;

import com.yasinyazici.riot.request.handler.ResponseHandler;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Yasin on 09/02/2016.
 * <p>This class is mainly focused on establishing a connection with the Riot servers for further communication
 * lead by the {@link ResponseHandler} and displaying the content through {@link RequestContent}</p>
 */
public class Request {

    private URL url;

    private RequestContent requestContent;

    private ResponseHandler responseHandler;

    /**
     * <p>Creates a new {@link Request} instance</p>
     *
     * @param url The url to connect to
     */
    public Request(URL url) {
        this.url = url;
    }

    /**
     * Opens the connection of the {@code url} given, and creates instances to manage specifics aspects, in this case,
     * both the handling of responses and the inputstream of the URL given
     */
    public void connect() {
        try {
            System.out.println("Establishing connection");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            responseHandler = new ResponseHandler(connection.getResponseCode());
            requestContent = new RequestContent(responseHandler.getResponse().getResponseCode() <= 400 ? connection.getInputStream() : connection.getErrorStream());
            System.out.println("Response message: " + responseHandler.getResponse().getMessage());
            System.out.println("Request content: " + requestContent.readStreamToString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public URL getUrl() {
        return url;
    }

    public RequestContent getRequestContent() {
        return requestContent;
    }

    public ResponseHandler getResponseHandler() {
        return responseHandler;
    }
}
