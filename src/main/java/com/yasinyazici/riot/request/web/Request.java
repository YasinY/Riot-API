package com.yasinyazici.riot.request.web;

import com.yasinyazici.riot.data.exceptions.DataException;
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
    Request(URL url) {
        if (url == null) {
            return;
        }
        this.url = url;
    }

    RequestReply makeRequest() throws Exception {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        //System.out.println(connection.getHeaderField(3));
        int responseCode = connection.getResponseCode();
        if(responseCode != 200) {
            Response response = Response.verifyResponse(responseCode);
            throw new ReplyException(response.getMessage() + ", (" + responseCode + ") ");
        }
        requestContent = new RequestContent(connection.getInputStream());
        String content = requestContent.getContent();
        return new RequestReply(responseCode, content);
    }

    public RequestContent getRequestContent() throws PropertyNotFound {
        if (requestContent == null) {
            throw new PropertyNotFound("Request content could not be grabbed");
        }
        return requestContent;
    }
}
