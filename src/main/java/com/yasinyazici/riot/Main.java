package com.yasinyazici.riot;

import com.yasinyazici.riot.request.web.*;

/**
 * Created by Yasin on 09/02/2016.
 */
public class Main {

    public static void main(String[] args)  {

        RequestCreator requestCreator = new RequestCreator();
        RequestProperty requestProperty = new RequestProperty(RequestType.GET_SUMMONER_DATA_BY_NAME, RequestRegion.EUROPE_WEST, "jungleíslife");
        requestCreator.setRequestProperty(requestProperty);
        requestCreator.create();



    }

}
