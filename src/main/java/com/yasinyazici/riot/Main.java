package com.yasinyazici.riot;

import com.yasinyazici.riot.data.champion.ChampionImage;
import com.yasinyazici.riot.data.exceptions.DataException;
import com.yasinyazici.riot.data.exceptions.PropertyNotFound;
import com.yasinyazici.riot.data.exceptions.ReplyException;
import com.yasinyazici.riot.data.exceptions.WrongRequestFormatException;
import com.yasinyazici.riot.data.masteries.MasteryData;
import com.yasinyazici.riot.data.staticdata.Region;
import com.yasinyazici.riot.data.summoner.Summoner;

import java.io.IOException;

/**
 * Created by Yasin on 17.01.2017
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class Main {

    public static void main(String[] args) throws ReplyException, DataException, IOException, WrongRequestFormatException, PropertyNotFound {
        LeagueAPI leagueAPI = new LeagueAPI();
        Summoner summoner = leagueAPI.getSummoner(Region.EUW, "KAARAX");
        MasteryData masteryData = leagueAPI.getMasteryData(6211);
        System.out.println(masteryData.getName());
        ChampionImage championImage = leagueAPI.getChampionData(266);
        System.out.println(championImage.getChampionImageData().getFull());
        System.out.println(leagueAPI.getImageUrl(Region.EUW, 266));

    }
}
