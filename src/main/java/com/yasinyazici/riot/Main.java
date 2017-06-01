package com.yasinyazici.riot;

import com.yasinyazici.riot.data.exceptions.DataException;
import com.yasinyazici.riot.data.exceptions.ReplyException;
import com.yasinyazici.riot.data.exceptions.WrongRequestFormatException;
import com.yasinyazici.riot.data.staticdata.Region;
import com.yasinyazici.riot.data.summoner.Summoner;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @author Yasin on 11.03.2017.
 * @version 1.0
 */

public class Main {

    public static void main(String[] args) throws ReplyException, DataException, IOException, WrongRequestFormatException, InterruptedException, URISyntaxException {
        LeagueAPI leagueAPI = new LeagueAPI(Region.EUW);

        Summoner summoner = leagueAPI.getSummoner("mace in da face");
        System.out.println(summoner.getName());
    }
}
