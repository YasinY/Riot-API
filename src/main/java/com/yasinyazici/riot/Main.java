package com.yasinyazici.riot;

import com.yasinyazici.riot.request.web.*;

/**
 * Created by Yasin on 09/02/2016.
 */
public class Main {

    public static void main(String[] args)  {

        RequestCreator requestCreator = new RequestCreator(new RequestEntry("a748fb02-e3e6-404b-b55a-c8bf273f3a94"));
        requestCreator.setRequestProperty(new RequestProperty(RequestType.GET_SUMMONER_DATA_BY_NAME, RequestRegion.EUROPE_WEST, "hiimsh0ck"));
        requestCreator.create();



    }

}
