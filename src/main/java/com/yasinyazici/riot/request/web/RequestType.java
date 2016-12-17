package com.yasinyazici.riot.request.web;

import com.yasinyazici.riot.request.types.ApiRequestType;

/**
 * Created by Yasin on 17.12.2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public interface RequestType
{
    String getLink();

     default Type getType() {
        return ApiRequestType.class.isAssignableFrom(this.getClass()) ? Type.API_CALL : Type.GLOBAL;
    }
    String getStart();
}
