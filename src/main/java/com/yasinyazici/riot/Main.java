package com.yasinyazici.riot;

import com.yasinyazici.riot.data.summoner.Summoner;
import com.yasinyazici.riot.data.summoner.runes.Runes;

/**
 * Created by Yasin on 09/02/2016.
 */
public class Main {

    public static void main(String[] args) {
        LeagueAPI leagueAPI = new LeagueAPI();
        Summoner summoner = leagueAPI.getSummoner("euw", "jungleíslife");
        Runes runes = summoner.getRunes();
        System.out.println(runes.getPage(0).getName());
    }

}
