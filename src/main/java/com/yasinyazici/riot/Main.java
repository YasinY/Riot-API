package com.yasinyazici.riot;

import com.yasinyazici.riot.data.champion.ChampionImage;
import com.yasinyazici.riot.data.championmastery.ChampionMastery;
import com.yasinyazici.riot.data.currentgame.CurrentGameInfo;
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
        Summoner summoner = leagueAPI.getSummoner(Region.EUW, "montanabiack88");
        ChampionStatsRanked championStatsRanked = leagueAPI.getChampionStatsRanked(Region.EUW, summoner.getId(), Season.SEASON_6);
        championStatsRanked.getChampionStatsSummary().stream().forEach(championStatsSummary ->  {
            ChampionImage championImage = leagueAPI.getChampionData(championStatsSummary.getId());
            System.out.println("Champion: **" + championImage.getName() + "**");
            System.out.println("WR: " + championStatsSummary.getChampionStatsList().displayWinrate());
            System.out.println("Average CS: " + championStatsSummary.getChampionStatsList().getAverageCreepScore());
            System.out.println("Average KDA: " + championStatsSummary.getChampionStatsList().displayAverageKDA());
            System.out.println("Total kills: " + championStatsSummary.getChampionStatsList().getTotalChampionKills());
            System.out.println("Total sessions played: " + championStatsSummary.getChampionStatsList().getTotalSessionsPlayed());
        });


    }
}
