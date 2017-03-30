package com.yasinyazici.riot.request.types;

import com.yasinyazici.riot.request.types.impl.ApiRequestType;
import com.yasinyazici.riot.request.types.impl.RegionalRequestType;

/**
 * <p>Used as parent for different {@link RequestType}'s mainly used to navigate a Request to.</p>
 * @author Yasin
 */
public interface RequestType {

    /**
     * Contains the correct URL with placeholders (to get replaced)
     * @return the url directing to the
     */
    String getLink();

    /**
     * Used as base to build the URL, usually contains placeholders to get replaced
     * @return the link
     */
    String getStart();

    /**
     * Gets the type for each request based on what is being implemented
     * @return the type
     */
    default Type getType() {
        return ApiRequestType.class.isAssignableFrom(this.getClass()) ? Type.API_CALL : RegionalRequestType.class.isAssignableFrom(this.getClass()) ? Type.REGIONAL : Type.GLOBAL;
    }

    /**
     * Gets the query parameters for each url
     * @return the query parameters as {@link String}
     */
    default String getQueryParameter() {
        return "";
    }
}
