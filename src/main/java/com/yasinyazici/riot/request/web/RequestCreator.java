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
    public static String create(RequestProperty requestProperty) throws IOException, WrongRequestFormatException, DataException, ReplyException {
        return new Request(new RequestLink(requestProperty)).makeRequest().getResponseMessage();
    }
}
