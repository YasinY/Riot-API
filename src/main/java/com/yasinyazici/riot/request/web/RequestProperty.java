package com.yasinyazici.riot.request.web;

/**
 * Created by Yasin on 23/02/2016.
 */
public class RequestProperty {

    private RequestType requestType;

    private RequestRegion requestRegion;

    private String[] parameters;
    /**
     * <p>Creates a new {@link RequestProperty} instance</p>
     *
     * @param requestType   The type of request set by the {@link Enum<RequestType>} to perform
     * @param requestRegion The region set by the {@link Enum<RequestRegion>} of which the region should query at
     * @param parameters    Additional parameters which must equal the format of {@link RequestType} given.
     */
    public RequestProperty(RequestType requestType, RequestRegion requestRegion, String ... parameters) {
        if(requestType == null || requestRegion == null || parameters == null) {
            return;
        }
        this.requestType = requestType;
        this.requestRegion = requestRegion;
        this.parameters = parameters;
    }
    /**
     * <p>Returning the request type given upon the creation of a new {@link RequestCreator} instance</p>
     *
     * @return requestType The RequestType to return
     */
    public RequestType getRequestType() {
        return requestType;
    }

    /**
     * <p>Returns the region the query is being performed at upon the creation of a new {@link RequestCreator} instance</p>
     *
     * @return requestRegion the region
     */
    public RequestRegion getRequestRegion() {
        return requestRegion;
    }

    /**
     * <p>Gets the parameters given upon creating a {@link Request}
     * In fact, the parameters given follow a specific pattern, so if {@code parameters} size given is over 3 and the RequestType
     * equals {@code RequestType.SUMMONER_DATA_BY_NAME} then this class assumes that the
     * pattern is {@code summonerId}, {@code season} and {@code featured}</p>
     *
     * @return parameters
     */
    public String[] getParameters() {
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
     * Sets the request region
     *  For dynamic changing of regions
     * @param requestRegion The request region to set
     */
    public void setRequestRegion(RequestRegion requestRegion) {
        this.requestRegion = requestRegion;
    }

    /**
     * Sets the parameters
     * @param parameters The parameters to set
     */
    public void setParameters(String ... parameters) {
        this.parameters = parameters;
    }
}
