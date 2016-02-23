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

    public Request(URL url) {
            this.url = url;
    }

    /**
     * Connects
     */
    public void connect() {
        try {
            System.out.println("Establishing connection");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            responseHandler = new ResponseHandler(connection.getResponseCode());
            requestContent = new RequestContent(responseHandler.getResponseEnum().getResponseCode() <= 400 ? connection.getInputStream() : connection.getErrorStream());
            System.out.println("Response message: " + responseHandler.getResponseEnum().getMessage());
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
