package com.yasinyazici.riot.request.web;

import com.yasinyazici.riot.request.types.impl.ApiRequestType;
import com.yasinyazici.riot.request.types.RequestType;

/**
 * Created by Yasin on 23/02/2016.
 */
public class RequestProperty {

    private RequestType requestType;

    private Object[] parameters;
    /**
     * <p>Creates a new {@link RequestProperty} instance</p>
     *
     * @param requestType   The type of request set by the {@link Enum<  ApiRequestType  >} to perform
     * @param parameters    Additional parameters which must equal the format of {@link ApiRequestType} given.
     */
    public RequestProperty(RequestType requestType, String ... parameters) {
        if(requestType == null || parameters == null) {
            return;
        }
        this.requestType = requestType;
        this.parameters = parameters;
    }
    /**
     * <p>Returning the request type given upon the creation of a new {@link RequestCreator} instance</p>
     *
     * @return requestType The ApiRequestType to return
     */
    public RequestType getRequestType() {
        return requestType;
    }

    /**
     * <p>Gets the parameters given upon creating a {@link Request}
     * In fact, the parameters given follow a specific pattern, so if {@code parameters} size given is over 3 and the ApiRequestType
     * equals {@code ApiRequestType.SUMMONER_DATA_BY_NAME} then this class assumes that the
     * pattern is {@code summonerId}, {@code season} and {@code featured}</p>
     *
     * @return parameters
     */
    public Object[] getParameters() {
        return parameters;
    }

    /**
     * Sets the request type
     * @param requestType The request type to set
     */
    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }

    /**
     * Sets the parameters
     * @param parameters The parameters to set
     */
    public void setParameters(Object ... parameters) {
        this.parameters = parameters;
    }
}
