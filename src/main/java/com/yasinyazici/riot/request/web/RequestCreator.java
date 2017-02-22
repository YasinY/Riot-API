package com.yasinyazici.riot.request.web;

import com.yasinyazici.riot.data.exceptions.DataException;
import com.yasinyazici.riot.data.exceptions.ReplyException;
import com.yasinyazici.riot.data.exceptions.WrongRequestFormatException;
import com.yasinyazici.riot.request.types.impl.ApiRequestType;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Yasin on 18/02/2016.
 *
 * @author Yasin
 * @version 1.0
 * @apiNote See {@link RequestFormat} as reference of how the usage of parameters corresponding to {@link ApiRequestType} should be
 */
public class RequestCreator {

    private RequestProperty requestProperty;

    public RequestCreator() {
        this.requestProperty = new RequestProperty(ApiRequestType.NONE, "");
    }


    public RequestReply create() throws IOException, WrongRequestFormatException, DataException, ReplyException {
        return new Request(new RequestLink(requestProperty)).makeRequest();
    }



    /**
     * Returns an instance of RequestProperty
     *
     * @return requestProperty The instance of RequestProperty to return
     * @link RequestProperty contains properties essential for requests to make
     *
     */
    public RequestProperty getRequestProperty() {
        return requestProperty;
    }
}
