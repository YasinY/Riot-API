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
        long id = summoner.getSummonerProperties().getId();
        Map<String, MasteryPages> masteryPages = leagueAPI.getMasteryPages("euw", id);
        System.out.println(id);
        masteryPages.forEach((x, y) -> y.getMasteryPages().forEach(masteryPage -> {
            System.out.println(" ------------- " + masteryPage.getName() + " ------------- ");
            masteryPage.getMasteries().forEach(mastery -> {
                try {
                    MasteryData masteryData = leagueAPI.getMasteryData(mastery.getId());
                    System.out.println("Mastery: " + masteryData.getName() + ", points: " + mastery.getRank() + " (" + masteryData.getMasteryTree() + ")");
                    System.out.println("Runedata: " + leagueAPI.getRune(8003).getName());
                } catch (DataException | WrongRequestFormatException | IOException | ReplyException e) {
                    e.printStackTrace();
                }
            });
        }));

    }
}
