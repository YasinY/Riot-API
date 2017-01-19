package com.yasinyazici.riot;

import com.yasinyazici.riot.data.exceptions.DataException;
import com.yasinyazici.riot.data.exceptions.ReplyException;
import com.yasinyazici.riot.data.exceptions.WrongRequestFormatException;
import com.yasinyazici.riot.data.masteries.MasteryData;
import com.yasinyazici.riot.data.summoner.Summoner;
import com.yasinyazici.riot.data.summoner.masteries.MasteryPages;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Yasin on 17.01.2017
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class Main {

    public static void main(String[] args) throws ReplyException, DataException, IOException, WrongRequestFormatException {
        LeagueAPI leagueAPI = new LeagueAPI();
        Summoner summoner = leagueAPI.getSummoner("euw", "jungle ís life");
        MasteryData data = leagueAPI.getMasteryData("euw", 6331);
        //Map<String, MasteryPages> masteryPages = leagueAPI.getMasteryPages("euw", summoner.getSummonerProperties().getId());


    }
}
