package com.yasinyazici.riot;

import com.yasinyazici.riot.data.champion.ChampionInfo;
import com.yasinyazici.riot.data.exceptions.ReplyException;
import com.yasinyazici.riot.data.game.Season;
import com.yasinyazici.riot.data.summoner.Summoner;
import com.yasinyazici.riot.data.summoner.ranked.ChampionStatsRanked;
import com.yasinyazici.riot.data.summoner.ranked.league.LeagueEntry;

import java.util.List;
import java.util.Map;

/**
 * Created by Yasin on 09/02/2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class Main {

    public static void main(String[] args) throws Exception {
        LeagueAPI leagueAPI = new LeagueAPI();
        String region = "euw";
        Summoner summoner = leagueAPI.getSummoner(region, "tcgasukaninja");
        long summonerId = summoner.getSummonerProperties().getId();
        System.out.println("SummonerId: " + summonerId);
        Map<String, List<LeagueEntry>> leagueEntry = leagueAPI.getLeagueEntries(region, summonerId);
        ChampionStatsRanked championStatsRanked = summoner.getChampionStatsRanked(Season.SEASON_6);
        championStatsRanked.getChampionStatsSummary().forEach(p -> {
            try {
                Thread.sleep(1500);
                ChampionInfo championInfo = leagueAPI.getChampionInfo(region, p.getId());
                System.out.println("---------------------------------------");
                System.out.println("Champion: " + championInfo.getName());
                System.out.println("KDA: " + p.getChampionStatsList().displayAverageKDA());
                System.out.println("Average CS:" + p.getChampionStatsList().displayAverageCreepScore());
                System.out.println("Mastery: " + leagueAPI.getChampionMastery(region, summonerId, p.getId()).getChampionPoints());
            } catch (Exception e) {
                e.printStackTrace();
                if(e instanceof ReplyException) {
                    System.out.println(((ReplyException) e).getResponse().getMessage() + ",FEAFAEFAA Code: " + ((ReplyException) e).getResponseCode());
                }
            }
        });
    }
}
