package com.yasinyazici.riot.request.types;

import com.yasinyazici.riot.request.web.RequestType;

/**
 * Created by Yasin on 17.12.2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 * REQUESTS FOR https://www.global.api.pvp.net/
 */
public enum GlobalRequestType implements RequestType {
    START() {
        @Override
        public String getLink() { return "https://global.api.pvp.net/"; }
    };

    public String getStart() {
        return START.getLink();
    }
}
