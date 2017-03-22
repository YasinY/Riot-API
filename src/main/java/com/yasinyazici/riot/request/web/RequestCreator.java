package com.yasinyazici.riot.request.web;

import com.yasinyazici.riot.data.exceptions.DataException;
import com.yasinyazici.riot.data.exceptions.ReplyException;
import com.yasinyazici.riot.data.exceptions.WrongRequestFormatException;
import com.yasinyazici.riot.request.types.impl.ApiRequestType;

import java.io.IOException;

/**
 * Created by Yasin on 18/02/2016.
 *
 * @author Yasin
 * @version 1.0
 * @apiNote See {@link RequestFormat} as reference of how the usage of parameters corresponding to {@link ApiRequestType} should be
 */
public class RequestCreator {

    /**
     * <p>Creates a new debug request</p>
     * @param requestProperty the request property to createRequest a request on and to debug
     * @return a {@link RequestReply}
     * @throws IOException Thrown when an internet problem occurs
     * @throws WrongRequestFormatException Thrown when the {@link RequestFormat} given as parameter does not equal the parameters found within the request
     * @throws DataException Thrown when the data is invalid (e.g. empty)
     * @throws ReplyException Thrown when the connection was successful, but a bad reply returns (other than 201)
     */
    public static RequestReply createDebugRequest(RequestProperty requestProperty) throws IOException, WrongRequestFormatException, DataException, ReplyException {
        return new Request(new RequestLink(requestProperty)).makeRequest();
    }
    public static String createRequest(RequestProperty requestProperty) throws IOException, WrongRequestFormatException, DataException, ReplyException {
        System.out.println("Creating request " + requestProperty.getRequestType().getLink());
        return new Request(new RequestLink(requestProperty)).makeRequest().getResponseMessage();
    }
}
