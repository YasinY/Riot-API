package com.yasinyazici.riot;

import com.yasinyazici.riot.data.champion.ChampionImage;
import com.yasinyazici.riot.data.championmastery.ChampionMastery;
import com.yasinyazici.riot.data.currentgame.CurrentGameInfo;
import com.yasinyazici.riot.data.exceptions.DataException;
import com.yasinyazici.riot.data.exceptions.PropertyNotFound;
import com.yasinyazici.riot.data.exceptions.ReplyException;
import com.yasinyazici.riot.data.exceptions.WrongRequestFormatException;
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
        Summoner summoner = leagueAPI.getSummoner(Region.EUW, "noragecritpls");
        ChampionMastery championMastery = summoner.getChampionMastery(245);
        summoner.getActiveGame().getParticipants().stream().forEach(p -> {
            try {
                ChampionImage championImage = leagueAPI.getChampionData(p.getChampionId());
                System.out.println("Summoner: " + p.getSummonerName() + ", Champion played: " + championImage.getName() + "");
                System.out.println(leagueAPI.getChampionMastery(summoner.getRegion(), p.getSummonerId(), p.getChampionId()).getChampionPoints());
                Thread.sleep(3000);
            } catch (PropertyNotFound | DataException | WrongRequestFormatException | ReplyException | IOException | InterruptedException propertyNotFound) {
                propertyNotFound.printStackTrace();
            }
        });

    }
}
