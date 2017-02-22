package com.yasinyazici.riot;

import com.yasinyazici.riot.data.champion.ChampionStats;
import com.yasinyazici.riot.data.exceptions.DataException;
import com.yasinyazici.riot.data.exceptions.PropertyNotFound;
import com.yasinyazici.riot.data.exceptions.ReplyException;
import com.yasinyazici.riot.data.exceptions.WrongRequestFormatException;
import com.yasinyazici.riot.data.game.Season;
import com.yasinyazici.riot.data.staticdata.Region;
import com.yasinyazici.riot.data.summoner.Summoner;
import com.yasinyazici.riot.data.summoner.ranked.ChampionStatsRanked;

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
        ChampionStatsRanked championStatsRanked = leagueAPI.getChampionStatsRanked(Region.EUW, summoner.getId(), Season.SEASON_7);
        championStatsRanked.getChampionStatsSummary().forEach(p -> {
            try {
                ChampionStats championData = leagueAPI.getChampionInfo(Region.EUW, p.getId());
                System.out.println(" ---- " + championData.getName() + " ---- ");
                System.out.println("KDA: " + p.getChampionStatsList().displayAverageKDA());
                System.out.println("WR: " + p.getChampionStatsList().displayWinrate());
                System.out.println("CS: " + p.getChampionStatsList().getAverageCreepScore());
                System.out.println("LOST: " + p.getChampionStatsList().getTotalSessionsPlayed() + " WIN: " + (p.getChampionStatsList().getTotalSessionsPlayed() - p.getChampionStatsList().getTotalSessionsLost()));
            } catch (DataException | WrongRequestFormatException | IOException | ReplyException e) {
                e.printStackTrace();
            }
        });

    }
}
