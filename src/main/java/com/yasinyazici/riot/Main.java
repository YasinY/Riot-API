package com.yasinyazici.riot;

import com.yasinyazici.riot.data.championmastery.ChampionMastery;
import com.yasinyazici.riot.data.game.Season;
import com.yasinyazici.riot.data.summoner.Summoner;
import com.yasinyazici.riot.data.summoner.ranked.ChampionStatsRanked;
import com.yasinyazici.riot.data.summoner.ranked.ChampionStatsSummary;
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
        Summoner summoner = leagueAPI.getSummoner("euw", "dämonjho");
        List<ChampionMastery> championMasteries = leagueAPI.getChampionMasteries("euw", summoner.getSummonerProperties().getId());
        //championMasteries.stream().forEach(p -> System.out.println(p.getChampionPoints()));
        Map<String, List<LeagueEntry>> leagueEntry = leagueAPI.getLeagueEntries("euw", summoner.getSummonerProperties().getId());
        System.out.println(summoner.getSummonerProperties().getId());
        ChampionStatsRanked championStatsRanked = leagueAPI.getChampionStatsRanked("euw", summoner.getSummonerProperties().getId(), Season.SEASON_6);
        championStatsRanked.getChampions().stream().forEach(p -> System.out.println(p.getChampionStatsList()));
        for (List<LeagueEntry> leagueEntries : leagueEntry.values()) {
            for(LeagueEntry leagueEntryElement : leagueEntries) {
                System.out.println("Queue: " + leagueEntryElement.getQueue());
                System.out.println("Name: " + leagueEntryElement.getName());
                System.out.println("Tier: " + leagueEntryElement.getTier());
                leagueEntryElement.getEntries().stream().forEach(p -> {
                    System.out.println("League points: " + p.getLeaguePoints());
                    System.out.println("Division: " + p.getDivision());
                    System.out.println("Name: " + p.getPlayerOrTeamId());
                });
            }
        }

//        Summoner summoner = leagueAPI.getSummoner("euw", "Kha Sec");
//        LeagueEntry leagueEntry = leagueAPI.getLeagueEntry("euw", summoner.getSummonerProperties().getId());
//        System.out.println(leagueEntry.getTier() + " " + leagueEntry.getEntries().get(0).getLeaguePoints());
//        CurrentGameInfo currentGameInfo = leagueAPI.getActiveGame(summoner.getRegion(), summoner.getSummonerProperties().getId());
//        currentGameInfo.getParticipants().stream().filter(Objects::nonNull).forEachOrdered(p -> {
//            //TODO handle response code 204
//            try {
//                long championId = p.getChampionId();
//                System.out.println("Name: " + p.getSummonerName() + ", id: " + p.getSummonerId());
//                System.out.println("Champion(" + championId + "): " + leagueAPI.getChampionInfo(summoner.getRegion(), championId).getName());
//                ChampionMastery championMastery = leagueAPI.getChampionMastery(summoner.getRegion(), p.getSummonerId(), championId);
//                System.out.println("Mastery with champion: " + championMastery.getChampionLevel() + " (" + championMastery.getChampionPoints() + ")");
//                Thread.sleep(1500);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        });
    }
}
