package com.yasinyazici.riot;

import com.yasinyazici.riot.data.exceptions.DataException;
import com.yasinyazici.riot.data.exceptions.ReplyException;
import com.yasinyazici.riot.data.exceptions.WrongRequestFormatException;
import com.yasinyazici.riot.data.summoner.Summoner;
import com.yasinyazici.riot.data.summoner.ranked.league.LeagueEntry;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by Yasin on 24.12.2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class Main {

    public static void main(String[] args) throws ReplyException, DataException, IOException, WrongRequestFormatException {
        LeagueAPI leagueAPI = new LeagueAPI();
        Summoner pascal = leagueAPI.getSummoner("euw", "dämonjho");
        Map<String, List<LeagueEntry>> leagueEntry = leagueAPI.getLeagueEntries("euw", pascal.getSummonerProperties().getId());
        for(List<LeagueEntry> element : leagueEntry.values()) {
            element.forEach(p -> p.getEntries().stream().forEach(x-> {
                System.out.println("Name: " + p.getName());
                System.out.println("Tier: " +p.getTier() + " " + x.getDivision());
                System.out.println("LP: "+ x.getLeaguePoints());
            }));
        }

    }
}
