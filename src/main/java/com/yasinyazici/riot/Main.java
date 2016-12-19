package com.yasinyazici.riot;

import com.yasinyazici.riot.data.activegame.CurrentGameInfo;
import com.yasinyazici.riot.data.championmastery.ChampionMastery;
import com.yasinyazici.riot.data.summoner.Summoner;
import com.yasinyazici.riot.data.summoner.ranked.LeagueEntry;

import java.util.Objects;

/**
 * Created by Yasin on 09/02/2016
 * E-mail: yasin_programmer@hotmail.com
 * Github: YasinY
 */
public class Main {

    public static void main(String[] args) throws Exception {
        LeagueAPI leagueAPI = new LeagueAPI();
        Summoner summoner = leagueAPI.getSummoner("euw", "level99shaman");
        LeagueEntry leagueEntry = leagueAPI.getLeagueEntry("euw", summoner.getSummonerProperties().getId());
        System.out.println(leagueEntry.getTier() + " " + leagueEntry.getEntries().get(0).getLeaguePoints());
        CurrentGameInfo currentGameInfo = leagueAPI.getActiveGame(summoner.getRegion(), summoner.getSummonerProperties().getId());
        currentGameInfo.getParticipants().stream().filter(Objects::nonNull).forEachOrdered(p -> {
            //TODO handle response code 204
            try {
                long championId = p.getChampionId();
                System.out.println("Name: " + p.getSummonerName() + ", id: " + p.getSummonerId());
                System.out.println("Champion(" + championId + "): " + leagueAPI.getChampionInfo(summoner.getRegion(), championId).getName());
                ChampionMastery championMastery = leagueAPI.getChampionMastery(summoner.getRegion(), p.getSummonerId(), championId);
                System.out.println("Mastery with champion: " + championMastery.getChampionLevel() + " (" + championMastery.getChampionPoints() + ")");
                Thread.sleep(1500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
