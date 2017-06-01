package com.yasinyazici.riot.request.web;

import com.yasinyazici.riot.data.exceptions.DataException;
import com.yasinyazici.riot.data.exceptions.ReplyException;
import com.yasinyazici.riot.data.exceptions.WrongRequestFormatException;
import com.yasinyazici.riot.parsers.JsonDataParser;
import com.yasinyazici.riot.request.types.RequestType;

import java.io.IOException;
import java.io.InputStream;

/**
 * <p>Used as interface to create Requests</p>
 *
 * @author Yasin
 * @see RequestFormat as reference on how the usage of parameters corresponding to the {@link RequestType} should be
 */
public class RequestCreator {

    /**
     * <p>Creates a new request which returns an instance of {@link RequestReply} itself, making it possible to access both response- code and message . <!-- -->Used when debugging/testing requests.</p>
     *
     * @param requestProperty the request property to assign towards the request
     * @return a new {@link RequestReply} instance representing the response of the official REST-API
     * @throws IOException                 Thrown when an internet problem occurs
     * @throws WrongRequestFormatException Thrown when the {@link RequestFormat} given as parameter does not equal the parameters found within the request
     * @throws DataException               Thrown when the data is invalid (e.g. empty)
     * @throws ReplyException              Thrown when the connection was successful, but a bad reply returns (other than 201)
     *
     */
    public static RequestReply createDebugRequest(RequestProperty requestProperty) throws IOException, WrongRequestFormatException, DataException, ReplyException {
        return new Request(new RequestLink(requestProperty)).makeRequest();
    }

    /**
     * <p>Creates a new request which returns the {@link InputStream} of the {@link RequestReply} directly, so the content can be parsed by a corresponding {@link JsonDataParser}</p>
     * @param requestProperty the request property to assign towards the request
     * @return the {@link InputStream} of the {@link RequestReply}
     * @throws IOException                 Thrown when an internet problem occurs
     * @throws WrongRequestFormatException Thrown when the {@link RequestFormat} given as parameter does not equal the parameters found within the request
     * @throws DataException               Thrown when the data is invalid (e.g. empty)
     * @throws ReplyException              Thrown when the connection was successful, but a bad reply returns (other than 201)
     * @see JsonDataParser
     */
    public static String createRequest(RequestProperty requestProperty) throws IOException, WrongRequestFormatException, DataException, ReplyException {
        return new Request(new RequestLink(requestProperty)).makeRequest().getResponseMessage();
    }
}
